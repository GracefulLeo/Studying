package Hometask1.RectangleRunner;

/**
 * Created by rrty6 on 04.03.2017.
 */
public class RecRunner {
    public static void main(String[] args) {
        Rectangle one = new Rectangle(10,20);
        Rectangle two = new Rectangle(20,40);
        Rectangles listofrecs = new Rectangles();
        listofrecs.addRectangle(one);
        listofrecs.addRectangle(two);
        System.out.println(one.perimeter());
        System.out.println(two.perimeter());
        System.out.println(one.square());
        System.out.println(two.square());
        System.out.println(listofrecs.recsumsquare());


    }
}
