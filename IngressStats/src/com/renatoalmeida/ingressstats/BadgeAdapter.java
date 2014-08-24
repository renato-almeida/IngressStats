package com.renatoalmeida.ingressstats;

import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.renatoalmeida.ingressstats.badges.BadgeList;
import com.renatoalmeida.ingressstats.badges.BadgeRequirement;
import com.renatoalmeida.ingressstats.badges.IBadge;

public class BadgeAdapter extends ArrayAdapter<String>{

	private List<String> statsWithBadge;
	private HashMap<String, Long> values;
	
	public BadgeAdapter(Context context, List<String> statsWithBadge, HashMap<String, Long> values) {
		super(context, R.layout.activity_main_badge_item, statsWithBadge);
		
		this.statsWithBadge = statsWithBadge;
		this.values = values;
	}
	
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)this.getContext()).getLayoutInflater();
            row = inflater.inflate(R.layout.activity_main_badge_item, parent, false);
        }
        
        ImageView badge = (ImageView) row.findViewById(R.id.badge);
        TextView value = (TextView) row.findViewById(R.id.value);
        ImageView badgeNext = (ImageView) row.findViewById(R.id.badgeNext);
        
        
        String stat = statsWithBadge.get(position);
        BadgeRequirement br, nextBR;
		IBadge badgeObject;
        
        long badgeValue = values.get(stat);
        badgeObject = BadgeList.List.get(stat);
        br = badgeObject.getBadge(badgeValue);
        nextBR = badgeObject.getNextBadgeRequirement(br);
       
        if(br != null){ //Locked badge
	        badge.setImageResource(br.getImageResource());
	        value.setText(badgeValue+"");
        }
        if(nextBR != null){
        	String x = String.format("%d / %d \n %.1f%%", badgeValue, nextBR.getValue(), 1.0*badgeValue/nextBR.getValue()*100);
        	value.setText(x);
        	badgeNext.setImageResource(nextBR.getImageResource());
        }
        
        return row;
    }
	
}
