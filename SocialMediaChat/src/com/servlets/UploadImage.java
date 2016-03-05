package com.servlets;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javafx.geometry.Point2D;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dbstuff.TopicSqlImplement;
import com.imagedata.UserImage;
import com.imageprocess.Analyzer;

/**
 * Servlet implementation class AddTopic
 */
@MultipartConfig
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TopicSqlImplement dbActions;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadImage() {
		super();
		dbActions = new TopicSqlImplement();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * response.setContentType("text/html");
		 * 
		 * Topic topic = new Topic(request.getParameter("title"),
		 * request.getParameter("content"), -1);
		 * System.out.println(request.getParameter("file"));
		 * dbActions.addItem(topic);
		 */
		UserImage image;
		response.setContentType("multipart/form-data");

		Part filePart = request.getPart("file");
		System.out.println(filePart.getSubmittedFileName());
		if (filePart.getSize() != 0) {
			InputStream fileContent = filePart.getInputStream();
			BufferedImage subjectImage = ImageIO.read(fileContent);
		
			
			System.out.println(getServletContext().getRealPath("/"));
			FileOutputStream output = new FileOutputStream(getServletContext()
					.getRealPath("/")
					+ "/files/"
					+ java.io.File.separator
					+ filePart.getSubmittedFileName());
			
			ImageIO.write(subjectImage, "jpg", output);

			ArrayList<Point2D> m = new ArrayList<>();
			m.addAll(Arrays.asList(new Point2D(88, 144), new Point2D(412, 179),
					new Point2D(152, 285), new Point2D(322, 244), new Point2D(
							122, 483), new Point2D(355, 458), new Point2D(260,
							86), new Point2D(245, 164), new Point2D(239, 440)));

			image = new UserImage(-1, "files/"
					+ filePart.getSubmittedFileName(), m);
			Analyzer.analyze(subjectImage,m);
			
		} else {
			image = new UserImage(-1, "");
		}
		dbActions.addItem(image);

		response.sendRedirect("main.jsp");

	}

}
