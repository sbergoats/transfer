package ru.zalivochkin.sbergoats.dto;

import lombok.Data;

@Data
public class PostDTOGet {
    private String uuid;
    private String userId;
    private String postContent;
    private Long createdEpochMilli;
}
