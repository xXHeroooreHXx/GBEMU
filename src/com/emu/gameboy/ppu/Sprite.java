package com.emu.gameboy.ppu;

import java.util.BitSet;
// options:
//1 priority
//2 vFlip
//3 hFlip
//4 palette

public class Sprite {
		byte y;
		byte x;
		byte tile;
		BitSet options = new BitSet(4);

}
