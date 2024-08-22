package com.example.jpa.controller;

import com.example.jpa.memo.repository.PasswordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/*")
    public String showPasswordPage(HttpServletRequest request, @RequestParam(value = "error", required = false) String error, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && Boolean.TRUE.equals(session.getAttribute("authenticated"))) {
            // 세션이 존재하고 인증이 완료된 경우 memoList로 리다이렉트
            return "redirect:/memoList";
        }
        // 세션이 없거나 인증되지 않은 경우 password 페이지로 이동
        if (error != null) {
            model.addAttribute("error", error);
        }
        return "password";
    }


    @PostMapping("/verify")
    public String verifyPassword(@RequestParam("code") String code, HttpServletRequest request) {
        if (passwordService.verifyPassword(code)) {
            HttpSession session = request.getSession();
            session.setAttribute("authenticated", true);
            return "redirect:/memoList";
        } else {
            return "redirect:/password?error=정확한 인증번호를 입력해주세요.";
        }
    }
}
