package controller;

import java.util.Observer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import maps.Map;
import maps.Parser;
import model.CODSim;
import views.GameView;

public class Controller extends Application{
	/*
	 * Main gui
	 * 
	 */
	private static Parser parser;
	
	private BorderPane pane;
	private Observer gameview;
	private Observer currentview;
	private MenuBar menubar;
	private CODSim game;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		pane = new BorderPane();
		game = new CODSim(Map.London);
		Scene scene = new Scene(pane, 600, 700);
		gameview = new GameView(game);
		menubar = new MenuBar();
		game.addObserver(gameview);
		setView(gameview);
		setUpMenus();
		stage.setScene(scene);
		stage.show();
		
	}
	 private void setView(Observer view) {
		  pane.setCenter(null);
		  currentview = view;
		  pane.setCenter((Node) view);
	  }
	 private void setUpMenus() {
		  /*
		   * Sets up the menu system and adds a menu listener
		   */
		MenuListener mlistener = new MenuListener();
		
		Menu options = new Menu("Options");
	    MenuItem sim = new MenuItem("Simulation");
	    Menu newmap = new Menu("New Map");
	    MenuItem inc = new MenuItem("Inc");
	    MenuItem london = new MenuItem("London Docks");
	    MenuItem stmarie = new MenuItem("Saint Marie");
	    newmap.getItems().addAll(london,stmarie);
	    sim.setOnAction(mlistener);
	    inc.setOnAction(mlistener);
	    options.getItems().addAll(inc,sim,newmap);
	    menubar.getMenus().add(options);
	    pane.setTop(menubar);
	  }
	  private class MenuListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent e) {
			String item = ((MenuItem) e.getSource()).getText();
			if(item.equals("Simulation")) {
				setView(gameview);
			} else if(item.equals("London Docks")) {
				game.changeMap(Map.London);
			} if(item.equals("Saint Marie")) {
				game.changeMap(Map.StMarie);
			} else if(item.equals("Inc")) {
				game.rotatePlayer(90);
			}
		}
		  
	  }
}
