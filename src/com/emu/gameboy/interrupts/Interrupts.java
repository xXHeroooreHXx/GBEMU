package com.emu.gameboy.interrupts;

public class Interrupts implements com.emu.Interrupts {
	public byte enable;
	byte master;
	public byte flags;

	void interruptStep() {
		int option = -1;
		if(enable == master &&flags==master) {
			byte fire = (byte)(enable & flags);
			for(int i = 0;i<InterruptKind.values().length;i++) {
				if(((int) (fire) & InterruptKind.values()[i].getValue()) == 1) {
					option = i;
					flags &= ~InterruptKind.values()[i].getValue();
				}
			}
		}
		switch (option) {
		case 0:
			vblank();
			break;
	
		case 1:
			lcdstat();
			break;
		case 2:
			timer();
			break;
		case 3:
			serial();
			break;
		case 4:
			joypad();
			break;
		}
		
		
	}
	void vblank() {
		
	}
	void lcdstat() {
		
	}
	void timer() {
		
	}
	void serial() {
		
	}
	void joypad() {
		
	}
}
