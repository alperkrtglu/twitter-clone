package tweetservice.domain.dto;

import tweetservice.domain.entity.Tweet;

public record TweetViewResponseDTO(String text, int likeCount, int retweetCount) {

    public TweetViewResponseDTO(Tweet tweet) {
        this(tweet.getText(), tweet.getLikes().size(), tweet.getRetweets().size());
    }
}
