package AccessTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccessUtil {
	Connection conn = null;

	   

    public AccessUtil() throws Exception{

        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

        String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=D:\\Database1.accdb";

        conn = DriverManager.getConnection(url);

        System.out.println("Connect to Login Database Successful!");

    }
   

    public void DB_Loginout() throws Exception{

        if(conn!=null){

            try{

                conn.close();

                System.out.println("Close Login Database Successful!");

            }catch(SQLException e){

                System.out.println("Close Login Database Error!");

                e.printStackTrace();

            }

        }

    }

   

    public int DBQuery(String UserName, String Password) throws Exception{

        String sql = "select Password from Users where UserName='" + UserName + "';";

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(sql);

        String Ret = null;

       

        while(rs.next()){

            Ret=rs.getString(1);

            System.out.println(Ret);

 

           

            if(Password.equals(Ret)){

                System.out.println("User\"" + UserName + "\" Login Successful!");

                return 1;

            }

            else{

                System.out.println("User\"" + UserName + "\" Login Failed!");

                return 0;

            }

        }

       

        return -1;

    }
}
