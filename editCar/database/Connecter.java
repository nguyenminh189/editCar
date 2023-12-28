package editCar.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connecter {

        private Connection conn1;
        private static Connecter _instance;

        private Connecter(){
            String host= "jdbc:mysql://localhost:3306/projectjava2";
            String user="root";
            String pwd = "root";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                this.conn1 = DriverManager.getConnection(host, user,pwd);
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        public static Connecter getInstance(){
            if(_instance == null){
                _instance = new Connecter();
            }
            return _instance;
        }
        public Connection getConn() {
            return conn1;
        }



}
