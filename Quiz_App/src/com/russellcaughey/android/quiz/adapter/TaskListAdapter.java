package com.russellcaughey.android.quiz.adapter;

import java.util.ArrayList;

import com.russellcaughey.android.quiz.R;
import com.russellcaughey.android.quiz.parts.Question;
import com.russellcaughey.android.quiz.taskmanager.views.TaskListItem;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class TaskListAdapter extends BaseAdapter {

	private ArrayList<Question> questions;
	private Context context;
	public TaskListAdapter(ArrayList<Question> questions, Context context) {
		super();
		this.questions = questions;
		this.context = context;
	}

	@Override
	public int getCount() {
		return questions.size();
	}

	@Override
	public Question getItem(int position) {
		return (null == questions) ? null : questions.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TaskListItem tli;
		if(null == convertView){
			tli = (TaskListItem)View.inflate(context, R.layout.question_list_item, null);
		} else {
			tli = (TaskListItem)convertView;
		}
		tli.setQuestion(questions.get(position));
		return tli;
	}
}
