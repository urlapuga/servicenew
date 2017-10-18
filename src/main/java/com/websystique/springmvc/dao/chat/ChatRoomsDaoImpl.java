package com.websystique.springmvc.dao.chat;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.model.chat.ChatRooms;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("chatRoomsDao")
public class ChatRoomsDaoImpl extends AbstractDao<Integer, ChatRooms>implements ChatRoomsDao
{

    public List<ChatRooms> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<ChatRooms> entitylist = (List<ChatRooms>) criteria.list();
        return entitylist;
    }

    public void add(ChatRooms entity) {
        persist(entity);
    }

    public void update(ChatRooms entity) {
        persistupdate(entity);
    }

    public void delete(ChatRooms entity){super.delete(entity);}

    public ChatRooms getByEmployee(int employeeId) {
        return null;
    }

}
