package tweetservice.domain.controller.advice;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tweetservice.domain.exception.TweetNotFoundException;
import tweetservice.domain.exception.UserAuthenticationException;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class TweetServiceExceptionHandler {

    @ExceptionHandler(TweetNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handlerTweetNotFoundException(TweetNotFoundException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(UserAuthenticationException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public String handlerUserAuthenticationException(UserAuthenticationException exception) {
        return exception.getMessage();
    }
}