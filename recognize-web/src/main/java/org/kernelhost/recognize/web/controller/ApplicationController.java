package org.kernelhost.recognize.web.controller;

import javax.servlet.http.HttpSession;

import org.kernelhost.recognize.web.constant.Qualifier;
import org.kernelhost.recognize.web.model.User;
import org.kernelhost.recognize.web.view.ImageView;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "next-image", method = RequestMethod.GET)
	public ModelAndView getRandomImage(ModelAndView mav, HttpSession session) {
		Connection<Facebook> connection = ((Connection<Facebook>) session.getAttribute(Qualifier.USER_FACEBOOK_CONNECTION));
		Facebook api = connection.getApi();
		mav.setView(new ImageView(connection.getDisplayName(), api.userOperations().getUserProfileImage()));
		
		return mav;
	}
	
}
