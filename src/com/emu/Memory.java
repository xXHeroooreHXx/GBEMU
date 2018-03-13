package com.emu;

public interface Memory {

	//extern const;
	//Diferentes tipos de memoria
	char[] ioReset;
	char[] cart;
	char[] sram;
	char[] io;
	char[] vram;
	char[] oam;
	char[] wram;
	char[] hram;
		

	Memory(int iioReset,int icart,int isram, int iio, int ivram, int ioam, int iwram, int ihram){
		this.ioReset =new char[iioReset];
		this.cart =new char[icart];
		this.sram =new char[isram];
		this.io =new char[iio];
		this.vram =new char[ivram];
		this.oam =new char[ioam];
		this.wram =new char[iwram];
		this.hram = new char[ihram];
		
	}
	
	void copy(short destination,short source, size_t length);

	char readByte(short address);
	short readShort(short address);
	short readShortFromStack();

	void writeByte(short address,char value);
	void writeShort(short address,short value);
	void writeShortToStack(short value);
	
}
