package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Tasks;

import java.util.List;

public interface TaskService {

    List<Tasks> findAll();
    List<Tasks> getManagerTasks();
    List<Tasks> getTechnicianTasks();
    List<Tasks> getByEmployee(int id);
    List<Tasks> getByCompany(int id);
    List<Tasks> getBySubscriber(int id);
    void add(Tasks tasks);
    Tasks getById(int id);



}
