package ru.zalivochkin.sbergoats.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zalivochkin.sbergoats.dto.PostDTOGet;
import ru.zalivochkin.sbergoats.dto.PostDTOPut;
import ru.zalivochkin.sbergoats.model.Post;
import ru.zalivochkin.sbergoats.repository.SbergoatsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SbergoatsServiceImpl implements SbergoatsService {

    private final SbergoatsRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTOGet> getByUuid(String uuid) {
        List<Post> postList = repository.getByUuid(uuid);
        return postList.stream().map(post ->
            modelMapper.map(post, PostDTOGet.class)
        ).collect(Collectors.toList());
    }

    @Override
    public List<PostDTOGet> getByUserId(String userId) {
        List<Post> postList = repository.getByUserId(userId);
        return postList.stream().map(post ->
            modelMapper.map(post, PostDTOGet.class)
        ).collect(Collectors.toList());
    }

    @Override
    public PostDTOGet post(PostDTOPut postDTOPut) {
        Post post = modelMapper.map(postDTOPut, Post.class);
        return modelMapper.map(repository.save(post), PostDTOGet.class);
    }

}
