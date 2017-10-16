package com.smh.includePage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/includePage")
public class IncludePageController {
	@RequestMapping("/headinclude.view")
	public String headInclude() {
		return "includePage/headinclude";
	}
}
