package gatto;

import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

public class Gatto {
	private Double x;
	private Double y;
	private Double size;
	private Color skin;	//pelle
	private Color eye;	//occhi
	private Color belly;	//pancia
	Gatto (Double x, Double y, Double size) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.skin = Color.ORANGE;
		this.eye = Color.GREEN;
		this.belly = Color.YELLOW;
	}
	Gatto (Double x, Double y, Double size, Color skin) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.skin = skin;
		this.eye = Color.GREEN;
		this.belly = Color.YELLOW;
	}
	Gatto (Double x, Double y, Double size, Color skin, Color eye) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.skin = skin;
		this.eye = eye;
		this.belly = Color.YELLOW;
	}
	Gatto (Double x, Double y, Double size, Color skin, Color eye, Color belly) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.skin = skin;
		this.eye = eye;
		this.belly = belly;
	}
	

	public Group drawHead (Group root) {
		//PROPORZIONI

		//testa
		Double Ytesta = this.y;
		Double radiusXCranio = this.size*3/2;
		Double radiusYCranio = this.size;
		//muso
		Double altezzaMuso = Ytesta + this.size/2;
		Double raggioMuso = this.size/2;
		Double raggioMento = raggioMuso*2/3;
		Double altezzaMento = altezzaMuso + raggioMento;		
		//naso
		Double altezzaNaso = Ytesta;
		Double raggioNaso = raggioMento;
		//occhi
		Double altezzaOcchi = Ytesta-radiusXCranio/3;
		Double raggioOcchi = radiusYCranio/3;
		Double distanzaOcchi = radiusXCranio/3;
		Double larghezzaPupille = raggioOcchi/2;
		//orecchie
		Double raggioOrecchie = this.size;
		Double altezzaOrecchiaSopra = Ytesta - radiusYCranio;
		Double altezzaOrecchiaSotto = Ytesta - radiusYCranio/2;
		Double altezzaOrecchiaInterno = altezzaOrecchiaSotto + radiusYCranio/3;
		Double distanzaOrecchiaSopra = radiusXCranio/2;
		Double distanzaOrecchiaSotto = radiusXCranio;
		//DISEGNO

		Ellipse cranio = new Ellipse (x, Ytesta, radiusXCranio, radiusYCranio);
		cranio.setFill(this.skin);
		Circle labbraSinistra = new Circle (x - raggioMuso, altezzaMuso, raggioMuso);
		Circle labbraDestra = new Circle (x + raggioMuso, altezzaMuso, raggioMuso);
		Shape labbra = Shape.union(labbraSinistra, labbraDestra);
		labbra.setFill(this.belly);
		labbra.setStrokeWidth(1);
		labbra.setStroke(Color.BLACK);
		Circle mento = new Circle (x, altezzaMento, raggioMento);
		mento.setStroke(Color.BLACK);
		mento.setFill(this.belly);
		//naso
		Polygon naso = new Polygon();
		naso.getPoints().addAll(new Double[] {
			x + raggioNaso * Math.sin( Math.PI/3), altezzaNaso,
			x - raggioNaso * Math.sin( Math.PI/3), altezzaNaso,
			x, altezzaMuso,		
		});
		naso.setFill(Color.PINK);
		naso.setStroke(Color.RED);
		//occhi
		Circle occhioSinistro = new Circle (x - distanzaOcchi, altezzaOcchi, raggioOcchi);
		Circle occhioDestro = new Circle (x + distanzaOcchi, altezzaOcchi, raggioOcchi);
		Shape occhi = Shape.union(occhioSinistro, occhioDestro);
		occhi.setFill(this.eye);
		//pupille
			//due parti della pupilla sinistra
		Circle pupillaSinistraSinistra = new Circle (x - distanzaOcchi - larghezzaPupille, altezzaOcchi, raggioOcchi);
		Circle pupillaSinistraDestra = new Circle (x - distanzaOcchi + larghezzaPupille, altezzaOcchi, raggioOcchi);
			//dua parti della pupilla destra
		Circle pupillaDestraSinistra = new Circle (x + distanzaOcchi - larghezzaPupille, altezzaOcchi, raggioOcchi);
		Circle pupillaDestraDestra = new Circle(x + distanzaOcchi + larghezzaPupille, altezzaOcchi, raggioOcchi);
			//operazioni delle parti
		Shape pupillaSinistra = Shape.intersect(pupillaSinistraSinistra, pupillaSinistraDestra);
		Shape pupillaDestra = Shape.intersect(pupillaDestraSinistra, pupillaDestraDestra);
		Shape pupille = Shape.union(pupillaSinistra, pupillaDestra);
		pupille.setFill(Color.BLACK);
		//orecchie
		Circle orecchiaSinistraSopra = new Circle (x - distanzaOrecchiaSopra, altezzaOrecchiaSopra, raggioOrecchie);
		Circle orecchiaSinistraSotto = new Circle (x - distanzaOrecchiaSotto, altezzaOrecchiaSotto, raggioOrecchie);
		Shape orecchiaSinistra = Shape.intersect(orecchiaSinistraSopra, orecchiaSinistraSotto);
		Circle orecchiaDestraSopra = new Circle (x + distanzaOrecchiaSopra, altezzaOrecchiaSopra, raggioOrecchie);
		Circle orecchiaDestraSotto = new Circle (x + distanzaOrecchiaSotto, altezzaOrecchiaSotto, raggioOrecchie);
		Shape orecchiaDestra = Shape.intersect(orecchiaDestraSopra, orecchiaDestraSotto);
		Shape orecchie = Shape.union (orecchiaSinistra, orecchiaDestra);
		orecchie.setFill(this.skin);
		//orecchie interne
		Circle orecchiaInternaSinistraSopra = orecchiaSinistraSopra;
		Circle orecchiaInternaSinistraSotto = new Circle (x - distanzaOrecchiaSotto, altezzaOrecchiaInterno, raggioOrecchie);
		Shape orecchiaInternaSinistra = Shape.intersect(orecchiaInternaSinistraSopra, orecchiaInternaSinistraSotto);
		Circle orecchiaInternaDestraSopra = orecchiaDestraSopra;
		Circle orecchiaInternaDestraSotto = new Circle (x + distanzaOrecchiaSotto, altezzaOrecchiaInterno, raggioOrecchie);
		Shape orecchiaInternaDestra = Shape.intersect(orecchiaInternaDestraSopra, orecchiaInternaDestraSotto);
		Shape orecchieInterne = Shape.union (orecchiaInternaSinistra, orecchiaInternaDestra);
		orecchieInterne.setFill(Color.PINK);
		
		//INSERISCO IN GROUP
		root.getChildren().addAll(orecchie, orecchieInterne, cranio, occhi, pupille, mento, labbra, naso);		
		return root;
	}
	public Group drawBody (Group root) {
		//PROPORZIONI
		//DISEGNO
		//INSERISCO IN GROUP
		root.getChildren().addAll();
		return root;
	}
	public Group draw (Group root) {
		root = this.drawBody(root);
		root = this.drawHead(root);
		return root;		
	}
}
