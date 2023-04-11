import java.util.LinkedList;

public class lesson4 {

    public static void main(String[] args) {

        LL();

        LinkedList<Integer> list = new LinkedList<Integer>();

        int[] array = {3, 4, 5, 1, 8, 7, 9, 2,};

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        int number = 1;
        
        System.out.println("C чем работаем - ");
        System.out.println(list);

        enqueue(list, number);
        System.out.println("Метод <enqueue>, элемент (" + number + ") добавлен в конец очереди:");
        System.out.println(list);

        System.out.println("Метод <dequeue>, возвращает первый элемент из очереди (" + dequeue(list) + ") и удаляет его.");
        System.out.println("Очередь после метода <dequeue>:");
        System.out.println(list);

        System.out.println("Метод <first>, возвращает первый элемент из очереди (" + first(list) + ") не удаляя его.");
        System.out.println("Очередь после метода <first>:");
        System.out.println(list);

    }

    public static LinkedList<Integer> LL(){

        LinkedList<Integer> somelist = new LinkedList<>();

        somelist.add(1);
        somelist.add(3);
        somelist.add(2);
        somelist.add(9);
        somelist.add(8);
        somelist.add(7);
        System.out.println("Исходный список элементов: " + somelist);

        LinkedList<Integer> reversed = reverse(somelist);
        System.out.println("Перевернутый список: " + reversed);

        return somelist;
    }    

    public static LinkedList<Integer> reverse(LinkedList<Integer> somelist) {

        LinkedList<Integer> reversed = new LinkedList<>();

        for (int i = somelist.size() - 1; i >= 0; i--) {
            Integer element = somelist.get(i);
            reversed.add(element);
        }
        return reversed;

    }    
   
    public static void enqueue(LinkedList<Integer> array, int num) {

        array.add(num);
    }

    public static int dequeue(LinkedList<Integer> array) {

        int number = 0;
        number = array.get(0);
        array.remove(0);
        return number;

    }

    public static int first(LinkedList<Integer> array) {

        int number = 0;
        number = array.get(0);
        return number;

    }
}
