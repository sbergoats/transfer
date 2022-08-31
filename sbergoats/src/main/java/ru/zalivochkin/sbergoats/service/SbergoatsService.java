package ru.zalivochkin.sbergoats.service;

import ru.zalivochkin.sbergoats.dto.PostDTOGet;
import ru.zalivochkin.sbergoats.dto.PostDTOPut;

import java.util.List;

public interface SbergoatsService {
  List<PostDTOGet> getByUuid(String uuid);

  List<PostDTOGet> getByUserId(String userId);

  PostDTOGet post(PostDTOPut post);
}
