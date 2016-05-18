package websiteGoesHere.Game.Room;

public class Location {
	public int x, y;
	public int width;
	public int height;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = -1;
		this.height = -1;
	}
	
	public Location(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean touching(Location loc) {
		if(this.width == -1 || this.height == -1) return false;
		
		int minXDist = (this.width/2) + (loc.width/2);
		int minYDist = (this.height) + (loc.height/2);
		if(Math.abs(this.x - loc.x) <= minXDist || Math.abs(this.y - loc.y) <= minYDist) {
			return true;
		}
		return false;
	}
	
	public Location[] getCorners() {
		if(width == -1 || height == -1) return null;
		int xClose = x-width/2;
		int xFar = x+width/2;
		int yClose = y-height/2;
		int yFar = y+height/2;
		Location[] locs = new Location[] {new Location(xClose, yClose), new Location(xFar, yClose), new Location(xClose, yFar), new Location(xFar, yFar)};
		return locs;
	}
}
