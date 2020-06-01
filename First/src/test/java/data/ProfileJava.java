package data;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProfileJava {

	public String[] profileinfo(int i) throws IOException, ParseException {
		
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("src/test/java/data/ProfileJson.json");
		Object obj = jsonParser.parse(reader);
		JSONArray usersList = (JSONArray) obj;
		
		JSONObject users = (JSONObject) usersList.get(i);
		JSONObject user = (JSONObject) users.get("users");
		String country = (String) user.get("country");
		String address = (String) user.get("address");
		String email = (String) user.get("email");
		String phone = (String) user.get("phone");
		return new String[] {country, address, email, phone};
	}
}
