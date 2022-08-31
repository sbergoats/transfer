package ru.zalivochkin.sbergoats.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zalivochkin.sbergoats.dto.PostDTOGet;
import ru.zalivochkin.sbergoats.dto.PostDTOPut;
import ru.zalivochkin.sbergoats.service.SbergoatsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SbergoatsController {

    private final SbergoatsService service;

    @GetMapping("/get-by-uuid")
    public List<PostDTOGet> getByUuid(@NonNull String uuid) {
        return service.getByUuid(uuid);
    }

    @GetMapping("/get-by-user-id")
    public List<PostDTOGet> getByUserId(@NonNull String userId) {
        return service.getByUserId(userId);
    }

    @PostMapping("/post")
    public PostDTOGet post(PostDTOPut post) {
        return service.post(post);
    }

}
