package com.emu.gameboy.ppu;

public enum GPU_MODE {
	GPU_MODE_HBLANK (0),
	GPU_MODE_VBLANK (1),
	GPU_MODE_OAM (2),
	GPU_MODE_VRAM (3);
	int value;
	GPU_MODE(int value){
		this.value = value;
	}
	int getValue() {
		return this.value;
	}
}
