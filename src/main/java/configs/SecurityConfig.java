/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author duyhu
 */
public class SecurityConfig {
        public static final String ROLE_EDITOR = "EDITOR";
	public static final String ROLE_MOD = "MOD";
        public static final String ROLE_SUPERMOD = "SUPERMOD";
        public static final String ROLE_ADMIN = "ADMIN";

	// String: Role
	// List<String>: urlPatterns.
	private static final Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();

	static {
		init();
	}

	private static void init() {

		List<String> urlPatterns1 = new ArrayList<String>();

                urlPatterns1.add("/themgv");

		mapConfig.put(ROLE_EDITOR, urlPatterns1);

		List<String> urlPatterns2 = new ArrayList<String>();

		urlPatterns2.add("/taolop");
                urlPatterns2.add("/themsinhvien");
                urlPatterns2.add("/themgv");
                urlPatterns2.add("/sualop");
                urlPatterns2.add("/suathongtin");
                urlPatterns2.add("/suagv");

		mapConfig.put(ROLE_MOD, urlPatterns2);
                
                List<String> urlPatterns3 = new ArrayList<String>();

		urlPatterns3.add("/taolop");
                urlPatterns3.add("/themsinhvien");
                urlPatterns3.add("/themgv");
                urlPatterns3.add("/sualop");
                urlPatterns3.add("/suathongtin");
                urlPatterns3.add("/suagv");
                urlPatterns3.add("/xoalop");
                urlPatterns3.add("/xoasinhvien");
                urlPatterns3.add("/xoagv");

		mapConfig.put(ROLE_SUPERMOD, urlPatterns3);
                
                List<String> urlPatterns4 = new ArrayList<String>();

		urlPatterns4.add("/taolop");
                urlPatterns4.add("/themsinhvien");
                urlPatterns4.add("/themgv");
                urlPatterns4.add("/chitietlop");
                urlPatterns4.add("/sualop");
                urlPatterns4.add("/suathongtin");
                urlPatterns4.add("/suagv");
                urlPatterns4.add("/xoalop");
                urlPatterns4.add("/xoasinhvien");
                urlPatterns4.add("/xoagv");

		mapConfig.put(ROLE_ADMIN, urlPatterns4);
	}

	public static Set<String> getAllAppRoles() {
		return mapConfig.keySet();
	}

	public static List<String> getUrlPatternsForRole(String role) {
		return mapConfig.get(role);
	}
}
