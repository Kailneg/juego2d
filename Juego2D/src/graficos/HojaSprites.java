package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HojaSprites {
	
	private final int ancho;
	private final int alto;
	private BufferedImage imagen;
	private final int[] pixeles;
	
	//Se pone final por buena costumbre, así se le ayuda a JVM a interpretar el código
	public HojaSprites(final String ruta, final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;
		
		//El array tiene que tener el mismo tamaño que píxeles tenga el SpriteSheet
		pixeles = new int[ancho*alto];

		try {
			imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
			
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getAncho(){
		return ancho;
	}
}
