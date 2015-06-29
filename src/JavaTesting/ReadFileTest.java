package JavaTesting;

import Tutorials.ReadFile;

public class ReadFileTest {
	public static void main(String[] args) {
		try {
			ReadFile in = new ReadFile("/home/sensefields/development/workspace/git/LearningScala/resources/test.txt");
			int c;
			while ((c = in.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
