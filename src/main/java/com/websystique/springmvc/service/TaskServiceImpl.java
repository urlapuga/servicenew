package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.TaskDao;
import com.websystique.springmvc.model.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao dao;

    public List<Tasks> findAll() {
        return dao.findAll();
    }

    public void add(Tasks tasks) {
        dao.add(tasks);
    }

}
