package websitecom;

public class Set {
	
	private int[] numbers;
	
	public Set(int[] numbers) {
		this.numbers = numbers;
	}
	
	public int size() {
		return numbers.length-1;
	}
	
	public boolean equals(Set other) {
		if(other.size() != this.size()) return false;
		
		for(int i = 0; i < numbers.length; i++){
			
		}
		return true;
	}

}
