package com.dbstuff;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.userdata.User;

public class UserSqlImplement {

	private String url = "jdbc:mysql://ems.informatik.uni-oldenburg.de:55000/it15g11";
	private Connection conn;

	public void addItem(User o) {
		User u = o;
		try {
			conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO users(id, name, email) VALUES (?,?, ?)");
			ps.setInt(1, u.getId());
			ps.setString(2, u.getName());
			ps.setString(3, u.getEmail());

			ps.execute();

			ps = conn
					.prepareStatement("INSERT INTO friendLists(listID, list) VALUES (?,?)");

			ps.setInt(1, u.getId());
			ps.setObject(2, u.getFriendList());
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

	/* Loads the friends list to the DB */
	public void loadFriendList(Object list, int userID) {
		try {
			conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE  friendLists SET list=? WHERE listID=?");
			ps.setObject(1, list);
			ps.setInt(2, userID);
			ps.execute();
			System.out.println("Exported to DB"+(HashMap<Integer, String>)list);

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

	}

	/* Returns the list of friends for a user */
	public Object getFriendList(int userID) {

		try {
			conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT list FROM friendLists WHERE listID=?");
			ps.setInt(1, userID);

			ResultSet rs = ps.executeQuery();
			rs.next();

			byte[] buf = rs.getBytes(1);
			ObjectInputStream objectIn = null;
			if (buf != null)
				objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
			Object friends = objectIn.readObject();

			return friends;

		} catch (SQLException | IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public User findUser(int u) {

		/* need to be made croectly */

		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from users where id = ?");
			ps.setInt(1, u);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User foundUser = new User(rs.getString(3), rs.getNString(2), u);
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
