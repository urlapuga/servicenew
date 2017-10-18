package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.TaskType;

import java.util.List;

public interface TaskTypeDao {

    TaskType byId(int id);
    List<TaskType> findAll();
    void add(TaskType entity);
    void update(TaskType entity);
    void delete(int id);
}
