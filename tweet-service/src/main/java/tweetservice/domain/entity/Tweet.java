package tweetservice.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tweetservice.domain.common.AbstractEntity;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Tweet extends AbstractEntity {

    @Column
    private String text;

    @Column(name = "user_id")
    private Long userId;

}
