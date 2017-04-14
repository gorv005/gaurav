package main;

import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
/*  w  w w  .  j a v a  2  s .  c  o  m*/
public class Main extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    WebEngine webEngine = new WebEngine();
    webEngine.getLoadWorker().stateProperty()
        .addListener((obs, oldValue, newValue) -> {
          if (newValue == Worker.State.SUCCEEDED) {

            JSObject jsobj = (JSObject) webEngine.executeScript("window");
            jsobj.setMember("ABCD", new HelloWorld());
          }
        });
    System.out.println("llll");
    webEngine.load("http://www.java2s.com");

    Group root = new Group();
    Scene scene = new Scene(root, 300, 250);

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}


