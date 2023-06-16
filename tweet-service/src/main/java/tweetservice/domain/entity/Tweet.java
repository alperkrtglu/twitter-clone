package tweetservice.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tweetservice.domain.common.AbstractEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tweet extends AbstractEntity {

    private String text;

    private Long userId;
}