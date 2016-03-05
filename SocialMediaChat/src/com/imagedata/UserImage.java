package com.imagedata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.geometry.Point2D;
/*
 * Describes the images that are processed
 * 
 * */
public class UserImage {

	private int userId;
	private String fileName;
	private List<Point2D> interestPoints;

	public UserImage() {}

	public UserImage(int userId) {

		this.userId = userId;
	}

	public UserImage(int userId, String fileName) {

		this.userId = userId;
		this.fileName = fileName;
	}

	public UserImage(int userId, String fileName, List<Point2D> interestPoints) {
		this.userId 		= userId;
		this.fileName 		= fileName;
		this.interestPoints = interestPoints;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Point2D> getInterestPoints() {
		return interestPoints;
	}

	public void setInterestPoints(List<Point2D> interestPoints) {
		this.interestPoints = interestPoints;
	}

	public ArrayList<Integer> getInterestPointsValues() {
		ArrayList<Integer> a = new ArrayList<>();
		for (Point2D p : interestPoints) {
			a.add((int) p.getX());
			a.add((int) p.getY());
		}
		return a;
	}

	

}
