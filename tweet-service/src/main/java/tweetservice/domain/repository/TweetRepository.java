package tweetservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tweetservice.domain.entity.Tweet;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    @Query("SELECT t FROM Tweet t LEFT JOIN FETCH t.likes l WHERE t.userId = :userId")
    List<Tweet> findAllWithLikesByUserId(Long userId);

    @Query("SELECT t FROM Tweet t LEFT JOIN FETCH t.retweets r WHERE t.userId = :userId")
    List<Tweet> findAllWithRetweetsByUserId(Long userId);
}
