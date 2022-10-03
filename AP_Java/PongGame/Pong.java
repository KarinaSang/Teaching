package game;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pong extends Application {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int PLAYER_HEIGHT = 100;
	private static final int PLAYER_WIDTH = 15;
	private static final double BALL_R = 15;
	private int ballYSpeed = 1;
	private int ballXSpeed = 1;
	private double playerOneYPos = HEIGHT/2;
	private double playerOneXPos = 0;
	private double computerYPos = HEIGHT/2;
	private double computerXPos = WIDTH-PLAYER_WIDTH;
	private double ballXPos = WIDTH/2;
	private double ballYPos = HEIGHT/2;
	private int scoreP1 = 0;
	private int scoreComputer = 0;
	private boolean gameStarted = false;

	
	// start the application
	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("PONG");
		
		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));
		tl.setCycleCount(Timeline.INDEFINITE);
		
		canvas.setOnMouseMoved(e -> playerOneYPos = e.getY());
		canvas.setOnMouseClicked(e -> gameStarted = true);
	
		StackPane sp = new StackPane(canvas);
		Scene scene = new Scene(sp);
		stage.setScene(scene);
		stage.show();
		tl.play();	
	}
	
	private void run(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		gc.fillRect(0,  0,  WIDTH, HEIGHT);
		
		gc.setFill(Color.WHITE);
		gc.setFont(Font.font(25));
		
		if (gameStarted) {
			ballXPos += ballXSpeed;
			ballYPos += ballYSpeed;
			
			if (ballXPos < WIDTH - WIDTH/4) {
				computerYPos = ballYPos - PLAYER_HEIGHT/2;
			}
			else {
				if (ballYPos > computerYPos + PLAYER_HEIGHT/2) {
					computerYPos += 1;
				}
				else {
					computerYPos -= 1;
				}
			}
			
			gc.fillOval(ballXPos, ballYPos, BALL_R, BALL_R);
		}
		else {
			gc.setStroke(Color.WHITE);
			gc.setTextAlign(TextAlignment.CENTER);
			gc.strokeText("Click", WIDTH/2, HEIGHT/2);
			
			ballXPos = WIDTH/2;
			ballYPos = HEIGHT/2;
			
			ballXSpeed = new Random().nextInt(2) == 0 ? 1 : -1;
			ballYSpeed = new Random().nextInt(2) == 0 ? 1 : -1;
		}
		
		// make sure that the ball stays in the canvas
		if (ballYPos > HEIGHT || ballYPos < 0) {
			ballYSpeed *= -1;
		}
		
		// if we/computer miss the ball, then the game ends
		if (ballXPos < playerOneXPos - PLAYER_WIDTH) {
			scoreComputer++;
			gameStarted = false;
		}
		
		if (ballXPos > computerXPos + PLAYER_WIDTH) {
			scoreP1++;
			gameStarted = false;
		}
		
		// make sure that ball bounces back if we/computer hit it
		if (((ballXPos + BALL_R) > computerXPos 
				&& ballYPos >= computerYPos 
				&& ballYPos <= computerYPos + PLAYER_HEIGHT) 
			||((ballXPos - BALL_R) < playerOneXPos 
				&& ballYPos >= playerOneYPos 
				&& ballYPos <= playerOneYPos + PLAYER_HEIGHT)  
			) {
			ballYSpeed += 1 * Math.signum(ballYSpeed);
			ballXSpeed += 1 * Math.signum(ballXSpeed);
			ballXSpeed *= -1;
			ballYSpeed *= -1;		
		}
		
		gc.fillText("Player 1: " + scoreP1 + "                               " + "Computer: " + scoreComputer, WIDTH/2, 100);
		gc.fillRect(computerXPos, computerYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
		gc.fillRect(playerOneXPos, playerOneYPos, PLAYER_WIDTH, PLAYER_HEIGHT);
		
	}
}
