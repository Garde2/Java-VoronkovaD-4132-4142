/**
 *  кальк. добавила факториал, но криво, и мучаюсь с логами)

 */
import java.util.Scanner;
import java.util.logging.*;
import java.io.IOException;

public class lesson2_2 {
    static Scanner scanner = new Scanner(System.in);
     
    static public void main(String[] args) throws IOException {
                
        Calc();       
    }    

    static public void Logger() throws IOException{
    Logger logger = Logger.getLogger(test.class.getName());
    FileHandler fh = new FileHandler("log2.xml");
    logger.addHandler(fh);

    XMLFormatter xml = new XMLFormatter();
    fh.setFormatter(xml);     
        
    logger.info("Calc");
    } 

    static public void Calc() throws IOException{       //task3
                                       
        int num1 = getInt();
        int num2 = getInt();
        char op = getOperation();
        int result = result(num1,num2,op);
        System.out.println("Результат вычисления: "+ result);
       
    }

    public static int getInt() throws IOException {
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
        Logger();
        return num;
    }
    public static char getOperation() throws IOException {
        System.out.println("Введите операцию (+, -, *, /, !(от num1)):");
        char op;
        if(scanner.hasNext()){
            op = scanner.next().charAt(0);  
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            op = getOperation();                      
        }
        Logger();
        return op;
    }

    public static int factorial (int num1) throws IOException {
        int result = 1;
        for (int i = 1; i <= num1; i++) {
           result = result * i;            
        }        
        return result;           
    }

    public static int result(int num1, int num2, char op) throws IOException {
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
            case '!': 
                result = factorial(num1);
            default:
                System.out.println("Или это факториал или что-то пошло не так...");
                result = result(num1, num2, getOperation());
                 
        }
        Logger();        
        return result;
        
    }
} 
    

