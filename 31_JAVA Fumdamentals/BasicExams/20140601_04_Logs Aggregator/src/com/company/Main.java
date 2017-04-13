package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        boolean isFound;
        List<User> users = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            isFound = false;

            String[] tokens = scanner.nextLine().split("\\s+");
            for (User user : users) {
                if (user.getName().equals(tokens[1])) {
                    user.addIp(tokens[0]);
                    user.addDuration(Long.parseLong(tokens[2]));

                    isFound = true;
                }
            }

            if (!isFound) {
                User user = new User(tokens[1]);
                user.addIp(tokens[0]);
                user.addDuration(Long.parseLong(tokens[2]));

                users.add(user);
            }
        }

        users.sort((u1, u2) -> u1.getName().compareToIgnoreCase(u2.getName()));

        for (User user : users) {
            System.out.printf("%s: %d [%s]%n", user.getName(), user.getDuration(), String.join(", ", user.getIpList()));
        }
    }
}