#pragma once

class Register {
protected:
	signed int *value;

public:
	explicit Register() {

	}
	virtual ~Register() {
		delete value;
	}
	virtual void increment(signed int quantity = 1) {
		value += 1;
	}
	virtual void decrement(signed int quantity = 1) {
		increment(0 - quantity);
	}
	virtual void reset(signed int initial = 0x0) {
		*value = initial;
	}
	signed int get() {
		return *value;
	}
};

class ByteRegister : Register {
private:
	signed int value : 3;
public:
	ByteRegister() {
		value = 0x0;
	}
};