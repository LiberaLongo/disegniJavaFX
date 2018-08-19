package orsetto;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public class DisegnoOrsetti extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		//variabili ampiezza schermo
		Double width = 1000.0, height = 700.0;
		//stampa tutto
		Group disegno = new Group();
		Orsetto orsetto1 = new Orsetto (width*1/4, height/2, 100., Color.RED, Color.FUCHSIA);
		Orsetto orsetto2 = new Orsetto (width*2/4, height/2, 100., Color.BLUE, Color.GREEN);
		Orsetto orsetto3 = new Orsetto (width*3/4, height/2, 100., Color.YELLOW, Color.ORANGE);
		disegno = orsetto1.draw(disegno);
		disegno = orsetto2.draw(disegno);
		disegno = orsetto3.draw(disegno);
		Scene scene = new Scene(disegno ,width, height);
		primaryStage.setTitle("Orsetto");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String args[]){
		launch(args);
	}
}
