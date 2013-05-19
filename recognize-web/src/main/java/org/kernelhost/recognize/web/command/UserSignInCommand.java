package org.kernelhost.recognize.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kernelhost.recognize.web.constant.Qualifier;
import org.kernelhost.recognize.web.model.User;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

@Component
public class UserSignInCommand implements SignInAdapter {

	@Override
	public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
		HttpSession session = request.getNativeRequest(HttpServletRequest.class).getSession();
		Object api = connection.getApi();
		if (api instanceof Facebook) {
			session.setAttribute(Qualifier.USER_FACEBOOK_CONNECTION, connection);
		}
		
		User user = new User();
		user.setId(connection.getKey().getProviderUserId());
		user.setName(connection.getDisplayName());
		
		session.setAttribute(Qualifier.USER, user);
		
		return null;
	}

}
