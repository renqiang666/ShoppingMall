package com.hotelsystem.bean;
/**
 * 
 * @author Administrator
 *
 */
public class MenmbersBean {

	private String mId;
	private String mName;
	private double mConsume;
	public LevelDiscountBean lb;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public double getmConsume() {
		return mConsume;
	}

	public void setmConsume(double mConsume) {
		this.mConsume = mConsume;
	}

	public LevelDiscountBean getLb() {
		return lb;
	}

	public void setLb(LevelDiscountBean lb) {
		this.lb = lb;
	}

	@Override
	public String toString() {
		return "MenmbersBean [mId=" + mId + ", mName=" + mName + ", mConsume=" + mConsume + ", lb=" + lb + "]";
	}
	
}
