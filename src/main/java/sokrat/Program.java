package sokrat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Program {
    public static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
    public static ArrayList<Integer> counter = new ArrayList<>();
    public static void addContact(String contact, Integer number){
        if (phoneBook.containsKey(contact)){
            phoneBook.get(contact).add(number);
        }
        else {
            ArrayList<Integer> lst = new ArrayList<>();
            lst.add(number);
            phoneBook.put(contact, lst);
        }
    }
    public static void showContacts (HashMap<String, ArrayList<Integer>> phoneBook, ArrayList<Integer> counter){
        for (Map.Entry<String, ArrayList<Integer>> elem : phoneBook.entrySet()){
            counter.add(elem.getValue().size());
        }
        Collections.sort(counter, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = counter.size() - 1; i >= 0; i--){
            for (Map.Entry<String, ArrayList<Integer>> elem : phoneBook.entrySet()){
                if (counter.get(i) == elem.getValue().size()){
                    System.out.println(elem);
                }
            }
        }
    }

    public static void main(String[] args) {
        addContact("Sokrat", 123456);
        addContact("Sokrat", 789456);
        addContact("Sokrat", 896532);
        addContact("Ghaba", 458755);
        addContact("Ghaba", 7845632);
        addContact("Ketu", 451236);
        showContacts(phoneBook, counter);
    }
}
