package com.example.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class JpaController {

    @GetMapping("/memoList")
    public String main(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && Boolean.TRUE.equals(session.getAttribute("authenticated"))) {
            return "memoList";
        } else {
            return "redirect:/password"; // 인증되지 않은 경우 패스워드 페이지로 리다이렉트
        }
    }
}
