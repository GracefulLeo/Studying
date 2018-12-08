package Scrap.AppartmentsCount;

//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//import static AppartmentsCount.Main.conn;

/**
 * Created by gracefulleo on 23.06.17.
 */
public class ViewApp {
//    static void viewAppartments (Scanner sc) throws SQLException{
//        System.out.println("You want to check all appartments?");
//        String answer = sc.nextLine();
//        if (true /* == "yes"*/){
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM appartments");
//            try {
//                ResultSet rs = ps.executeQuery();
//                try{
//                    ResultSetMetaData md = rs.getMetaData();
//
//                    for (int i = 1; i <= md.getColumnCount(); i++)
//                        System.out.print(md.getColumnName(i));
//                    System.out.println();
//                    while (rs.next()){
//                        for (int i =1; i <=md.getColumnCount();i++){
//                        System.out.print(rs.getString(i)+"\t\t");
//                        }
//                        System.out.println();
//                    }
//                }finally {
//                    rs.close();
//                }
//            }finally {
//                ps.close();
//            }
//
//        }
//    }
}
