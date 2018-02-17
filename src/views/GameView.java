package views;

import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.CODSim;
import model.Player;

/*
 * GUI Representation of the game view, 
 * 
 * worries about drawing things where they need to be
 */
public class GameView extends BorderPane implements Observer{
	private Canvas canvas;
	private GraphicsContext gc;
	private CODSim game;
	private Player player;
	private Image playerimg;
	private ImageView playerViewer;
	public GameView(CODSim game) {
		this.game = game;
		Pane stack = new Pane();
		canvas = new Canvas();
		gc = canvas.getGraphicsContext2D();
		player = game.getPlayer();
		playerViewer = new ImageView();
		playerimg = new Image("images/player.png");
		stack.getChildren().addAll(canvas,playerViewer);
		drawGame();
		this.setCenter(stack);
	}
	public void drawGame() {
		
		//draw the bmp image to the screen
		Image img = SwingFXUtils.toFXImage(game.getMap().getMapImage(), null);
		canvas.setWidth(img.getWidth());
		canvas.setHeight(img.getHeight());
		//draw the background.
		gc.drawImage(img, 0, 0);
		//draws the player at their position and rotation
		player = game.getPlayer();
		playerViewer.setX(player.getLocation().getX());
		playerViewer.setY(player.getLocation().getY());
		playerViewer.setImage(playerimg);
		playerViewer.setRotate(player.getRotation());
		
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		game = (CODSim) o;
		drawGame();
		//draw game etc
		
		
	}
		
}
