package logowanie;

import java.awt.event.ActionEvent;


public class StarterError extends ErrorMessage {

	public StarterError(String message) {
		super("B³¹d logowania. Spróbuj ponownie.");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new Starter();
		dispose();
	}

	
}
