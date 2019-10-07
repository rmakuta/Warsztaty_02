package pl.coderslab;

import pl.coderslab.exercise.Exercise;
import pl.coderslab.exercise.ExerciseDao;
import pl.coderslab.group.Group;
import pl.coderslab.group.GroupDao;
import pl.coderslab.solution.Solution;
import pl.coderslab.solution.SolutionDao;
import pl.coderslab.user.User;
import pl.coderslab.user.UserDao;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        User user1 = new User("Piotr", "piotr@fronczewski.pl", "123", 1);
        user.setName("Janek");
        user.setEmail("janek@baranek.pl");
        user.setPassword("132");
        user.setGroupId(1);

        UserDao userDao = new UserDao();
//        userDao.create(user1);

        Group group = new Group("druga");

        GroupDao groupDao = new GroupDao();
//        groupDao.create(group);

        Exercise exercise = new Exercise();
//        exercise.setTitle("czwarte");

        ExerciseDao exerciseDao = new ExerciseDao();
//        exerciseDao.create(exercise);

        Solution solution = new Solution();
        solution.setDescription("rozwiązanie pierwszego zadania");
        solution.setExerciseId(1);
        solution.setUsersId(1);

        SolutionDao solutionDao = new SolutionDao();
        solutionDao.create(solution);
    }
}