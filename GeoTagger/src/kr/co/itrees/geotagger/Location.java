package kr.co.itrees.geotagger;

import java.sql.Timestamp;

public class Location 
{
	private Timestamp ts;
	
	private int lat;
	private int lon;
	
	private String q1;
	private String q2;
	private String q3;
	private String q4;
	private String q5;
	
	private String photo;
	private String email;
	private String phone;
	private String website;
	
	public Timestamp getTs()
	{
		return ts;
	}
	
	public void setTs(Timestamp ts)
	{
		this.ts = ts;
	}
	
	public int getLat()
	{
		return lat;
	}
	
	public void setLat(int lat)
	{
		this.lat = lat;
	}
	
	public int getLon()
	{
		return lon;
	}
	
	public void setLon(int lon)
	{
		this.lon = lon;
	}
	
	public String getQ1() 
	{
		return q1;
	}
	
	public void setQ1(String q1) 
	{
		this.q1 = q1;
	}
	
	public String getQ2() 
	{
		return q2;
	}
	
	public void setQ2(String q2) 
	{
		this.q2 = q2;
	}
	
	public String getQ3() 
	{
		return q3;
	}
	
	public void setQ3(String q3) 
	{
		this.q3 = q3;
	}
	
	public String getQ4() 
	{
		return q4;
	}
	
	public void setQ4(String q4) 
	{
		this.q4 = q4;
	}
	
	public String getQ5() 
	{		
		return q5;
	}
	
	public void setQ5(String q5) 
	{
		this.q5 = q5;
	}
	
	public String getPhoto() 
	{
		return photo;
	}
	
	public void setPhoto(String photo) 
	{
		this.photo = photo;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getPhone() 
	{
		return phone;
	}
	
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}
	
	public String getWebsite() 
	{
		return website;
	}
	
	public void setWebsite(String website) 
	{
		this.website = website;
	}
}
