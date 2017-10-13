package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Employees;
import com.websystique.springmvc.model.chat.ChatMessages;
import com.websystique.springmvc.service.EmployeeService;
import com.websystique.springmvc.service.chat.ChatMessagesService;
import com.websystique.springmvc.service.chat.ChatRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    ChatRoomsService chatRoomsService;
    @Autowired
    ChatMessagesService chatMessagesService;
    @Autowired
    EmployeeService employeeService;

    private Map<String, String> userNames() {
        Map<String, String> employeeNames = new HashMap<>();
        List<Employees> employeesList = employeeService.findAll();
        employeesList.forEach(e -> employeeNames.put(String.valueOf(e.getId()), e.getLogin()));
        return employeeNames;
    }

    @RequestMapping(value = {"/rooms"}, method = RequestMethod.GET)
    public String showBuhgalter(ModelMap model) {
        model.addAttribute("room", 0);
        model.addAttribute("employeenames", userNames());
        model.addAttribute("rooms", chatRoomsService.findAll());
        return "chat/rooms";
    }

    //MESSAGEES IN ROOM
    @RequestMapping(value = {"/room-{room}"}, method = RequestMethod.GET)
    public String roomMessages(@PathVariable String room, ModelMap model) {
        model.addAttribute("messages", chatMessagesService.getByRoom(Integer.parseInt(room)));
        model.addAttribute("room", room);
        model.addAttribute("employeenames", userNames());
        System.out.println("room - " + room);
        System.out.println("roommessages");
        return "chat/roommessages";
    }

    //CHAT WITH USER
    @RequestMapping(value = {"/user-messages-{user}"}, method = RequestMethod.GET)
    public String userMessages(@PathVariable String user, ModelMap model) {
        List<ChatMessages> chatMessages = chatMessagesService.findChat(Integer.parseInt(user),4);
        model.addAttribute("messages",chatMessages);
        model.addAttribute("user", user);
        model.addAttribute("employeenames", userNames());
        return "chat/roommessages";
    }


    @RequestMapping(value = {"/newmessage-{room}-{message}-{getter}"}, method = RequestMethod.GET)
    public String newMessage(@PathVariable String room, @PathVariable String message, @PathVariable String getter, ModelMap model) {
        ChatMessages messages = new ChatMessages();
        messages.setFromuser(1);
        messages.setRoom(Integer.parseInt(room));
        messages.setText(message);
        messages.setTouser(Integer.parseInt(getter));
        messages.setFromuser(1);
        chatMessagesService.add(messages);
        return "redirect:room-" + room;
    }
}
