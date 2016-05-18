package com.website.chat.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Server implements Runnable{
	
	private List<ServerClient> clients = new ArrayList<ServerClient>();
	
	private DatagramSocket socket;
	private int port;
	private Thread run, manage, send, receive;
	private boolean running;
	
	public Server(int port) {
		this.port = port;
		try {
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		run = new Thread(this, "Server");
		run.start();
	}

	public void run() {
		running = true;
		System.out.println("Server created @" + port);
		manageClients();
		receive();
	}

	private void manageClients() {
		manage = new Thread("Manage") {
			public void run() {
				while(running){
					
				}
			}
		};
		manage.start();
	}

	private void receive() {
		receive = new Thread("Receive") {
			public void run() {
				while(running){
					byte[] data = new byte[1024];
					DatagramPacket packet = new DatagramPacket(data, data.length);
					try {
						socket.receive(packet);
					} catch (IOException e) {
						e.printStackTrace();
					}
					String string = new String(packet.getData());
					process(packet);
					clients.add(new ServerClient("Karl", packet.getAddress(), packet.getPort(), 50));
					System.out.println(clients.get(0).address.toString() + ":" + clients.get(0).port);
				}
			}
		};
		receive.start();
	}
	
	private void process(DatagramPacket packet) {
		String string = new String(packet.getData());
		if (string.startsWith("/c/")) {
			UUID id = UUID.randomUUID();
			clients.add(new ServerClient(string.substring(3, string.length()), packet.getAddress(), packet.getPort(), 50));
		} else {
			System.out.println(string);
		}
	}
}
