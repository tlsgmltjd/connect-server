package com.example.hellochat.domain.chat.repository;

import org.springframework.data.repository.CrudRepository;
import webSocket.chat.domain.Chat;

import java.util.List;

public interface ChatRepository extends CrudRepository<Chat, Long> {

    List<Chat> findAllByRoomId(Long roomId);
}
