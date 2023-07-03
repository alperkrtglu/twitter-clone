package tweetservice.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tweetservice.domain.common.AbstractVersionedEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tweet extends AbstractVersionedEntity {

    private String text;

    private String userId;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Retweet> retweets = new ArrayList<>();

    public Tweet(String text, String userId) {
        this.text = text;
        this.userId = userId;
    }

    public void update(Tweet tweet) {
        this.text = tweet.text;
    }
}
