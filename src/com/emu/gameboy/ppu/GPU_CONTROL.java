package com.emu.gameboy.ppu;

public enum GPU_CONTROL {
	GPU_CONTROL_BGENABLE (1 << 0),
	GPU_CONTROL_SPRITEENABLE (1 << 1),
	GPU_CONTROL_SPRITEVDOUBLE (1 << 2),
	GPU_CONTROL_TILEMAP (1 << 3),
	GPU_CONTROL_TILESET (1 << 4),
	GPU_CONTROL_WINDOWENABLE (1 << 5),
	GPU_CONTROL_WINDOWTILEMAP (1 << 6),
	GPU_CONTROL_DISPLAYENABLE (1 << 7);
	private final byte value;

	private GPU_CONTROL(int value){
		this.value =(byte) value;
	}
	int getValue() {
		return value;
	}
}
