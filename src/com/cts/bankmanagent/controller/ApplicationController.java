package com.cts.bankmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class ApplicationController {

	@ResponseBody
	@RequestMapping(value = "/hellospring", method = RequestMethod.GET)
	public String hello() {
		return "hello from spring 212";
	}
}
