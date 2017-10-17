package com.smh.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smh.login.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Resource
	private UserService userService;

	@RequestMapping("/doLogin.view")
	public String doLogin(HttpServletRequest requset) {
		return "login/login";
	}
}
