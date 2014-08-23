package com.renatoalmeida.ingressstats.shareactivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import com.renatoalmeida.ingressstats.R;
import com.renatoalmeida.ingressstats.R.id;
import com.renatoalmeida.ingressstats.R.layout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ShareActivityAdapter extends BaseAdapter{
	
	private static final int TYPE_HEADER = 0;
	private static final int TYPE_ITEM = 1;
 
	private List<Item> mData = new ArrayList<Item>();

	private LayoutInflater mInflater;
 
	public ShareActivityAdapter(Context context, HashMap<String, Integer> stats) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		Resources res = context.getResources();
		String[] sections = res.getStringArray(R.array.group_name_list);
		String[] statList = res.getStringArray(R.array.stats);
		TypedArray sectionItems = res.obtainTypedArray(R.array.group_list);

		for(int i=0; i<sections.length; i++){
			String header = sections[i];
			mData.add(new SectionItem(header));
			
			int[] interval = res.getIntArray(sectionItems.getResourceId(i, -1));
			
			for(int j=interval[0]; j<= interval[1]; j++){
				mData.add(new StatItem(statList[j], stats.get(statList[j])));
			}
			
		}
		sectionItems.recycle();
	}
 
	@Override
	public int getItemViewType(int position) {
		return ((Item)getItem(position)).isSection() ? TYPE_HEADER : TYPE_ITEM;
	}
 
	@Override
	public int getViewTypeCount() {
		return 2;
	}
 
	@Override
	public int getCount() {
		return mData.size();
	}
 
	@Override
	public Item getItem(int position) {
		return mData.get(position);
	}
 
	@Override
	public long getItemId(int position) {
		return position;
	}
 
	public View getView(int position, View convertView, ViewGroup parent) {
		
		int rowType = getItemViewType(position);
		
		
		switch (rowType) {
			case TYPE_HEADER:
				SectionItem hItem = (SectionItem)getItem(position);
				
				if (convertView == null) 
					convertView = mInflater.inflate(R.layout.activity_share_list_section, null);
				
				TextView tv = (TextView)convertView.findViewById(R.id.activity_share_list_section_text);
				tv.setText(hItem.getTitle());
				
				break;
			case TYPE_ITEM:
				StatItem sItem = (StatItem)getItem(position);
				
				if (convertView == null)
					convertView = mInflater.inflate(R.layout.activity_share_list_item, null);

				TextView nameTv = (TextView)convertView.findViewById(R.id.activity_share_list_item_text);
				TextView valueTv = (TextView)convertView.findViewById(R.id.activity_share_list_item_value);

				nameTv.setText(sItem.getStat());
				valueTv.setText(sItem.getValue()+"");
				
				break;
		}

		return convertView;
	}
}
