package websitecom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lotto {

	private Scanner input;
	private PrintWriter output;

	public void run() {
		File source = new File("lotto.txt");
		File dest = new File("output.txt");

		// ArrayList<Arrays> list = new ArrayList<Arrays>();

		try {
			input = new Scanner(source);
			output = new PrintWriter(dest);

			println("Lotto Maximiser by Karl Phillips");
			println("---");
			
			int count = 1;
			while (input.hasNext()) {
				String line = input.nextLine();
				String lottoSix = line.substring(11, line.lastIndexOf(","));
				String date = line.substring(0, 10);
				int bonus = Integer.parseInt(line.substring(line.lastIndexOf(",") + 1));

				try {
					int[] arraySix = lottoToArray(lottoSix, 6);

					for (int i = 0; i < arraySix.length; i++) {
						addToCount(arraySix[i]);
						resetAge(arraySix[i]);
					}
					incrementAge();

				} catch (Exception e) {
					e.printStackTrace();
					println("Line " + count + " is invalid!");
				}
				count++;
			}

			// Print out Singles Array
			println("Number of times single integers have won: [Int]([Win Count])[Last drawn x drawings ago]");
			for (int i = 1; i < single.length-1; i++) {
				if (single[i] == 0)
					continue;
				String output = i + "(" + single[i] + ")(" + age[i] + "), ";
				if(i % 10 == 0){
					println(output);
				} else {
					print(output);
				}
			}
			println(49 + "(" + single[49] + ")(" + age[49] + ")");
			// end

			input.close();
			output.close();
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error. File not Found.");
		}
	}

	private int[] lottoToArray(String s, int length) throws Exception {

		int[] array = new int[length];

		s += ",";
		int count = 0;
		while (s.indexOf(",") != -1) {
			String integer = s.substring(0, s.indexOf(","));
			array[count] = Integer.parseInt(integer);
			s = s.substring(s.indexOf(",") + 1);
			count++;
		}

		return array;
	}

	private int[] age = new int[50];
	
	private void incrementAge() {
		for(int i = 0; i < age.length; i++) {
			age[i]++;
		}
	}
	
	private void resetAge(int x) {
		age[x] = 0;
	}
	
	private int[] single = new int[50];

	private void addToCount(int i) {
		single[i] = single[i] + 1;
	}

	private void print(String s) {
		output.print(s);
		System.out.print(s);
	}
	
	private void println(String s) {
		output.println(s);
		System.out.println(s);
	}

	public static void main(String[] args) {
		Lotto l = new Lotto();
		l.run();
	}

}