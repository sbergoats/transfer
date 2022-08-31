package ru.zalivochkin.sbergoats.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "posts")
@EntityListeners(ClockAwareEntityListener.class)
public class Post {

    @Id
    private String uuid;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "post_content")
    private String postContent;

    @Column(name = "created_epoch_milli")
    private Long createdEpochMilli;

    @Column(name = "last_update_epoch_milli")
    private Long lastUpdateEpochMilli;

    @Column(name = "deleted_epoch_milli")
    private Long deletedEpochMilli;

}
