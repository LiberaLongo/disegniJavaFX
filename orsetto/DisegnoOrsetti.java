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
		Double y = height/2;
		Double size = 80.;
		//stampa tutto
		Group root = new Group();
		Orsetto KIRIAIR = new Orsetto(width*2/5, y, size, Color.FUCHSIA, Color.PINK);
		Orsetto KoMaKi_ = new Orsetto(width*3/5, y, size, Color.DARKORANGE, Color.ORANGE);
		Orsetto KiraLushia = new Orsetto(width*4/5, y, size, Color.PINK, Color.HOTPINK);
		Orsetto LLibera = new Orsetto(width*1/5, y, size, Color.BLUE, Color.AQUA);
		root = LLibera.draw(root);
		root = KiraLushia.draw(root);
		root = KoMaKi_.draw(root);
		root = KIRIAIR.draw(root);
		Scene scene = new Scene(root ,width, height);
		primaryStage.setTitle("Orsetto");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String args[]){
		launch(args);
	}
}
