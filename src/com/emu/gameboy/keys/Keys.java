package com.emu.gameboy.keys;

import java.util.BitSet;

//buttons layout:
// 0 -> a
// 1 -> b
// 2 -> select
// 3 -> start
// 4 -> right
// 5 -> left
// 6 -> up
// 7 -> down
public class Keys {
	byte Buttons;		 
	
	void setA(boolean setBit){
		Buttons = setBit
				? (byte) (Buttons |(1))
				: (byte) (Buttons &~(1));
	}
	void setB(boolean setBit){
		Buttons = setBit
				? (byte) (Buttons |(1<<1))
				: (byte) (Buttons &~(1<<1));
	}
	void setSelect(boolean setBit){
		Buttons = setBit
				? (byte) (Buttons |(1<<2))
				: (byte) (Buttons &~(1<<2));
	}
	void setStart(boolean setBit){
		Buttons = setBit
				? (byte) (Buttons |(1<<3))
				: (byte) (Buttons &~(1<<3));
	}
	void setCruceta(int i,boolean setBit) {
		Buttons = setBit
				? (byte) (Buttons |(1<<i))
				: (byte) (Buttons &~(1<<i));
	}
	byte returnKeys() {
		return Buttons;
	}

}