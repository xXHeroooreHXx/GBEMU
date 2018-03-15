package com.emu.gameboy.ppu;

import com.emu.gameboy.display.Colour;

public class PPU {
	byte control;
	byte scrollX;
	byte scrollY;
	byte scanline;
	long tick;
	int lastTick = 0;
	Colour backgroundPalette[];
	Colour spritePalette[][];
	byte tiles[][][];
	void gpuStep() {
		int gpuMode = GPU_MODE.GPU_MODE_HBLANK.getValue();
		switch(gpuMode) {
		
		}
	}
	void hblank() {
		
	}
	void renderScanline() {
		
	}
	void updateTile(short address,byte value) {
		
	}
}
