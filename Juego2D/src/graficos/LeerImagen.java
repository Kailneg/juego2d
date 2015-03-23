package graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LeerImagen {
	
	private static BufferedImage imagen;
	
	public static BufferedImage leer(Object clase, String ruta){
		try {
			imagen = ImageIO.read(LeerImagen.class.getResource(ruta));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imagen;
	}
}
