package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.TaskType;
import com.websystique.springmvc.model.Tasks;
import com.websystique.springmvc.service.TaskService;
import com.websystique.springmvc.service.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    TaskTypeService taskTypeService;
    //TASKS


    @RequestMapping(value = {"/settaskemployee/{id}/{employeeId}"}, method = RequestMethod.GET)
    public String setTaskEmployee(@PathVariable Integer id,@PathVariable Integer employeeId, ModelMap model) {

        Tasks tasks = taskService.getById(id);
        tasks.setEmployeeTaskTo(employeeId);
        taskService.update(tasks);
        model.addAttribute("error","task updated");
        return "error";
    }



    /**
     * Закрываем задачу
     * Проверяем , что человек закрывает свою задачу , которая в работе
     */
    @RequestMapping(value = {"/closetask/{id}"}, method = RequestMethod.GET)
    public String closeOwnTask(@PathVariable String id, ModelMap model) {

        Tasks tasks = taskService.getById(Integer.parseInt(id));
        Integer employeeId = 3;
        if ((tasks.getEmployee() == employeeId) && (tasks.getStatus() == 1)) {
            tasks.setStatus(2);
            taskService.update(tasks);
            model.addAttribute("error", "1");
        } else {
            model.addAttribute("error", "0");
        }
        return "error";
    }


    @RequestMapping(value = {"/startwork/{id}"}, method = RequestMethod.GET)
    public String startOwnTask(@PathVariable String id, ModelMap model) {

        Tasks tasks = taskService.getById(Integer.parseInt(id));
        Integer employeeId = 3;
        String message = "";
        if ((tasks.getEmployee() == employeeId) && (tasks.getStatus() == 0)) {
            tasks.setStatus(1);
            taskService.update(tasks);
            message = "Задача в работе";
        } else {
            if (tasks.getStatus() != 1) message = "В работу можно взть тоьк оновую заявку ";
            if (tasks.getEmployee() != employeeId) message = "В работу можно взять только свою задачу";
        }
        model.addAttribute("error", message);
        return "error";
    }

    @RequestMapping(value = {"/canceltask/{id}"}, method = RequestMethod.GET)
    public String cancelOwnTask(@PathVariable String id, ModelMap model) {

        Tasks tasks = taskService.getById(Integer.parseInt(id));
        Integer employeeId = 3;
        String message = "";
        if (tasks.getEmployee() == employeeId) {
            tasks.setStatus(3);
            taskService.update(tasks);
            message = "Задача отменена ";
        } else {
            message = "Отменить можно только свою задачу";
        }
        model.addAttribute("error", message);
        return "error";
    }

    @RequestMapping(value = {"/rejecttask/{id}"}, method = RequestMethod.GET)
    public String rejectOwnTask(@PathVariable String id, ModelMap model) {

        Tasks tasks = taskService.getById(Integer.parseInt(id));
        Integer employeeId = 3;
        String message = "";
        if (tasks.getEmployee() == employeeId) {
            tasks.setEmployeeTaskTo(null);
            taskService.update(tasks);
            message = "Задача теперь без исполнителя";
        } else {
            message = "Отказатся можно только от своей задачи";
        }
        model.addAttribute("error", message);
        return "error";
    }


    @RequestMapping(value = {"/newowntask/{type}/{subscriber}/{date}/{text}"}, method = RequestMethod.GET)
    public String createOwnTask(@PathVariable String type, @PathVariable String subscriber, @PathVariable String date,
                                @PathVariable String text, ModelMap model) {

        SimpleDateFormat format1 = new SimpleDateFormat("dd_MM_yyyy hh:mm");

        Date d1 = new Date();
        try {
            d1 = format1.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if ((type.length() > 0) && (subscriber.length() > 0) && (date.length() > 0) && text.length() > 0) {
            Tasks tasks = new Tasks();
            tasks.setDateto(new Timestamp(d1.getTime()));
            tasks.setType(Integer.parseInt(type));
            tasks.setSubscriberId(Integer.parseInt(subscriber));
            tasks.setText(text);
            taskService.add(tasks);
        }

        model.addAttribute("tasktypes", taskTypeService.findAll());
        model.addAttribute("owntasks", taskService.findAll());
        return "/owntasks";
    }


    @RequestMapping(value = {"/tasks"}, method = RequestMethod.GET)
    public String listTasks(ModelMap model) {
        List<Tasks> tasks = taskService.findAll();
        List<TaskType> taskTypes = taskTypeService.findAll();
        model.addAttribute("tasktypes", taskTypes);
        model.addAttribute("tasks", tasks);
        return "tasklist";
    }


    @RequestMapping(value = {"/tasks"}, method = RequestMethod.POST)
    public String saveTask(@Valid Tasks tasks, BindingResult result,HttpServletRequest request,
                           ModelMap model) {
        System.out.println(tasks.getDateto());
        taskService.add(tasks);
        model.addAttribute("tasktypes", taskTypeService.findAll());
        model.addAttribute("tasks", taskService.findAll());
        return "redirect:"+request.getHeader("Referer");
    }

    @RequestMapping(value = {"/task-edit-{id}"}, method = RequestMethod.GET)
    public String editTask(@PathVariable String id, ModelMap model) {

        Tasks tasks = taskService.getById(Integer.parseInt(id));
        List<TaskType> taskTypeList = taskTypeService.findAll();

        TaskType taskType = taskTypeService.byId(tasks.getType());
        model.addAttribute("tasktypes", taskTypeList);
        model.addAttribute("task", tasks);
        return "/task/" + taskType.getPage();
    }

}
