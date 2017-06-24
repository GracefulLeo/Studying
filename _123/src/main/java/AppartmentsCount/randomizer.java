package AppartmentsCount;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import static AppartmentsCount.Main.conn;


public class randomizer {
    static String randomAddress()  {return addressNames[rnd.nextInt(addressNames.length)];}
    static String randomRegionNames() {return regionNames[rnd.nextInt(regionNames.length)];}
    static int randomAreas() {return areas[rnd.nextInt(areas.length)];}
    static int randomRooms() {return rooms[rnd.nextInt(rooms.length)];}
    static int randomPrices() {return prices[rnd.nextInt(prices.length)];}

    static final Random rnd = new Random();
    static final String[] addressNames = {"Mitrofanova", "Shidna", "Griboedova", "Grizodubova"};
    static final String[] regionNames = {"East","West","North","South"};
    static final int[] areas = {22,44,66,99};
    static final int[] rooms = {1,2,3,4};
    static final int[] prices = {12000,24000,36000,90000};



    public static void random (Scanner sc) throws SQLException{

                System.out.println("Enter the number of appartments:" );
        String appCount = sc.nextLine();
        int Count = Integer.parseInt(appCount);


        conn.setAutoCommit(false);

        try {
            try {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO appartments (region,address,area,roomQuantity, price) VALUE (?,?,?,?,?)");
                try {
                    for (int i = 0 ; i < Count ;i++){
                        ps.setString(1,randomRegionNames());
                        ps.setString(2, randomAddress());
                        ps.setInt(3,randomAreas());
                        ps.setInt(4,randomRooms());
                        ps.setInt(5,randomPrices());
                        ps.executeUpdate();
                    }
                    conn.commit();
                }finally{
                    ps.close();
                }

                }catch (Exception ex) {
                conn.rollback();
            }
            }finally {
            conn.setAutoCommit(true);
        }

    }
}
