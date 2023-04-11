import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class lesson5 {

    public static void main(String[] args) {

        Map<String, ArrayList<String>> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in, "Ads");

        boolean book = true;

        while (book) { 
            System.out.println();
            System.out.println("Введите команду:\n 1 - Добавление номера.\n" +
                    "2 - Вывод книги.\n" +
                    "0- Выйти из книги.");
            String operation = scanner.nextLine();
            switch (operation) {
                case "1":
                    addContact(phoneBook, scanner);
                    break;
                case "2":
                    showAllContacts(phoneBook);
                    break;
                case "0":
                    book = false;
                    System.out.println("Вы вышли из программы.");
                    break;
                default:
                    System.out.println("Неверная операция.");
                    break;
                    
            }
        }
    }

    public static void addContact(Map<String, ArrayList<String>> db, Scanner scanner) {

        System.out.println();
        ArrayList<String> phone_number = new ArrayList<>();
        System.out.println("Введите ФИО контакта: ");
        String name = scanner.nextLine().toUpperCase();
        System.out.println();
        System.out.println("Введите введите номер телефона: ");
        String number = scanner.nextLine();

        if (!db.containsKey(name)) {           
            db.put(name, phone_number);
        }

        db.get(name).add(number);

    }

    
    public static void showAllContacts(Map<String, ArrayList<String>> book) {

        System.out.println();

        for (String name : book.keySet()) {
            System.out.printf(name + ":\n");
            ArrayList<String> phones = book.get(name);

            for (String phone : phones) {
                System.out.printf(phone + "\n");
            }

            System.out.println();
        }
    }
}