package kr.co.itrees.geotagger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Vector;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

/**
 * 
 * @author 이준원
 * @since 2014-05-11
 * @update 2014-05-11 (이준원)
 * @charset UTF-8
 */
public class HttpRequestHelper 
{
	@SuppressWarnings("unchecked")
	public void sendLocation(Location loc)
	{
		HttpPost request = new HttpPost("http://192.237.166.7/api/0.1/location/");
		
		request.setHeader("Content-Type", "application/json");
		request.setHeader("Authorization", "ApiKey tester:1a2b3c4d5e");
		
		Vector<BasicNameValuePair> entity = new Vector<BasicNameValuePair>();
		
		
		
		entity.add(new BasicNameValuePair("orig_id", "123"));
		
		String[] q1 = loc.getQ1().split(",");
		String[] q2 = loc.getQ1().split(",");
		String q3 = loc.getQ3();				// description
		String[] q4 = loc.getQ1().split(",");	// tags
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
		
		
		// for question 1
		if(q1list.contains("Evangelism"))
		{
			entity.add(new BasicNameValuePair("evanType", "true"));
		}
		
		if(q1list.contains("Training"))
		{
			entity.add(new BasicNameValuePair("trainType", "true"));
		}
		
		if(q1list.contains("Mercy"))
		{
			entity.add(new BasicNameValuePair("mercyType", "true"));
		}
		
		// for question 2
		if(q2list.contains("Youth / Children"))
		{
			entity.add(new BasicNameValuePair("youthType", "true"));
		}
		
		if(q2list.contains("Campus Ministry"))
		{
			entity.add(new BasicNameValuePair("campusType", "true"));
		}
		
		if(q2list.contains("Indigenous People"))
		{
			entity.add(new BasicNameValuePair("indigineousType", "true"));
		}
		
		if(q2list.contains("Prison Ministry"))
		{
			entity.add(new BasicNameValuePair("prisonType", "true"));
		}
		
		if(q2list.contains("Prostitutes"))
		{
			entity.add(new BasicNameValuePair("prostitutesType", "true"));
		}
		
		if(q2list.contains("Orphans"))
		{
			entity.add(new BasicNameValuePair("orphansType", "true"));
		}
		
		if(q2list.contains("Women"))
		{
			entity.add(new BasicNameValuePair("womenType", "true"));
		}
		
		if(q2list.contains("Urban Ministry"))
		{
			entity.add(new BasicNameValuePair("urbanType", "true"));
		}
		
		if(q2list.contains("Hospital Ministry"))
		{
			entity.add(new BasicNameValuePair("hospitalType", "true"));
		}
		
		if(q2list.contains("Media / Communications"))
		{
			entity.add(new BasicNameValuePair("mediaType", "true"));
		}
		
		if(q2list.contains("Community Development"))
		{
			entity.add(new BasicNameValuePair("communityDevType", "true"));
		}
		
		if(q2list.contains("Bible Studies"))
		{
			entity.add(new BasicNameValuePair("bibleStudyType", "true"));
		}
		
		if(q2list.contains("Church Planting"))
		{
			entity.add(new BasicNameValuePair("churchPlantingType", "true"));
		}
		
		if(q2list.contains("Arts / Entertainment / Sports"))
		{
			entity.add(new BasicNameValuePair("artsType", "true"));
		}
		
		if(q2list.contains("Counseling"))
		{
			entity.add(new BasicNameValuePair("counselingType", "true"));
		}
		
		if(q2list.contains("Healthcare"))
		{
			entity.add(new BasicNameValuePair("healthcareType", "true"));
		}
		
		if(q2list.contains("Maintenance / Construction"))
		{
			entity.add(new BasicNameValuePair("constructionType", "true"));
		}
		
		if(q2list.contains("Research"))
		{
			entity.add(new BasicNameValuePair("researchType", "true"));
		}
		
		entity.add(new BasicNameValuePair("desc", q3));
		
		String tags = "[";
		for(int i = 0; i < q4.length; i++)
		{
			tags += q4[i];
			
			if(i == q4.length)
			{
				tags += "]";
				break;
			}
			tags += ",";
		}
		
		entity.add(new BasicNameValuePair("tags", tags));
		
		
		
		entity.add(new BasicNameValuePair("contactConfirmed", q5));
		
		entity.add(new BasicNameValuePair("contactEmail", contactEmail));
		entity.add(new BasicNameValuePair("contactPhone", contactPhone));
		entity.add(new BasicNameValuePair("contactWebsite", contactWebsite));
		
		entity.add(new BasicNameValuePair("lat", lat.toString()));
		entity.add(new BasicNameValuePair("lon", lon.toString()));
		
		entity.add(new BasicNameValuePair("user", "/api/0.1/user/2/"));
		
		try 
		{
			UrlEncodedFormEntity ent = new UrlEncodedFormEntity(entity, HTTP.UTF_8);
			request.setEntity(ent);
			
			
			HttpClient client = new DefaultHttpClient();
			
			@SuppressWarnings("rawtypes")
			ResponseHandler reshandler = new BasicResponseHandler();
			
			client.execute(request, reshandler);
			
		} 
		
		catch (UnsupportedEncodingException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
