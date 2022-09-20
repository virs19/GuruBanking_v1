package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	Properties pro;
	
	public Readconfig()
	{
		File src= new File("./configurationfiles/config.properties");
		try
		{
			FileInputStream ip=new FileInputStream(src);
			pro=new Properties();
			pro.load(ip);
		}
		catch(Exception e)
		{
			System.out.println("exception is"+e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password ;
	}
	public String getChromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String getEdgepath()
	{
		String edgepath=pro.getProperty("edgepath");
		return edgepath;
	}
	public String getFirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	



}
