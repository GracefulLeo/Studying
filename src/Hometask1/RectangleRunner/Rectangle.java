package Hometask1.RectangleRunner;

/**
 * Created by rrty6 on 03.03.2017.
 */
public class Rectangle {

    private int width;
    private int length;

        Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int perimeter (){
            int p = 2* (length + width);
            return p;
    }

    public int square (){
        int s = length * width;
        return  s;
    }
}
