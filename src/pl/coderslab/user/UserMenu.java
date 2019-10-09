package pl.coderslab.user;

import java.util.Scanner;

public class UserMenu {

    public void menu() {
        UserDao userDao = new UserDao();
        boolean isRightOption = true;
        Scanner scanner = new Scanner(System.in);

        while (isRightOption){
            User[] users = userDao.findAll();
            System.out.println();
            for (User u : users) {
                System.out.println(u);
            }
            System.out.println();
            System.out.println("Wybierz jedną z opcji: ");
            System.out.println("add - dodanie użytkownika");
            System.out.println("edit - edycja użytkownika");
            System.out.println("delete - usunięcie użytkownika");
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
        User user = new User();
        Scanner scanner = new Scanner(System.in);

        System.out.println("name: ");
        user.setName(scanner.next());

        System.out.println("email: ");
        user.setEmail(scanner.next());

        System.out.println("password: ");
        user.setPassword(scanner.next());

        System.out.println("groupId: ");
        user.setGroupId(scanner.nextInt());

        UserDao userDao  = new UserDao();
        userDao.create(user);
    }

    public void edit(){
        System.out.println("No to edytujemy!");
        System.out.println("Podaj ID użytkownika do edycji: ");
        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDao();
        User user = userDao.read(scanner.nextInt());
        System.out.println("id: " + user.getId());
        System.out.println("name: " + user.getName() + ", po zmianie: ");
        user.setName(scanner.next());
        System.out.println("email: " + user.getEmail() + ", po zmianie: ");
        user.setEmail(scanner.next());
        System.out.println("password: " + user.getPassword() + ", po zmianie: ");
        user.setPassword(scanner.next());
        System.out.println("gropId: " + user.getGroupId() + ", po zmianie: ");
        user.setGroupId(scanner.nextInt());
        userDao.update(user);
    }

    public void delete(){
        System.out.println("No to usuwamy!");
        UserDao userDao = new UserDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID do usunięcia: ");
        userDao.delete(scanner.nextInt());
    }
}
