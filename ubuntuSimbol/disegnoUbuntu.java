package ubuntuSimbol;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

public class disegnoUbuntu extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		//variabili ampiezza schermo
		Double width = 1300.0, height = 700.0;
		Double x = width/2, y = height/2;
		Double distance = width/4;
		//cosa voglio disegnare
		simbolUbuntu ubuntuRAG = new simbolUbuntu (x - distance, y, 100.);
		simbolUbuntu ubuntuRGB = new simbolUbuntu (x + distance, y, 100., Color.RED, Color.YELLOW, Color.BLUE);
		simbolUbuntu monocolor = new simbolUbuntu (x, y, 100., Color.PURPLE);
		//Stampa tutto
		Group root = new Group();
		root = ubuntuRAG.draw(root);
		root = ubuntuRGB.draw(root);
		root = monocolor.draw(root);
		Scene scene = new Scene(root , width, height);
		primaryStage.setTitle("Simbol of Ubuntu");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String args[]){
		launch(args);
	}
}
