package ru.zalivochkin.sbergoats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zalivochkin.sbergoats.model.Post;

import java.util.List;

public interface SbergoatsRepository extends JpaRepository<Post, String> {

    List<Post> getByUuid(String uuid);

    List<Post> getByUserId(String userId);

}
