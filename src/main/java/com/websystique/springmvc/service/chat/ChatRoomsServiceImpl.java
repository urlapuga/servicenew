package com.websystique.springmvc.service.chat;

import com.websystique.springmvc.dao.chat.ChatRoomsDao;
import com.websystique.springmvc.model.chat.ChatRooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("chatRoomsService")
@Transactional
public class ChatRoomsServiceImpl implements ChatRoomsService {

    @Autowired
    private ChatRoomsDao dao;

    public List<ChatRooms> findAll() {
        return dao.findAll();
    }

    public void add(ChatRooms entity) {

        dao.add(entity);
    }

    public void delete(ChatRooms entity) {
        dao.delete(entity);
    }




}
