package com.websystique.springmvc.service.chat;

import com.websystique.springmvc.model.chat.ChatRooms;

import java.util.List;

public interface ChatRoomsService {

    List<ChatRooms> findAll();
    void add(ChatRooms entity);
    void delete(ChatRooms entity);
}
