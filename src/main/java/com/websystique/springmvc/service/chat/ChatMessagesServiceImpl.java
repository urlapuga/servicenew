package com.websystique.springmvc.service.chat;

import com.websystique.springmvc.dao.chat.MessagesDao;
import com.websystique.springmvc.model.chat.ChatMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("chatMessagesService")
@Transactional
public class ChatMessagesServiceImpl implements ChatMessagesService {

    @Autowired
    private MessagesDao dao;

    public List<ChatMessages> findAll() {
        return dao.findAll();
    }

    public void add(ChatMessages entity) {

        dao.add(entity);
    }

    @Override
    public List<ChatMessages> getByRoom(int id) {
        return dao.getByRoom(id);
    }

    @Override
    public List<ChatMessages> findChat(int from, int to) {
        return dao.findChat(from,to);
    }


}
