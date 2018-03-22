/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package usearraylistandhashmap;

import java.util.ArrayList;

/**
 *
 * @author nrg
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        CustomArrayList<String> people = new CustomArrayList<String>();
        people.add("Nick");
        people.add("John");
        people.add("Nikola");
        people.add("Misha");
        people.add("Petia");

        people.set(3,"Alex");
        
        people.add(2, "444");
        people.add(3,"111");

        people.remove("Nick");
        people.remove("111");
        people.remove("Petia");


        System.out.println("-----------------------   ");
        System.out.println("---- ArrayList --------   ");
        System.out.println("-----------------------   ");
        System.out.println("Count of elements =  "+people.size());
        for(int i=0; i<=people.size()-1; i++){
            System.out.println(i+1+") "+people.get(i));

        }
        System.out.println("--------------------   ");
        
        CustomLinkedList<String> cities = new CustomLinkedList<String>();
        cities.add("Minsk");
        cities.add("Soligorsk");
        cities.add("Milan");
        cities.add("Kiev");
        cities.add(1, "111");
        cities.add(5, "555");
        cities.add(5, "666");

        cities.remove(1);
        cities.remove(5);
        cities.remove(3);

        cities.remove("Soligorsk");

        cities.set(-3, null);
        cities.set(0, "Stolin");
        cities.set(1, "Stolin");

        System.out.println("-----------------------   ");
        System.out.println("---- LinkedList -------   ");
        System.out.println("-----------------------   ");
        System.out.println("Count of elements =  "+cities.size());
        for(int i=1; i<=cities.size(); i++){
            System.out.println(i+") "+cities.get(i));
        }
        System.out.println("----------------------   ");
        System.out.println("----------------------   ");
        System.out.println("---- HashMap ---------   ");
        System.out.println("----------------------   ");

        CustomHashMap<Integer, Integer> map = new CustomHashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(11, 11);
        map.put(101, 101);
        map.put(2, 2);
        map.put(201,201);
        map.put(9,9);

        map.put(11,12);
        map.put(12,12);

        System.out.println("get value is " + map.get(1));
        System.out.println("get value is " + map.get(201));
        System.out.println("--------------------------------------------");
        map.showAllElements();
        System.out.println("--------------------------------------------");

        map.remove(101);
        map.remove(201);

        map.remove(13);

        map.showAllElements();
        System.out.println("--------------------------------------------");
    }

}
