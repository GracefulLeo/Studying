package MyOwn;


import java.util.Arrays;

/**
 * Created by rrty6 on 05.05.2017.
 */
public class StringCheckers
{
    public static void main(String[] args)
    {
    String[] MyList = new String [2];
        String a = new String("Fuck yeah!!");
        MyList[0] = a;
        System.out.println(MyList[0]);
        String b = new String("Super FUCK YEAH!!!!");
        MyList[1] = b;
        // Checking of properly work of new object
        for (int i = 10; i>0 ; i--)
        {
            System.out.println(Arrays.toString(MyList));
        }
        // Alternate of ArrayList getSize
    int arrsize = MyList.length;
        System.out.println(arrsize);
        // Alternate of ArrayList getObject
    String s = MyList[1];
        System.out.println(s);
    if (MyList[1] == null)
        System.out.println("Cell is empty");
    else
        System.out.println(MyList[1]);
    }
}
