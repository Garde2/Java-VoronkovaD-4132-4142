/**
 *  Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

    Вывести все простые числа от 1 до 1000

    Реализовать простой калькулятор

    * +Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69. 
    Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.

 */
import java.util.Scanner;

public class lesson1 {
    static Scanner scanner = new Scanner(System.in);
    static public void main(String[] args) {

        //Triangle(4);
        //Simple(1, 1000);
        Calc();

    }    

    static public void Simple(int min, int max) {       //task2
        int counter = 0;
        int i, x;
        for(i = min; i < max; i++) {
            for(x = 1; x <= i; x++) {
                if (i % x == 0) {
                    counter ++;
                }
            }
                if(counter == 2){
                    System.out.println(i);
                    counter = 0;
                }
                else{
                    counter = 0;
                }
            }       
        
    }

    static public void Triangle(int n) {       //task1
                                             
        int tn = n * (n + 1)/2; //summ
        int mn = 1 ; 
        for (int k = 1; k < n; k++, mn *= k);  // multiply

        System.out.println(tn);  //task 1
        System.out.println(mn); //task 1-2
    }

    static public void Calc() {       //task3
                                       
        int num1 = getInt();
        int num2 = getInt();
        char op = getOperation();
        int result = result(num1,num2,op);
        System.out.println("Результат вычисления: "+result);
       
    }

    public static int getInt(){
        System.out.println("Введите число:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        }
        else{
            System.out.println("Ошибка! Попробуйте еще раз!");
            scanner.next();
            num = getInt();        
        }
        return num;
    }
    public static char getOperation(){
        System.out.println("Введите операцию (+, -, *, /):");
        char op;
        if(scanner.hasNext()){
            op = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            op = getOperation();
        }
        return op;
    }
    public static int result(int num1, int num2, char op){
        int result;
        switch (op){     //выбор вариантов, базируемся на вводе символов
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                System.out.println("Что-то пошло не так... Введите еще раз...");
                result = result(num1, num2, getOperation());
        }
        return result;
    }
}
