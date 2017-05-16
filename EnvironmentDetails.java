package com.nomura.unity.takara.bean;

import com.nomura.unity.takara.helper.PropertyHelper;

public class EnvironmentDetails  //Code to define environments which would be picked up run time based on data in init.properties file
{

	public static String environment;
	public static String runningEnvironment;
	public static String UserId;

	public String getRunningEnvironment() throws Throwable
	{
//		if((EnvironmentDetails.runningEnvironment == null) || (EnvironmentDetails.runningEnvironment.length() < 13))
//		{
			EnvironmentDetails.environment = PropertyHelper.getPropertiesByKey("environment");
			
			EnvironmentDetails.runningEnvironment = EnvironmentDetails.environment;
			System.out.println("Using test environment: " + EnvironmentDetails.environment);
			
			if ("UAT".equalsIgnoreCase(EnvironmentDetails.environment))
			{
				EnvironmentDetails.runningEnvironment = "http://uat-intranet.nomuranow.com/takara/";
			} 
			else if ("BETA".equalsIgnoreCase(EnvironmentDetails.environment))

			{
				EnvironmentDetails.runningEnvironment = "http://takaraprd-mir.us-gen1.gslb.nomura.com:18082/takara/#/";
			}
//
//		}

		return EnvironmentDetails.runningEnvironment;
	}

	public void setRunningEnvironment(final String runningEnvironment)
	{
		EnvironmentDetails.runningEnvironment = runningEnvironment;
	}

    public static String getUserId() {
	// it is userID of the user for eg pandeyg, kothep, dhanaraa
    if(EnvironmentDetails.UserId == null)
	{
		return UserId ;
	}
	return UserId;
} 

    public void setUserId(String UserId) {
	// it is userID of the user for eg pandeyg, kothep, dhanaraa
	EnvironmentDetails.UserId = UserId;
	
}

}
