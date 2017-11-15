package Utility;

import org.json.JSONArray;
import globals.Profile;
import java.util.*;

public class ProfileUtility {
	public static ArrayList<Profile> convertResultSetToArray(
			List<List<String>> resultList) {
		ArrayList<Profile> resultArray = new ArrayList<Profile>();
		Profile temp = new Profile();
		int size = resultList.size();
		for (int i = 0; i < size; i++) {
			temp.id = resultList.get(i).get(0);
			temp.name = resultList.get(i).get(1);
			temp.email = resultList.get(i).get(2);
			temp.phone = resultList.get(i).get(3);
			temp.gender = resultList.get(i).get(4);
			temp.city = resultList.get(i).get(5);
			temp.country = resultList.get(i).get(6);
			temp.fb = resultList.get(i).get(7);
			temp.pic = resultList.get(i).get(8);
			temp.school = resultList.get(i).get(9);
			temp.coaching = resultList.get(i).get(10);
			temp.college = resultList.get(i).get(11);
			temp.branch = resultList.get(i).get(12);
			temp.profession = resultList.get(i).get(13);
			temp.board = resultList.get(i).get(14);
			temp.mains = resultList.get(i).get(15);
			temp.advance = resultList.get(i).get(16);
			temp.pmt = resultList.get(i).get(17);
			temp.percentage = resultList.get(i).get(18);
			temp.other = resultList.get(i).get(19);
			resultArray.add(new Profile(temp));
		//	System.out.print(resultArray.get(i).name + " ");
		}
		return resultArray;
	}
}
