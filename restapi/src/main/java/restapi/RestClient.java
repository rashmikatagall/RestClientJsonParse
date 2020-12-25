package restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestClient {
	
	private URL url;
	private HttpURLConnection connection;
	
	public RestClient(String url) throws MalformedURLException
	{
		this.url = new URL(url);
	}
	
	public String request(String method) throws IOException{
	
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(method);
		connection.connect();
		BufferedReader reader;
		
		if(connection.getResponseCode() != 200)
			 reader = new BufferedReader(new InputStreamReader((connection.getErrorStream())));
		else
			 reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));
		
		StringBuilder response = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null)
			{
				response.append(line);
			}
		
		return response.toString();
					
		}
		
	
	
	

}
