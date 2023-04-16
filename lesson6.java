import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class lesson6 {
    public static void main(String[] args) {

        notebook nb1 = new notebook("Asus", "Laptop 15 D543MA-DM1368", 6, 4000, "Windows Pro", "красный");
        notebook nb2 = new notebook("Acer", " ExpertBook L2 L2402CYA-EB0133", 4, 2048, "Linux", "белый");
        notebook nb3 = new notebook("ThundeRobot", "ThundeRobot 911 Plus Pro SD", 2, 1024, "Windows", "синий");
        notebook nb4 = new notebook("ThundeRobot", "911 MR Max", 8, 256, "Windows", "серый");
        notebook nb5 = new notebook("Asus", "VivoBook Pro 15", 16, 3056, "Windows", "серебристый");
        notebook nb6 = new notebook("Echips", "Echips Envy", 16, 512, "Linux", "зеленый");
        notebook nb7 = new notebook("OUIO", "GT5105-16GB-2TB", 16, 512, "Linux", "розовый");
        notebook nb8 = new notebook(" GEZI", " Graphics 600", 12, 1024, "macOS", "белый");
        notebook nb9 = new notebook("MAIBOOK", "M547", 32, 2048, "Windows", "черный");
        notebook nb10 = new notebook("Apple", "MacBook Air", 64, 256, "macOS", "серый");

        HashSet<notebook> notebooks = new HashSet<notebook>(
                Arrays.asList(nb1, nb2, nb3, nb4, nb5, nb6, nb7, nb8, nb9, nb10));

        Scanner scanner = new Scanner(System.in, "cp866");

        System.out.println();
        System.out.println("Давайте выберем ноутбук!\n" +
                "Вы сможете выбрать ваш новый ноут по нескольким критериям.\n" + 
                "Введите цифру важнейшего критерия, по которому выбираем: \n");

        boolean filter = true;

        while (filter) {
            System.out.println("1 - по размеру оперативной памяти\n" +
                    "2 - по объему жесткого диска\n" +
                    "3 - по типу операционной системы\n" +
                    "4 - по цвету\n" +
                    "5 - выход из каталога");
       
            String operation = scanner.nextLine();
            switch (operation) {
                case "1":
                    filterRAM(notebooks, scanner);
                    break;
                case "2":
                    filterhardDisk(notebooks, scanner);
                    break;
                case "3":
                    filterOS(notebooks, scanner);
                    break;
                case "4":
                    filterColor(notebooks, scanner);
                    break;                
                case "5":
                    System.out.println("Вы вышли из каталога!");
                    filter = false;
                    break;
                default:
                    System.out.println("Выбор не соответствует имеющимся вариантам");
                    System.out.println();
                    break;

            }
        }
    }
    
    public static void filterRAM(HashSet<notebook> notebooks, Scanner scanner) {

        TreeSet<Integer> RAM = new TreeSet<>();

        for (notebook note : notebooks) {
            RAM.add(note.getRAM());
        }

        System.out.println();
        System.out.println("У имеющихся ноутов разный объем ОЗУ: "
                + RAM.toString().replaceAll("^\\[|\\]$", "") + " Гб\n" +
                "Введите минимальное значение: ");

        String op = scanner.nextLine();
        int filter = Integer.parseInt(op);

        if (RAM.contains(filter)) {
            System.out.println();
            System.out.println("У нас есть: ");
            System.out.println();
            for (notebook note : notebooks) {
                if (note.getRAM() == filter) {
                    note.showInfo();
                }
            }

        } else {
            System.out.println("Таких нет! Попробуйте поискать по другому значению!");
            filterRAM(notebooks, scanner);
        }
    }
   
    public static void filterhardDisk(HashSet<notebook> notebooks, Scanner scanner) {

        TreeSet<Integer> hardDisk = new TreeSet<>();

        for (notebook note : notebooks) {
            hardDisk.add(note.getHardDisk());
        }

        System.out.println();
        System.out.println("У имеющихся ноутов разный объем жесткого диска "
                + hardDisk.toString().replaceAll("^\\[|\\]$", "") + " Гб\n" +
                "Введите минимальное значение: ");

        String op = scanner.nextLine();
        int filter = Integer.parseInt(op);

        if (hardDisk.contains(filter)) {
            System.out.println();
            System.out.println("У нас есть: ");
            System.out.println();
            for (notebook note : notebooks) {
                if (note.getHardDisk() == filter) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Таких нет! Попробуйте поискать по другому значению!");
            filterhardDisk(notebooks, scanner);
        }
    }
    
    public static void filterOS(HashSet<notebook> notebooks, Scanner scanner) {

        TreeSet<String> opSystems = new TreeSet<>();

        for (notebook note : notebooks) {
            opSystems.add(note.getopSystem());
        }

        System.out.println();
        System.out.println("У имеющихся ноутов разные операционные системы: "
                + opSystems.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующую: ");

        String op = scanner.nextLine().toUpperCase();

        if (opSystems.contains(op)) {
            System.out.println();
            System.out.println("У нас есть: ");
            System.out.println();
            for (notebook note : notebooks) {
                if (note.getopSystem().equals(op)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Таких нет! Попробуйте поискать по другому значению!");
            filterOS(notebooks, scanner);
        }
    }
    
    public static void filterColor(HashSet<notebook> notebooks, Scanner scanner){

        TreeSet<String> colors = new TreeSet<>();

        for (notebook note: notebooks){
            colors.add(note.getColor());
        }

        System.out.println();
        System.out.println("У имеющихся ноутов разные цвета: "
                + colors.toString().replaceAll("^\\[|\\]$", "") + "\n" +
                "Введите интересующий вас цвет: ");
      
        String os = scanner.nextLine().toLowerCase();

        if (colors.contains(os)) {
            System.out.println();
            System.out.println("У нас есть: ");
            System.out.println();
            for (notebook note : notebooks) {
                if (note.getColor().equals(os)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Таких нет! Попробуйте поискать по другому значению!");
            filterColor(notebooks, scanner);
        }
    }    
}