package org.example.mvc;

import org.example.mvc.controller.Controller;
import org.example.mvc.view.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleControllerHandlerAdapter implements HandlerAdapter{
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof Controller);
    }

    @Override
    public ModelAndView handle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        String viewName = ((Controller) handler).handleRequest(req, resp);
        return new ModelAndView(viewName);
    }
}
