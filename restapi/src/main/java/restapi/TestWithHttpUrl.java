package restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class TestWithHttpUrl {

	public static void main(String[] args) {
       StringBuffer response = new StringBuffer();
		try {
			URL url = new URL("http://jsonplaceholder.typicode.com/albums");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(5000);
			connection.connect();
			if(connection.getResponseCode() != 200)
			{
				BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				String line;
				while((line = bf.readLine())!=null)
				{
					response.append(line);
				}
			}
			BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while((line = bf.readLine())!=null)
			{
				response.append(line);
			}
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(response);

	}

}
