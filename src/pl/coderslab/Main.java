package pl.coderslab;

import pl.coderslab.exercise.ExerciseMenu;
import pl.coderslab.group.GroupMenu;
import pl.coderslab.solution.Solution;
import pl.coderslab.solution.SolutionDao;
import pl.coderslab.solution.SolutionMenu;
import pl.coderslab.user.UserMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isRightOption = true;
        Scanner scanner = new Scanner(System.in);

        while (isRightOption){
            System.out.println("Wybierz jedną z opcji: ");
            System.out.println("add - dodawanie rozwiązania");
            System.out.println("view - przeglądanie swoich rozwiązań");
            System.out.println("users - użytkownicy");
            System.out.println("groups - gupy");
            System.out.println("exercises - ćwiczenia");
            System.out.println("solutions - rozwiązania");
            System.out.println("quit - zakończenie programu");

            String option = scanner.next();
            option = option.toLowerCase();
            int userId = 2;//Integer.parseInt(args[0]);

            switch (option){
                case "add": add(userId); break;
                case "view": view(userId); break;
                case "users": users(); break;
                case "groups": groups(); break;
                case "exercises": exercises(); break;
                case "solutions": solutions(); break;
                case "quit": isRightOption = false;
            }
        }
    }

    public static void add(int userId){
        SolutionDao solutionDao = new SolutionDao();
        Solution[] solutions = solutionDao.findAllByUserId(userId);

        for (Solution s: solutions){
            if(s.getDescription() == null) {
                System.out.println(s);
            }
        }
        System.out.println("podaj iD zadania, do którego chcesz dodać rozwiązanie: ");
        Scanner scanner = new Scanner(System.in);

        Solution[] solutions2 = solutionDao.findAllByExerciseId(scanner.nextInt());
        System.out.println("Podaj rozwiązanie: ");
        Scanner scanner1 = new Scanner(System.in);
        solutions2[1].setDescription(scanner1.nextLine());
        solutionDao.update(solutions2[1]);
    }

    public static void view(int userId){
        SolutionDao solutionDao = new SolutionDao();
        Solution[] solutions = solutionDao.findAllByUserId(userId);

        for (Solution s: solutions){
            System.out.println(s);
        }
    }

    public static void users(){
        UserMenu userMenu = new UserMenu();
        userMenu.menu();
    }

    public static void groups(){
        GroupMenu groupMenu = new GroupMenu();
        groupMenu.menu();
    }

    public static void exercises(){
        ExerciseMenu exerciseMenu = new ExerciseMenu();
        exerciseMenu.menu();
    }

    public static void solutions(){
        SolutionMenu solutionMenu = new SolutionMenu();
        solutionMenu.menu();
    }
}
