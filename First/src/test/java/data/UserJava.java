package data;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UserJava {

	public String[] loginfo(int i) throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("src/test/java/data/UserJson.json");
		Object obj = jsonParser.parse(reader);
		JSONArray usersList = (JSONArray) obj;
		
		JSONObject users = (JSONObject) usersList.get(i);
		JSONObject user = (JSONObject) users.get("Users");
		String fullname = (String) user.get("Full Name");
		String password = (String) user.get("Password");
		return new String[] {fullname, password};
	}
}
