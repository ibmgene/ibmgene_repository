package cn.ibm.com.common.ibmUtils;

import cn.ibm.com.common.ibmUtils.BluePagesDataWrapper;

import javax.security.auth.login.LoginException;

import swat.ReturnCode;
import swat.cwa;

import com.ibm.bluepages.BPResults;
import com.ibm.bluepages.BluePages;

public class SecurityServiceImpl {
	public static final int VALID_USER = 0;
	public static final int LDAP_SERVER_CONFIG_ERROR = 1;
	public static final int LDAP_SERVER_ERROR_2 = 2;
	public static final int LDAP_SERVER_ERROR_3 = 3;
	public static final int MISSING_PASSWORD = 4;
	public static final int LDAP_SERVER_ERROR_5 = 5;
	public static final int INVALID_EMAIL_ID = 6;
	public static final int MULTIPLE_ENTRIES = 7;
	public static final int LDAP_SERVER_ERROR_8 = 8;
	public static final int AUTHENTICATION_FAILED = 9;

	private static final String LDAP_SERVER_ERROR_MESSAGE = "The IBM LDAP server is not responding. Please try again later.";
	private static final String INVALID_CREDENTIALS_MESSAGE = "Invaild ID or Password";
	private static final String UNKNOWN_LOGIN_ISSUE = "We are unable to log you in at this time. Please try again later...";

//	private final static int MAX_BLUE_PAGE_DATA_ATTEMPTS = 10;
	private final static String BLUE_PAGES_LDAP_SERVER = "bluepages.ibm.com";
	
	
	public boolean authenticateUser(String name, String pwd)
			throws LoginException {
		ReturnCode rc = cwa.authenticate(BLUE_PAGES_LDAP_SERVER, name, pwd);
		if (rc == null) {
			throw new LoginException(
					"Unable to authenticate user. Please try again later...");
		}
		switch (rc.getCode()) {
		case VALID_USER:
			return true;

		case LDAP_SERVER_CONFIG_ERROR:
			throw new LoginException(LDAP_SERVER_ERROR_MESSAGE);

		case LDAP_SERVER_ERROR_2:
			throw new LoginException(LDAP_SERVER_ERROR_MESSAGE);

		case LDAP_SERVER_ERROR_3:
			throw new LoginException(LDAP_SERVER_ERROR_MESSAGE);

		case MISSING_PASSWORD:
			throw new LoginException(INVALID_CREDENTIALS_MESSAGE);

		case LDAP_SERVER_ERROR_5:
			throw new LoginException(LDAP_SERVER_ERROR_MESSAGE);

		case INVALID_EMAIL_ID:
			throw new LoginException(INVALID_CREDENTIALS_MESSAGE);

		case MULTIPLE_ENTRIES:
			throw new LoginException(INVALID_CREDENTIALS_MESSAGE);

		case LDAP_SERVER_ERROR_8:
			throw new LoginException(LDAP_SERVER_ERROR_MESSAGE);

		case AUTHENTICATION_FAILED:
			throw new LoginException(INVALID_CREDENTIALS_MESSAGE);
		default:
			throw new LoginException(UNKNOWN_LOGIN_ISSUE);
		}

	}
	

}
