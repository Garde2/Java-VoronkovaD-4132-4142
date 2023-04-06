import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

public class lesson2 {       
    
    public static void main(String[] args) throws IOException {

        Map<String, String> param = new HashMap<String,String>();
        param.put("name","Ivanov");
        param.put("country","Russia");
        param.put("city","Moscow");
        param.put("age",null);
        System.out.println(getResult(param));

        int[] sortArr = {14, 7, 3, 9, 1, 36, 145, 54, 2, 8, 5};
        Sort(sortArr);
        for(int i = 0; i < sortArr.length; i++){
        System.out.print(sortArr[i] + "\n");                
        }
    }    

    public static void Sort(int[] arr)  throws IOException {
        Logger logger = Logger.getLogger(test.class.getName());
        FileHandler fh = new FileHandler("log.xml");
        logger.addHandler(fh);

        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);        
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j + 1] < arr[j]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        logger.info("Test");
        }              
    }

    public static String getResult(Map<String, String> params)
    {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String,String> pair : params.entrySet())
        {
            if (pair.getValue() != null)
            {
                str.append(pair.getKey() +" = '" + pair.getValue()+"', ");
            }
        }
        str.delete(str.toString().length()-5,str.toString().length());
        return str.toString();
    }

}

//обернем логгером (по итерации тип логгер и вывод  хэндлер  в консоль/файл xml например важно какой уровень)
//меняем на файлхэндлер и меняем зависимость

