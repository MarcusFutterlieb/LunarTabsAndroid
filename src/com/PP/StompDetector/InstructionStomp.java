package com.PP.StompDetector;

import com.PP.LunarTabsAndroid.Activities.MainActivity;
import com.PP.LunarTabsAndroid.UI.DataModel;

public class InstructionStomp implements StompListener  {
	
	/**
	 * Main Activity
	 */
	protected MainActivity mainActivity;
	
	/**
	 * Constructor
	 * @param parent
	 */
	public InstructionStomp(MainActivity parent) {
		mainActivity =  parent;
	}

	@Override
	public void trigger_callback(double ts) {
		
		//emulate click on button (only if tab file loaded and we have stuff to click on)
		DataModel dataModel = DataModel.getInstance();
		if(dataModel.getSong()!=null &&
				dataModel.getCurrentSegment()>=0 &&
				dataModel.getTrackNum()>=0 && 
				dataModel.getInstSegments()!=null &&
				dataModel.getInstSegments().size()>0 &&
				dataModel.getCurrentSegment()>=0) {
					
					//emulate click on next instruction button
					mainActivity.getDownButton().performClick();
		}
		
		/*
		mainActivity.getDownButton().callOnClick();
		DataModel dataModel = DataModel.getInstance();
		if(dataModel.getSong()!=null && dataModel.getTrackNum() >=0 && dataModel.getCurrentSegment()>=0) {
			
			//next instruction
			mainActivity.nextInstruction();			
		}
		*/
	}

	/**
	 * @return the mainActivity
	 */
	public MainActivity getMainActivity() {
		return mainActivity;
	}

	/**
	 * @param mainActivity the mainActivity to set
	 */
	public void setMainActivity(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}	
}
