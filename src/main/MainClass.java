package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class MainClass extends Application{
	 static ApplicationFrame mainFrame;
	 WebView webComponent;
	  WebEngine webEngine;
  public static void main(String [] args){
	  Application.launch(args);
    /*SwingUtilities.invokeLater(new Runnable() {
    @Override
      public void run() {
    	
       mainFrame = new ApplicationFrame();
        mainFrame.setVisible(true);
        System.out.println("RUN");
        
      
      }
    });*/

  }
   public  ApplicationFrame getObject(){
	   return mainFrame;
   }
@Override
public void start(Stage arg0) throws Exception {
	// TODO Auto-generated method stub
	
	 webComponent = new WebView();
     webEngine=webComponent.getEngine();
    
   /*  JSObject jsobj = (JSObject)webEngine.executeScript("window");
     jsobj.setMember("android", new HelloWorld());*/
   
//       Util.list.add(url);
    // loadUrl(url);
   //  webComponent.getEngine().getLoadWorker().stateProperty().add
     System.out.println("RUN2");
     webEngine.getLoadWorker().stateProperty()
     .addListener((obs, oldValue, newValue) -> {
       if (newValue == Worker.State.SUCCEEDED) {

         JSObject jsobj = (JSObject) webEngine.executeScript("window");
         jsobj.setMember("android", new HelloWorld());
       }
     });
	  mainFrame = new ApplicationFrame(webEngine,webComponent);
      mainFrame.setVisible(true);
      System.out.println("RUN");
}
}

/**
* Main window used to display some HTML content.
*/
class ApplicationFrame extends JFrame{

  JFXPanel javafxPanel;
  WebEngine engine;
  WebView webComponent;
  JPanel mainPanel;
 
  private static JButton backButton, forwardButton;
  private static JPanel contentPrevious,contentCurrent,contentNext,upper,lower;
  JTextField urlField;
  JButton goButton;
  public static int positionOfPage;
 // String url="http://192.168.0.120/netless/home.php";
  String url=Util.BASE_PATH_HTTP_SERVER_LIVE+"home.php";

  public  Util util=new Util();
  public ApplicationFrame(WebEngine webEngine,WebView webComponent){
    this.engine=webEngine;
    this.webComponent=webComponent;
    javafxPanel = new JFXPanel();

    initSwingComponents();
    //util.loadJavaFXScene(url);
    loadJavaFXScene(url);
  }

  /**
  * Instantiate the Swing compoents to be used
  */
  private void initSwingComponents(){
	  
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.add(javafxPanel, BorderLayout.CENTER);
    upper = new JPanel();
  /*  JPanel urlPanel = new JPanel(new FlowLayout());
    urlField = new JTextField();
    urlField.setColumns(50);
    urlPanel.add(urlField);
    goButton = new JButton("Go");

    *//**
     * Handling the loading of new URL, when the user
     * enters the URL and clicks on Go button.
     *//*
    goButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Platform.runLater(new Runnable() {
          @Override
          public void run() {
            String url = urlField.getText();
            if ( url != null && url.length() > 0){
              //  webComponent.getEngine().load(url);
                loadUrl("vg");
            }
          }
        });

      }
    });*/  //go buttoon
    contentPrevious = new JPanel(new FlowLayout());
    JLabel lblPrevious = new JLabel("contentPrevious JPanel");
    contentPrevious.add(lblPrevious);
    contentNext = new JPanel(new FlowLayout());
    JLabel lblNext = new JLabel("contentNext JPanel");
    contentNext.add(lblNext);
    contentCurrent = new JPanel(new FlowLayout());
    JLabel lblCurrent = new JLabel("NETLESS");
    contentCurrent.add(lblCurrent);
    upper.add(contentCurrent);
    lower = new JPanel(new FlowLayout());
    backButton = new JButton("<<< Back");
    backButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			/*int sizeHistory = engine.getHistory().getEntries().size();
	          if(sizeHistory>1)
	          {
	              Entry entry = engine.getHistory().getEntries().get(sizeHistory-2);
	              System.out.println("URL hist.: " + entry.getUrl());
	              loadUrl(entry.getUrl());
	          }*/
			
			 /*engine.getHistory().go(-1);
			 loadUrl(engine.getHistory().getEntries().get(engine.getHistory().getCurrentIndex()).getUrl());*/
			 final WebHistory history=engine.getHistory();
			 ObservableList<WebHistory.Entry> entryList=history.getEntries();
			 int currentIndex=history.getCurrentIndex();
			 // Out("currentIndex = "+currentIndex);
			 // Out(entryList.toString().replace("],","]\n"));
			 System.out.println("history.getCurrentIndex()=="+history.getCurrentIndex());
			 if(history.getCurrentIndex()>0){
			 Platform.runLater(new Runnable() { public void run() { history.go(-1); } });
			 System.out.println(entryList.get(currentIndex>0?currentIndex-1:currentIndex).getUrl());
	
			 }
			 }
	});
    lower.add(backButton);
    forwardButton = new JButton("Forward >>>");
    forwardButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			final WebHistory history=engine.getHistory();
		    ObservableList<WebHistory.Entry> entryList=history.getEntries();
		    int currentIndex=history.getCurrentIndex();
//		    Out("currentIndex = "+currentIndex);
//		    Out(entryList.toString().replace("],","]\n"));
			 if(history.getCurrentIndex()<entryList.size()-1){
			 
		    Platform.runLater(new Runnable() { public void run() { history.go(1); } });
		    System.out.println(entryList.get(currentIndex<entryList.size()-1?currentIndex+1:currentIndex).getUrl());
			}
		}
		
	});
    lower.add(forwardButton);
    mainPanel.add(upper, BorderLayout.NORTH);
    mainPanel.add(lower,BorderLayout.SOUTH);
   
    /*urlPanel.add(goButton);
    mainPanel.add(urlPanel, BorderLayout.NORTH);*/ //Go button

    this.add(mainPanel);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(700,600);
   
  }

  /**
  * Instantiate the JavaFX Components in
  * the JavaFX Application Thread.
  */
 public  void loadJavaFXScene(String url){
	 //Platform.run
	
    Platform.runLater(new Runnable() {
      @Override
      public void run() {

        BorderPane borderPane = new BorderPane();
       
        engine.load(url);
        borderPane.setCenter(webComponent);
        Scene scene = new Scene(borderPane,450,450);
        javafxPanel.setScene(scene);
        System.out.println("RUN1");
    
        
      }
    });
  }
 
 public  void loadUrl(String url){
	
	 Platform.runLater(new Runnable() {
		
		@Override
		public void run() {
			 System.out.println("LOAD==="+url);
			// TODO Auto-generated method stub
	//		 Util.list.add(url);
			 engine.load(url);
		//	loadJavaFXScene(url);
		}
	});
	 
 }
}