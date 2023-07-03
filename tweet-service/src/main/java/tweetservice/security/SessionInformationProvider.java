package tweetservice.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import tweetservice.domain.exception.UserAuthenticationException;

@Component
public class SessionInformationProvider {

    public String getCurrentUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof Jwt jwt) {
            if (jwt.getClaims().get("sub") instanceof String userId) {
                return userId;
            }
        }

        throw new UserAuthenticationException("Invalid user id provided!");
    }
}
