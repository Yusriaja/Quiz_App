 
package com.russellcaughey.android.quiz.activities;

import com.russellcaughey.android.quiz.parts.QuizPlay;

import android.app.Application;

public class QuizApplication extends Application{
	private QuizPlay currentQuiz;

	public void setCurrentQuiz(QuizPlay currentQuiz) {
		this.currentQuiz = currentQuiz;
	}
	
	public QuizPlay getCurrentQuiz() {
		return currentQuiz;
	}
}
