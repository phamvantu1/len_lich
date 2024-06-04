package dao;

/**
 *
 * @QuangTung
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    public static Connection con;
    
    public DAO(){
		if(con == null){
			String dbUrl = "jdbc:mysql://localhost:3306/btl_cnpm_db?autoReconnect=true&useSSL=false";
			String dbClass = "com.mysql.cj.jdbc.Driver";

			try {
				Class.forName(dbClass);
				con = DriverManager.getConnection (dbUrl, "root", "mysql@123456");
                                System.out.println("OK!!");
			}catch(Exception e) {
				e.printStackTrace();
			}
                        
		}
	}
}
