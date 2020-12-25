package restapi;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParseOrgJson {

	public static void main(String[] args) {

     try {
		RestClient client = new RestClient("http://jsonplaceholder.typicode.com/albums");
		String response = client.request("GET");
		System.out.println(response);
		JSONArray ja = new JSONArray(response);
		System.out.println("USERID*********ID**********TITLE");
		for(int i=0;i<ja.length();i++)
		{
			JSONObject jo = ja.getJSONObject(i);
			int u = jo.getInt("userId");
			int d = jo.getInt("id");
			String s = jo.getString("title");
			System.out.println(u+"         "+ d+"             "+ s);
			
		}
		
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (IOException e)
     {
		e.printStackTrace();
     }

	}

}
