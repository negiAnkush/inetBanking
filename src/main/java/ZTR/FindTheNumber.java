package ZTR;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTheNumber {
    public static String findString(List<String> countries, String str)
    {
        String flag = "no";
        for (String cntry : countries)
            if (cntry==str)
                flag ="yes";

        return flag;
    }

    public static String findNumber(List<Integer> arrInt, int n)
    {
        String flag = "no";
        for (int arr : arrInt)
            if (arr==n)
                flag ="yes";

        return flag;
    }


    public static void main (String [] args)
    {
        List<Integer> intList = new ArrayList<>(Arrays.asList(1,4,12,43,53,32,22,87,3));
        List<String> strList =  Arrays.asList("canada","japan","india","usa","korea","australia");

        System.out.println("is no is present :"+findNumber(intList, 4));
        System.out.println("is string is present :"+findString(strList, "usa"));

    }
}
