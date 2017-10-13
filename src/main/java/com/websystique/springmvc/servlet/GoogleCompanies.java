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
            response.getWriter().write("<table>");
            googleCompaniesList.forEach(c -> {
                try {
                    String entityToresponse = "<tr><td>"+c.getName()+"</td><td>"+c.getPhone()+"</td><td>" +
                            "<input type=\"button\" value=\"Save\" href=\"/potential-save-"+c.getGoogleId()+"\"></td></tr>";
                    response.getWriter().write(entityToresponse);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            response.getWriter().write("</table>");
        }

    }
}
