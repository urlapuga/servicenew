package com.websystique.springmvc.dao.chat;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.chat.ChatMessages;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("chatmessagesDao")
public class MessagesDaoImpl extends AbstractDao<Integer, ChatMessages>implements MessagesDao
{

    public List<ChatMessages> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<ChatMessages> entitylist = (List<ChatMessages>) criteria.list();
        return entitylist;
    }

    public void add(ChatMessages entity) {
        persist(entity);
    }

    public List<ChatMessages> getByRoom(int id) {
        return getByNamedQueryWithParam("getByRoom","room",String.valueOf(id));
    }

    public List<ChatMessages> findChat(int from, int to) {
        return getByNamedQueryWithTwoParams("getByUser", "user1", String.valueOf(from), "user2", String.valueOf(to));
    }

}
