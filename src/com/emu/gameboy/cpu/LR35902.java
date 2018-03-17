package com.emu.gameboy.cpu;
import com.emu.gameboy.mmu.*;
import com.emu.gameboy.interrupts.*;
//import com.emu.gameboy.keys.*;
import com.emu.CPU;

public class LR35902 implements CPU {
	private Registers registers,rsv;
	Memory mmu,mms;
	int ticks;
	int stopped; 
	public LR35902() {
		rsv = registers;
		registers = new Registers();
		Interrupts interrupts = new Interrupts();
		mms = mmu;
		mmu = new Memory(registers,interrupts);
	}
	
	void resetCPU(){
		ticks = 0;
		stopped = 0;
		registers = new Registers();
		Interrupts interrupts = new Interrupts();
		mmu = new Memory(registers,interrupts);
	}
	void runCPU() {
		
	}
	
}
