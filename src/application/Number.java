package application;

import java.util.ArrayList;

public class Number extends Token {
	@Override
	public boolean parse(ArrayList<Key> cmd) {
		Digit d = new Digit();
		DecPoint dp = new DecPoint();
		if (!d.parse(cmd)) // parse as a digit
			return false;
		else {
			value = d.value; // convert the parsed digit as a number value
			while (d.parse(cmd)) { // continue parsing the remaining digits
				value = value * 10 + d.value; // convert the parsed digits as a
												// number value
			}
		}
		if (!dp.parse(cmd)) { // parse as a decimal point
			return true;
		}
		
		double base = 0.1; // parse the digits after the decimal point
		if (d.parse(cmd)) {
			value += d.value * base; // convert to a decimal value
			base /= 10;
			while (d.parse(cmd)) { // parse the remaining digits
				value += d.value * base; // convert to a decimal value
				base /= 10;
			}
		}
		return true;
	}
}