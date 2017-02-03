package edu.asu.msse.gnayak2;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gallery extends JFrame {

	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public Gallery() {
		setResizable(false);
		setPreferredSize(new Dimension(Constants.WIDTH,Constants.HEIGHT));
		panel = new JPanel();
		
		panel.add(new JLabel("Gallery"));
		add(panel);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
