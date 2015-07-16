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
					.prepareStatement("INSERT INTO topics( title, content, user_id, file) VALUES (?, ?, ?, ?)");
			ps.setString(1, topic.getTitle());
			ps.setString(2, topic.getContent());
			ps.setInt(3, topic.getUserId());
			ps.setString(4, topic.getFileName());
			ps.execute();
			System.out.println("executed");

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Topic> getAll() {

		ArrayList<Topic> topics;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from topics");

			ResultSet rs = ps.executeQuery();
			
			topics = new ArrayList<Topic>();
			while (rs.next()) {
			
					topics.add(new Topic(rs.getInt(1), rs.getNString(2), rs
						.getNString(3), rs.getInt(4),rs.getNString(5)));
				
			}
			//System.out.println(topics.get(1).getContent());

		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return null;
		}
		return topics;
	}

	public Connection getConnection() throws SQLException,
			FileNotFoundException, IOException {

		return DriverManager.getConnection(url, "it15g11", "7nigyw2");
	}

}
