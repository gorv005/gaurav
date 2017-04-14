/*
 * Copyright (c) 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class EmbeddedMediaPlayer extends Application {

   // private static final String MEDIA_URL = "file:/E:/movies/Cokestudio/1234.mp4";
    private static String MEDIA_URL ="http://192.168.0.120/netless/videos/10120094.mp4";
    public void fun(String videoname){
    	Stage primaryStage = new Stage();
    	primaryStage.setTitle("Embedded Media Player");
        
        MEDIA_URL =Util.VIDEO_PATH_HTTP+videoname;
       System.out.println("URL VIDEO=="+MEDIA_URL);
        // create media player
        Media media = new Media (MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
    	MediaView mediaView=new MediaView();
    	mediaView.setMediaPlayer(mediaPlayer);
        if(mediaPlayer.getError()==null){
        	mediaPlayer.setOnError(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("ERRORR");
				}
			});
        }
        mediaPlayer.setAutoPlay(true);
        MediaControl mediaControl = new MediaControl(mediaPlayer);
        Group root = new Group();
        root.getChildren().add(mediaView);
        Scene scene = new Scene(root, 540, 241);
        scene.setRoot(mediaControl);

        primaryStage.setScene(scene);
        primaryStage.show();
        mediaPlayer.play();
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Embedded Media Player");
       

        // create media player
        Media media = new Media (MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
    	MediaView mediaView=new MediaView();
    	mediaView.setMediaPlayer(mediaPlayer);
        if(mediaPlayer.getError()==null){
        	mediaPlayer.setOnError(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("ERRORR");
				}
			});
        }
        mediaPlayer.setAutoPlay(true);
        MediaControl mediaControl = new MediaControl(mediaPlayer);
        Group root = new Group();
        root.getChildren().add(mediaView);
        Scene scene = new Scene(root, 540, 241);
        scene.setRoot(mediaControl);

        primaryStage.setScene(scene);
        primaryStage.show();
        mediaPlayer.play();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
