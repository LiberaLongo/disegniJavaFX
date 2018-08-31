package ubuntuSimbol;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Shape;

public class disegnoUbuntu extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		//variabili ampiezza schermo
		Double width = 1300.0, height = 700.0;
		Double x = width/2, y = height/2;
		//cosa voglio disegnare
		simbolUbuntu ubuntu = new simbolUbuntu (x, y, 250.);
		//Stampa tutto
		Group root = new Group();
		root = ubuntu.draw(root);
		Scene scene = new Scene(root , width, height);
		primaryStage.setTitle("Simbol of Ubuntu");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String args[]){
		launch(args);
	}
}
