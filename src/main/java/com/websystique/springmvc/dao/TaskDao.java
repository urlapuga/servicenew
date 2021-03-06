package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Tasks;

import java.util.List;

public interface TaskDao {

    List<Tasks> findAll();
    void add(Tasks tasks);
    void update(Tasks tasks);
    List<Tasks> getManagerTasks();
    List<Tasks> getTechnicianTasks();
    List<Tasks> getTasksByEmployeeId(int id);
    List<Tasks> getTasksByCompany(int id);
    List<Tasks> getByCustomer(int id);
    List<Tasks> getByEmployeeAndDate(String date,String employee);
    Tasks getById(int id);
}
