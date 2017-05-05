package MyOwn;

import java.util.Arrays;

/**
 * Created by rrty6 on 05.05.2017.
 */
public class ArrayDelete
{
    public static void main(String[] args)
    {
     int[] ar = new int[5];
        for (int i = 0; i<ar.length;i++)
        {
           ar[i] = i;

        }


        System.out.println(Arrays.toString(ar));

     int[] ar1 = new int[4];
     for(int i1 = 0;i1<ar.length-1;i1++)
     {
         ar1[i1] = i1;
     }
        System.out.println(Arrays.toString(ar1));
    }
}
