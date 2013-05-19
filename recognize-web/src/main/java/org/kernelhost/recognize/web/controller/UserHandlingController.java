package org.kernelhost.recognize.web.controller;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;
	
@Controller
@RequestMapping("/")
public class UserHandlingController implements SignInAdapter {
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@Override
	public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
		return null;
	}
	
}
