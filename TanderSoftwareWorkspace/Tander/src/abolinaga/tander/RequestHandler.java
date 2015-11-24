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

public class RequestHandler 
{
	public String sendPostRequest(String _strRequestURL,  HashMap<String, String> _hmPostDataParams) 
	{
		URL url;
		
		/* StringBuilder object to store the message retrieved from the server */        
		StringBuilder sb = new StringBuilder();
		try
		{
			/* Initializing URL */
			url = new URL(_strRequestURL);
			
			/* Creating an httmlurl connection */
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			/* Configuring connection properties */            
			conn.setReadTimeout(15000);            
			conn.setConnectTimeout(15000);            
			conn.setRequestMethod("POST");            
			conn.setDoInput(true);            
			conn.setDoOutput(true);
			
			/* Creating an output stream */           
			OutputStream os = conn.getOutputStream();
			
			/*
			 * Writing parameters to the request 
			 * We are using a method getPostDataString which is defined below             
			 */        
			BufferedWriter writer = new BufferedWriter(                    
					new OutputStreamWriter(os, "UTF-8"));            
			writer.write(getPostDataString(_hmPostDataParams));
			
			writer.flush();            
			writer.close();            
			os.close();            
			int responseCode = conn.getResponseCode();
			
			if (responseCode == HttpsURLConnection.HTTP_OK) 
			{                                
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));                
				sb = new StringBuilder();                
				String strResponse;                
				
				/* Reading server response */                
				while ((strResponse = br.readLine()) != null)
				{                    
					sb.append(strResponse);               
				}            
			}
			else
			{
				/* Do Nothing */
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
		
		return sb.toString();
	}
	
	public String sendGetRequest(String _strRequestURL)
	{
		StringBuilder sb =new StringBuilder();
		
		try 
		{
            URL url = new URL(_strRequestURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String strResponse;
            while((strResponse=bufferedReader.readLine())!=null)
            {
                sb.append(strResponse + "\n");
            }
        }
		catch(Exception e)
		{
			return e.getMessage();
        }
        return sb.toString();
	}
	 
	private String getPostDataString(HashMap<String, String> _hmParams) throws UnsupportedEncodingException 
	{
		
		StringBuilder result = new StringBuilder();        
		boolean first = true;       
		 
		for (Map.Entry<String, String> entry : _hmParams.entrySet())
		{
			if (first)               
			{
				first = false;            
			}
			else
			{
				result.append("&"); 
			}
			 
			result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));            
			result.append("=");            
			result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));        
		}         
		return result.toString();    
	}		 
}
