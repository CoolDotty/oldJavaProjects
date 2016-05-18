package com.website.Game.Networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Network {

	private InetAddress ip;
	private int port;
	
	private Thread send;
	private DatagramSocket socket;
	
	public Network() {
	}
	
	public void send(String msg) {
		if ("".equals(msg)) return;
		System.out.println("OUT:" + msg);
		final byte[] data = msg.getBytes();
		send = new Thread("Send") {
			public void run() {
				DatagramPacket packet = new DatagramPacket(data, data.length, ip, port);
				try {
					socket.send(packet);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		send.start();
	}
	
	public boolean openConnection(String name, String serverIp, int port) {
		this.port = port;
		try {
			socket = new DatagramSocket();
			ip = InetAddress.getByName(serverIp);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		send("/c/login " + name);
		return true;
	}
	
	private String recieve() {
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		try {
			socket.receive(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String message = new String(packet.getData());
		return message;
	}
}
