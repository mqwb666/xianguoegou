package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 链接数据库
 */
public class conn {
	static Connection con=null;
	public static Connection con() {
		
		try {
			//1:记载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2:创建链接
			 con=DriverManager.getConnection("jdbc:mysql://1.116.95.148:3306/xianguoegou","xianguoegou","PZLyBzHHH6AzJDsD");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void close(Connection con,Statement st,ResultSet rs) {
		try {
			if(con!=null) {
				con.close();
			}
			if(st!=null) {
				st.close();
			}
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
