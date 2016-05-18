package websitecom.script;

import websitecom.Cmd;
import websitecom.TwitchBot;

public abstract class Script {

	protected String name = "Default Script Name";
	protected String help = "";
	
	public Script() {
	}
	
	public void run(TwitchBot bot, String channel, String sender, String login, String hostname, String message) {
		
	}
	
	public String help() {
		return help;
	}
	
	public String getName() {
		return name;
	}
}
