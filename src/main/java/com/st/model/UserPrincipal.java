package com.st.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails{
	
	private User user;
	
	

	public UserPrincipal(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("User"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}
    @Override
    public boolean isAccountNonExpired() {
    	// TODO Auto-generated method stub
    	return UserDetails.super.isAccountNonExpired();
    }
    
    @Override
    public boolean isAccountNonLocked() {
    	// TODO Auto-generated method stub
    	return UserDetails.super.isAccountNonLocked();
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
    	// TODO Auto-generated method stub
    	return UserDetails.super.isCredentialsNonExpired();
    }
    
    @Override
    public boolean isEnabled() {
    	// TODO Auto-generated method stub
    	return UserDetails.super.isEnabled();
    }
}