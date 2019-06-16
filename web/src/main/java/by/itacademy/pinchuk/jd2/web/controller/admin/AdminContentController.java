package by.itacademy.pinchuk.jd2.web.controller.admin;

import by.itacademy.pinchuk.jd2.database.dto.ContentDto;
import by.itacademy.pinchuk.jd2.database.dto.filter.ContentFilterDto;
import by.itacademy.pinchuk.jd2.database.entity.Lang;
import by.itacademy.pinchuk.jd2.database.entity.QContent;
import by.itacademy.pinchuk.jd2.database.util.DslPredicateBuilder;
import by.itacademy.pinchuk.jd2.service.service.ContentService;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/admin/content")
@SessionAttributes("limit")
@AllArgsConstructor
public class AdminContentController {

    private final ContentService contentService;

    @GetMapping
    public String list(Model model, @RequestParam(required = false) Integer page) {
        // TODO: 2019-06-15 inject defaultLimit from properties using @Value
        int pageCount = contentService.countPages(10);
        List<ContentDto> contents = contentService.findAllOnPage(page, 10);
        model.addAttribute("contents", contents);
        model.addAttribute("pageCount", pageCount);
        return "admin/content-list";
    }

    @PostMapping
    public String filteredList(Model model, Locale locale, ContentFilterDto contentFilterDto, Integer limit) {
        model.addAttribute("limit", limit);
        Predicate predicate = new DslPredicateBuilder()
                .containsIgnoreCase(
                        QContent.content.translations.get(Lang.valueOf(locale.toString())).title,
                        contentFilterDto.getTitle()
                )
                .eq(QContent.content.createdBy.username, contentFilterDto.getCreatedBy())
                .eq(QContent.content.active, contentFilterDto.getActive())
                .containsIgnoreCase(QContent.content.tags.any().value, contentFilterDto.getTag())
                .build();
        List<ContentDto> contents = contentService.findAllOnPage(predicate, 1, limit);
        Long pageCount = contentService.count(predicate) / limit;
        model.addAttribute("contents", contents);
        model.addAttribute("pageCount", pageCount);
        return "admin/content-list";
    }
}
