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

    @Override
    public List<Tasks> getByEmployeeAndDate(String employee, String date) {

        return dao.getByEmployeeAndDate(employee, date);
    }

    public List<Tasks> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Tasks> getManagerTasks() {
        return dao.getManagerTasks();
    }

    @Override
    public List<Tasks> getTechnicianTasks() {
        return dao.getTechnicianTasks();
    }

    @Override
    public List<Tasks> getByEmployee(int id) {
        return dao.getTasksByEmployeeId(id);
    }

    @Override
    public List<Tasks> getByCompany(int id) {
        return dao.getTasksByCompany(id);
    }

    @Override
    public List<Tasks> getBySubscriber(int id) {
        return dao.getByCustomer(id);
    }

    public void add(Tasks tasks) {
        dao.add(tasks);
    }

    @Override
    public Tasks getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void update(Tasks tasks) {
        dao.update(tasks);
    }

}
