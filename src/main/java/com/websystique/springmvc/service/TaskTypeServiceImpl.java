package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.TaskTypeDao;
import com.websystique.springmvc.model.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("taskTypeService")
@Transactional
public class TaskTypeServiceImpl implements TaskTypeService {

    @Autowired
    private TaskTypeDao dao;

    public List<TaskType> findAll() {
        return dao.findAll();
    }

    public void add(TaskType entity) {
        dao.add(entity);
    }

    public void update(TaskType entity) {
        dao.update(entity);
    }

    public void delete(int id) {
        dao.delete(id);
    }

}
