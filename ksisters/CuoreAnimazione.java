package ksisters;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class CuoreAnimazione extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
                //variabili spaziali
                Double size = 200.;
                Double width = 1000.;
		Double height = 700.;
		//centro della finestra
		Double x = width/2;
		Double y = height/2;
		//Disegno dei soggetti
		Group root = new Group();
		//dei cuori animati e pucciosissimi
		Cuore cuore1 = new Cuore(x, y, size);
		Shape cuoreS1 = cuore1.draw();		
		root.getChildren().addAll(cuoreS1);
		//Stampa tutto
		Scene scene = new Scene(root , width, height);
		primaryStage.setTitle("cuore pulsante");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String args[]){
		launch(args);
	}
}

