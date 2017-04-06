package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] line = scanner.nextLine().split("\\s");

            Student std = new Student();

            std.setName(line[0]);
            ArrayList<Double> tmp = new ArrayList<>();
            for (int j = 1; j < line.length; j++) {
                tmp.add(Double.parseDouble(line[j]));
            }

            std.setGrades(tmp);
            students.add(std);
        }

        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student std1, Student std2) {
                if (std1.getName().compareTo(std2.getName()) == 0) {
                    if (std1.getAverage() <= std2.getAverage()) {
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
                return std1.getName().compareTo(std2.getName());
            }
        });

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getAverage() >= 5) {
                System.out.printf("%s -> %.2f", students.get(i).getName(), students.get(i).getAverage());
                System.out.println();
            }
        }
    }
}
