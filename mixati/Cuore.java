package mixati;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Cuore {
	private Double x;
	private Double y;
	private Double size;
	private Color colore;

	Cuore() {
	}
	Cuore(Double x, Double y, Double size) {
		this.x = x - size/2;
		this.y = y;
		this.size = size;
		this.colore = Color.RED;	//colore rosso di default
	}
	Cuore(Double x, Double y, Double size, Color paint) {
		this.x = x - size/2;
		this.y = y;
		this.size = size;
		this.colore = paint;
	}
	public Shape draw() {
		Double distanza = this.size * 4/5;	//distanza tra il centro del cuore e un cerchio
		Circle sinistro = new Circle(this.x-distanza, this.y, this.size);
		Circle destro = new Circle(this.x+distanza, this.y, this.size);
		Shape cerchi = Shape.union(sinistro, destro);
		Polygon sotto = new Polygon();
		sotto.getPoints().addAll(new Double[]{
			this.x - (distanza + this.size * Math.cos( Math.PI/3 )), this.y + this.size * Math.sin( Math.PI/3 ),	//sinistro
			this.x, this.y,												//sopra
			this.x + (distanza + this.size * Math.cos( Math.PI/3 )), this.y + this.size * Math.sin( Math.PI/3 ),	//destro
			this.x, this.y+this.size*2										//sotto
		});
		Shape cuore = Shape.union(cerchi, sotto);
		cuore.setFill(this.colore);
		return cuore;
	}
	public Shape draw(Double x, Double y, Double size, Color paint) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.colore = paint;
		return this.draw();
	}
}
