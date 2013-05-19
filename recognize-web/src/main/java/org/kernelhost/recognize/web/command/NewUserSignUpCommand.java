package org.kernelhost.recognize.web.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.NoSuchConnectionException;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.stereotype.Component;

@Component("newUserSignUpCommand")
public class NewUserSignUpCommand implements ConnectionSignUp {

	@Autowired
	private UsersConnectionRepository usersConnectionRepository;

	@Override
	public String execute(Connection<?> connection) {
		ConnectionData connectionData = connection.createData();
		String userId = connectionData.getProviderUserId();
		ConnectionRepository connectionRepository = usersConnectionRepository.createConnectionRepository(userId);
		try {
			connectionRepository.getConnection(new ConnectionKey(connectionData.getProviderId(), userId));
		} catch (NoSuchConnectionException e) {
			connectionRepository.addConnection(connection);
		}

		return userId;
	}

}
