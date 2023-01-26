package org.example;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate3")
public class CalculateHttpServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(CalculateHttpServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("service");
        int operand1 = Integer.parseInt(req.getParameter("operand1"));
        String operator = req.getParameter("operator");
        int operand2 = Integer.parseInt(req.getParameter("operand2"));

        int ret = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter out = resp.getWriter();
        out.println(ret);
    }
}
