package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Teclado implements KeyListener{
	
	private final static int numeroTeclas = 100;
	private final static boolean teclas[] = new boolean[numeroTeclas];
	
	//Se ponen public por cuestiones de rendimiento
	public boolean arriba, abajo, izquierda, derecha;
	
	public void actualizar(){
		//Si uno de los dos es presionado, entonces será true
		arriba = teclas[KeyEvent.VK_W] || teclas[KeyEvent.VK_UP];
		abajo = teclas[KeyEvent.VK_S] || teclas[KeyEvent.VK_DOWN];
		izquierda = teclas[KeyEvent.VK_A] || teclas[KeyEvent.VK_LEFT];
		derecha = teclas[KeyEvent.VK_D] || teclas[KeyEvent.VK_RIGHT];
		accion();
	}

	private void accion() {

	}

	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		teclas[e.getKeyCode()] = false;
	}

	
	public void keyTyped(KeyEvent e) {}
}
