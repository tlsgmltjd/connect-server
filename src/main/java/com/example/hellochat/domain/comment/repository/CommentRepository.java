package com.example.hellochat.domain.comment.repository;

import com.example.hellochat.domain.board.entity.Board;
import com.example.hellochat.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBoardId(Board board);
}
