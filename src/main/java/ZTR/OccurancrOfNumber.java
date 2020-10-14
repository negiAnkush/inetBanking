package ZTR;

public class OccurancrOfNumber {

    public static void main (String args[])
    {
        String str = "1 2 2 3 3 3 4 4 4 4 5 5 5 5 5 6 6 6 6 6 6";
        String [] strArr = str.split(" ");
        int[] arr = new int[strArr.length];

        for (int i =0; i<strArr.length; i++)
                arr[i] = Integer.parseInt(strArr[i]);


        int[] count = new int[arr.length];
        int temp =0;
        for (int i=0; i<arr.length; i++)
        {
            temp = arr[i];
            count[temp]++;
        }
         for (int i=0; i<arr.length; i++)
                if(count[i]>0)
                {
                    System.out.printf("%d occuranc of %d times \n", i, count[i]);

                }


         /* fibonac series

          */
        System.out.println("fibonac series ");

         int n=10, a=0, b=1, sum;
         System.out.print("series of "+ n +" terms is : ");

         for (int i =1; i<=n; i++)
        {
            sum=a+b;
            System.out.print(a+" ");
            a=b;
            b=sum;
        }

    }
}
