package com.emu.gameboy.ppu;

import com.emu.gameboy.display.Colour;

public class PPU {
	byte control;
	byte scrollX;
	byte scrollY;
	byte scanline;
	long tick;
	Colour backgroundPalette[];
	Colour spritePalette[][];
	byte tiles[][][];
	void gpuStep() {
		
	}
	void hblank() {
		
	}
	void renderScanline() {
		
	}
	void updateTile(short address,byte value) {
		
	}
}
