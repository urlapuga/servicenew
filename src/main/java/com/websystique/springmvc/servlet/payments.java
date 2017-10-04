package com.websystique.springmvc.servlet;

import com.websystique.springmvc.model.Payments;
import com.websystique.springmvc.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Component
@WebServlet(name = "payments",urlPatterns = "/payments")
public class payments extends HttpServlet {

    @Autowired
    PaymentsService paymentsService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("payments data");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Payments> paymentsList= paymentsService.findAll();
        System.out.println(paymentsList);
        response.getWriter().write("payments data");
    }
}
