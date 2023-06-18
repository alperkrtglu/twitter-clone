package tweetservice.domain.dto.mapper;

import lombok.experimental.UtilityClass;
import tweetservice.domain.dto.TweetAddUpdateRequestDTO;
import tweetservice.domain.dto.TweetViewResponseDTO;
import tweetservice.domain.entity.Tweet;

import java.util.List;

@UtilityClass
public class TweetMapper {

    public Tweet dtoToEntity(final TweetAddUpdateRequestDTO dto, final Long userId) {
        return new Tweet(dto.text(), userId);
    }

    public List<TweetViewResponseDTO> entitiesToDTOs(List<Tweet> tweets) {
        return tweets.stream().map(TweetViewResponseDTO::new).toList();
    }
}
