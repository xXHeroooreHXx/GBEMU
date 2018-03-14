package com.emu.gameboy.display;

public class Colour {
	byte r,g,b;
	public Colour(){
		this.r = 0;
		this.g = 0;
		this.b = 0;
	}
	public Colour(int r, int g, int b){
		this.r =(byte) r;
		this.g =(byte) g;
		this.b =(byte) b;
	}
}
