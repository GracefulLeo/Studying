package AppartmentsCount;

import java.sql.SQLException;
import java.sql.Statement;

import static AppartmentsCount.Main.conn;


public class inDB {
    public static void initDB () throws SQLException{
        Statement st = conn.createStatement();
        try {
            st.execute("DROP TABLE if EXISTS appartments");
            st.execute("CREATE TABLE appartments(id INT not NULL auto_increment PRIMARY KEY, Region VARCHAR (20),address VARCHAR(20) , area INT , roomQuantity INT , price INT)");
        }finally{
            st.close();
        }
    }

}