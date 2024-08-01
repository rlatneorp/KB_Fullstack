package org.scoula.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {
    public String getIndex(HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }
}
