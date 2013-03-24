package com.as.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
 
public class ImageAdapter extends BaseAdapter 
{
	final static int PADDING_COUNT = 8; //���������� ����� ���������
	private Context mContext;
	private int[] SourceArray;
	
	public ImageAdapter(Context c, int [] Arr) //�����������
	{
		mContext = c; 	//��������
		SourceArray = Arr; //������ ������ �� �������
	}
	
	public int getCount() //���������� ���������� ��������
	{
		return SourceArray.length;
	}
	
	public Object getItem(int position) 
	{
		return null; //������ ������� ������, �� ����� ��������
	}
	
	public long getItemId(int position) 
	{
		return 0; //������ ������� ������ ��������, �� ���� ��������
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
					PADDING_COUNT,PADDING_COUNT);	//��������� �������
		}
		else 
		{
			imageView = (ImageView) convertView;
		}
		imageView.setImageResource(SourceArray[position]);
		return imageView;
	}

}