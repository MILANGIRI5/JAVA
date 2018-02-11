import java.sql.*;
public class Demo
{
	public static void main(String[] args)
	{
		try {
			//first step (Load & register driver )
			Class.forName("com.mysql.jdbc.Driver"); 
			
			
			//second step(Get connection)
			Connection con=DriverManager.getConnection("jdbc:mySql://localhost:3306","root","root");
			
			if(con != null) 
				System.out.println("connection open...");
			
			// step 3 : creating statement 
			Statement st=con.createStatement();
			
			//step 4 : executing query 
			ResultSet rs=st.executeQuery("select id, name from dingadb.student");
			
			
			while(rs.next()) {
				String name = rs.getString("name"); 
				int id = rs.getInt("id"); 
				System.out.println("Id : " + id + " \t name :" + name);
			}
			
			//step 5 : closing connection 
			con.close();
			
			System.out.println("connection closed !!! ");
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}

	}

}
