package com.example.studymatch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    public static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        Users.users = users;
    }

    public final int IDNUM = 0, NAME = 1, CODE = 2, LESSON = 3, MODE = 4, CONTACT = 5, IMAGE = 6;
    public void loadFile(String filename) {
        try {
            FileReader fileReader = new FileReader(filename);
            Scanner text = new Scanner(fileReader);

            while (text.hasNext()) {
                String line = text.nextLine();
                String[] details = line.split(",");
                String iDNum = details[IDNUM];
                String name = details[NAME];
                String code = details[CODE];
                String lesson = details[LESSON];
                String mode = details[MODE];
                String contact = details[CONTACT];
                String image = details[IMAGE];

                User user = new User(iDNum, name, code, lesson, mode, contact);
                users.add(user);
            }
            text.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not Exist");
        }
    }

    public int getSize() {
        return users.size();
    }

    public int searchName(String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public int searchIDNum(String name) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getIDNum().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(int index) {
        users.remove(index);
    }

    public void printId() {
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getName());
        }
    }
}

