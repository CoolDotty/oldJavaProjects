package websitecom;

import org.jibble.pircbot.PircBot;

public class TwitchBot extends PircBot {
	public TwitchBot(String user) {
		this.setName(user);
	}

	private final String key = "YoGurl!";

	public void onMessage(String channel, String sender, String login,
			String hostname, String message) {
		if (!message.toLowerCase().startsWith(key.toLowerCase())) return;
		
		sendMessage(channel, sender + " I'm here!");
	}
}

/*
 * if (in.equals(key + "time")) { String time = new java.util.Date().toString();
 * sendMessage(channel, sender + ": The time is now " + time); } else if
 * (in.equals(key + "clear")) { sendMessage(channel, Cmd.clear); } else if
 * (in.equals(key + "irc")) { sendMessage(channel, getServer() + ":" + getPort()
 * + " #" + "karlthecool"); } else if (in.equals(key + "help")) {
 * sendMessage(channel, "Help: " + key + "time, " + key + "clear, " + key +
 * "irc");
 */