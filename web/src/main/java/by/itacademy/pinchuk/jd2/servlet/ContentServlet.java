package by.itacademy.pinchuk.jd2.servlet;

import by.itacademy.pinchuk.jd2.dto.ContentFilterDto;
import by.itacademy.pinchuk.jd2.entity.Content;
import by.itacademy.pinchuk.jd2.service.ContentService;
import by.itacademy.pinchuk.jd2.util.HibernateHelper;
import by.itacademy.pinchuk.jd2.util.ServletHelper;
import lombok.Cleanup;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private ContentService contentService = ContentService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        @Cleanup Session session = HibernateHelper.getSession();

        String id = req.getParameter("id");

        if (StringUtils.isNumeric(id)) {
            Optional<Content> content = contentService.get(Long.valueOf(id), session);
            if (content.isPresent()) {
                req.getServletContext()
                        .getRequestDispatcher("/WEB-INF/jsp/content.jsp")
                        .forward(req, resp);
            } else {
                resp.sendRedirect("/404");
            }
        } else {
            ContentFilterDto contentFilterDto = ServletHelper.buildContentFilterDto(req);
            List<Content> filteredContent = contentService.getFiltered(contentFilterDto, session);
            req.setAttribute("contents", filteredContent);
            req.getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/content-list.jsp")
                    .forward(req, resp);
        }
    }
}
