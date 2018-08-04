package ksisters;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Cuore {
	private Double x;
	private Double y;
	private Double size;
	
	Cuore() {
	}
	Cuore(Double x, Double y, Double size) {
		this.x = x - size/2;
		this.y = y;
		this.size = size;
	}
	public Shape draw() {
		Circle sinistro = new Circle(this.x-this.size*4/5, this.y, this.size);
		Circle destro = new Circle(this.x+this.size*4/5, this.y, this.size);
		Shape cerchi = Shape.union(sinistro, destro);		
		Polygon sotto = new Polygon();
		sotto.getPoints().addAll(new Double[]{
			this.x-this.size*3/2+1, this.y+this.size*3/4,
			this.x, this.y,
			this.x+this.size*3/2-1, this.y+this.size*3/4,
			this.x, this.y+this.size*2
		});
		Shape cuore = Shape.union(cerchi, sotto);
		cuore.setFill(Color.RED);
		return cuore;
	}
	public Shape draw(Double x, Double y, Double size, Color paint) {
		this.x = x;
		this.y = y;
		this.size = size;
		return this.draw();
	}
}
