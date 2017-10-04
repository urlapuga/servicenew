package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Tasks;

import java.util.List;

public interface TaskDao {


    List<Tasks> findAll();
    void add(Tasks tasks);
}
