package com.russellcaughey.android.quiz.activities;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.russellcaughey.android.quiz.R;
import com.russellcaughey.android.quiz.db.DBHelper;
import com.russellcaughey.android.quiz.parts.Constants;
import com.russellcaughey.android.quiz.parts.QuizPlay;
import com.russellcaughey.android.quiz.parts.Question;

public class StartActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
	}

	public void onClickStartQuiz(View view) {
		Intent i;
		// Get Question set
		List<Question> questions = getQuestionSetFromDb();
		QuizPlay quiz = new QuizPlay();
		quiz.setQuestions(questions);
		quiz.setNumRounds(getNumQuestions());
		((QuizApplication) getApplication()).setCurrentQuiz(quiz);
		i = new Intent(this, QuestionActivity.class);
		startActivity(i);
	}

	public void onClickExit(View view) {
		finish();
	}

	private List<Question> getQuestionSetFromDb() throws Error {
		int numQuestions = getNumQuestions();
		DBHelper myDbHelper = new DBHelper(this);
		try {
			myDbHelper.createDataBase();
		} catch (IOException ioe) {
			throw new Error("Unable to create database");
		}
		try {
			myDbHelper.openDataBase();
		} catch (SQLException sqle) {
			throw sqle;
		}
		List<Question> questions = myDbHelper
				.getQuestionSet(numQuestions);
		myDbHelper.close();
		return questions;
	}


	private int getNumQuestions() {

		return 10;
	}
}