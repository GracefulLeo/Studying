package AppartmentsCount;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static AppartmentsCount.Main.conn;

public class addApp {
    static void addAppartments(Scanner sc) throws SQLException{
        System.out.println("Enter appartment region name:");
        String regName = sc.nextLine();
        System.out.println("Enter appartment adress:");
        String addressName = sc.nextLine();
        System.out.println("Enter appartment area:");
        String sAppArea = sc.nextLine();
        int appArea = Integer.parseInt(sAppArea);
        System.out.println("Enter quantity of rooms in appartment:");
        String sRmQuantity = sc.nextLine();
        int rmQuantity = Integer.parseInt(sRmQuantity);
        System.out.println("Enter price of this beatiful appartment:");
        String sPrice = sc.nextLine();
        int pr = Integer.parseInt(sPrice);

        PreparedStatement ps = conn.prepareStatement("INSERT INTO appartments (region,address,area,roomQuantity,price) VALUES (?,?,?,?,?)");
        try {
            ps.setString(1,regName);
            ps.setString(2,addressName);
            ps.setInt(3,appArea);
            ps.setInt(4,rmQuantity);
            ps.setInt(5,pr);
            ps.executeUpdate();
        }finally {
            ps.close();
        }
    }
}
