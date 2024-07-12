package com.litovchenko.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.litovchenko.data.UserDAO;
import com.litovchenko.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/users")
public class UserServletController extends HttpServlet{
    static Logger logger = LoggerFactory.getLogger(UserServletController.class);
    List<User> usersList = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String route = req.getParameter("action");
        logger.info("route : " + route);
        switch (route) {
            case "getAll"-> {
                res.setContentType("application/json; charset=UTF-8");
                usersList = UserDAO.select();
                logger.info("Inside of getAll : " + usersList.size());
                //transform to json and send it
                mapper.writeValue(res.getWriter(), usersList);
                logger.info(mapper.toString());
            }

            default -> {
                System.out.println("Invalid parameter");
            }
        }
    }

    //In "doPost" we send the form data to Java, then we insert into the database
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //String route = req.getParameter("action");
        String route = "add";
        logger.info("In doPost()");
        logger.info("route : " + route);
        logger.info("req : " + req);
        logger.info("req : " + req.getParameter("name"));
        switch(route) {
            case "add"-> {
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String email = req.getParameter("email");
                String name = req.getParameter("name");
                logger.info(username,password,email,name);

                User newUser = new User(username, password, email, name);

                //Hardcode an User
                User hardUser = new User("Peposo", "cumbiapeposa1234", "pepoeventos@gmail.com", "El Pepo");
                UserDAO.insert(hardUser);

                res.setContentType("application/json; charset=UTF-8");
                Map<String, String> response = new HashMap();
                response.put("message", "User saved successfully!!!");
                mapper.writeValue(res.getWriter(), response);
            }
        }
    }
}
