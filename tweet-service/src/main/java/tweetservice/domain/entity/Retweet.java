package tweetservice.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tweetservice.domain.common.AbstractEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Retweet extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tweet_id", nullable = false)
    private Tweet tweet;

    @Column
    private Long userId;
}
