package ZTR;

import java.util.HashSet;

public class FirstDuplicateIntegerValue {
    public static int getFirstDuplicatePos(int[] arr)
    {
        HashSet<Integer> intInArr = new HashSet<>();
        for (int i=0; i<arr.length; i++)
        {
            if (intInArr.contains(arr[i]))
                return arr[i];
            else
                intInArr.add(arr[i]);
        }
        return '-';
    }


    public static void main(String args[])
    {
        int[] arr = {1,2,1,8,2,1,6};
        System.out.println("first duplicate of integer : "+getFirstDuplicatePos(arr));
    }
}
