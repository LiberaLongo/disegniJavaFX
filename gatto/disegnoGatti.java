package gatto;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class disegnoGatti extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		//variabili ampiezza schermo
		Double width = 1300.0, height = 700.0;
		//centro dello schermo
		Double size = 200.;
		//cosa voglio disegnare
		Group root = new Group();
		Gatto PanteraRosa = new Gatto(width/3, height/2, size, Color.PLUM, Color.YELLOW, Color.BISQUE);
		Gatto Norvy = new Gatto(width*4/5, height*2/3, size/2, Color.GREY, Color.GREEN, Color.LIGHTGREY);
		root = PanteraRosa.draw(root);
		root = Norvy.draw(root);
		//Stampa tutto
		Scene scene = new Scene(root , width, height);
		primaryStage.setTitle("Norvy e la pantera rosa by LLibera");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String args[]){
		launch(args);
	}
}
