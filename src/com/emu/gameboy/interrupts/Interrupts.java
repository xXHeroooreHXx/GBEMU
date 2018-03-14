package com.emu.gameboy.interrupts;

public class Interrupts implements com.emu.Interrupts {
	byte enable,master,flags;

	void interruptStep() {
		int option = -1;
		if(enable == master &&flags==master) {
			byte fire = (byte)(enable & flags);
			for(int i = 0;i<InterruptKind.values().length;i++)
				if(((int) (fire) & InterruptKind.values()[i].getValue()) == 1)
					option = i;
		}
	}
}
