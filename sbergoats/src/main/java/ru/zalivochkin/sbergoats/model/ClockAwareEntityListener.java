package ru.zalivochkin.sbergoats.model;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import java.time.Clock;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

// inspired by https://habr.com/ru/post/681608/
@Component
@NoArgsConstructor
public class ClockAwareEntityListener {

    // Couldn't use constructor injection here
    @Autowired
    private Clock clock;

    @PrePersist
    public void init(@NonNull final Post post) {
        if (Objects.isNull(post.getUuid())) {
            post.setUuid(UUID.randomUUID().toString());
        }
        Long nowEpochMilli = Instant.now(clock).toEpochMilli();
        if (Objects.isNull(post.getCreatedEpochMilli())) {
            post.setCreatedEpochMilli(nowEpochMilli);
        }
        if (Objects.isNull(post.getLastUpdateEpochMilli())) {
            post.setLastUpdateEpochMilli(nowEpochMilli);
        }
    }

}
