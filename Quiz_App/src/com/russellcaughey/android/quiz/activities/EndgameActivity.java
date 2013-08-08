/**
 * 
 */
package com.russellcaughey.android.quiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.russellcaughey.android.quiz.R;
import com.russellcaughey.android.quiz.parts.Constants;
import com.russellcaughey.android.quiz.parts.QuizPlay;
import com.russellcaughey.android.quiz.parts.Results;

public class EndgameActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i("QuizApp", "Created EndGameActivity");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.endgame);
		QuizPlay currentGame = ((QuizApplication) getApplication())
				.getCurrentQuiz();
		String result = "Your Score is " + currentGame.getRight() + "/"
				+ currentGame.getNumRounds() + ".. ";
		String comment = Results.getResultComment(currentGame.getRight(),
				currentGame.getNumRounds(), getDifficultySettings());

		TextView results = (TextView) findViewById(R.id.endgameResult);
		results.setText(result + comment);

		Button finishBtn = (Button) findViewById(R.id.finishBtn);
		Button answerBtn = (Button) findViewById(R.id.answerBtn);
	}

	private int getDifficultySettings() {
		SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		int diff = settings.getInt(Constants.DIFFICULTY, 2);
		return diff;
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	public void onClickAnswers(View view){
			Intent i = new Intent(this, AnswersActivity.class);
			startActivityForResult(i, Constants.PLAYBUTTON);
		}
	
	public void onClickMenu(View view) {
		finish();
		}
}


