package com.example.hellochat.domain.board.controller;

import com.example.hellochat.domain.board.dto.request.BoardLikeRequest;
import com.example.hellochat.domain.board.dto.request.CreateBoardRequest;
import com.example.hellochat.domain.board.dto.response.BoardResponse;
import com.example.hellochat.domain.board.dto.response.BoardsResponse;
import com.example.hellochat.domain.board.service.BoardService;
import com.example.hellochat.global.security.UserDetailsImpl;
import com.example.hellochat.global.util.MsgResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<MsgResponseDto> boardPost(@RequestBody @Valid CreateBoardRequest request, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        boardService.postBoard(request, userDetails.getUser());
        return ResponseEntity.ok(new MsgResponseDto("게시글 등록이 완료되었습니다.", HttpStatus.OK.value()));
    }

    @GetMapping
    public ResponseEntity<List<BoardsResponse>> boardsFind() {
        return ResponseEntity.ok(boardService.findBoards());
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<BoardResponse> boardFind(@PathVariable Long boardId) {
        return ResponseEntity.ok(boardService.findBoard(boardId));
    }

    @PostMapping("/like")
    public ResponseEntity<MsgResponseDto> boardLike(@RequestBody BoardLikeRequest request, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok(boardService.likeBoard(request, userDetails.getUser()));
    }
}
