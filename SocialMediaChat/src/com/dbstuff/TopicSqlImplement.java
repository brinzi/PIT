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
import java.util.ArrayList;
import java.util.HashMap;

import javafx.geometry.Point2D;

import com.imagedata.UserImage;

public class TopicSqlImplement {

	private String url = "jdbc:mysql://localhost:3306/studenti";
	private Connection conn;

	public void addItem(UserImage image) {

		try {
			conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO user_images(user_id, file, points) VALUES (?, ?, ?)");
			ps.setInt(1, image.getUserId());
			ps.setString(2, image.getFileName());
			ps.setObject(3, image.getInterestPointsValues());

			ps.execute();

			conn.close();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<UserImage> getAll() {

		ArrayList<UserImage> image;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from user_images");

			ResultSet rs = ps.executeQuery();

			image = new ArrayList<UserImage>();

			// read object from DB
			while (rs.next()) {

				byte[] buf = rs.getBytes(3);
				ObjectInputStream objectIn = null;
				if (buf != null)
					objectIn = new ObjectInputStream(new ByteArrayInputStream(
							buf));

				ArrayList<Integer> ints = ((ArrayList<Integer>) objectIn
						.readObject());
				ArrayList<Point2D> points = new ArrayList<>();
				for (int i = 1; i < ints.size(); i++) {
					if (i % 2 != 0) {
						points.add(new Point2D(ints.get(i - 1), ints.get(i)));
					}
				}
				image.add(new UserImage(rs.getInt(1), rs.getString(2), points));

			}
			// System.out.println(topics.get(1).getContent());
			conn.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return image;
	}

	public Connection getConnection() throws SQLException,
			FileNotFoundException, IOException {

		return DriverManager.getConnection(url, "root", "1234");
	}

}
