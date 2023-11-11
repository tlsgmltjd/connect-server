package com.example.hellochat.domain.user.controller;

import com.example.hellochat.domain.user.dto.response.UserInfoResponse;
import com.example.hellochat.domain.user.service.UserInfoService;
import com.example.hellochat.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserInfoController {
    private final UserInfoService userInfoService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserInfoResponse> userFind(@PathVariable Long userId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok(userInfoService.findUser(userId, userDetails.getUser()));
    }
}
