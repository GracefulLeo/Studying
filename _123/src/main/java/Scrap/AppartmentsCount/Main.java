package Scrap.AppartmentsCount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import static Scrap.AppartmentsCount.addApp.addAppartments;


public class Main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/appartments";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "29eb1f1ca";

    static Connection conn;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            try {
                conn = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
                inDB.initDB();

                while (true){
                    System.out.println("1.Add appartments:");
                    System.out.println("2.Add random appartments:");
                    System.out.println("3.Delete appartments:");
                    System.out.println("4.View appartments (all/via criteria):");
                    System.out.println("->");

                    String s =sc.nextLine();
                    switch (s){
                        case "1":
//                            addAppartments(sc);
                            break;
                        case "2":
//                            randomizer.random(sc);
                            break;
                        case "3":
//                            DeleteApp.deleteAppartments(sc);
                            break;
                        case "4":
//                            ViewApp.viewAppartments(sc);
                            break;

                    }
                }
            }finally {
                sc.close();
                if(conn!=null) conn.close();
            }

        }catch (Exception ex){
            ex.printStackTrace();
            return;
        }
    }


}
