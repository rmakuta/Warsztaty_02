package pl.coderslab;

import pl.coderslab.exercise.Exercise;
import pl.coderslab.exercise.ExerciseDao;
import pl.coderslab.exercise.ExerciseMenu;
import pl.coderslab.group.Group;
import pl.coderslab.group.GroupDao;
import pl.coderslab.group.GroupMenu;
import pl.coderslab.solution.Solution;
import pl.coderslab.solution.SolutionDao;
import pl.coderslab.solution.SolutionMenu;
import pl.coderslab.user.User;
import pl.coderslab.user.UserDao;
import pl.coderslab.user.UserMenu;

public class Main {
    public static void main(String[] args) {
//        UserMenu userMenu = new UserMenu();
//        userMenu.menu();

//        ExerciseMenu exerciseMenu = new ExerciseMenu();
//        exerciseMenu.menu();

//        GroupMenu groupMenu = new GroupMenu();
//        groupMenu.menu();

        SolutionMenu solutionMenu = new SolutionMenu();
        solutionMenu.menu();

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

}
