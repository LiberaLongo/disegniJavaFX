package trasportations;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public class LLiberaRotation extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
                //variabili spaziali
                Double width = 1000. , height = 700.;
                Double size = 50.;      //dimensione di un pixel
                Double x = width*1/2 - size*4;
		Double y = height*1/2 - size*4;
		//LLibera (the autor)
		Color coloriLLibera[] = {
			Color.PINK,
			Color.RED,
			Color.ORANGE,
			Color.YELLOW,
			Color.GREEN,
			Color.AQUA,
			Color.BLUE,
			Color.PURPLE,
			Color.BLACK,
			Color.WHITE,
			Color.FUCHSIA,
			Color.SANDYBROWN
		};
		Integer matrixLLibera[][] = {
			{ 5, 6, 7, 1, 2, 3, 4, 5},
			{ 6, 7, 1, 2, 3, 4, 5, 6},
			{ 7, 8, 8, 0, 0, 8, 8, 7},
			{ 8,10, 9, 0, 0, 9,10, 8},
			{ 0,10, 8, 0, 0, 8,10, 0},
			{ 0, 0, 0,11,11, 0, 0, 0},
			{ 0, 0, 1, 0, 0, 1, 0, 0},
			{11, 0, 0, 1, 1, 0, 0,11},
		};
		//Disegno dei soggetti
		Group root = new Group();
                //setta la rotazione
                Rotate rotate = new Rotate();
                rotate.setAngle(20);
                rotate.setPivotX(x + size*4);
                rotate.setPivotY(y + size*4);
		//crea la skin
		MCskin LLibera = new MCskin(x, y, size, coloriLLibera, matrixLLibera, rotate);
		root = LLibera.draw(root);
		//Stampa tutto
		Scene scene = new Scene(root , width, height);
		primaryStage.setTitle("a try of rotation by LLibera");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String args[]){
		launch(args);
	}
}

