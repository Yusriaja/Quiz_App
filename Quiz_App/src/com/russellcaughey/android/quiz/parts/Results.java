package com.russellcaughey.android.quiz.parts;

public class Results {

	public static String getResultComment(int numCorrect, int numRounds,
			int diff) {
		String comment = "";
		int percentage = calculatePercentage(numCorrect, numRounds);
		switch (diff) {

		default:
			if (percentage > 90) {
				comment = "Excellent!";
			} else if (percentage >= 80) {
				comment = "Nicely Done!";
			} else if (percentage >= 60) {
				comment = "Not bad..";
			} else if (percentage >= 40) {
				comment = "Not very good. Try Again.";
			} else {
				comment = "You have failed. Try Again.";
			}
		}
		return comment;
	}

	private static int calculatePercentage(int numCorrect, int numRounds) {
		double frac = (double) numCorrect / (double) numRounds;
		int percentage = (int) (frac * 100);
		return percentage;
	}
}
