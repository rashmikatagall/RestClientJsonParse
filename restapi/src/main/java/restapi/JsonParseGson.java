package restapi;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonParseGson {

	public static void main(String[] args) {
		
		 try {
				RestClient client = new RestClient("http://jsonplaceholder.typicode.com/albums");
				String response = client.request("GET");
				System.out.println(response);
				Gson gson = new Gson();
				Type albumList = new TypeToken<List<Album>>() {}.getType();
				List<Album> albums = gson.fromJson(response, albumList);
				for(Album album : albums)
				{
					System.out.println(album.getUserId()+"    "+ album.getId()+"     "+ album.getTitle());
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e)
		     {
				e.printStackTrace();
		     }

	}

}
