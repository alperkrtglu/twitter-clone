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
@Table(name = "Likes")
public class Like extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tweet_id", nullable = false)
    private Tweet tweet;

    private Long userId;
}
