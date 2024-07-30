package demo;
import java.sql.*;
import java.util.*;
public class first{
	public static void main(String[] args)throws SQLException {
		PreparedStatement st=null;
		Connection con=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the book number");
		int bno=sc.nextInt();
		System.out.println("enter the book name");
		String bname=sc.next();
		System.out.println("enter the book price");
		float prices=sc.nextFloat();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gobi","root","root");
			con.setAutoCommit(false);
			st = con.prepareStatement("insert into " + "book values(" + bno + ",'" + bname + "'," + prices + ")");

			 st.executeUpdate();
			 System.out.println("inserted");
			 con.commit();
		}
		catch(Exception e) {
			con.rollback();
			System.out.println(e);
			
		}finally {
			st.close();
			con.close();
		}
		
	}
}