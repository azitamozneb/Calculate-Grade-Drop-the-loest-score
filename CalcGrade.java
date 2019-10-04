/**
		 This program gets a set of test scores and uses
		 the Grader class to calculate the average with 
		 the lowest score dropped. 
		 */
		
import javax.swing.JOptionPane;
public class CalcAverage {

	public static void main(String[] args) {
		int numScore;
		String input;
		input=JOptionPane.showInputDialog("How many test scaore do you have? ");
		numScore = Integer.parseInt(input);
		double[] scores = new double[numScore];
		//Get the test score and store them in score array.
		for(int i=0;i <scores.length;i++)
		{
			input=JOptionPane.showInputDialog("Enter score #"+(i+1)+": ");
			scores[i]= Double.parseDouble(input);
		}
		//Create a Grader object
		Grader myGrader = new Grader(scores);
		JOptionPane.showMessageDialog(null, "The adjusted average is "+myGrader.getAverage());
		JOptionPane.showMessageDialog(null, "The lowest test score was "+myGrader.getLowestScore());
	}

}
import javax.swing.JOptionPane;

public class Grader {
	private double[] grade;
	public Grader(double[] grade )
	{
		
			this.grade= grade;
	}
	public double getAverage() {
		double average=0.0,lowest,total=0;
		if (grade.length<2) {
			JOptionPane.showMessageDialog(null, "Error: you must have at least two tst score!");
			average = 0;
		}
		for(double score : grade)
			total += score;
		lowest=getLowestScore();
		total -=lowest;
		average = (total/ (grade.length -  1));
		
		return average;
	}
	public double getLowestScore() {
		double lowest;
		lowest=grade[0];
		for(int i=1;i<grade.length;i++)
			if(grade[0]>grade[i])
				lowest=grade[i];
		return lowest;
	}
}
