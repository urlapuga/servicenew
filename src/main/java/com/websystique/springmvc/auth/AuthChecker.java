package com.websystique.springmvc.auth;

import com.websystique.springmvc.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.Arrays;

public class AuthChecker {

    @Autowired
    static HttpSession httpSession;

    public static boolean check(Integer[] allowedPositionsList) {
        Employees employees = (Employees) httpSession.getAttribute("employee");
        if(employees==null) return false;
        return Arrays.asList(allowedPositionsList).contains(employees.getPositionId());
    }

    public static boolean check(HttpSession session,Integer[] allowedPositionsList) {
        Employees employees = (Employees) session.getAttribute("employee");
        if(employees==null) return false;
        return Arrays.asList(allowedPositionsList).contains(employees.getPositionId());
    }

}
