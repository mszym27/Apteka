package logowanie;

import java.awt.event.ActionEvent;


public class StarterError extends ErrorMessage {

	public StarterError(String message) {
		super("B��d logowania. Spr�buj ponownie.");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new Starter();
		dispose();
	}

	
}
