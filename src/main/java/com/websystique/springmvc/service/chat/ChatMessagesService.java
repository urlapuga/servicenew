package com.websystique.springmvc.service.chat;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.chat.ChatMessages;

import java.util.List;

public interface ChatMessagesService {

    List<ChatMessages> findAll();
    void add(ChatMessages entity);
    List<ChatMessages> getByRoom(int id);
    List<ChatMessages> findChat(int from,int to);
}
