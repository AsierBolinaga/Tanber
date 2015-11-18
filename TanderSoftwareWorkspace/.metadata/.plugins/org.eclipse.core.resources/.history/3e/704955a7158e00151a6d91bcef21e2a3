package abolinaga.tander;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class RegisterUserClass 
{
	public String sendPostRequest(String _strRequestURL, HashMap<String, String> _hmPostDataParams) 
	{
		String strResponse = "";
		URL url;
		try
		{
			url = new URL(_strRequestURL);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(15000);
			conn.setConnectTimeout(15000);
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			
			OutputStream os = conn.getOutputStream();
			BufferedWriter  bfWritter = new BufferedWriter(
					new OutputStreamWriter(os, "UTF-8"));
			bfWritter.write(getPostDataString(_hmPostDataParams));
			
			bfWritter.flush();
			bfWritter.close();
			int iResponseCode = conn.getResponseCode();
			
			if(iResponseCode == HttpsURLConnection.HTTP_OK)
			{
				BufferedReader br = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				strResponse = br.readLine();
			}
			else
			{
				strResponse = "Error Registering";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return strResponse;
	}
	
	private String getPostDataString(HashMap<String, String> _hmParams) throws UnsupportedEncodingException 
	{
		StringBuilder sbResult = new StringBuilder();
		boolean bFirst = true;
		
		for(Map.Entry<String, String> entry : _hmParams.entrySet())
		{
			if(true == bFirst)
			{
				bFirst = false;
			}
			else
			{
				sbResult.append("&");
			}
			
			sbResult.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
			sbResult.append("=");
			sbResult.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
		}

		return sbResult.toString();
	}
}
