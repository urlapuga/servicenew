package com.websystique.springmvc.servlet;

import com.websystique.springmvc.apis.googleMaps.GoogleCompany;
import com.websystique.springmvc.apis.googleMaps.MapsApi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@WebServlet(name = "GoogleCompanies", urlPatterns = "/googlecompanies")
public class GoogleCompanies extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String searchString = URLEncoder.encode(request.getParameter("searchString"), "UTF-8");
        List<GoogleCompany> googleCompaniesList = MapsApi.getCompaniesByRequestString(searchString);
        if(googleCompaniesList.isEmpty())response.getWriter().write("no results in area");
        else {
            googleCompaniesList.forEach(c -> {
                try {
                    response.getWriter().write("\\n" + String.valueOf(c));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
