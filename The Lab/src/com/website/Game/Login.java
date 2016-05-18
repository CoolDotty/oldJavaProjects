package com.website.Game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;

import com.website.Game.Networking.Network;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Login {

	private JFrame frame;
	private JTextField name;
	private JTextField address;
	private JTextField port;

	/**
	 * Create the application.
	 */
	public Login() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 277, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(108, 50, 151, 14);
		frame.getContentPane().add(lblUsername);
		
		name = new JTextField();
		name.setBounds(23, 71, 236, 25);
		name.setToolTipText("ex: Starfighter");
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		address = new JTextField();
		address.setToolTipText("ex: 192.168.0.2");
		address.setColumns(10);
		address.setBounds(23, 128, 236, 25);
		frame.getContentPane().add(address);
		
		JLabel lblIpAddress = new JLabel("IP Address");
		lblIpAddress.setBounds(108, 107, 151, 14);
		frame.getContentPane().add(lblIpAddress);
		
		port = new JTextField();
		port.setToolTipText("ex: 8192");
		port.setColumns(10);
		port.setBounds(23, 185, 236, 25);
		frame.getContentPane().add(port);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(122, 164, 137, 14);
		frame.getContentPane().add(lblPort);
		
		JButton btnStart = new JButton("Start!");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sName = name.getText();
				String sAddress = address.getText();
				int iPort = Integer.parseInt(port.getText());
				Start(sName, sAddress, iPort);
			}
		});
		btnStart.setBounds(89, 320, 91, 23);
		frame.getContentPane().add(btnStart);
	}
	
	private void Start(String name, String address, int port) {
		Network net = new Network();
		net.openConnection(name, address, port);
		Game game = new Game(name, net);
		frame.dispose();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
