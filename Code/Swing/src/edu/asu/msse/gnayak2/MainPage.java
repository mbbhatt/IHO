package edu.asu.msse.gnayak2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPage extends JFrame {

	private JPanel panel;
	private JPanel row1;
	private JPanel row2;
	private JPanel row3;
	private JButton btnNewsAndEvents;
	private JButton btnFieldNotes;
	private JButton btnAbout;
	private JButton btnGallery;
	private JButton btnConnect;
	private JButton btnDonate;
	private BufferedImage bufferedImage;

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setResizable(false);
		setPreferredSize(new Dimension(Constants.WIDTH,Constants.HEIGHT));
//		setBounds(100, 100, 450, 300);
		
		panel = new JPanel();
//		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		row1 = new JPanel();
		row2 = new JPanel();
		row3 = new JPanel();
		
		row1.setSize(new Dimension(Constants.WIDTH-10,50));
		
		
		row2.setPreferredSize(new Dimension(Constants.WIDTH, 10));
		panel.setLayout(new BorderLayout());
		panel.add(row1, BorderLayout.NORTH);
		panel.add(row2, BorderLayout.CENTER);
		panel.add(row3, BorderLayout.SOUTH);
		
		btnNewsAndEvents = new JButton("News and Events");
		btnFieldNotes = new JButton("Filed Notes");
		btnAbout = new JButton("About");
		btnGallery = new JButton("Gallery");
		btnConnect = new JButton("Connect");
		btnDonate = new JButton("Donate");
		
		row2.setLayout(new GridLayout(2,3,3,3));
		row2.add(btnNewsAndEvents);
		row2.add(btnFieldNotes);
		row2.add(btnAbout);
		row2.add(btnGallery);
		row2.add(btnConnect);
		row2.add(btnDonate);
		
		getContentPane().add(panel);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setActionsForButtons();
		setPicture();
	}

	public void setPicture() {
		try {
			bufferedImage = ImageIO.read(new File("/home/gowtham/Pictures/titlelogo.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(bufferedImage, 0,0,null);
	}
	
	public void setActionsForButtons() {
		btnNewsAndEvents.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				frame.dispose();
//				frame.setVisible(false);
				NewsAndEvents newAndEvents = new NewsAndEvents();
				newAndEvents.setVisible(true);
			}
			
		});
		
		btnFieldNotes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FieldNotes fieldNotes = new FieldNotes();
				fieldNotes.setVisible(true);
			}
			
		});
		
		btnAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setVisible(true);
			}
			
		});
		
		btnGallery.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Gallery gallery = new Gallery();
				gallery.setVisible(true);
			}
			
		});
		
		btnConnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Connect connect = new Connect();
				connect.setVisible(true);
			}
			
		});
		
		btnDonate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Donate donate = new Donate();
				donate.setVisible(true);
			}
			
		});
		
	}
}
