package pl.coderslab.exercise;

import java.util.Scanner;

public class ExerciseMenu {
    public void menu() {
        ExerciseDao exerciseDao = new ExerciseDao();
        boolean isRightOption = true;
        Scanner scanner = new Scanner(System.in);

        while (isRightOption){
            Exercise[] exercises = exerciseDao.findAll();
            System.out.println();
            for (Exercise e : exercises) {
                System.out.println(e);
            }
            System.out.println();
            System.out.println("Wybierz jedną z opcji: ");
            System.out.println("add - dodanie zadania");
            System.out.println("edit - edycja zadania");
            System.out.println("delete - usunięcie zadania");
            System.out.println("quit - zakończenie programu");

            String option = scanner.next();
            option = option.toLowerCase();

            switch (option){
                case "add": add(); break;
                case "edit": edit(); break;
                case "delete": delete(); break;
                case "quit": isRightOption = false;
            }
        }
    }

    public void add(){
        System.out.println("No to dodajemy!");
        Exercise exercise = new Exercise();
        Scanner scanner = new Scanner(System.in);

        System.out.println("title: ");
        exercise.setTitle(scanner.nextLine());

        System.out.println("opis: ");
        exercise.setDescription(scanner.nextLine());

        ExerciseDao exerciseDao = new ExerciseDao();
        exerciseDao.create(exercise);
    }

    public void edit(){
        System.out.println("No to edytujemy!");
        System.out.println("Podaj ID zadania do edycji: ");
        Scanner scanner = new Scanner(System.in);
        ExerciseDao exerciseDao = new ExerciseDao();

        Exercise exercise = exerciseDao.read(scanner.nextInt());
        System.out.println("id: " + exercise.getId());

        System.out.println("title: " + exercise.getTitle() + ", po zmianie: ");
        exercise.setTitle(scanner.next());

        System.out.println("description: " + exercise.getDescription() + ", po zmianie: ");
        Scanner scanner1 = new Scanner(System.in);
        exercise.setDescription(scanner1.nextLine());

        exerciseDao.update(exercise);
    }

    public void delete(){
        System.out.println("No to usuwamy!");
        ExerciseDao exerciseDao = new ExerciseDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID do usunięcia: ");
        exerciseDao.delete(scanner.nextInt());
    }
}
