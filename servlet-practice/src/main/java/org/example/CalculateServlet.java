package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate1")
public class CalculateServlet implements Servlet {
    private static final Logger logger = LoggerFactory.getLogger(CalculateServlet.class);
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("init");
        this.servletConfig = config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("service");
        int operand1 = Integer.parseInt(req.getParameter("operand1"));
        String operator = req.getParameter("operator");
        int operand2 = Integer.parseInt(req.getParameter("operand2"));

        int ret = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter out = res.getWriter();
        out.println(ret);
    }

    @Override
    public void destroy() {
        // resource release
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
