package tweetservice.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tweetservice.domain.entity.Tweet;
import tweetservice.domain.exception.TweetNotFoundException;
import tweetservice.domain.repository.TweetRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetService {

    private final TweetRepository tweetRepository;

    @Transactional(readOnly = true)
    public List<Tweet> retrieve(String userId) {
        List<Tweet> tweets = tweetRepository.findAllWithLikesByUserId(userId);

        return !tweets.isEmpty() ?
                tweetRepository.findAllWithRetweetsByUserId(userId) : tweets;
    }

    @Transactional
    public void add(Tweet tweet) {
        tweetRepository.save(tweet);
    }

    @Transactional
    public void update(Long id, Tweet tweet) {
        Tweet _tweet = tweetRepository.findById(id)
                .orElseThrow(() -> new TweetNotFoundException(id));

        _tweet.update(tweet);
    }

    @Transactional
    public void delete(Long id) {
        tweetRepository.deleteById(id);
    }
}
