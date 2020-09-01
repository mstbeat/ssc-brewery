package guru.sfg.brewery.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RequestMatcher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RestHeaderAuthFilter extends AbstractRestAuthFilter {

	public RestHeaderAuthFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
		super(requiresAuthenticationRequestMatcher);

	}

	protected String getPassword(HttpServletRequest request) {
		return request.getHeader("Api-Secret");
	}

	protected String getUsername(HttpServletRequest request) {
		return request.getHeader("Api-Key");

	}

}
