package gatto;

import javafx.scene.Group;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;

public class Gatto {

	private Double x;
	private Double y;
	private Double Ytesta;
	private Double size;
	//colori
	private Color pelle;	//arancio
	private Color occhi;	//verde
	private Color muso;	//un colore chiaro, giallo
	private Color pancia;	//=muso
	private Color naso;	//rosa
	private Color orecchie;	//rosa
	//bordi
	private Boolean bordi;

	Gatto (Double x, Double y, Double size) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.Ytesta = this.y - this.size*3/2;
		//colori
		this.pelle = Color.ORANGE;
		this.occhi = Color.GREEN;
		this.pancia = Color.YELLOW;
		this.muso = this.pancia;
		this.naso = Color.PINK;
		this.orecchie = Color.PINK;
		this.bordi = false;
	}
	Gatto (Double x, Double y, Double size, Color pelle, Color occhi, Color pancia) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.Ytesta = this.y - this.size*3/2;
		//colori
		this.pelle = pelle;
		this.occhi = occhi;
		this.pancia = pancia;
		this.muso = this.pancia;
		this.naso = Color.PINK;
		this.orecchie = Color.PINK;
		this.bordi = false;
	}
	Gatto (Double x, Double y, Double size, Color pelle, Color occhi, Color pancia, Color muso, Color naso, Color orecchie) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.Ytesta = this.y - this.size*3/2;
		//colori
		this.pelle = pelle;
		this.occhi = occhi;
		this.pancia = pancia;
		this.muso = muso;
		this.naso = naso;
		this.orecchie = orecchie;
		this.bordi = false;
	}

	//setters e getters dei colori (per non impazzire)
	public void setPelle(Color pelle) {
		this.pelle = pelle;
	}
	public Color getPelle() {
		return this.pelle;
	}
	public void setOcchi(Color occhi) {
		this.occhi = occhi;
	}
	public Color getOcchi() {
		return this.occhi;
	}
	public void setMuso(Color muso) {
		this.muso = muso;
	}
	public Color getMuso() {
		return this.muso;
	}
	public void setPancia(Color pancia) {
		this.pancia = pancia;
	}
	public Color getPancia() {
		return this.pancia;
	}
	public void setNaso(Color naso) {
		this.naso = naso;
	}
	public Color getNaso() {
		return this.naso;
	}
	public void setOrecchie(Color orecchie) {
		this.orecchie = orecchie;
	}
	public Color getOrecchie() {
		return this.orecchie;
	}
	public void setStroke() {
		this.bordi = true;
	}
	public Boolean getStroke() {
		return this.bordi;
	}
	//Se si vuole disegnare solo la TESTA
	public void setYtestaDistance(Double distance) {
		this.Ytesta = this.y - distance;
	}
	public Double getYtesta() {
		return this.Ytesta;
	}

	public Group drawHead (Group root) {

		//PROPORZIONI

		//testa
		Double radiusXCranio = this.size*3/2;
		Double radiusYCranio = this.size;
		//muso
		Double altezzaMuso = this.Ytesta + this.size/2;
		Double raggioMuso = this.size/2;
		Double raggioMento = raggioMuso*2/3;
		Double altezzaMento = altezzaMuso + raggioMento;		
		//naso
		Double altezzaNaso = this.Ytesta;
		Double raggioNaso = raggioMento;
		//occhi
		Double altezzaOcchi = this.Ytesta-radiusXCranio/3;
		Double raggioOcchi = radiusYCranio/3;
		Double distanzaOcchi = radiusXCranio/3;
		Double larghezzaPupille = raggioOcchi/2;
		//orecchie
		Double raggioOrecchie = this.size;
		Double altezzaOrecchiaSopra = this.Ytesta - radiusYCranio;
		Double altezzaOrecchiaSotto = this.Ytesta - radiusYCranio/2;
		Double altezzaOrecchiaInterno = altezzaOrecchiaSotto + radiusYCranio/3;
		Double distanzaOrecchiaSopra = radiusXCranio/2;
		Double distanzaOrecchiaSotto = radiusXCranio;

		//DISEGNO

		//cranio
		Ellipse cranio = new Ellipse (this.x, this.Ytesta, radiusXCranio, radiusYCranio);
		cranio.setFill(this.pelle);
		if(this.bordi)
			cranio.setStroke(Color.BLACK);
		//muso
		Circle labbraSinistra = new Circle (this.x - raggioMuso, altezzaMuso, raggioMuso);
		Circle labbraDestra = new Circle (this.x + raggioMuso, altezzaMuso, raggioMuso);
		Shape labbra = Shape.union(labbraSinistra, labbraDestra);
		labbra.setFill(this.muso);
		labbra.setStrokeWidth(1);
		labbra.setStroke(Color.BLACK);
		Circle mento = new Circle (this.x, altezzaMento, raggioMento);
		mento.setStroke(Color.BLACK);
		mento.setFill(this.muso);
		//naso
		Polygon naso = new Polygon();
		naso.getPoints().addAll(new Double[] {
			this.x + raggioNaso * Math.sin( Math.PI/3), altezzaNaso,
			this.x - raggioNaso * Math.sin( Math.PI/3), altezzaNaso,
			this.x, altezzaMuso,		
		});
		naso.setFill(this.naso);
		naso.setStroke(Color.RED);
		//occhi
		Circle occhioSinistro = new Circle (this.x - distanzaOcchi, altezzaOcchi, raggioOcchi);
		Circle occhioDestro = new Circle (this.x + distanzaOcchi, altezzaOcchi, raggioOcchi);
		Shape occhi = Shape.union(occhioSinistro, occhioDestro);
		occhi.setFill(this.occhi);		
		if(this.bordi)
			occhi.setStroke(Color.BLACK);
		//pupille
			//due parti della pupilla sinistra
		Circle pupillaSinistraSinistra = new Circle (this.x - distanzaOcchi - larghezzaPupille, altezzaOcchi, raggioOcchi);
		Circle pupillaSinistraDestra = new Circle (this.x - distanzaOcchi + larghezzaPupille, altezzaOcchi, raggioOcchi);
			//dua parti della pupilla destra
		Circle pupillaDestraSinistra = new Circle (this.x + distanzaOcchi - larghezzaPupille, altezzaOcchi, raggioOcchi);
		Circle pupillaDestraDestra = new Circle(this.x + distanzaOcchi + larghezzaPupille, altezzaOcchi, raggioOcchi);
			//operazioni delle parti
		Shape pupillaSinistra = Shape.intersect(pupillaSinistraSinistra, pupillaSinistraDestra);
		Shape pupillaDestra = Shape.intersect(pupillaDestraSinistra, pupillaDestraDestra);
		Shape pupille = Shape.union(pupillaSinistra, pupillaDestra);
		pupille.setFill(Color.BLACK);
		//orecchie
		Circle orecchiaSinistraSopra = new Circle (this.x - distanzaOrecchiaSopra, altezzaOrecchiaSopra, raggioOrecchie);
		Circle orecchiaSinistraSotto = new Circle (this.x - distanzaOrecchiaSotto, altezzaOrecchiaSotto, raggioOrecchie);
		Shape orecchiaSinistra = Shape.intersect(orecchiaSinistraSopra, orecchiaSinistraSotto);
		Circle orecchiaDestraSopra = new Circle (this.x + distanzaOrecchiaSopra, altezzaOrecchiaSopra, raggioOrecchie);
		Circle orecchiaDestraSotto = new Circle (this.x + distanzaOrecchiaSotto, altezzaOrecchiaSotto, raggioOrecchie);
		Shape orecchiaDestra = Shape.intersect(orecchiaDestraSopra, orecchiaDestraSotto);
		Shape orecchie = Shape.union (orecchiaSinistra, orecchiaDestra);
		orecchie.setFill(this.pelle);
		if(this.bordi)
			orecchie.setStroke(Color.BLACK);
		//orecchie interne
		Circle orecchiaInternaSinistraSotto = new Circle (this.x - distanzaOrecchiaSotto, altezzaOrecchiaInterno, raggioOrecchie);
		Shape orecchiaInternaSinistra = Shape.intersect(orecchiaInternaSinistraSotto, orecchiaSinistra);
		Circle orecchiaInternaDestraSotto = new Circle (this.x + distanzaOrecchiaSotto, altezzaOrecchiaInterno, raggioOrecchie);
		Shape orecchiaInternaDestra = Shape.intersect(orecchiaInternaDestraSotto, orecchiaDestra);
		Shape orecchieInterne = Shape.union (orecchiaInternaSinistra, orecchiaInternaDestra);
		orecchieInterne.setFill(this.orecchie);
		if(this.bordi)
			orecchieInterne.setStroke(Color.BLACK);

		//INSERISCO IN GROUP

		root.getChildren().addAll(orecchie, orecchieInterne, cranio, occhi, pupille, mento, labbra, naso);		
		return root;
	}
	private Group drawDita (Group root, Double x, Double y, Double distance) {
		//PROPORZIONI
		Double radiusX = distance/3;
		Double radiusY = distance*2/3;
		//DISEGNO
		//ellissi
		Ellipse ditoSinistro = new Ellipse(x, y, radiusX, radiusY);
		Ellipse ditoCentrale = new Ellipse(x + distance/2, y, radiusX, radiusY);
		Ellipse ditoDestro = new Ellipse(x + distance, y, radiusX, radiusY);
		//colore
		ditoSinistro.setFill(this.pelle);
		ditoCentrale.setFill(this.pelle);
		ditoDestro.setFill(this.pelle);
		//bordo
		ditoSinistro.setStroke(Color.BLACK);
		ditoCentrale.setStroke(Color.BLACK);
		ditoDestro.setStroke(Color.BLACK);
		//INSERISCO IN GROUP
		root.getChildren().addAll(ditoSinistro, ditoDestro, ditoCentrale);
		return root;
	}
	public Group drawBody (Group root) {
		//PROPORZIONI

		//corpo
		Double Ycorpo = this.y + this.size;
		Double radiusXCorpo = this.size;
		Double radiusYCorpo = this.size*2;
		//pancia
		Double altezzaPancia = Ycorpo + radiusXCorpo/4;
		Double radiusXPancia = radiusXCorpo*2/3;
		Double radiusYPancia = radiusYCorpo*2/3;
		//braccia
		Double distanzaBraccia = this.size*7/8;
		Double widthBraccia = radiusXCorpo/2;
		Double heightBraccia = radiusYCorpo*3/2;
		//gambe
		Double radiusXGambe = radiusXCorpo/3;
		Double radiusYGambe = radiusYCorpo/2;
		Double altezzaGambe = Ycorpo + radiusYCorpo/2;
		Double distanzaGambe = this.size*7/6;

		//DISEGNO
		
		//corpo
		Ellipse corpo = new Ellipse(this.x, Ycorpo, radiusXCorpo, radiusYCorpo);
		corpo.setFill(this.pelle);
		if(this.bordi)
			corpo.setStroke(Color.BLACK);
		//pancia
		Ellipse panciaE = new Ellipse(this.x, altezzaPancia, radiusXPancia, radiusYPancia);
		Shape pancia = Shape.intersect(corpo, panciaE);
		pancia.setFill(this.pancia);
		if(this.bordi)
			pancia.setStroke(Color.BLACK);
		//braccia
			//braccio sinistro
		Rectangle braccioSinistroRectangle = new Rectangle(this.x - distanzaBraccia, this.y, widthBraccia, heightBraccia);
		Circle braccioSinistroCircle = new Circle(this.x + widthBraccia/2 - distanzaBraccia , this.y, widthBraccia/2);
		Shape braccioSinistro = Shape.union(braccioSinistroRectangle, braccioSinistroCircle);
			//braccio destro
		Rectangle braccioDestroRectangle = new Rectangle(this.x - widthBraccia + distanzaBraccia, this.y, widthBraccia, heightBraccia);
		Circle braccioDestroCircle = new Circle(this.x - widthBraccia/2 + distanzaBraccia, this.y, widthBraccia/2);
		Shape braccioDestro = Shape.union(braccioDestroRectangle, braccioDestroCircle);
			//entrambe le braccia
		Shape braccia = Shape.union(braccioSinistro, braccioDestro);
		braccia.setFill(this.pelle);
		braccia.setStroke(Color.BLACK);
		//gambe
		Ellipse gambaSinistra = new Ellipse(x - distanzaGambe, altezzaGambe, radiusXGambe, radiusYGambe);
		Ellipse gambaDestra = new Ellipse(x + distanzaGambe, altezzaGambe, radiusXGambe, radiusYGambe);
		Shape gambe = Shape.union(gambaSinistra, gambaDestra);
		gambe.setFill(this.pelle);
		if(this.bordi)
			gambe.setStroke(Color.BLACK);

		//INSERISCO IN GROUP
		root.getChildren().addAll(gambe, corpo, pancia);
		//dita delle gambe
			//gamba sinistra
		root = this.drawDita(root, this.x - distanzaGambe - radiusXGambe/2, altezzaGambe + radiusYGambe, radiusXGambe);
			//gamba destra
		root = this.drawDita(root, this.x + distanzaGambe - radiusXGambe/2, altezzaGambe + radiusYGambe, radiusXGambe);
		//braccia
		root.getChildren().add(braccia);
		//dita delle braccia
			//braccio sinistro
		root = this.drawDita(root, this.x - distanzaBraccia, this.y + heightBraccia, widthBraccia);
			//braccio destro
		root = this.drawDita(root, this.x - widthBraccia + distanzaBraccia, this.y + heightBraccia, widthBraccia);
		return root;
	}
	public Group draw (Group root) {
		root = this.drawBody(root);
		root = this.drawHead(root);
		return root;		
	}
}

