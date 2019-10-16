package pl.coderslab;

import pl.coderslab.solution.Solution;
import pl.coderslab.solution.SolutionDao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        UserMenu userMenu = new UserMenu();
//        userMenu.menu();

//        ExerciseMenu exerciseMenu = new ExerciseMenu();
//        exerciseMenu.menu();

//        GroupMenu groupMenu = new GroupMenu();
//        groupMenu.menu();

//        SolutionMenu solutionMenu = new SolutionMenu();
//        solutionMenu.menu();
        boolean isRightOption = true;
        Scanner scanner = new Scanner(System.in);

        while (isRightOption){
            System.out.println("Wybierz jedną z opcji: ");
            System.out.println("add - dodawanie rozwiązania");
            System.out.println("view - przeglądanie swoich rozwiązań");
            System.out.println("quit - wyjście");

            String option = scanner.next();
            option = option.toLowerCase();
            int userId = 2;//Integer.parseInt(args[0]);

            switch (option){
                case "add": add(userId); break;
                case "view": view(userId); break;
                case "quit": isRightOption = false;
            }
        }

//        User user = new User();
//        User user1 = new User("Piotr", "piotr@fronczewski.pl", "123", 1);
//        user.setName("Janek");
//        user.setEmail("janek@baranek.pl");
//        user.setPassword("132");
//        user.setGroupId(1);

//        UserDao userDao = new UserDao();
//        userDao.create(user1);
//        User[] users = userDao.findAllByGroupId(2);
//        for (User u: users){
//            System.out.println(u);
//        }

//        Group group = new Group("druga");

//        GroupDao groupDao = new GroupDao();
//        groupDao.create(group);

//        Exercise exercise = new Exercise();
//        exercise.setTitle("czwarte");

//        ExerciseDao exerciseDao = new ExerciseDao();
//        exerciseDao.create(exercise);

//        Solution solution = new Solution();
//        solution.setDescription("rozwiązanie pierwszego zadania");
//        solution.setExerciseId(1);
//        solution.setUsersId(3);
//        solution.setCreated();
//
//        SolutionDao solutionDao = new SolutionDao();
//        solutionDao.create(solution);
//        Solution[] solutions = solutionDao.findAll();
//        Solution[] solutions = solutionDao.findAllByUserId(1);
//        Solution[] solutions = solutionDao.findAllByExerciseId(1);
//        for (Solution s: solutions){
//            System.out.println(s);
//        }
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

        Solution solution = solutionDao.read(scanner.nextInt());
        System.out.println("Podaj rozwiązanie: ");
        Scanner scanner1 = new Scanner(System.in);
        String description = scanner.nextLine();
        solution.setDescription(description);
        solutionDao.update(solution);
    }

    public static void view(int userId){
        SolutionDao solutionDao = new SolutionDao();
        Solution[] solutions = solutionDao.findAllByUserId(userId);

        for (Solution s: solutions){
            System.out.println(s);
        }
    }

}
