package _sw22mcvtable;

import _sw22mcvtable.gui.MainFrame;

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
