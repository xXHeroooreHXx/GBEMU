package com.emu.gameboycolor.mmu;
import com.emu.math.*;
public class MemoryFragment {
	byte memory[];
	Range rango;
	String name;
	public MemoryFragment(String name,int size,int min, int max){
		this.rango = new Range(min,max);
		this.name = name;
		this.memory = new byte[size];
	}
	public MemoryFragment(String name,int size,Range range){
		this.rango = range;
		this.name = name;
		this.memory = new byte[size];
	}
	public boolean isInRange(int number) {
		return rango.isInRange(number);
	}
}
