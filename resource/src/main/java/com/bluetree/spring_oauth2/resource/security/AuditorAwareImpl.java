package com.bluetree.spring_oauth2.resource.security;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String> {
	
	private static final String DEFAULT_AUDITOR = "SYSTEM";

	@Override
	public Optional<String> getCurrentAuditor() {
		String username = SecurityContextHolder.getContext().getAuthentication() == null ? DEFAULT_AUDITOR :
			SecurityContextHolder.getContext().getAuthentication().getName();
		return Optional.of(username);
	}

}
