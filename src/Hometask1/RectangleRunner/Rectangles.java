package Hometask1.RectangleRunner;

import java.util.ArrayList;

/**
 * Created by rrty6 on 03.03.2017.
 */
public class Rectangles {
    ArrayList <Rectangle> listofRectangles = new ArrayList<Rectangle>();

    public void addRectangle (Rectangle rectangle){
        listofRectangles.add(rectangle);
    }



    public int recsumsquare (){
        int s = 0;
        for (int i=0;i<=listofRectangles.size();i++){
            s+=listofRectangles.get(i).square();

        }
        return s;

    }
}
