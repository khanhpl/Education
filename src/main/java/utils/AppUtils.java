/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import models.Account;

/**
 *
 * @author duyhu
 */
public class AppUtils {
    private static int REDIRECT_ID = 0;

	private static final Map<Integer, String> id_uri_map = new HashMap<Integer, String>();
	private static final Map<String, Integer> uri_id_map = new HashMap<String, Integer>();

	// Store user info in Session.
	public static void storeLoginedUser(HttpSession session, Account loginedUser) {
		// On the JSP can access via ${loginedUser}
		session.setAttribute("loginedUser", loginedUser);
	}

	// Get the user information stored in the session.
	public static Account getLoginedUser(HttpSession session) {
		Account loginedUser = (Account) session.getAttribute("loginedUser");
		return loginedUser;
	}

	public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
		Integer id = uri_id_map.get(requestUri);

		if (id == null) {
			id = REDIRECT_ID++;

			uri_id_map.put(requestUri, id);
			id_uri_map.put(id, requestUri);
			return id;
		}

		return id;
	}

	public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
		String url = id_uri_map.get(redirectId);
		if (url != null) {
			return url;
		}
		return null;
	}

}
