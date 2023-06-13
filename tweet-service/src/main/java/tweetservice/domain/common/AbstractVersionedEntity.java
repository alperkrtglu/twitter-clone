package tweetservice.domain.common;

import jakarta.persistence.Column;
import jakarta.persistence.Version;

public abstract class AbstractVersionedEntity extends AbstractEntity {

    @Version
    @Column(name = "version")
    private int version = 0;

    public AbstractVersionedEntity() {
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
