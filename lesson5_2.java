import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class lesson5_2 {
    public static void main(String[] args) {

        Map<String, Integer> names = new HashMap<>();
        String[] all = {
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"
        };
        countName(all, names); 
        sortedStaff(names);

    }
   
    public static void countName(String[] people, Map<String, Integer> names) {

        for (String person : people) {
            String name = person.split(" ")[0];

            if (names.containsKey(name)) {
                names.put(name, names.get(name) + 1);
            } else {
                names.put(name, 1);

            }
        }
    }
    
    public static void sortedStaff(Map<String, Integer> names) {

        Map<String, Integer> sorted= names.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));

        sorted.entrySet().forEach(System.out::println); 

    }
}

