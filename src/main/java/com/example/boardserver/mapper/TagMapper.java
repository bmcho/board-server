package com.example.boardserver.mapper;

import com.example.boardserver.dto.TagDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {
    int register(TagDTO tagDTO);

    void updateTags(TagDTO tagDTO);

    void deletePostTag(int tagId);
}