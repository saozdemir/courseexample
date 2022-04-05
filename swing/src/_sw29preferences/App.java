package _sw29preferences;

import _sw29preferences.gui.MainFrame;

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
