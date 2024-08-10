package com.example.studymatch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    public ArrayList<User> users = new ArrayList<>();

    public final int IDNUM = 1, NAME = 0, CODE = 2, LESSON = 3;
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

                User user = new User(iDNum, name, code, lesson);
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
}

