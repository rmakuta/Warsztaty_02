package pl.coderslab.group;

import java.util.Scanner;

public class GroupMenu {
    public void menu() {
        GroupDao groupDao = new GroupDao();
        boolean isRightOption = true;
        Scanner scanner = new Scanner(System.in);

        while (isRightOption){
            Group[] groups = groupDao.findAll();
            System.out.println();
            for (Group g : groups) {
                System.out.println(g);
            }
            System.out.println();
            System.out.println("Wybierz jedną z opcji: ");
            System.out.println("add - dodanie grupy");
            System.out.println("edit - edycja grupy");
            System.out.println("delete - usunięcie grupy");
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
        Group group = new Group();
        Scanner scanner = new Scanner(System.in);

        System.out.println("name: ");
        group.setName(scanner.next());

        GroupDao groupDao = new GroupDao();
        groupDao.create(group);
    }

    public void edit(){
        System.out.println("No to edytujemy!");
        System.out.println("Podaj ID grupy do edycji: ");
        Scanner scanner = new Scanner(System.in);
        GroupDao groupDao = new GroupDao();

        Group group = groupDao.read(scanner.nextInt());
        System.out.println("id: " + group.getId());

        System.out.println("name: " + group.getName() + ", po zmianie: ");
        group.setName(scanner.next());

        groupDao.update(group);
    }

    public void delete(){
        System.out.println("No to usuwamy!");
        GroupDao groupDao = new GroupDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID do usunięcia: ");
        groupDao.delete(scanner.nextInt());
    }
}
