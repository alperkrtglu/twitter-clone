package tweetservice.domain.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tweetservice.domain.common.AbstractVersionedEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tweet extends AbstractVersionedEntity {

    private String text;

    private Long userId;
}
