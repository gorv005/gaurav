package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;



public class Util {
	public static final String SAMBA_VOLUME = "usb_dev/usb_a1";
	public static final String SAMBA_HTTP_BASE_PATH = "http://192.168.0.1:8181";
	public static String VIDEO_BASE_PATH_HTTP_AUTO = SAMBA_HTTP_BASE_PATH + File.separator + SAMBA_VOLUME 
			+ File.separator + "videos";//+ "netless_files" + File.separator
	public static String HTTP = "http://";
	//public static  String BASE_PATH_HTTP_SERVER_LIVE = HTTP + "app.netless.in/";
	public static  String BASE_PATH_HTTP_SERVER_LIVE ="http://192.168.0.120/netless/";
	public static String VIDEO_PATH_HTTP = BASE_PATH_HTTP_SERVER_LIVE + "videos/";
	public static String LOG_URL_HTTP = BASE_PATH_HTTP_SERVER_LIVE +  "log.php";
	public static String WEBPAGES_PATH_HTTP = BASE_PATH_HTTP_SERVER_LIVE+"listing.php";
	public static String WEBPAGES_VIDEO_LISTING_PATH_HTTP = BASE_PATH_HTTP_SERVER_LIVE+"listingdetail.php?subcat_id=";
	
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
	
	
	public static JSONObject createPlayVideoJsonObject( String videoName) {
		
//		public static JSONObject createPlayVideoJsonObject(Context context, String videoName,
//				int videoId, int categoryId, int subcategoryId) {
			
			String loggerIdentifier = createIdentifierForLogging();
			
		/*	DeviceInfoBean deviceInfoBean = AppUtils.getDeviceInfo();
			
			String deviceManufacturer = deviceInfoBean.getManufacturer();
			String deviceModel = deviceInfoBean.getModel();
			boolean isTablet = MetricsUtils.isItTabletDevice(context);*/
			String deviceManufacturer = "Windows";
			String deviceModel = "Window 7";
			
			String deviceType = "Desktop";
		/*	if(!isTablet) {
				deviceType = "Android Phone";
			} else {
				deviceType = "Android Tablet";
			}*/
			
		//	String phoneNumber = MetricsUtils.getPhoneNumber(context);
		/*	if(phoneNumber != null) {
				if(phoneNumber.equals("")) {
					String savedPhoneNumber = AppUtils.getUserContactNumber(context);
					if(savedPhoneNumber != null) {
						phoneNumber = savedPhoneNumber;
					} else {
						phoneNumber = "XX";
					}				
				}						
			} else {
				String savedPhoneNumber = AppUtils.getUserContactNumber(context);
				if(savedPhoneNumber != null) {
					phoneNumber = savedPhoneNumber;
				} else {
					phoneNumber = "XX";
				}			
			}
			*/
			String phoneNumber = "XX";
		/*	String macAddress = MetricsUtils.getMacId(context);		
			if(macAddress != null) {
				if(macAddress.equals(""))
				{
					macAddress = "XX";
				}						
			} else {
				macAddress = "XX";
			}*/
			String	macAddress = "XX";
			/*String deviceUUID = MetricsUtils.getDeviceUUID(context);
			if(deviceUUID != null) {
				if(deviceUUID.equals(""))
				{
					deviceUUID = "XX";
				}					
			} else {
				deviceUUID = "XX";
			}*/
			String deviceUUID = "XX";
			
			
			boolean isOnlineVersion =true;	
			
			String zoneId = "111";
			String boxId = "2222";
			String appVersion = "2.0";
			
		/*	zoneId = MainActivity.ZONE_ID_SERVER;
			boxId = MainActivity.BOX_ID_SERVER;*/  //TODO
			
			if(zoneId != null) {
				if(zoneId.equals(""))
				{
					zoneId = "1";
				}					
			} else {
				zoneId = "1";
			}
			
			if(boxId != null) {
				if(boxId.equals(""))
				{
					boxId = "1";
				}					
			} else {
				boxId = "1";
			}
			
//			if(MainActivity.dummyMenuItemListForLaunching != null) {
//				if(MainActivity.dummyMenuItemListForLaunching.size() > 0) {
//					zoneId = MainActivity.dummyMenuItemListForLaunching.get(0).getZoneId();
//					boxId = MainActivity.dummyMenuItemListForLaunching.get(0).getBoxId();
//					appVersion = MainActivity.dummyMenuItemListForLaunching.get(0).getAppVersion();
//					
//					if(zoneId != null) {
//						if(zoneId.equals("")) {
//							zoneId = "111";
//						}						
//					} else {
//						zoneId = "111";
//					}
//				}
//			}
			
			JSONObject parentJsonObject = new JSONObject();
			JSONObject childJsonObject = new JSONObject();
			
			try {
				childJsonObject.put("logger_identifier", ""+loggerIdentifier);
				childJsonObject.put("device_manufacturer", ""+deviceManufacturer);
				childJsonObject.put("device_model", ""+deviceModel);
				childJsonObject.put("device_type", ""+deviceType);
				childJsonObject.put("device_phone_number", ""+phoneNumber);
				childJsonObject.put("device_mac_address", ""+macAddress);
				childJsonObject.put("device_uuid", ""+deviceUUID);			
				childJsonObject.put("is_online_version", isOnlineVersion);			
				//childJsonObject.put("category", "Bollywood Gupshup");
				//childJsonObject.put("subcategory", "Events");
				childJsonObject.put("video_name", ""+videoName);
				//childJsonObject.put("video_id", ""+videoId);
				//childJsonObject.put("category_id", ""+categoryId);
				//childJsonObject.put("subcategory_id", ""+subcategoryId);
				childJsonObject.put("zone_id", ""+zoneId);
				childJsonObject.put("box_id", ""+boxId);
				childJsonObject.put("playing_date", ""+getDate());
				childJsonObject.put("playing_time", ""+getTime());
				
				parentJsonObject.put("playVideo", childJsonObject);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("AppUtils.NETLESS_PERFORMANCE_LOG, LINE 75 - JSONCreator - play video json : " + parentJsonObject.toString());
			return parentJsonObject;
		}
	
	
private static String getDate() {
		
		String dateString = "";
		
		Calendar calendar = Calendar.getInstance();
		
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		
		String dayString = "";
		String monthString = "";
		if(dayOfMonth < 10) {
			dayString = "0"+dayOfMonth;
		} else {
			dayString = ""+dayOfMonth;
		}
		if(month < 10) {
			monthString = "0"+month;
		} else {
			monthString = ""+month;
		}
		
		dateString = dayString + "/" + monthString + "/" + year;
		
		return dateString;
	}
	
	private static String getTime() {
		
		String timeString ="";
		
		Calendar calendar = Calendar.getInstance();
		
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		String hourString = "";
		String minuteString = "";
		String secondString = "";
		
		if(hour < 10) {
			hourString = "0"+hour;
		} else {
			hourString = ""+hour;
		}
		if(minute < 10) {
			minuteString = "0"+minute;
		} else {
			minuteString = ""+minute;
		}
		if(second < 10) {
			secondString = "0"+second;
		} else {
			secondString = ""+second;
		}
		
		String AM_PM = calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM";
		timeString = hourString + ":" + minuteString + ":" + secondString + " " + AM_PM;
		
		return timeString;
	}
	
	
	
	public void sendPost(JSONObject jsonData){
		 try {

				URL url = new URL(Util.LOG_URL_HTTP);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
			//	conn.setRequestProperty("Content-Type", "application/json");
				 String data = "netless_log="+jsonData.toString();
				/*String input = "{\"qty\":100,\"name\":\"iPad 4\"}";

				OutputStream os = conn.getOutputStream();
				os.write(input.getBytes());
				os.flush()*/;

				/*if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
				}
*/
				OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
	            
	            //write parameters
	            writer.write(data);
	            writer.flush();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}

				conn.disconnect();

			  } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			 }
	}
	
	
	public void sendPost5(JSONObject jsonData){
		try {

	        DefaultHttpClient httpClient = new DefaultHttpClient();
	        HttpPost postRequest = new HttpPost(
	            "http://192.168.2.209/netless_php/log.php");
	       //         String json = "{\"application\":{\"isTest\":true,\"firstName\":\"Izak\",\"lastName\":\"Tarashandegan\",\"email\":\"izaktarashandegan@gmail.com\",\"phone\":\"4244420591\",\"zipcode\":\"90035\",\"describeYourself\":\"I am passionate about programming.I do my best to learn new materials about programming everyday. My favorite language is Java, and I do all my coding in Java.\",\"skills\":[\"I can talk in English and Farsi fluently, and I know a little Spanish too\"],\"education\":[{\"school\":\"CSUN\",\"graduationYear\":2013,\"degree\":\"bachelor\",\"major\":\"CS\"},{\"school\":\"SMC\",\"graduationYear\":2010,\"degree\":\"AA\",\"major\":\"CS\"}],\"experience\":[{\"company\":\"Ambient Digital Media\",\"fromDate\":\"2004-02-01\",\"toDate\":\"2004-05-01\",\"title\":\"web desinger\",\"workDone\":\"update their website\"},{\"company\":\"liberty plumbing and heating Inc.\",\"fromDate\":\"2004-06-01\",\"toDate\":\"2013-05-15\",\"title\":\"web desinger\",\"workDone\":\"work as a book keeper\"}]}}";
	     //   StringEntity input = new StringEntity(json);
	     /*   input.setContentType("application/json");
	        postRequest.setEntity(input);*/

	        HttpResponse response = httpClient.execute(postRequest);

	        StringBuilder sb = new StringBuilder();
	        
	            BufferedReader reader = 
	                   new BufferedReader(new InputStreamReader(response.getEntity().getContent()), 65728);
	            String line = null;

	            while ((line = reader.readLine()) != null) {
	                sb.append(line);
	            }
	        
	        


	System.out.println("finalResult " + sb.toString());
	        System.out.println(response.getStatusLine().getReasonPhrase());
/*
	        if (response.getStatusLine().getStatusCode() != 201) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                + response.getStatusLine().getStatusCode());
	        }*/

	        BufferedReader br = new BufferedReader(
	                        new InputStreamReader((response.getEntity().getContent())));

	        String output;
	        System.out.println("Output from Server .... \n");
	        while ((output = br.readLine()) != null) {
	            System.out.println(output);
	        }

	        httpClient.getConnectionManager().shutdown();

	      } catch (MalformedURLException e) {

	        e.printStackTrace();

	      } catch (IOException e) {

	        e.printStackTrace();

	      }
	}
	public void sendPost8(JSONObject jsonData)  {
		
		//	final String USER_AGENT = "Mozilla/5.0";
		//String jsonLogString = Html.fromHtml(jsonData.toString()).toString();
			System.out.println("SENDING DATA");
			String jsonLogString = jsonData.toString();
			System.out.println("SENDING DATA=="+jsonLogString);
		String url = "http://192.168.0.120/netless/log.php";
	/*	List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("netless_log", jsonLogString));*/
		
		List nameValuePairs = new ArrayList(1);
		nameValuePairs.add(new BasicNameValuePair("netless_log",jsonLogString));
		
		HttpClient client = null;
		try{
		 client = new DefaultHttpClient();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("dffnddddd");
		HttpPost httpPost=new HttpPost(url);
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//BasicNameValuePair pair = (BasicNameValuePair) parms.get(0);
		//String key = pair.getName();
		//String value = pair.getValue();
		//Log.d("test", "value before uploading .... key :  " + key + " :: value : " + value);
	//	httpPost.setHeader("User-Agent", USER_AGENT);

		/*try {
			httpPost.setEntity(new UrlEncodedFormEntity(urlParameters));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("dffngfgg");
		HttpResponse httpresponse = null;
		try {
			System.out.println("dffn");
			httpresponse = client.execute(httpPost);
			System.out.println("dffn");
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("dffn");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("dffn");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("dffn");
		}
		System.out.println("dffn");
		HttpEntity httpEntity=httpresponse.getEntity();
		
		System.out.println("dffn"+httpEntity.toString());
	//	is=httpEntity.getContent();
		
		/*DefaultHttpClient httpclient=new DefaultHttpClient();
		HttpPost post = new HttpPost(url);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("netless_log", jsonLogString));
		urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
		urlParameters.add(new BasicNameValuePair("cn", ""));
		urlParameters.add(new BasicNameValuePair("locale", ""));
		urlParameters.add(new BasicNameValuePair("caller", ""));
		urlParameters.add(new BasicNameValuePair("num", "12345"));

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = httpclient.execute(post);
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + post.getEntity());
		System.out.println("Response Code : " + 
                                    response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}*/

		
		
		
	}
	
	
	/*private static void sendPOST() throws IOException {
		URL obj = new URL(LOG_URL_HTTP);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST request not worked");
		}
	}*/
	
	
}
