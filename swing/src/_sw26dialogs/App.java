package _sw26dialogs;

import _sw26dialogs.gui.MainFrame;

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
