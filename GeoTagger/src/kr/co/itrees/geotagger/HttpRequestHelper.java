package kr.co.itrees.geotagger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * 
 * author 이준원
 * since 2014-05-11
 * update 2014-05-11 (이준원)
 * charset UTF-8
 */
public class HttpRequestHelper 
{
	@SuppressWarnings("unchecked")
	public String sendLocation(Location loc)
	{
		HttpPost request = new HttpPost("http://192.237.166.7/api/0.1/location/");
		
		request.setHeader("Accept", "application/json");
		request.setHeader("Content-Type", "application/json");
		request.setHeader("Authorization", "ApiKey tester:1a2b3c4d5e");
			
		String[] q1 = loc.getQ1().split(",");
		String[] q2 = loc.getQ2().split(",");
		String q3 = loc.getQ3();				// description
		String[] q4 = loc.getQ4().split(",");	// tags
		String q5 = loc.getQ5(); 				// contactConfirmed
		
		String contactEmail = loc.getEmail();
		String contactPhone = loc.getPhone();
		String contactWebsite = loc.getWebsite();
		
		Double lat = (double) (loc.getLat()/1000000.f);
		Double lon = (double) (loc.getLon()/1000000.f);
		
		ArrayList<String> q1list = new ArrayList<String>();
		
		for(int i = 0; i < q1.length; i++)
		{
			q1list.add(q1[i]);
		}
		
		ArrayList<String> q2list = new ArrayList<String>();
		
		for(int i = 0; i < q2.length; i++)
		{
			q2list.add(q2[i]);
		}
		
		if(q5.equals("yes"))
		{
			q5 = "true";
		}
		
		else if(q5.equals("no"))
		{
			q5 = "false";
		}
		
		JSONObject jobj = new JSONObject();
		
		try 
		{
			jobj.put("orig_id", "123");
			
			if(q1list.contains("Evangelism"))
			{
				jobj.put("evanType", true);
			}
			
			if(q1list.contains("Training"))
			{
				jobj.put("trainType", true);
			}
			
			if(q1list.contains("Mercy"))
			{
				jobj.put("mercyType", true);
			}
			
			// for question 2
			if(q2list.contains("Youth / Children"))
			{
				jobj.put("youthType", true);
			}
			
			if(q2list.contains("Campus Ministry"))
			{
				jobj.put("campusType", true);
			}
			
			if(q2list.contains("Indigenous People"))
			{
				jobj.put("indigineousType", true);
			}
			
			if(q2list.contains("Prison Ministry"))
			{
				jobj.put("prisonType", true);
			}
			
			if(q2list.contains("Prostitutes"))
			{
				jobj.put("prostitutesType", true);
			}
			
			if(q2list.contains("Orphans"))
			{
				jobj.put("orphansType", true);
			}
			
			if(q2list.contains("Women"))
			{
				jobj.put("womenType", true);
			}
			
			if(q2list.contains("Urban Ministry"))
			{
				jobj.put("urbanType", true);
			}
			
			if(q2list.contains("Hospital Ministry"))
			{
				jobj.put("hospitalType", true);
			}
			
			if(q2list.contains("Media / Communications"))
			{
				jobj.put("mediaType", true);
			}
			
			if(q2list.contains("Community Development"))
			{
				jobj.put("communityDevType", true);
			}
			
			if(q2list.contains("Bible Studies"))
			{
				jobj.put("bibleStudyType", true);
			}
			
			if(q2list.contains("Church Planting"))
			{
				jobj.put("churchPlantingType", true);
			}
			
			if(q2list.contains("Arts / Entertainment / Sports"))
			{
				jobj.put("artsType", true);
			}
			
			if(q2list.contains("Counseling"))
			{
				jobj.put("counselingType", true);
			}
			
			if(q2list.contains("Healthcare"))
			{
				jobj.put("healthcareType", true);
			}
			
			if(q2list.contains("Maintenance / Construction"))
			{
				jobj.put("constructionType", true);
			}
			
			if(q2list.contains("Research"))
			{
				jobj.put("researchType", true);
			}
			
			jobj.put("desc", q3);
			
			JSONArray jarr = new JSONArray();
			
			for(int i = 0; i < q4.length; i++)
			{
				jarr.put(q4[i]);
			}
			
			jobj.put("tags", jarr);
			
			jobj.put("contactConfirmed", q5);
			
			jobj.put("contactEmail", contactEmail);
			jobj.put("contactPhone", contactPhone);
			jobj.put("contactWebsite", contactWebsite);
			
			jobj.put("lat", lat.toString());
			jobj.put("lon", lon.toString());
			
			jobj.put("user", "/api/0.1/user/2/");
		} 
		
		catch (JSONException e2) 
		{
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		
		try 
		{
			StringEntity se = new StringEntity(jobj.toString());
			se.setContentType("application/json");
			request.setEntity(se);
			
			
			HttpClient client = new DefaultHttpClient();
			
			@SuppressWarnings("rawtypes")
			ResponseHandler reshandler = new BasicResponseHandler();
			
			return client.execute(request, reshandler);
			
		} 
		
		catch (UnsupportedEncodingException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
			return null;
		}
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return null;
		}
		
	}
}
