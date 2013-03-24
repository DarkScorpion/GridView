package com.as.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
 
public class ImageAdapter extends BaseAdapter 
{
	final static int PADDING_COUNT = 8; //Расстояние между объектами
	private Context mContext;
	private int[] SourceArray;
	
	public ImageAdapter(Context c, int [] Arr) //Конструктор
	{
		mContext = c; 	//контекст
		SourceArray = Arr; //массив ссылок на объекты
	}
	
	public int getCount() //Возврощает количество обьектов
	{
		return SourceArray.length;
	}
	
	public Object getItem(int position) 
	{
		return null; //Должен вернуть обьект, но здесь упрощено
	}
	
	public long getItemId(int position) 
	{
		return 0; //Должен вернуть строку элемента, но тоже упрощено
	}
	
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		ImageView imageView;
		if (convertView == null) 
		{
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(PADDING_COUNT, PADDING_COUNT,
					PADDING_COUNT,PADDING_COUNT);	//Указывает отступы
		}
		else 
		{
			imageView = (ImageView) convertView;
		}
		imageView.setImageResource(SourceArray[position]);
		return imageView;
	}

}