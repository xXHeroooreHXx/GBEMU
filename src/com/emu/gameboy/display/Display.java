package com.emu.gameboy.display;

public class Display {
	Colour framebuffer[] = new Colour[160*144]; //Creamos la pantalla de 160 * 144 pixeles
	Colour palette[] = {
			new Colour(255,255,255), //Paleta de escala de grises
			new Colour(192,192,192),
			new Colour(96,96,96),
			new Colour(0,0,0)
	};
	void renderScanLine() {
		
	}
	void drawFrameBuffer() {
		
	}
}
