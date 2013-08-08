/**
 * 
 */
package com.russellcaughey.android.quiz.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.russellcaughey.android.quiz.R;
import com.russellcaughey.android.quiz.parts.QuizPlay;
import com.russellcaughey.android.quiz.util.Utility;

public class AnswersActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.answers);
		QuizPlay currentGame = ((QuizApplication)getApplication()).getCurrentQuiz();
		TextView results = (TextView)findViewById(R.id.answers);
		String answers = Utility.getAnswers(currentGame.getQuestions());
		results.setText(answers);
		Button finishBtn = (Button) findViewById(R.id.finishBtn);
	}
	
	public void onClickBack(View view) {
			finish();
		}
}
