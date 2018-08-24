package mixati;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import static javafx.application.Application.launch;
import javafx.util.Duration;
import javafx.animation.ScaleTransition;

public class disegno extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
                //variabili spaziali
                Double pixel = 20.;
		Double size = 80.;
		Double width = 1000.;
		Double height = 700.;
		Double altezzaTeste = height/4;
		Double y = height/2;
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
			{ 8,10, 9, 0, 0, 9,10, 8},
			{ 0,10, 8, 0, 0, 8,10, 0},
			{ 0, 0, 0,11,11, 0, 0, 0},
			{ 0, 0, 1, 0, 0, 1, 0, 0},
			{11, 0, 0, 1, 1, 0, 0,11},
		};
		//Disegno dei soggetti
		Group root = new Group();
		//posizioni
		Double XKIRIAIR = width * 2/5;
		Double XKoMaKi_ = width * 3/5;
		Double XKiraLushia = width * 4/5;
		Double XLLibera = width * 1/5;
		//i corpi delle ksister (a forma di orsetto)
		Orsetto KIRIAIRbody = new Orsetto(XKIRIAIR, y, size, Color.FUCHSIA, Color.PINK);
		Orsetto KoMaKi_body = new Orsetto(XKoMaKi_, y, size, Color.DARKORANGE, Color.ORANGE);
		Orsetto KiraLushiabody = new Orsetto(XKiraLushia, y, size, Color.PINK, Color.HOTPINK);
		Orsetto LLiberabody = new Orsetto(XLLibera, y, size, Color.BLUE, Color.AQUA);
		root = LLiberabody.drawBody(root);
		root = KiraLushiabody.drawBody(root);
		root = KoMaKi_body.drawBody(root);
		root = KIRIAIRbody.drawBody(root);
/*
		//i cuori
		Cuore KIRIAIRcuore = new Cuore(XKIRIAIR, y, pixel, Color.RED);
		Cuore KoMaKi_cuore = new Cuore(XKoMaKi_, y, pixel, Color.BLUE);
		Cuore KiraLushiacuore = new Cuore(XKiraLushia, y, pixel, Color.GREEN);
		Cuore LLiberacuore = new Cuore(XLLibera, y, pixel, Color.PURPLE);
		root.getChildren().addAll( LLiberacuore.draw(), KoMaKi_cuore.draw(), KiraLushiacuore.draw(), KIRIAIRcuore.draw() );
*/
		//le Ksisters
		MCskin KIRIAIR 		= new MCskin(XKIRIAIR, altezzaTeste, pixel, coloriKIRIAIR, matrixKIRIAIR);
		MCskin KoMaKi_ 		= new MCskin(XKoMaKi_, altezzaTeste, pixel, coloriKoMaKi_, matrixKoMaKi_);
		MCskin KiraLushia	= new MCskin(XKiraLushia, altezzaTeste, pixel, coloriKiraLushia, matrixKiraLushia);
		MCskin LLibera		= new MCskin(XLLibera, altezzaTeste, pixel, coloriLLibera, matrixLLibera);
		root = LLibera.draw(root);
		root = KiraLushia.draw(root);
		root = KoMaKi_.draw(root);
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

