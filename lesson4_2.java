import java.util.Scanner;
import java.util.LinkedList;

public class lesson4_2 {
    public static void main(String[] args) {

        LinkedList<Double> reslist = new LinkedList<Double>();  

        try (Scanner scanner = new Scanner(System.in)) {            
            System.out.print("Введите первое число: ");
            reslist.add(scanner.nextDouble());  
            scanner.nextLine();

            while(true) {  

                System.out.print("Выберите действие ( +, -, *, / ) \n или клавишу [X] для отмены последнего действия или выхода: ");
                String string = scanner.nextLine();       

                if ("X".equals(string) || "X".equals(string)) {  
                    reslist.removeFirst();

                    if (reslist.isEmpty()) reslist.add(0.0);  
                    }
                else {
                    System.out.print("Введите второе число: ");  
                    double num2 = scanner.nextDouble();  

                    calculate(reslist, string, num2);  
                    scanner.nextLine();  
                    }

                System.out.println("Результат: " + reslist.getFirst());                          
            }
        }
    }

    public static void calculate(LinkedList<Double> reslist, String string, double num2) {

        double result = reslist.getFirst();      

        switch (string) {                 
            
            case "+":
                reslist.add(0, reslist.getFirst() + num2);
                System.out.printf(result + " " + string + " " + num2 + " = " + reslist.getFirst() + "\n");               
                break;
            
            case "-":
                reslist.add(0, reslist.getFirst() - num2);
                System.out.printf(result + " " + string + " " + num2 + " = " + reslist.getFirst() + "\n"); 
                break;

            case "*":
                reslist.add(0, reslist.getFirst() * num2);
                System.out.printf(result + " " + string + " " + num2 + " = " + reslist.getFirst() + "\n");   
                break;
            
            case "/":
                if (num2 == 0) {       
                    System.out.println("На ноль делить нельзя (тут)!");
                    break;
                }
                reslist.add(0, reslist.getFirst() / num2);
                System.out.printf(result + " " + string + " " + num2 + " = " + reslist.getFirst() + "\n");  
                break;
            
            default:
                System.out.println("Что-то пошло не так. ");

        }
    }
}