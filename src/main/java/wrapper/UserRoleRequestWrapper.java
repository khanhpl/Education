/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wrapper;

import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 *
 * @author duyhu
 */
public class UserRoleRequestWrapper  extends HttpServletRequestWrapper {
    private String user;
	private List<String> roles = null;
	private HttpServletRequest realRequest;

	public UserRoleRequestWrapper(String user, List<String> roles, HttpServletRequest request) {
		super(request);
		this.user = user;
		this.roles = roles;
		this.realRequest = request;
	}

	@Override
	public boolean isUserInRole(String role) {
		if (roles == null) {
			return this.realRequest.isUserInRole(role);
		}
		return roles.contains(role);
	}

	@Override
	public Principal getUserPrincipal() {
		if (this.user == null) {
			return realRequest.getUserPrincipal();
		}

		// Make an anonymous implementation to just return our user
		return new Principal() {
			@Override
			public String getName() {
				return user;
			}
		};
	}
}
