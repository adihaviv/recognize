package org.kernelhost.recognize.web.controller;

import javax.servlet.http.HttpSession;

import org.kernelhost.recognize.web.constant.Qualifier;
import org.kernelhost.recognize.web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
	
@Controller
@RequestMapping("/")
public class ApplicationController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest(ModelAndView mav, HttpSession session) {
		mav.setViewName("index");
		User user = (User) session.getAttribute(Qualifier.USER);
		if (user != null) {
			mav.addObject(user);
		}
		
		return mav;
	}
	
}
