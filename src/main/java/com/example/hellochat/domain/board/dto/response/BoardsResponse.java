package com.example.hellochat.domain.board.dto.response;

import lombok.Builder;

@Builder
public record BoardsResponse (
    Long boardId,
    String title,
    String content,
    Integer commentCount,
    BoardAuthorDto author,
    Integer likeCount
) {}