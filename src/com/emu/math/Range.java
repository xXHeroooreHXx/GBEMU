package com.emu.math;

public class Range {
	int minNum;
	int maxNum;
	Range(int x, int y){
		this.minNum = x;
		this.maxNum = y;
	}
	boolean isInRange(int number){
		if((this.minNum<=number)&&(number<=this.maxNum)){
			return true;
		}
		return false;
	}
	public int getMinNum() {
		return minNum;
	}
	public void setMinNum(int minNum) {
		this.minNum = minNum;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	
}

