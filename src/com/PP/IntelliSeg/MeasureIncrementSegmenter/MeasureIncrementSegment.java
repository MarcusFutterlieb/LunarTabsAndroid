package com.PP.IntelliSeg.MeasureIncrementSegmenter;

import android.preference.PreferenceManager;

import com.PP.APIs.FileOpAPI;
import com.PP.APIs.PlaybackEngineAPI;
import com.PP.IntelliSeg.Abstract.Segment;
import com.PP.LunarTabsAndroid.UI.DataModel;

public class MeasureIncrementSegment extends Segment {

	/**
	 * Ctr
	 * @param start
	 * @param end
	 */
	public MeasureIncrementSegment(int start, int end) {
		super(start, end);
	}

	@Override
	public void play() {
		DataModel dataModel = DataModel.getInstance();
        String tempo_str = PreferenceManager.getDefaultSharedPreferences(dataModel.getMainActivity().getApplicationContext())
        		.getString("playback_speed_pref", "1.00");
        double tempoScale = Double.parseDouble(tempo_str);
        if(dataModel.getPlaybackTrackInds()!=null) {
        	PlaybackEngineAPI.playClip_multiTrack(dataModel.getSong(), FileOpAPI.SAVE_PATH, getStart(),getEnd(),dataModel.getPlaybackTrackInds(), tempoScale);		
        }
        else {
        	PlaybackEngineAPI.playClip(dataModel.getSong(), FileOpAPI.SAVE_PATH, getStart(),getEnd(),dataModel.getTrackNum(), tempoScale);		
        }
	}

	@Override
	public String getTitlePresentation() {
		return "(M" + (getStart()+1) + "-" + "M" + (getEnd()+1) + ")";
	}
}
