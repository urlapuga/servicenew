package com.websystique.springmvc.dao.chat;

import com.websystique.springmvc.model.chat.ChatMessages;

import java.util.List;

public interface MessagesDao {

    List<ChatMessages> findAll();
    void add(ChatMessages entity);
    List<ChatMessages> getByRoom(int id);
    List<ChatMessages> findChat(int employee1,int employee2 );
}
