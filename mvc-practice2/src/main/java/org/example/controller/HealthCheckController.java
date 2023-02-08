package org.example.controller;

import org.example.anootation.Controller;
import org.example.anootation.RequestMapping;
import org.example.anootation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HealthCheckController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String home(HttpServletRequest req, HttpServletResponse resp){
        return "ok";
    }
}
