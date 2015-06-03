package com.dbstuff;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.topicdata.Topic;

public class TopicSqlImplement {

	private String url = "jdbc:mysql://ems.informatik.uni-oldenburg.de:55000/it15g11";
	private Connection conn;

	public void addItem(Topic topic) {

		try {
			conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO topics( title, content, user_id) VALUES (?, ?, ?)");
			ps.setString(1, topic.getTitle());
			ps.setString(2, topic.getContent());
			ps.setInt(3, topic.getUserId());
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

	public ArrayList<Topic> getAll() {

		/* need to be made croectly */
		ArrayList<Topic> topics;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from topics");

			ResultSet rs = ps.executeQuery();

			topics = new ArrayList<Topic>();
			while (rs.next()) {
				topics.add(new Topic(rs.getInt(1), rs.getNString(2), rs
						.getNString(3), rs.getInt(4)));
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return null;
		}
		return topics;
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
