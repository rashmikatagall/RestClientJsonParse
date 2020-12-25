package restapi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParseJackson {

	public static void main(String[] args)
	{
	 try {
			RestClient client = new RestClient("http://jsonplaceholder.typicode.com/albums");
			String response = client.request("GET");
			System.out.println(response);
			ObjectMapper objectMapper = new ObjectMapper();
			List<Album> albums = objectMapper.readValue(response, new TypeReference<List<Album>>() {});
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
