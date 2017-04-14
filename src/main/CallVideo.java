package main;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


public class CallVideo extends Application{
	private static final String MEDIA_URL =
            "file:/E:/movies/Cokestudio/1234.mp4";
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		String workingDir=System.getProperty("user.dir");
		File f=new File("E:/movies", "/Cokestudio/123.mp4");
		Media m=new Media(f.toURI().toString());
		MediaPlayer mediaPlayer=new MediaPlayer(m);
		MediaView mediaView=new MediaView(mediaPlayer);
		StackPane pane=new StackPane();
		pane.getChildren().add(mediaView);
		primaryStage.setScene(new Scene(pane,960,540));
		primaryStage.setTitle("Neless");
		primaryStage.show();
		mediaPlayer.play();
		VlcVideoPlayer player=new VlcVideoPlayer();
		player.start(MEDIA_URL);
	}

     public static void main(String[] args) {
		launch(args);
	}
}