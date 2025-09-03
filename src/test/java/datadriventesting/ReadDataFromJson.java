package datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ReadDataFromJson {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		//Parse the JSON Physical file into Java Object using Json
		//Parser class
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new FileReader("./ConfigData/commonData.json"));
		//Convert the java object into JSON Object(type casting)
		
		JSONObject obj1 = (JSONObject)obj;
		
		//read the data using get() by passing key
		System.out.println(obj1.get("Browser"));
		System.out.println(obj1.get("Url"));
		System.out.println(obj1.get("Username"));
		System.out.println(obj1.get("Password"));
		
		
	}

}
