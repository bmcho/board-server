package com.example.boardserver.dto.request;

import com.example.boardserver.dto.SortStatus;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostSearchRequest {
    private int id;
    private String name;
    private String contents;
    private int views;
    private int categoryId;
    private int userId;
    private SortStatus sortStatus;
}