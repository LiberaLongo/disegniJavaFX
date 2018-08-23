package gatto;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class disegnogatti extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		//variabili ampiezza schermo
		Double width = 1000.0, height = 700.0;
		Double x = width/2, y= height/2, size = 200.;
		//cosa voglio disegnare
		Group root = new Group();
		Gatto Norvy = new Gatto(x, y, size, Color.GREY, Color.GREEN, Color.LIGHTGREY);
		root = Norvy.draw(root);
		//Stampa tutto
		Scene scene = new Scene(root , width, height);
		primaryStage.setTitle("Norvy by LLibera");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String args[]){
		launch(args);
	}
}
