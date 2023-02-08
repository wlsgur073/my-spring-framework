package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class DispatcherSerlvet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(DispatcherSerlvet.class);

    private RequestMappingHandlerMapping rmhm;

    @Override
    public void init() throws ServletException {
        rmhm = new RequestMappingHandlerMapping();
        rmhm.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("[DispatcherSerlvet] service started");


        try {
            Controller handler = rmhm.findHandler(req.getRequestURI());
            String viewName = handler.handleRequest(req, resp);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewName);
            requestDispatcher.forward(req, resp);
        } catch (Exception e) {
            log.info("exception occurred: [{}]", e.getMessage(), e);
        }

    }
}
