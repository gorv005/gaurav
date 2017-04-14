package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
 
/**
 * @web http://java-buddy.blogspot.com/
 */
public class FXVideoPlayer{
     
    private static final String MEDIA_URL = "http://192.168.0.120/netless/videos/10120094.mp4";
     
    private static void initFxLater(JFXPanel panel){
        Group root = new Group();
        Scene scene = new Scene(root, 540, 210);
         
        // create media player
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
         
        // create mediaView and add media player to the viewer
        MediaView mediaView = new MediaView(mediaPlayer);
        ((Group)scene.getRoot()).getChildren().add(mediaView);
         
        panel.setScene(scene);
    }
     
    private static void initSwingLater(){
        JFrame jFrame = new JFrame("- JFrame -");
        jFrame.setSize(540, 210);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        final JFXPanel jFXPanel = new JFXPanel();
        jFrame.add(jFXPanel);
         
        Platform.runLater(new Runnable(){
 
            @Override
            public void run() {
                initFxLater(jFXPanel);
            }
        });
         
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
 
            @Override
            public void run() {
                initSwingLater();
            }
             
        });
    }
}
