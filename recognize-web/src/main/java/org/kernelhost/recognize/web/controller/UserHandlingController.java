package org.kernelhost.recognize.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;
	
@Controller
@RequestMapping("/")
public class UserHandlingController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
}
