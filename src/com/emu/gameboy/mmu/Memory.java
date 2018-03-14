package com.emu.gameboy.mmu;
import com.emu.gameboy.cpu.*;
import com.emu.math.Range;

public class Memory implements com.emu.Memory{
	char ioReset[] = {
			0x0F, 0x00, 0x7C, 0xFF, 0x00, 0x00, 0x00, 0xF8, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x01,
			0x80, 0xBF, 0xF3, 0xFF, 0xBF, 0xFF, 0x3F, 0x00, 0xFF, 0xBF, 0x7F, 0xFF, 0x9F, 0xFF, 0xBF, 0xFF,
			0xFF, 0x00, 0x00, 0xBF, 0x77, 0xF3, 0xF1, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF,
			0x00, 0xFF, 0x00, 0xFF, 0x00, 0xFF, 0x00, 0xFF, 0x00, 0xFF, 0x00, 0xFF, 0x00, 0xFF, 0x00, 0xFF,
			0x91, 0x80, 0x00, 0x00, 0x00, 0x00, 0x00, 0xFC, 0x00, 0x00, 0x00, 0x00, 0xFF, 0x7E, 0xFF, 0xFE,
			0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x3E, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF,
			0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xC0, 0xFF, 0xC1, 0x00, 0xFE, 0xFF, 0xFF, 0xFF,
			0xF8, 0xFF, 0x00, 0x00, 0x00, 0x8F, 0x00, 0x00, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF,
			0xCE, 0xED, 0x66, 0x66, 0xCC, 0x0D, 0x00, 0x0B, 0x03, 0x73, 0x00, 0x83, 0x00, 0x0C, 0x00, 0x0D,
			0x00, 0x08, 0x11, 0x1F, 0x88, 0x89, 0x00, 0x0E, 0xDC, 0xCC, 0x6E, 0xE6, 0xDD, 0xDD, 0xD9, 0x99,
			0xBB, 0xBB, 0x67, 0x63, 0x6E, 0x0E, 0xEC, 0xCC, 0xDD, 0xDC, 0x99, 0x9F, 0xBB, 0xB9, 0x33, 0x3E,
			0x45, 0xEC, 0x52, 0xFA, 0x08, 0xB7, 0x07, 0x5D, 0x01, 0xFD, 0xC0, 0xFF, 0x08, 0xFC, 0x00, 0xE5,
			0x0B, 0xF8, 0xC2, 0xCE, 0xF4, 0xF9, 0x0F, 0x7F, 0x45, 0x6D, 0x3D, 0xFE, 0x46, 0x97, 0x33, 0x5E,
			0x08,0xEF, 0xF1, 0xFF, 0x86, 0x83, 0x24, 0x74, 0x12, 0xFC, 0x00, 0x9F, 0xB4, 0xB7, 0x06, 0xD5,
			0xD0, 0x7A, 0x00, 0x9E, 0x04, 0x5F, 0x41, 0x2F, 0x1D, 0x77, 0x36, 0x75, 0x81, 0xAA, 0x70, 0x3A,
			0x98, 0xD1, 0x71, 0x02, 0x4D, 0x01, 0xC1, 0xFF, 0x0D, 0x00, 0xD3, 0x05, 0xF9, 0x00, 0x0B, 0x00
		}; //ioReset code.
	static int size_cart = 0x8000;
	static int size_sram = 0x2000;
	static int size_io = 0x100;
	static int size_vram = 0x2000;
	static int size_oam = 0x100;
	static int size_wram = 0x2000;
	static int size_hram = 0x80;
	//range object, used later;
	 Range rCart = new Range(0x0000,0x7FFF);
	 Range rSram = new Range(0xA000,0xBFFF);
	 Range rIo = new Range(0xFF00,0xFF7F);
	 Range rVram = new Range(0x8000,0x9FFF);
	 Range rOam = new Range(0xFE00,0xFE9F);
	 Range rWram = new Range(0xC000,0xDFFF);
	 Range rHram = new Range(0xFF80,0xFFFE);
	 Range rEco = new Range(0xE000,0xFDFF);

	 char[] cart = new char[size_cart];
	 char[] sram = new char[size_sram];
	 char[] io = new char[size_io];
	 char[] vram = new char[size_vram];
	 char[] oam = new char[size_oam];
	 char[] wram = new char[size_wram];
	 char[] hram = new char[size_hram];
	
	Registers reg;
	
	public Memory(Registers _reg) {
		this.reg = _reg;
	}
	
	void copy(short destination,short source, int length) {
		if(length>0) {
			writeByte((short) (destination),readByte((short) (source)));
			copy(++destination,++source,--length);
		}
	}

	char readByte(short address) {
		if(rCart.isInRange(address))
			return cart[address];
		else if(rVram.isInRange(address))
			return vram[address - rVram.getMinNum()];
		else if(rSram.isInRange(address))
			return sram[address - rSram.getMinNum()];
		else if(rWram.isInRange(address))
			return wram[address - rWram.getMinNum()];
		else if(rEco.isInRange(address))
			return wram[address - rEco.getMinNum()];
		else if(rOam.isInRange(address))
			return oam[address - rOam.getMinNum()];
		else if(rIo.isInRange(address))
			return io[address - rIo.getMinNum()];
		else if(rHram.isInRange(address))
			return hram[address-rHram.getMinNum()];
					//TODO GPU ADDRESSES!
		//else if(address == 0xff40) return gpu.control;
		//else if(address == 0xff42) return gpu.scrollY;
		//else if(address == 0xff43) return gpu.scrollX;
		//else if(address == 0xff44) return gpu.scanline; // read only
		
		
	return ' ';
	}
	
	short readShort(short address) {
		return (short) (readByte(address) | (readByte((short) (address + 1)) <<8));
	}	
	short readShortFromStack() {
		short value = readShort(reg.getSP().getValue());
		reg.SP.set((short) (value + 2));
		return value;
	}

	void writeByte(short address,char value) {
		if(rCart.isInRange(address))
			 cart[address] = value;
		else if(rVram.isInRange(address))
			 vram[address - rVram.getMinNum()] = value;
		else if(rSram.isInRange(address))
			 sram[address - rSram.getMinNum()] = value;
		else if(rWram.isInRange(address))
			 wram[address - rWram.getMinNum()] = value;
		else if(rEco.isInRange(address))
			 wram[address - rEco.getMinNum()] = value;
		else if(rOam.isInRange(address))
			 oam[address - rOam.getMinNum()] = value;
		else if(rIo.isInRange(address))
			io[address - rIo.getMinNum()] = value;
		else if(rHram.isInRange(address))
			 hram[address-rHram.getMinNum()] = value;
		else if(address == 0xff46) copy((short)0xFE00, (short) (value << 8),160); // OAM DMA
		/* TODO GPU
		else if(address == 0xff40) gpu.control = value;
		else if(address == 0xff42) gpu.scrollY = value;
		else if(address == 0xff43) gpu.scrollX = value;
		
		
		else if(address == 0xff47) { // write only
			int i;
			for(i = 0; i < 4; i++) backgroundPalette[i] = palette[(value >> (i * 2)) & 3];
		}
		
		else if(address == 0xff48) { // write only
			int i;
			for(i = 0; i < 4; i++) spritePalette[0][i] = palette[(value >> (i * 2)) & 3];
		}
		
		else if(address == 0xff49) { // write only
			int i;
			for(i = 0; i < 4; i++) spritePalette[1][i] = palette[(value >> (i * 2)) & 3];
			}
	
	INTERRUPCIONES
	
	else if(address == 0xff0f) interrupt.flags = value;
	else if(address == 0xffff) interrupt.enable = value;
		*
		*/
	}
	void writeShort(short address,short value) {
		writeByte(address,(char) (value & 0x00FF));
		writeByte((short) (address + 1),(char) ((value & 0x00FF)>>8));
	}
	void writeShortToStack(short value) {
		reg.SP.set(  (short) (reg.SP.getValue()-2)	);
		writeShort(reg.SP.getValue(),value);
	}

	public Registers getReg() {
		return reg;
	}

	public void setReg(Registers reg) {
		this.reg = reg;
	}
}
