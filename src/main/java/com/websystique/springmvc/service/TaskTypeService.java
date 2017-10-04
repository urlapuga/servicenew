package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Companies;
import com.websystique.springmvc.model.TaskType;

import java.util.List;

public interface TaskTypeService {
    List<TaskType> findAll();
    void add(TaskType entity);
    void update(TaskType entity);
    void delete(int id);

}
