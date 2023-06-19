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
@Slf4j
public class TweetService {

    private final TweetRepository tweetRepository;

    @Transactional(readOnly = true)
    public List<Tweet> retrieve(Long userId) {
        List<Tweet> tweets = tweetRepository.findAllWithLikesByUserId(userId);

        return !tweets.isEmpty() ?
                tweetRepository.findAllWithRetweetsByUserId(userId) : tweets;
    }

    @Transactional
    public void add(Tweet tweet) {
        tweetRepository.save(tweet);
        log.info("Tweet created! Tweet Id: {}", tweet.getId());
    }

    @Transactional
    public void update(Long id, Tweet tweet) {
        Tweet _tweet = tweetRepository.findById(id)
                .orElseThrow(() -> new TweetNotFoundException(id));

        _tweet.update(tweet);
        log.info("Tweet updated! Tweet Id: {}", id);
    }

    @Transactional
    public void delete(Long id) {
        tweetRepository.deleteById(id);
        log.info("Tweet deleted! Tweet Id: {}", id);
    }
}
