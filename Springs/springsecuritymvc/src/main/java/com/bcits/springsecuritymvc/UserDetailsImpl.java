package com.bcits.springsecuritymvc;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.bcits.springsecuritymvc.beans.EmpInfoBean;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Component
public class UserDetailsImpl implements UserDetails {
	
	
	private EmpInfoBean empInfoBean;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(empInfoBean.getRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return empInfoBean.getPassword();
	}

	@Override
	public String getUsername() {
		return empInfoBean.getName()+"";
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}// End of class
