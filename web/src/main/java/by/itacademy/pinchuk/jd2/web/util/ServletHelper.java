package by.itacademy.pinchuk.jd2.web.util;

import by.itacademy.pinchuk.jd2.database.dto.filter.ContentFilterDto;
import by.itacademy.pinchuk.jd2.database.dto.filter.LimiterDto;
import by.itacademy.pinchuk.jd2.database.util.AppConfig;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

@UtilityClass
public class ServletHelper {

    public ContentFilterDto buildContentFilterDto(HttpServletRequest req) {
        String active = req.getParameter("active");
        String title = req.getParameter("title");
        String createdBy = req.getParameter("createdBy");
        String tag = req.getParameter("tag");
        return ContentFilterDto.builder()
                .paging(buildLimitFilterDto(req))
                .active(StringUtils.isNotEmpty(active)
                        ? BooleanUtils.toBoolean(active)
                        : null)
                .createdBy(StringUtils.isNotEmpty(createdBy)
                        ? createdBy
                        : null)
                .title(StringUtils.isNotEmpty(title) ? title : null)
                .tag(StringUtils.isNotEmpty(tag) ? tag : null)
                .build();
    }

    private LimiterDto buildLimitFilterDto(HttpServletRequest req) {
        String limit = req.getParameter("limit");
        String page = req.getParameter("page");
        return LimiterDto.builder()
                .limit(StringUtils.isNumeric(limit)
                        ? Integer.valueOf(limit)
                        : Integer.valueOf(AppConfig.get("view.default.limit"))
                )
                .page(StringUtils.isNumeric(page)
                        ? Integer.valueOf(page)
                        : 1
                )
                .build();
    }
}
