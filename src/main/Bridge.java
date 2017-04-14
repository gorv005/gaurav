package main;


import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class Bridge extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Application.launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		  WebEngine webEngine = new WebEngine();
		    webEngine.getLoadWorker().stateProperty()
		        .addListener((obs, oldValue, newValue) -> {
		          if (newValue == Worker.State.SUCCEEDED) {

		            JSObject jsobj = (JSObject) webEngine.executeScript("window");
		            jsobj.setMember("ABCD", new HelloWorld());
		          }
		        });

		    webEngine.load("https://www.google.co.in");

		    Group root = new Group();
		    Scene scene = new Scene(root, 300.0, 250.0);

		    arg0.setScene(scene);
		    arg0.show();
		  }
	}


