package main;

import java.io.File;

import org.json.JSONObject;

public class HelloWorld {
			Util util=new Util();
			MainClass class1=new MainClass();
			//ApplicationFrame mainClass=new ApplicationFrame();
		  public String sayGoodbye(String name) {
		    return "hi:" + name;
		  }
		  public void playVideo(String videoFileName) {
			  System.out.println("HII");
		  }
		  
		 
			public void playVideo(String videoFileName,String adPlayStatuss,String adVideoFileName1, String adVideoFileName2,String adVideoFileName3) {
				System.out.println("videoFileName==="+videoFileName);
				EmbeddedMediaPlayer embeddedMediaPlayer=new EmbeddedMediaPlayer();
				JSONObject playVideoJsonObject = Util.createPlayVideoJsonObject(""+videoFileName);
					
						util.sendPost(playVideoJsonObject);
					
				embeddedMediaPlayer.fun(videoFileName);
			//	String videoPath = Util.VIDEO_PATH_HTTP + File.separator + videoFileName;
			}
		  
			public void getMoreView(final int categoryId) {	
				
				  
					String pageUrl = Util.WEBPAGES_PATH_HTTP + "?cat_id=" + categoryId;	 
					  System.out.println("pageUrl=="+pageUrl);
					  class1.getObject().loadUrl(pageUrl);
					 // class1.getObject().setVisible(true);
					//  mainClass.loadUrl(pageUrl);
					 
					  //ApplicationFrame.loadUrl(pageUrl);
			  }
			public void getListingMoreView(final int subcategoryId) {
				String pageUrl = Util.WEBPAGES_VIDEO_LISTING_PATH_HTTP+ subcategoryId;
				  class1.getObject().loadUrl(pageUrl);
			}
}
