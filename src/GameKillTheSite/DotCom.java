package GameKillTheSite;

import java.util.ArrayList;

/**
 * Created by rrty6 on 12.05.2017.
 */
public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public void setName (String n){
        name = n;
    }

    public String checkYourself (String userInput){
        String result = "мимо";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);

        if (locationCells.isEmpty()) {
            result = "Потопил";
            System.out.println("Ой! Вы потопили" + name + "  :(" );
            } else {
            result = "Попал";
        }
        }
      return  result;
    }
}
