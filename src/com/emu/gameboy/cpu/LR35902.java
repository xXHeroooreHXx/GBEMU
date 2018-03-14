package com.emu.gameboy.cpu;
import com.emu.gameboy.mmu.*;
import com.emu.gameboy.interrupts.*;
import com.emu.gameboy.keys.*;
import com.emu.CPU;

public class LR35902 implements CPU {
	private Registers registers,rsv;
	Memory mmu;
	int t,m; //Time clocks
	public LR35902() {
		registers = new Registers();
		mmu = new Memory(registers);
	}
	
	void resetCPU(){
		t = 0;
		m = 0;
		registers = new Registers();
		mmu = new Memory(registers);
	}
	

}
