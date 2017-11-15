package sql;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import globals.*;

public class ProfileManager {
	public static int addProfileToDatabase(Profile profile) {
		String sql = "INSERT INTO personal_profile(name,email,phone,gender,city,country,fb,pic) VALUES('"
				+ profile.name
				+ "', '"
				+ profile.email
				+ "', '"
				+ profile.phone
				+ "', '"
				+ profile.gender
				+ "', '"
				+ profile.city
				+ "', '"
				+ profile.country
				+ "', '"
				+ profile.fb
				+ "', '" + profile.pic + "')";
		int id = JDBCConnector.executeMydbUpdateSql(sql);
		sql = "INSERT INTO education_profile(id,school,coaching,college,branch,profession,board,mains,advance,pmt,percentage,other) VALUES('"
				+ id
				+ "', '"
				+ profile.school
				+ "', '"
				+ profile.coaching
				+ "', '"
				+ profile.college
				+ "', '"
				+ profile.branch
				+ "', '"
				+ profile.profession
				+ "', '"
				+ profile.board
				+ "', '"
				+ profile.mains
				+ "', '"
				+ profile.advance
				+ "', '"
				+ profile.pmt
				+ "', '"
				+ profile.percentage
				+ "', '"
				+ profile.other + "')";
		JDBCConnector.executeMydbUpdateSql(sql);
		return id;
	}

	public static ArrayList<Profile> getAllProfiles() {
		String sql = "SELECT "
				+ "personal_profile.id,"
				+ "personal_profile.name,"
				+ "personal_profile.email,"
				+ "personal_profile.phone,"
				+ "personal_profile.gender,"
				+ "personal_profile.city,"
				+ "personal_profile.country,"
				+ "personal_profile.fb,"
				+ "personal_profile.pic,"
				+ "education_profile.school,"
				+ "education_profile.coaching,"
				+ "education_profile.college,"
				+ "education_profile.branch,"
				+ "education_profile.profession,"
				+ "education_profile.board,"
				+ "education_profile.mains,"
				+ "education_profile.advance,"
				+ "education_profile.pmt,"
				+ "education_profile.percentage,"
				+ "education_profile.other "
				+ "FROM personal_profile INNER JOIN education_profile ON personal_profile.id = education_profile.id";
		List<List<String>> resultList = JDBCConnector.executeMydbQuerySql(sql);
		return Utility.ProfileUtility.convertResultSetToArray(resultList);
	}

	public static ArrayList<Profile> searchByCollege(String college) {
		String sql = "SELECT "
				+ "personal_profile.id,"
				+ "personal_profile.name,"
				+ "personal_profile.email,"
				+ "personal_profile.phone,"
				+ "personal_profile.gender,"
				+ "personal_profile.city,"
				+ "personal_profile.country,"
				+ "personal_profile.fb,"
				+ "personal_profile.pic,"
				+ "education_profile.school,"
				+ "education_profile.coaching,"
				+ "education_profile.college,"
				+ "education_profile.branch,"
				+ "education_profile.profession,"
				+ "education_profile.board,"
				+ "education_profile.mains,"
				+ "education_profile.advance,"
				+ "education_profile.pmt,"
				+ "education_profile.percentage,"
				+ "education_profile.other "
				+ "FROM personal_profile INNER JOIN education_profile ON personal_profile.id = education_profile.id WHERE education_profile.college = "
				+ college;
		List<List<String>> resultList = JDBCConnector.executeMydbQuerySql(sql);
		return Utility.ProfileUtility.convertResultSetToArray(resultList);
	}

	public static ArrayList<Profile> searchByCountry(String country) {
		String sql = "SELECT "
				+ "personal_profile.id,"
				+ "personal_profile.name,"
				+ "personal_profile.email,"
				+ "personal_profile.phone,"
				+ "personal_profile.gender,"
				+ "personal_profile.city,"
				+ "personal_profile.country,"
				+ "personal_profile.fb,"
				+ "personal_profile.pic,"
				+ "education_profile.school,"
				+ "education_profile.coaching,"
				+ "education_profile.college,"
				+ "education_profile.branch,"
				+ "education_profile.profession,"
				+ "education_profile.board,"
				+ "education_profile.mains,"
				+ "education_profile.advance,"
				+ "education_profile.pmt,"
				+ "education_profile.percentage,"
				+ "education_profile.other "
				+ "FROM personal_profile INNER JOIN education_profile ON personal_profile.id = education_profile.id WHERE personal_profile.country = "
				+ country;
		List<List<String>> resultList = JDBCConnector.executeMydbQuerySql(sql);
		return Utility.ProfileUtility.convertResultSetToArray(resultList);
	}

	public static ArrayList<Profile> searchByProfession(String profession) {
		String sql = "SELECT "
				+ "personal_profile.id,"
				+ "personal_profile.name,"
				+ "personal_profile.email,"
				+ "personal_profile.phone,"
				+ "personal_profile.gender,"
				+ "personal_profile.city,"
				+ "personal_profile.country,"
				+ "personal_profile.fb,"
				+ "personal_profile.pic,"
				+ "education_profile.school,"
				+ "education_profile.coaching,"
				+ "education_profile.college,"
				+ "education_profile.branch,"
				+ "education_profile.profession,"
				+ "education_profile.board,"
				+ "education_profile.mains,"
				+ "education_profile.advance,"
				+ "education_profile.pmt,"
				+ "education_profile.percentage,"
				+ "education_profile.other "
				+ "FROM personal_profile INNER JOIN education_profile ON personal_profile.id = education_profile.id WHERE education_profile.profession = "
				+ profession;
		List<List<String>> resultList = JDBCConnector.executeMydbQuerySql(sql);
		return Utility.ProfileUtility.convertResultSetToArray(resultList);
	}

	public static ArrayList<Profile> searchByCity(String city) {
		String sql = "SELECT "
				+ "personal_profile.id,"
				+ "personal_profile.name,"
				+ "personal_profile.email,"
				+ "personal_profile.phone,"
				+ "personal_profile.gender,"
				+ "personal_profile.city,"
				+ "personal_profile.country,"
				+ "personal_profile.fb,"
				+ "personal_profile.pic,"
				+ "education_profile.school,"
				+ "education_profile.coaching,"
				+ "education_profile.college,"
				+ "education_profile.branch,"
				+ "education_profile.profession,"
				+ "education_profile.board,"
				+ "education_profile.mains,"
				+ "education_profile.advance,"
				+ "education_profile.pmt,"
				+ "education_profile.percentage,"
				+ "education_profile.other "
				+ "FROM personal_profile INNER JOIN education_profile ON personal_profile.id = education_profile.id WHERE personal_profile.city = "
				+ city;
		List<List<String>> resultList = JDBCConnector.executeMydbQuerySql(sql);
		return Utility.ProfileUtility.convertResultSetToArray(resultList);
	}

	// Engineering Query
	public static ArrayList<Profile> searchEngineeringInIndia() {
		String sql = "SELECT "
				+ "personal_profile.id,"
				+ "personal_profile.name,"
				+ "personal_profile.email,"
				+ "personal_profile.phone,"
				+ "personal_profile.gender,"
				+ "personal_profile.city,"
				+ "personal_profile.country,"
				+ "personal_profile.fb,"
				+ "personal_profile.pic,"
				+ "education_profile.school,"
				+ "education_profile.coaching,"
				+ "education_profile.college,"
				+ "education_profile.branch,"
				+ "education_profile.profession,"
				+ "education_profile.board,"
				+ "education_profile.mains,"
				+ "education_profile.advance,"
				+ "education_profile.pmt,"
				+ "education_profile.percentage,"
				+ "education_profile.other "
				+ "FROM personal_profile INNER JOIN education_profile ON personal_profile.id = education_profile.id WHERE education_profile.profession = 'Engineering' AND personal_profile.country = 'India'";
		List<List<String>> resultList = JDBCConnector.executeMydbQuerySql(sql);
		return Utility.ProfileUtility.convertResultSetToArray(resultList);
	}

	// Medical Query
	public static ArrayList<Profile> searchMedical() {
		String sql = "SELECT "
				+ "personal_profile.id,"
				+ "personal_profile.name,"
				+ "personal_profile.email,"
				+ "personal_profile.phone,"
				+ "personal_profile.gender,"
				+ "personal_profile.city,"
				+ "personal_profile.country,"
				+ "personal_profile.fb,"
				+ "personal_profile.pic,"
				+ "education_profile.school,"
				+ "education_profile.coaching,"
				+ "education_profile.college,"
				+ "education_profile.branch,"
				+ "education_profile.profession,"
				+ "education_profile.board,"
				+ "education_profile.mains,"
				+ "education_profile.advance,"
				+ "education_profile.pmt,"
				+ "education_profile.percentage,"
				+ "education_profile.other "
				+ "FROM personal_profile INNER JOIN education_profile ON personal_profile.id = education_profile.id WHERE education_profile.profession = 'Medical'";
		List<List<String>> resultList = JDBCConnector.executeMydbQuerySql(sql);
		return Utility.ProfileUtility.convertResultSetToArray(resultList);
	}

	// Study Abroad Query
	public static ArrayList<Profile> searchStudyAbroad() {
		String sql = "SELECT "
				+ "personal_profile.id,"
				+ "personal_profile.name,"
				+ "personal_profile.email,"
				+ "personal_profile.phone,"
				+ "personal_profile.gender,"
				+ "personal_profile.city,"
				+ "personal_profile.country,"
				+ "personal_profile.fb,"
				+ "personal_profile.pic,"
				+ "education_profile.school,"
				+ "education_profile.coaching,"
				+ "education_profile.college,"
				+ "education_profile.branch,"
				+ "education_profile.profession,"
				+ "education_profile.board,"
				+ "education_profile.mains,"
				+ "education_profile.advance,"
				+ "education_profile.pmt,"
				+ "education_profile.percentage,"
				+ "education_profile.other "
				+ "FROM personal_profile INNER JOIN education_profile ON personal_profile.id = education_profile.id WHERE NOT personal_profile.country = 'India'";
		List<List<String>> resultList = JDBCConnector.executeMydbQuerySql(sql);
		return Utility.ProfileUtility.convertResultSetToArray(resultList);
	}

	// Tutor
	public static ArrayList<Profile> searchTutor() {
		String sql = "SELECT "
				+ "personal_profile.id,"
				+ "personal_profile.name,"
				+ "personal_profile.email,"
				+ "personal_profile.phone,"
				+ "personal_profile.gender,"
				+ "personal_profile.city,"
				+ "personal_profile.country,"
				+ "personal_profile.fb,"
				+ "personal_profile.pic,"
				+ "education_profile.school,"
				+ "education_profile.coaching,"
				+ "education_profile.college,"
				+ "education_profile.branch,"
				+ "education_profile.profession,"
				+ "education_profile.board,"
				+ "education_profile.mains,"
				+ "education_profile.advance,"
				+ "education_profile.pmt,"
				+ "education_profile.percentage,"
				+ "education_profile.other "
				+ "FROM personal_profile INNER JOIN education_profile ON personal_profile.id = education_profile.id WHERE education_profile.profession = 'Tutor'";
		List<List<String>> resultList = JDBCConnector.executeMydbQuerySql(sql);
		return Utility.ProfileUtility.convertResultSetToArray(resultList);
	}
}