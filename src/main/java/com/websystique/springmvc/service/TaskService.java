package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Tasks;

import java.util.List;

public interface TaskService {

    List<Tasks> findAll();
    void add(Tasks tasks);

}
