package ksisters;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class rotatedKsisters extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
                //variabili spaziali
                Double size = 40.;      //dimensione di un pixel
                Double spazioX = 85.;   //spazio lungo l'orizzontale ---
		Double spazioY = 22.;	//spazio lungo la verticale |
		Double angle = -20.;
                Double width = (size*8)*3+4*spazioX, height = (size*8)*2+3*spazioY;
		//KIRIAIR
		Color coloriKIRIAIR[] = {
			Color.PINK,
			Color.MAROON,
			Color.BLACK,
			Color.WHITE,
			Color.GREEN,
			Color.RED,
			Color.FUCHSIA
		};
		Integer matrixKIRIAIR[][] = {
			{1, 6, 1, 1, 1, 1, 1, 1},
			{6, 1, 1, 0, 0, 1, 1, 1},
			{1, 2, 2, 0, 0, 2, 2, 1},
			{2, 4, 3, 0, 0, 3, 4, 2},
			{0, 4, 2, 0, 0, 2, 4, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{1, 0, 0, 5, 5, 0, 0, 1},
		};
		//KOMAKI
		Color coloriKoMaKi_[] = {
			Color.PINK,
			Color.DARKORANGE,
			Color.BLACK,
			Color.WHITE,
			Color.DARKVIOLET,
			Color.PURPLE,
			Color.LIGHTGREY,
		};
		Integer matrixKoMaKi_[][] = {
			{6, 2, 2, 1, 1, 2, 2, 6},
			{2, 4, 4, 2, 2, 4, 4, 2},
			{2, 4, 5, 2, 2, 4, 5, 2},
			{1, 2, 2, 1, 2, 2, 2, 1},
			{1, 1, 1, 2, 0, 2, 2, 1},
			{1, 1, 2, 0, 0, 4, 3, 2},
			{1, 2, 5, 0, 0, 5, 3, 1},
			{2, 2, 0, 0, 0, 0, 0, 1},
		};
		//KiraLushia
		Color coloriKiraLushia[] = {
			Color.PINK,	//pelle
			Color.HOTPINK,	//capelli
			Color.BLACK,
			Color.WHITE,
			Color.RED, 	//occhio <-
			Color.ORCHID,
			Color.BLUE, //occhio    ->
			Color.AQUA
		};
		Integer matrixKiraLushia[][] = {
			{1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1},
			{1, 2, 2, 1, 1, 2, 2, 1},
			{2, 3, 5, 0, 0, 7, 3, 2},
			{1, 3, 4, 0, 0, 6, 3, 1},
			{1, 0, 0, 0, 0, 0, 0, 1},
			{1, 0, 0, 0, 0, 0, 0, 1},
		};
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
			{ 8,10, 9, 0, 0, 9, 10, 8},
			{ 0,10, 8, 0, 0, 8, 10, 0},
			{ 0, 0, 0, 11, 11, 0, 0, 0},
			{ 0, 0, 1, 0, 0, 1, 0, 0},
			{11, 0, 0, 1, 1, 0, 0, 11},
		};
		//altre variabili spaziali per decidere la posizione reciproca delle figure
		Double x = width*1/2 - size*4;
		Double y = height*1/2 - size*4;
		//Disegno dei soggetti
		Group root = new Group();
		MCskin KIRIAIR = new MCskin(x, height-size*8-spazioY, size, coloriKIRIAIR, matrixKIRIAIR, angle);
		MCskin KoMaKi_ = new MCskin(width-size*8-spazioX, y, size, coloriKoMaKi_, matrixKoMaKi_, angle);
		MCskin KiraLushia = new MCskin(spazioX, y, size, coloriKiraLushia, matrixKiraLushia, angle);
		MCskin LLibera = new MCskin(x, spazioY, size, coloriLLibera, matrixLLibera, angle);
		root = LLibera.draw(root);
		root = KoMaKi_.draw(root);
		root = KiraLushia.draw(root);
		root = KIRIAIR.draw(root);
		//Stampa tutto
		Scene scene = new Scene(root , width, height);
		primaryStage.setTitle("Ksister fan-code by LLibera");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String args[]){
		launch(args);
	}
}

