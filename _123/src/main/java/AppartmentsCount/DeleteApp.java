package AppartmentsCount;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static AppartmentsCount.Main.conn;

public class DeleteApp {
     static void deleteAppartments (Scanner sc) throws SQLException{
        System.out.println("Enter appartment id to delete:");
        String sAppId = sc.nextLine();
        int appId = Integer.parseInt(sAppId);

         PreparedStatement ps = conn.prepareStatement("DELETE FROM appartments WHERE id = ?");
         try{
             ps.setInt(1,appId);
             ps.executeUpdate();
         }finally {
             ps.close();
         }

    }
}
