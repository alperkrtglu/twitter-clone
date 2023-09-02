package tweetservice.domain.controller.advice;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tweetservice.domain.exception.TweetNotFoundException;

@RestControllerAdvice
@Order
public class GlobalExceptionHandler {

    @ExceptionHandler(TweetNotFoundException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerTweetNotFoundException(Exception exception) {
        return exception.getMessage();
    }
}
