package ZTR;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/** * Java Program to find duplicate elements in an array. There are two straight
 * forward solution of this problem first, brute force way and second by using
 * * HashSet data structure. A third solution, similar to second one is by using
 * * hash table data structure e.g. HashMap to store count of each element and * print element with count 1.
 * * * @author AnkyNegi
 * */

public class DuplicateInArray {

    public static void main (String[] args)
    {
        String[] names = {"ankush", "rashmi", "pankaj", "kavita", "laxman", "sourav", "rashmi", "trilochan"};


        // brute force method
        System.out.println("dupicate using brute force ");
        for(int i=0; i<names.length; i++)
            for (int j=i+1; j<names.length; j++)
                if (names[i].equals(names[j]))
                    System.out.println("found duplicate elememt in array using brute force : "+names[j]);

        System.out.println("\n");

        System.out.println("dupicate using datastructure hasset ");
        HashSet<String> setNames = new HashSet<>();
        for (String name : names)
        {
            if (setNames.contains(name))
                System.out.println("found duplicate elememt in array using hasset : "+name);
            else
                setNames.add(name);
        }

        System.out.println("\n");

        System.out.println("dupicate using datastructure hashmap ");
        HashMap<String,Integer> mapNames = new HashMap<>();
        for (String name : names)
        {
            if (mapNames.containsKey(name))
                mapNames.put(name, mapNames.get(name)+1);
            else
                mapNames.put(name, 1);
        }

        for (String name : names)
            if (mapNames.get(name)>1) {
                System.out.println("found duplicate elememt in array using hasmap :" + name);
                break;
            }

        for (Map.Entry<String,Integer> entry : mapNames.entrySet())
        {
            if (entry.getValue()>1)
                System.out.println("found duplicate elememt in array using hasmap :" + entry.getKey());

        }

    }
}
