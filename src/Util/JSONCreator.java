package Util;

public class JSONCreator {
	public static String createIdentifierForLogging() {

		String identifier = "";

		StringBuilder builder = new StringBuilder();
		//int randomNo = getRandomNumner(context);


		builder.append("desktop_"); //desktop app

		builder.append("online"); //online


	//Phone Number
		//randomNo = getRandomNumner(context);				
		builder.append("_");
		//builder.append(randomNo);
		builder.append("XX");
		//Log.i("DEBUG", "INSIDE MAIN METHOD - PHONE NUM IS NOT NULL BUT NO VALUE THEN RANDOM_NUMBER : " + randomNo);


		
			//MAC ID
			
			builder.append("_");
			//builder.append(randomNo);
			builder.append("XX");
			//Log.i("DEBUG", "INSIDE MAIN METHOD - MAC_ADDRESS IS NULL THEN RANDOM_NUMBER : " + randomNo);
		
			
			//DEVICE ID
				builder.append("_");
				//builder.append(randomNo);
				builder.append("XX");
				//Log.i("DEBUG", "INSIDE MAIN METHOD - DEVICE_UUID IS NOT NULL BUT NO VALUE THEN RANDOM_NUMBER : " + randomNo);
			

		identifier = builder.toString();
		//identifier = identifier.replaceAll(":", "_");
		identifier = identifier.trim();
		


		return identifier;

	}
}
