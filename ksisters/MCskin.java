package ksisters;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MCskin {
	private Double x;
	private Double y;
	private Double size;
	private Color colori[];
	private Integer matrix[][];

	public MCskin(Double x, Double y, Double size, Color[] colori, Integer[][] matrix) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
		this.colori = colori;
		this.matrix = matrix;
	}

	public Group draw(Group root) {
		for(int j=0 ; j < 8 ; j++) {
			for(int i=0; i < 8; i++) {
				Rectangle pixel = new Rectangle(this.x + j * this.size, this.y + i*this.size, this.size, this.size);
				pixel.setFill(this.colori[this.matrix[i][j]]);
				root.getChildren().add(pixel);
			}
		}
		return root;
	}
}

