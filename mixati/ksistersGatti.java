package mixati;
// autore: Libera Longo (nome minecraft: LLibera)
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import static javafx.application.Application.launch;
import javafx.util.Duration;
import javafx.animation.ScaleTransition;
//dimensione variabile dello schermo
import java.awt.Dimension;
import java.awt.Toolkit;

public class ksistersGatti extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		//dimensione automatica dello schermo
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                Double width = ((int) screenSize.getWidth() / 100) * 100.; //da un numero (scritto nella forma Axy, quindi xy sono le ultime due cifre e A tutte le altre) voglio ottenere A00 esempio A=13 xy=69 ho Axy=1369. e A00 = 1300.
		Double height = ((int) screenSize.getHeight() / 100) * 100.;
		//System.out.println("whidth = "+width+"\nheight = "+ height);
                //variabili spaziali
                Double size = 30.;      	//dimensione di un pixel
		Double sizeCuori = 40.;
		Double sizeGatti = 40.;	//dimensione del raggio del cerchio di un cuoricino
		Double space = width/10;	//spazietto
                Double spazioXSkin = size*8+space/2;		//spazio lungo l'orizzontale ---
		Double spazioYSkin = size*5+space/5;	//spazio lungo la verticale |
		Double spazioXGatti = size*14 + space;
		Double spazioYGatti = size*4 + space/2;
		Double spazioXCuori = spazioXSkin;
		Double spazioYCuori = spazioYSkin+space*2/5;	
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
		//LLibera (l'autore)
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
		//centro della finestra
		Double x = width/2;
		Double y = height/2;
		//Disegno dei soggetti
		Group root = new Group();
		//dei cuori animati e pucciosissimi
		Cuore cuore1 = new Cuore(x - spazioXCuori, y - spazioYCuori, sizeCuori, Color.ORANGE);	//in alto a sinistra
		Cuore cuore2 = new Cuore(x + spazioXCuori, y - spazioYCuori, sizeCuori, Color.FUCHSIA);	//in alto a destra
		Cuore cuore3 = new Cuore(x - spazioXCuori, y + spazioYCuori, sizeCuori, Color.BLUE);	//in basso a sinistra
		Cuore cuore4 = new Cuore(x + spazioXCuori, y + spazioYCuori, sizeCuori);		//in basso a destra
		Shape cuoreS1 = cuore1.draw();
		Shape cuoreS2 = cuore2.draw();
		Shape cuoreS3 = cuore3.draw();
		Shape cuoreS4 = cuore4.draw();
		//aggiungo i cuori al disegno
		root.getChildren().addAll(cuoreS1, cuoreS2, cuoreS3, cuoreS4);
		//i "nostri" (c'è anche la mia micina :-) ) gatti pucciosissimi
		Gatto Lulù = new Gatto(x + spazioXGatti, y - spazioYGatti, sizeGatti, Color.LIGHTGREY, Color.AQUA, Color.WHITE);//mia
		Gatto Norvy = new Gatto(x - spazioXGatti, y - spazioYGatti, sizeGatti, Color.GREY, Color.YELLOW, Color.LIGHTGREY);//di Kiria
		Gatto Miele = new Gatto(x - spazioXGatti, y + spazioYGatti, sizeGatti, Color.GOLD, Color.BLUE, Color.ORANGE);//di Lushia
		Gatto Tiubik = new Gatto(x + spazioXGatti, y + spazioYGatti, sizeGatti, Color.GREY, Color.ORANGE, Color.GREY);//di Komaki
		Tiubik.setTigrato();
		//aggiungo i gatti al disegno
		root = Lulù.draw(root);
		root = Norvy.draw(root);
		root = Miele.draw(root);
		root = Tiubik.draw(root);
		//le Ksisters
		MCskin KIRIAIR = new MCskin(x, y+spazioYSkin, size, coloriKIRIAIR, matrixKIRIAIR);
		MCskin KoMaKi_ = new MCskin(x+spazioXSkin, y, size, coloriKoMaKi_, matrixKoMaKi_);
		MCskin KiraLushia = new MCskin(x-spazioXSkin, y, size, coloriKiraLushia, matrixKiraLushia);
		//la "firma dell'autore" (la mia skin :-) )
		MCskin LLibera = new MCskin(x, y-spazioYSkin, size, coloriLLibera, matrixLLibera);
		//aggiungo le ksister al disegno
		root = LLibera.draw(root);
		root = KoMaKi_.draw(root);
		root = KiraLushia.draw(root);
		root = KIRIAIR.draw(root);
		//Stampa tutto
		Scene scene = new Scene(root , width, height);
		scene.setFill(Color.MIDNIGHTBLUE);
		primaryStage.setTitle("Ksister fan-code by LLibera");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String args[]){
		launch(args);
	}
}

