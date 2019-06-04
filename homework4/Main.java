package homework4;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static void showCollision(){
        Collision cat1 = new Collision(1, "John");
        Collision cat2 = new Collision(2, "Jake");

        HashMap<Collision, Integer> cats = new HashMap<>();
        cats.put(cat1, cat1.getId());
        cats.put(cat2, cat2.getId());

        for(Map.Entry entry : cats.entrySet()){
            System.out.println("Key: " + entry.getKey().toString()+" Value: " + entry.getValue());
            System.out.println("Hashcode of key is: " + entry.getKey().hashCode());
        }
    }

    private static void showLostElement(){
        Cat cat1 = new Cat(1, "Biba");
        Cat cat2 = new Cat(2, "Joba");

        HashMap<Cat, String> cats = new HashMap<>();
        cats.put(cat1, cat1.getName());
        cats.put(cat2, cat2.getName());

        for(Map.Entry entry : cats.entrySet()){
            System.out.println("Key: " + entry.getKey().toString()+" Value: " + entry.getValue());
            System.out.println("Hashcode of key is: " + entry.getKey().hashCode());
        }

        cat1.setId(55);

        System.out.println("\nFind cat1 key in catMap: " + cats.containsKey(cat1));
        System.out.println("Get cat1 value : " + cats.get(cat1));

        HashMap<Cat, String> catsNew = new HashMap<>(cats);
        System.out.println("Find cat1 key in catNewMap: " + catsNew.containsKey(cat1));
        System.out.println("Get cat1 value: " + catsNew.get(cat1));
    }


    public static void main(String[] args) {
        System.out.println("Task A");
        showCollision();

        System.out.println("\nTask B");
        showLostElement();
    }
}