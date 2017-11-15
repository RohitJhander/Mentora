package Controller;

import globals.Profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import sql.ProfileManager;

import com.google.gson.Gson;

@WebServlet("/searchstudyabroad")
public class StudyAbroadHandler extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ArrayList<Profile> profiles = new ArrayList<Profile>();
		for (Profile p : ProfileManager.searchStudyAbroad()) {
			profiles.add(new Profile(p));
		}
		if (profiles.size() != 0) {
			Gson gson = new Gson();
			String json = gson.toJson(profiles);
			out.print(json);
		} else {
			JSONObject obj = new JSONObject();
			try {
				obj.put("Message", "Empty");
			} catch (Exception e) {
				e.printStackTrace();
			}
			out.print(obj);
		}
	}
}
