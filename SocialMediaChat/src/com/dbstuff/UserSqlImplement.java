package com.dbstuff;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import com.userdata.User;

public class UserSqlImplement {

	private String url = "jdbc:mysql://ems.informatik.uni-oldenburg.de:55000/it15g11";
	private Connection conn;


	public void addItem(Object o) {
		User u = (User) o;
		try {
			conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Users VALUES(?,?)");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			
			ps.execute();

			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
/*
	@Override
	public boolean update(Object o) {
		User u = (User) o;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update \"Utilizator\"  SET \"Gold\",\"S_army\",a_army,number_of_settlements where \"ID\"=?");
			ps.setDouble(1, u.getGoldAmount());
			ps.setInt(2, u.getStationedArmy());
			ps.setInt(3, u.getAvalibleArmy());
			ps.setInt(4, u.getSettlements().size());
			ps.setString(5, u.getUserID());
			ps.executeUpdate();

			return true;
		} catch (SQLException | IOException e) {
			return false;
		}
	}

	@Override
	public boolean delete(Object o) {
		User u = (User) o;

		try {
			Connection conn = getConnection();
			PreparedStatement ps;
			ps = conn
					.prepareStatement("Delete from \"Utilizator\"   where \"ID\"=?");
			ps.setString(1, u.getUserID());
			ps.execute();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return false;
	}
*/

	public boolean findUser(User u) {

		/*need to be made croectly*/
		
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from User  where email = ? AND password = ?");
			ps.setString(1, u.getEmail() );
			System.out.println(u.getEmail());
			ps.setString(2, u.getPassword());
			System.out.println(u.getPassword());;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
			
				return true;
			}
			
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
/*
	@Override
	public HashMap<String, Object> getAll() {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from \"Utilizator\"");
			ResultSet rs = ps.executeQuery();
			HashMap<String, Object> userMap = new HashMap<>();
			HashMap<String, Settlement> settlementMap;
			while (rs.next()) {
				userMap.put(
						rs.getString(1),
						new User(rs.getString(1), rs.getString(2), rs
								.getDouble(3), rs.getInt(5), rs.getInt(4),
								settlementMap, new HashMap<String, Resource>()));
			}

			return userMap;
		} catch (SQLException | IOException e) {
			return null;
		}
	}
	
	*/

	public Connection getConnection() throws SQLException,
			FileNotFoundException, IOException {
		
		return DriverManager.getConnection(url, "it15g11","7nigyw2");
	}

}
