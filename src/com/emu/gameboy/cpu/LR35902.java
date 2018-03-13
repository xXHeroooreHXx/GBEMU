package com.emu.gameboy.cpu;

import com.emu.CPU;

public class LR35902 implements CPU {
	private Registers registers;
	
	public LR35902() {
		registers = new Registers();
	}

}
