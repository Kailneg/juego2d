package graficos;

import java.awt.image.BufferedImage;

public final class Sprite {
	//Tamaño del lado del sprite. Normalmente es 32, 64, 128...
	private final int lado;
	
	private int x, y;
	private BufferedImage imagen;
	
	public int pixeles[];
	
	public Sprite (final int lado, final int columna, final int fila, final HojaSprites hoja) {
		this.lado = lado;
		
		//El array tiene que tener el mismo tamaño que píxeles tenga el Sprite
		pixeles = new int[lado*lado];
		
		this.x = columna * lado;
		this.y = fila * lado;
	}
}
