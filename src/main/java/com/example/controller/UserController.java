package com.example.controller;

import com.example.entity.UserBean;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/rest/test")
    public Object test(@RequestParam(name = "userId") final Integer userId, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        String userName = (String) session.getAttribute("userName");
//        logger.info("Login userName:"+userName);
        UserBean userBean = userService.getUserById(userId).get();
        userBean.setUsername(null);
        return userBean;
    }

    @RequestMapping("/rest/login")
    public void Login(@RequestParam(name = "userName") final String userName, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);
    }
}
