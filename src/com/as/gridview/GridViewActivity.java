package com.as.gridview;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewActivity extends Activity 
{
	GridView gvMain;
	final static int ROW_NUMBER = 8; //количество строк
	final static int COL_NUMBER = 5; //количество стобцов, нужно равное аргументу в layout
	//Массив сссылок на картинки
	private int [] fruitId = 
				{
				R.drawable.fruit00, //Нулевая фишка
				R.drawable.fruit01,
				R.drawable.fruit02,
				R.drawable.fruit03,
				R.drawable.fruit04,
				R.drawable.fruit05,
				R.drawable.fruit06,
				R.drawable.fruit07
				};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); //Убираем заголовок
		setContentView(R.layout.activity_grid_view);
		gvMain = (GridView)findViewById(R.id.gridView1);
		gvMain.setAdapter( new ImageAdapter(this, RandomFilling()) ); //генерация случайно таблицы
		gvMain.setOnItemClickListener(new OnItemClickListener() //Установка слушателя на нажатия элементов
		{
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
			{
				showMessage(GridViewActivity.this,  "" + position);
			}
		});
	}
	//Возврат массива со случаными ссылками на изображения
	public int[] RandomFilling()
	{
		Random rndNum = new Random();
		int [] A = new int [ROW_NUMBER*COL_NUMBER];
		for(int i=0;i<A.length;i++)
			A[i] = fruitId[rndNum.nextInt(fruitId.length)];
		return A;
	}
	
	void showMessage(Context ctx, String str)
	{
		Toast.makeText(ctx, str, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.grid_view, menu);
		return true;
	}

}
