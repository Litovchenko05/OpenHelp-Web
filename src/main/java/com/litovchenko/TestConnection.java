package com.litovchenko;

import com.litovchenko.data.UserDAO;
import com.litovchenko.model.User;

import java.util.ArrayList;
import java.util.List;

public class TestConnection {
    public static void main(String[] args) {
        //List<User> usersLista = UserDAO.select();
        //System.out.println(usersLista);

        List<User> usersList = new ArrayList<>();
        usersList = UserDAO.select();
        System.out.println(usersList);
        //User user = new User("MarioLopez", "1512523", "maritoo@gmail.com", "Mario Lopez");
        //System.out.println(UserDAO.insert(user));
    }
}

