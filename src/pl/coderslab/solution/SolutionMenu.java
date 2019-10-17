package pl.coderslab.solution;

import pl.coderslab.exercise.Exercise;
import pl.coderslab.exercise.ExerciseDao;
import pl.coderslab.user.User;
import pl.coderslab.user.UserDao;

import java.util.Scanner;

public class SolutionMenu {
    public void menu() {
        SolutionDao solutionDao = new SolutionDao();
        boolean isRightOption = true;
        Scanner scanner = new Scanner(System.in);

        while (isRightOption){
            System.out.println();
            System.out.println("Wybierz jedną z opcji: ");
            System.out.println("add - przypisanie zadania użytkownikowi");
            System.out.println("view - przegląd rozwiązań danego użytkownika");
            System.out.println("quit - wyjście");

            String option = scanner.next();
            option = option.toLowerCase();

            switch (option){
                case "add": add(); break;
                case "view": view(); break;
                case "quit": isRightOption = false;
            }
        }
    }

    public void add(){
        System.out.println("No to dodajemy!");

        UserDao userDao = new UserDao();
        User[] users = userDao.findAll();
        for (User u: users){
            System.out.println(u);
        }
        System.out.println("Podaj ID użytkownika: ");
        Scanner scanner = new Scanner(System.in);
        int userId = scanner.nextInt();

        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise[] exercises = exerciseDao.findAll();
        for (Exercise e: exercises){
            System.out.println(e);
        }
        System.out.println("Podaj ID ćwiczenia: ");
        int exerciseId = scanner.nextInt();

        Solution solution = new Solution();
        solution.setUsersId(userId);
        solution.setExerciseId(exerciseId);

        SolutionDao solutionDao = new SolutionDao();
        solutionDao.create(solution);
    }

    public void view(){
        System.out.println("No to edytujemy!");
        System.out.println("Podaj ID użytkownika, którego rozwiązania chcesz zobaczyć: ");
        Scanner scanner = new Scanner(System.in);
        SolutionDao solutionDao = new SolutionDao();
        Solution[] solutions = solutionDao.findAllByUserId(scanner.nextInt());

        for (Solution s: solutions){
            System.out.println(s);
        }
    }
}
