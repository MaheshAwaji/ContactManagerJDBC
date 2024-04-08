package com.jspiders.contactmanager.jdbcOperations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCOperations {
	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static ResultSet resultSet;
	
	public static void insertContact(int id,String firstName,String lastName,long mobileNumber,String email,String category) {
		try {
			openConnection();
			query="insert into contact values(?,?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, firstName);
			preparedStatement.setString(3, lastName);
			preparedStatement.setLong(4, mobileNumber);
			preparedStatement.setString(5,email);
			preparedStatement.setString(6, category);
			int res=preparedStatement.executeUpdate();
			if (res==1) {
				System.out.println("Contact saved Successfully");
				
			}else {
				System.err.println("Error");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void displayContacts( ResultSet resultSet) throws SQLException {
		if (!resultSet.next()) {
			System.err.println("Contact list is Empty ");
			return;
			
		} else {
			do{
				System.out.print(resultSet.getInt(1)+" ");
				System.out.print(resultSet.getString(2)+" ");
				System.out.print(resultSet.getString(3)+" ");
				System.out.print(resultSet.getLong(4)+" ");
				System.out.print(resultSet.getString(5)+" ");
				System.out.print(resultSet.getString(6)+" ");
				System.out.println();
			}while(resultSet.next());
		}
		
		
	}
	public static void showContact() {
		try {
			openConnection();
			query="select * from contact";
			preparedStatement=connection.prepareStatement(query);
			resultSet= preparedStatement.executeQuery();
			displayContacts(resultSet);
		} catch (Exception e) {
	         e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void deleteContact(int id) {
		try {
			openConnection();
			query="delete from contact where id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int res=preparedStatement.executeUpdate();
			if(res==1) {
				System.err.println("User Deleted");
			}else {
				System.err.println("User Does not Exist");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void searchContactById(int id) {
		try {
			openConnection();
			query="select * from contact where id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet= preparedStatement.executeQuery();
			displayContacts(resultSet);	
		} catch (Exception e) {
	         e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	public static void searchContactByFirstname(String firstname) {
		try {
			openConnection();
			query="select * from contact where firstname=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, firstname);
			resultSet= preparedStatement.executeQuery();
			displayContacts(resultSet);			
		} catch (Exception e) {
	         e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	
	public static void searchContactByLastname(String lastname) {
		try {
			openConnection();
			query="select * from contact where id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, lastname);
			resultSet= preparedStatement.executeQuery();
			displayContacts(resultSet);

			
		} catch (Exception e) {
	         e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	public static void searchContactByMobileNumber(long mobileNumber) {
		try {
			openConnection();
			query="select * from contact where mobileNumber=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setLong(1, mobileNumber);
			resultSet= preparedStatement.executeQuery();
			displayContacts(resultSet);
			
		} catch (Exception e) {
	         e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void searchContactByEmailId(String emailId) {
		try {
			openConnection();
			query="select * from contact where email=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, emailId);
			resultSet= preparedStatement.executeQuery();
			displayContacts(resultSet);		
		} catch (Exception e) {
	         e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void searchContactByCategory(String category) {
		try {
			openConnection();
			query="select * from contact where category=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, category);
			resultSet= preparedStatement.executeQuery();
			displayContacts(resultSet);			
		} catch (Exception e) {
	         e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void updateFirstName(String firstName,int id) {
		try {
			openConnection();
			query="update contact set firstName=? where id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, firstName);
			preparedStatement.setInt(2, id);
			int res=preparedStatement.executeUpdate();
			System.out.println(res +"rows affected");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void updateLastName(String lastName,int id) {
		try {
			openConnection();
			query="update contact set lastName=? where id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, lastName);
			preparedStatement.setInt(2, id);
			int res=preparedStatement.executeUpdate();
			System.out.println(res +"rows affected");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void updateMobileNumber(long mobileNumber,int id) {
		try {
			openConnection();
			query="update contact set mobileNumber=? where id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setLong(1, mobileNumber);
			preparedStatement.setInt(2, id);
			int res=preparedStatement.executeUpdate();
			System.out.println(res +"rows affected");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void updateEmailId(String EmailId,int id) {
		try {
			openConnection();
			query="update contact set email=? where id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, EmailId);
			preparedStatement.setInt(2, id);
			int res=preparedStatement.executeUpdate();
			System.out.println(res +"rows affected");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	public static void updateCategory(String category,int id) {
		try {
			openConnection();
			query="update contact set category=? where id=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, category);
			preparedStatement.setInt(2, id);
			int res=preparedStatement.executeUpdate();
			System.out.println(res +"rows affected");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weje1","root", "root");
	}
	
	public static void closeConnection() throws SQLException {
		if (connection!=null) {
			connection.close();
		}
		if(preparedStatement!=null) {
			preparedStatement.close();
		}
		if(resultSet!=null) {
			resultSet.close();
		}
		if(driver!=null) {
			DriverManager.deregisterDriver(driver);
		}
	}
}
