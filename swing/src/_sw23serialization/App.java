package _sw23serialization;

import _sw23serialization.gui.MainFrame;

import javax.swing.*;

public class App {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
			}
		});	
	}

}
