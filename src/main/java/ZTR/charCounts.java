package ZTR;

import java.util.HashMap;
import java.util.Map;

public class charCounts {

    public static void charCountInString(String str)
    {
        Map<Character, Integer> charSetMap = new HashMap<>();

        char[] charArr = str.toLowerCase().toCharArray();

        for (char c : charArr)
        {
            if (c!=' ')
            {
                if(charSetMap.containsKey(c))

                    charSetMap.put(c, charSetMap.get(c)+1);

                else

                    charSetMap.put(c,1);
            }
        }


        for(Map.Entry entry : charSetMap.entrySet())
        {
            System.out.println(entry.getKey()+"   "+entry.getValue());
        }

    }

    public static void main(String args[])
    {

        String givenString = "aNkushRashMiNegirAwat";
        charCountInString(givenString);

    }
}
