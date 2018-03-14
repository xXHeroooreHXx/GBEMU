package com.emu.gameboy.interrupts;

enum InterruptKind {

		INTERRUPTS_VBLANK (1 << 0),
		INTERRUPTS_LCDSTAT(1<<1),
		INTERRUPTS_TIMER (1<<2),
		INTERRUPTS_SERIAL (1 << 3),
		INTERRUPTS_JOYPAD (1 << 4);
	private final int value;
	InterruptKind(int value){
		this.value = value;
	}
	int getValue() {
		return value & 0xF;
	}
}
