import java.lang.Math;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class CoSeno extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
	//variabili ampiezza schermo
	Double width = 600.0, height = 600.0;
	//variabili posizione del soggetto
	Double x = width/2, y=height/2;
	Double raggio = 200.;

	//cosa voglio disegnare
	Circle cerchio = new Circle(x, y, raggio);
	cerchio.setFill(Color.RED);

	Polygon esagono = new Polygon();
	esagono.getPoints().addAll(new Double[] {
		x + raggio * Math.cos( Math.PI * 0/3 ) , y + raggio * Math.sin( Math.PI * 0/3 ) ,
		x + raggio * Math.cos( Math.PI * 1/3 ) , y + raggio * Math.sin( Math.PI * 1/3 ) ,
		x + raggio * Math.cos( Math.PI * 2/3 ) , y + raggio * Math.sin( Math.PI * 2/3 ) ,
		x + raggio * Math.cos( Math.PI * 3/3 ) , y + raggio * Math.sin( Math.PI * 3/3 ) ,
		x + raggio * Math.cos( Math.PI * 4/3 ) , y + raggio * Math.sin( Math.PI * 4/3 ) ,
		x + raggio * Math.cos( Math.PI * 5/3 ) , y + raggio * Math.sin( Math.PI * 5/3 ) ,
	});
	esagono.setFill(Color.BLUE);

	//Stampa tutto
	Group root = new Group(cerchio, esagono);
	Scene scene = new Scene(root , width, height);
	primaryStage.setTitle("Use of sin and cos");
	primaryStage.setScene(scene);
	primaryStage.show();
	}
	public static void main(String args[]){
	launch(args);
	}
}
