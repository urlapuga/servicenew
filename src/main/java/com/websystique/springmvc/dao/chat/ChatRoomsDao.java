package com.websystique.springmvc.dao.chat;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.chat.ChatRooms;

import java.util.List;

public interface ChatRoomsDao {

    List<ChatRooms> findAll();
    void add(ChatRooms room);
    void delete(ChatRooms room);
    ChatRooms getByEmployee(int employeeId);
}
