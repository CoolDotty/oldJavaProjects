package websitecom.script;

import websitecom.TwitchBot;

public class Poll extends Script {

	private int state;
	private final int idle = 0;
	private final int polling = 1;

	private int[] tally;

	public Poll() {
		state = idle;
		super.name = "Poll";
		super.help = "[Q] [R1] [R2] .. etc";
	}

	public void run(TwitchBot bot, String channel, String sender, String login,
			String hostname, String message) {
		switch (state) {
		case idle:
			
			break;
		case polling:
			
			break;
		}
	}

}
