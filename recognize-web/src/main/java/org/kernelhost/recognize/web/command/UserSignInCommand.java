package org.kernelhost.recognize.web.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

@Component
public class UserSignInCommand implements SignInAdapter {

	@Override
	@SuppressWarnings("unchecked")
	public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
		Connection<Facebook> facebookConnection = (Connection<Facebook>) connection;
		Facebook facebook = facebookConnection.getApi();
		
		List<FacebookProfile> friendProfiles = facebook.friendOperations().getFriendProfiles();
		byte[] userProfileImage = facebook.userOperations().getUserProfileImage(friendProfiles.get(0).getId());
		
		HttpSession session = request.getNativeRequest(HttpServletRequest.class).getSession();
		
		return null;
	}

}
