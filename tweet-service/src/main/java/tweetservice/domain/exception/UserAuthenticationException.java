package tweetservice.domain.exception;

public class UserAuthenticationException extends RuntimeException {

    public UserAuthenticationException(String message) {
        super(message);
    }
}
