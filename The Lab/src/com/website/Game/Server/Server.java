package com.website.Game.Server;

import java.io.IOException;
import java.util.Scanner;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server implements Runnable{

	private Slot[] slots;
	private int port;
	private boolean running;
	
	private DatagramSocket socket;
	private Thread run, send, receive, console;
	
	public Server(int port){
		this.port = port;
		
		slots = new Slot[10];
		for(int i = 0; i < slots.length; i++) {
			slots[i] = new Slot();
		}
			
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
		begingReceive();
		beginConsole();
	}
	
	private void beginConsole() {
		System.out.println("Ready for manual input");
		console = new Thread("Console") {
			public void run() {
				Scanner sc = new Scanner(System.in);
				while(running){
					String command = sc.next();
					//inject into process()
				}
			}
		};
		console.start();
	}
	
	private void begingReceive() {
		System.out.println("Ready to recieve packets");
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
					process(packet);
				}
			}
		};
		receive.start();
	}
	
	private void process(DatagramPacket packet) {
		String string = new String(packet.getData());
		string = string.trim();
		System.out.println("Received: " + string);
		
		if (string.startsWith("/c/login")) {
			String name = string.substring(9);
			for(int i = 0; i < slots.length; i++) {
				if(slots[i].isEmpty()) {
					slots[i] = new Player(name);
					System.out.println(name + "[" + i + "] Connected!");
					break;
				}
			}
		} else {
			System.out.println("Unknown command: " + string);
		}
	}
}
