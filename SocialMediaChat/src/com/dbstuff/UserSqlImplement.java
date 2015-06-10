package com.dbstuff;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.userdata.User;

public class UserSqlImplement {

	private String url = "jdbc:mysql://ems.informatik.uni-oldenburg.de:55000/it15g11";
	private Connection conn;

	public void addItem(Object o) {
		User u = (User) o;
		try {
			conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO users(id, name, email) VALUES (?,?, ?)");
			ps.setInt(1, u.getId());
			ps.setString(2,	u.getName());
			System.out.println("added name");
			ps.setString(3, u.getEmail());
			System.out.println("and email");
			

			ps.execute();
			System.out.println("executed");

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Override public boolean update(Object o) { User u = (User) o; try {
	 * Connection conn = getConnection(); PreparedStatement ps = conn
	 * .prepareStatement(
	 * "update \"Utilizator\"  SET \"Gold\",\"S_army\",a_army,number_of_settlements where \"ID\"=?"
	 * ); ps.setDouble(1, u.getGoldAmount()); ps.setInt(2,
	 * u.getStationedArmy()); ps.setInt(3, u.getAvalibleArmy()); ps.setInt(4,
	 * u.getSettlements().size()); ps.setString(5, u.getUserID());
	 * ps.executeUpdate();
	 * 
	 * return true; } catch (SQLException | IOException e) { return false; } }
	 * 
	 * @Override public boolean delete(Object o) { User u = (User) o;
	 * 
	 * try { Connection conn = getConnection(); PreparedStatement ps; ps = conn
	 * .prepareStatement("Delete from \"Utilizator\"   where \"ID\"=?");
	 * ps.setString(1, u.getUserID()); ps.execute(); } catch (SQLException |
	 * IOException e) { e.printStackTrace(); }
	 * 
	 * return false; }
	 */

	public User findUser(int u) {

		/* need to be made croectly */

		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from users where id = ?");
			ps.setInt(1, u);
		
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("found = true");
				User foundUser= new User( rs.getString(3), rs.getNString(2),u);
				System.out.println(foundUser.getName() + "  nop name here ");
				
				return foundUser;
				
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/*
	 * @Override public HashMap<String, Object> getAll() { try { Connection conn
	 * = getConnection(); PreparedStatement ps = conn
	 * .prepareStatement("select * from \"Utilizator\""); ResultSet rs =
	 * ps.executeQuery(); HashMap<String, Object> userMap = new HashMap<>();
	 * HashMap<String, Settlement> settlementMap; while (rs.next()) {
	 * userMap.put( rs.getString(1), new User(rs.getString(1), rs.getString(2),
	 * rs .getDouble(3), rs.getInt(5), rs.getInt(4), settlementMap, new
	 * HashMap<String, Resource>())); }
	 * 
	 * return userMap; } catch (SQLException | IOException e) { return null; } }
	 */

	public Connection getConnection() throws SQLException,
			FileNotFoundException, IOException {

		return DriverManager.getConnection(url, "it15g11", "7nigyw2");
	}

}
