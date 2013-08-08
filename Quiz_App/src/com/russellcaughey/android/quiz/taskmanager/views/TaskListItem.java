package com.russellcaughey.android.quiz.taskmanager.views;

import com.russellcaughey.android.quiz.R;
import com.russellcaughey.android.quiz.parts.Question;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListView;

public class TaskListItem extends LinearLayout {
	
	private Question question;
	private ListView list;
	
	public TaskListItem(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		list = (ListView) findViewById(R.id.listView1);
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
		
		//list.setText(question.getQuestion());
		//list.setChecked(question.isComplete());
	}
}
