package graficos;

public final class Pantalla {
	
	private final int ancho, alto;
	
	public final int[] pixeles;
	
	public Pantalla(final int ancho, final int alto){
		this.ancho = ancho;
		this.alto = alto;
		
		pixeles = new int[ancho * alto];
	}
	
	private void limpiar(){
		for (int i = 0; i < pixeles.length; i++){
			pixeles[i] = 0;
		}
	}
	
	private void mostrar(final int compensacionX, final int compensacionY){
		
		for (int y = 0; y < alto; y++){
			
			int posicionY = y + compensacionY;
			if (posicionY < 0 || posicionY > alto)
				continue;
			
			for (int x = 0; x < ancho; x++){
				
				int posicionX = x + compensacionX;
				if (posicionX < 0 || posicionX > ancho)
					continue;
				
				//Codigo para redibujar (mostrar)
			}
		}
	}
}
