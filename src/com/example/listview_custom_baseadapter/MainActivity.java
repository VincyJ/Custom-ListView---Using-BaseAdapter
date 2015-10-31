package com.example.listview_custom_baseadapter;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list=(ListView) findViewById(R.id.listView1);
		list.setAdapter(new MyAdapter(this));
	}

	class SingleRow{
		
		String company;
		String ceo;
		int images;
		
		public SingleRow(String company, String ceo, int images) {
			this.company = company;
			this.ceo = ceo;
			this.images = images;
		}
	}
	
	class MyAdapter extends BaseAdapter{

		ArrayList<SingleRow> list;
		Context context;
		
		MyAdapter(Context c) {
		// TODO Auto-generated constructor stub
			this.context=c;
		list=new ArrayList<SingleRow>();
		
		Resources res=getResources();
		String[] company1=res.getStringArray(R.array.company);
		String[] ceo1=res.getStringArray(R.array.ceos);
		int[] images={R.drawable.microsoft,R.drawable.google,R.drawable.yahoo,R.drawable.intel,R.drawable.apple,R.drawable.hp,R.drawable.sony};
		for (int i = 0; i < 7; i++) {
			list.add(new SingleRow(company1[i],ceo1[i],images[i]));
		}
	}	
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return list.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int i, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row=inflater.inflate(R.layout.single_row, arg2, false);
			
			TextView company=(TextView) row.findViewById(R.id.textView1);
			TextView coe=(TextView) row.findViewById(R.id.textView2);
			ImageView image=(ImageView) row.findViewById(R.id.imageView1);
			
			SingleRow temp=list.get(i);
			
			company.setText(temp.company);
			coe.setText(temp.ceo);
			image.setImageResource(temp.images);
			
			return row;
		}
		
	}
	
}
