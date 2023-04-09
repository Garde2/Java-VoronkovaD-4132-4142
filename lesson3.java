import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;

public class lesson3 {

    public static int[] SortMerge(int[] sortArr) {
        
        int[] numm = Arrays.copyOf(sortArr, sortArr.length);
        int[] numm1 = new int[sortArr.length];
        int[] result = SortMergeInner(numm, numm1, 0, sortArr.length);
        return result;
        
    }

    public static int[] SortMergeInner(int[] numm, int[] numm1, int startIndex, int endIndex) {
        
        if (startIndex >= endIndex - 1) {
            return numm;
            
        }
        
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted = SortMergeInner(numm, numm1, startIndex, middle);
        int[] sorted1 = SortMergeInner(numm, numm1, middle, endIndex);

        int index = startIndex;
        int index1 = middle;
        int destIndex = startIndex;
        int[] result = sorted == numm ? numm1 : numm;
        
        while (index < middle && index1 < endIndex) {
            result[destIndex++] = sorted[index] < sorted1[index1]
                    ? sorted[index++] : sorted1[index1++];
        }
        while (index < middle) {
            result[destIndex++] = sorted[index++];
        }
        while (index1 < endIndex) {
            result[destIndex++] = sorted1[index1++];
        }
        return result;
    }
        
    public static ArrayList<Integer> CreateIt(int capacity){  //создадим список

        ArrayList<Integer> numbers = new ArrayList<>();
        
        Random rnd = new Random();        

            for (int i=0; i < capacity; i++) {
                numbers.add(rnd.nextInt(50));
            }             
        return numbers;
        
    }

    public static void SortIt(ArrayList<Integer> numbers, int capacity){  // удалим четные
        
        for (int i = numbers.size() - 1; i >= 0; i--) {
            int even = numbers.get(i) % 2;
            if (even == 0) {
                //System.out.println("чч:" + numbers.get(i));
                numbers.remove(i);
            }
        }
        Collections.sort(numbers);
        System.out.println(numbers);
        
    }  

    public static void SortItAgain(ArrayList<Integer> numbers, int capacity){  // мин макс среднее
        
        int min;
        int max;
        float average = 0;

        for (int i = 0; i < capacity; i++) {
            average = average  + numbers.get(i);
        }

        Collections.sort(numbers);
        System.out.println("С чем работаем: "); 
        System.out.println(numbers); 
        min = numbers.get(0);
        max = numbers.get(capacity - 1);
        average = average / capacity;
        System.out.println("Минимальное - " + min); 
        System.out.println("Максимальное - " + max); 
        System.out.println("Среднее - " + average); 
                 
    }         
    
    public static void main(String[] args){

        int[] sortArr = {60, 15, 23, 2, 65, 45, 83, 12, 6, 1};
        int[] result = SortMerge(sortArr);
        System.out.println("Задача 1:"); 
        System.out.println(Arrays.toString(result));
        
        int capacity = 15;
        //CreateIt(capacity); 
        System.out.println("Задача 2, исходный:"); 
        System.out.println(CreateIt(capacity));           
        System.out.println("Задача 2,Сортированный:");          
        SortIt(CreateIt(capacity), capacity);     
        System.out.println("Задача 3:");  
        SortItAgain(CreateIt(capacity), capacity);          
        
    }
   
}


    

