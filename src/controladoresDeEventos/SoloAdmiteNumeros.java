package controladoresDeEventos;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SoloAdmiteNumeros implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (!Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE||c==KeyEvent.VK_ENTER)
		{
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
