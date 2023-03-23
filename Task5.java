/*
Сташкова К.С., группа 10|4992|25/01/2023

    Реализуйте структуру телефонной книги с помощью HashMap, 
    учитывая, что 1 человек может иметь несколько телефонов.
    (список сотрудников задан изначально)
    Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
    Отсортировать по убыванию популярности номеров.
 */

package HW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class Task5 {

    public static void main(String[] args) {

        
        HashMap<String, String> users = new HashMap<>();
        users.put("89103456666", "Иван Иванов");
        users.put("89103662352", "Светлана Петрова");
        users.put("89108374666", "Кристина Белова");
        users.put("89108297429", "Кристина Белова");
        users.put("89120817429", "Анна Мусина");
        users.put("89018462429", "Анна Крутова");
        users.put("89018462430", "Анна Крутова");
        users.put("89001942430", "Иван Юрин");
        users.put("89001942499", "Петр Лыков");
        users.put("89001942112", "Павел Чернов");
        users.put("89001942133", "Павел Чернов");
        users.put("89045672133", "Петр Чернышов");
        users.put("89020942133", "Мария Федорова");
        users.put("89947174827", "Марина Светлова");
        users.put("89092856284", "Мария Савина");
        users.put("89001900003", "Мария Рыкова");
        users.put("89826461864", "Мария Рыкова");
        users.put("89892957398", "Марина Лугова");
        users.put("89000011133", "Анна Владимирова");
        users.put("89829918364", "Иван Мечников");
        users.put("89826468888", "Петр Петин");
        users.put("89804836194", "Иван Ежов");

        LinkedHashMap<String, Integer> calls = new LinkedHashMap<>();
        calls.put("89103456666", new Random().nextInt(10));
        calls.put("89103662352", new Random().nextInt(10));
        calls.put("89108374666", new Random().nextInt(10));
        calls.put("89108297429", new Random().nextInt(10));
        calls.put("89120817429", new Random().nextInt(10));
        calls.put("89018462429", new Random().nextInt(10));
        calls.put("89018462430", new Random().nextInt(10));
        calls.put("89001942430", new Random().nextInt(10));
        calls.put("89001942499", new Random().nextInt(10));
        calls.put("89001942112", new Random().nextInt(10));
        calls.put("89001942133", new Random().nextInt(10));
        calls.put("89045672133", new Random().nextInt(10));
        calls.put("89020942133", new Random().nextInt(10));
        calls.put("89947174827", new Random().nextInt(10));
        calls.put("89092856284", new Random().nextInt(10));
        calls.put("89001900003", new Random().nextInt(10));
        calls.put("89826461864", new Random().nextInt(10));
        calls.put("89892957398", new Random().nextInt(10));
        calls.put("89000011133", new Random().nextInt(10));
        calls.put("89829918364", new Random().nextInt(10));
        calls.put("89826468888", new Random().nextInt(10));
        calls.put("89804836194", new Random().nextInt(10));

        String[] ppl = names(users);
        pplCounter(ppl);
        callsCounter(calls);
    }

    static String[] names(HashMap<String, String> data){
        ArrayList <String> temp = new ArrayList<>();
        temp.addAll(data.values());
        String t = "";
        for (int i = 0; i < temp.size(); i ++){
            t = t.concat(temp.get(i) + " ");
        }
        String[] users = t.split(" ");
        return users;
    }

    static void pplCounter(String[] people){
        Set<String> ppl = new HashSet<>();
        for (int i = 0; i < people.length; i+=2) {
            int n = 0;
            for (int j = 0; j < people.length; j++) {
                if (people[i].contains(people[j])) {
                    n++;
                }
            }  
        ppl.add("Имя "+ people[i] + " встречается " + n +" раз");          
        }
        System.out.println(ppl);
    }

    static void callsCounter(LinkedHashMap<String, Integer> data){
        Set<String> keys = data.keySet();
        TreeMap<Integer, String> phonecalls = new TreeMap<>();
        for(String k: keys){
            phonecalls.put(data.get(k), k);
        }
        System.out.println(phonecalls);
    }
}



