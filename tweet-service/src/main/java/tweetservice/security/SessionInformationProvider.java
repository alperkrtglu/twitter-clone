package tweetservice.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SessionInformationProvider {

    public Long getCurrentUserId() {
        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (userId == null) {
            throw new IllegalArgumentException("Invalid user id provided");
        }

        return userId;
    }
}
