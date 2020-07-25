package edu.psu.sweng861;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

/* Contains methods called by AppController */
@Component
public class AppHelper implements Helper {

	/* Parse returned json string into JSON, build object, 
	   adds object to list, returns list */
	public List<Stands4Obj> parseStands4Json(String s) {
		
		JSONParser parser = new JSONParser();
		JSONObject parsedObj = null;

		List<Stands4Obj> results = new ArrayList<>();
		
		try {
			parsedObj = (JSONObject)parser.parse(s);
			JSONArray arr = (JSONArray) parsedObj.get("result");
			System.out.println("length: " + arr.size());
			
			for (int i = 0; i < arr.size(); i++) {
				JSONObject obj = (JSONObject)arr.get(i);
				int id = i+1;
				String song = obj.get("song").toString();
				String artist = obj.get("artist").toString();
				String album = obj.get("album").toString();
				//System.out.println("song: " + song);
				//System.out.println("artist: " + artist);
				//System.out.println("album: " + album);
				
				results.add(new Stands4Obj(id, song, artist, album));
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results;
	}

	// Takes string param to call API, returns response json string
	public String returnStands4(String term) {
		
		term = encodeValue(term).replace("+", "%20");
		//System.out.println("term: " + term);
		String path = "https://www.stands4.com/services/v2/lyrics.php?"
				 + "uid=7909&tokenid=OVvqY7IIbuSJvbaP&"
				 + "term=" + term + "&format=json";
				
		HttpURLConnection con;
		StringBuffer sb = new StringBuffer();
		try {
			// Create URL
			URL url = new URL(path);
			System.out.println(url.toString());
			
			con = (HttpURLConnection) url.openConnection();
			
			System.out.println("Response code: " + con.getResponseCode());
			
			BufferedReader br = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			
			String line;
			while( (line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String result = sb.toString();
		System.out.println("Sb size: " + result.length());
		return result;
	}
	
    // Encodes string value using `UTF-8` encoding scheme
    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}
