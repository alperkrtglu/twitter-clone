package tweetservice.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SessionInformationProvider {

    public String getCurrentUsername() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
