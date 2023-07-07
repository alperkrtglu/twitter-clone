package tweetservice.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import tweetservice.domain.entity.Tweet;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @AfterReturning(pointcut = "execution(* tweetservice.domain.service.TweetService.add(..)) && args(tweet)")
    public void logAfterAdd(Tweet tweet) {
        log.info("Tweet added with ID: {}", tweet.getId());
    }

    @AfterReturning(pointcut = "execution(* tweetservice.domain.service.TweetService.update(..)) && args(id, tweet)", argNames = "id,tweet")
    public void logAfterUpdate(Long id, Tweet tweet) {
        log.info("Tweet updated with ID: {}", id);
    }

    @AfterReturning(pointcut = "execution(* tweetservice.domain.service.TweetService.delete(..)) && args(id)")
    public void logAfterDelete(Long id) {
        log.info("Tweet deleted with ID: {}", id);
    }
}
