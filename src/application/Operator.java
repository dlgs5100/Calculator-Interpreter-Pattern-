package application;

import java.util.ArrayList;

public class Operator extends Token {
	final int ADD = 1;
	final int SUB = 2;
	final int MUL = 3;
	final int DIV = 4;
	final int NEG = 0;
	String validSym;
	int opcode;

	public Operator(String ops) {
		validSym = ops;
	}

	public double eval(double o1, double o2) {
		double r = 0;
		switch (opcode) {
		case ADD:
			r = o1 + o2;
			break;
		case SUB:
			r = o1 - o2;
			break;
		case MUL:
			r = o1 * o2;
			break;
		case DIV:
			return o1 / o2;
		}
		return r;
	}

	@Override
	public boolean parse(ArrayList<Key> cmd) {
		// TODO Auto-generated method stub
		String ops;
		if (cmd.size() > 0)
			ops = cmd.get(0).ch;
		else
			return false;
		if (validSym.indexOf(ops) < 0) // check if the incoming token is an
			return false;   			// expected operator
			
		if (ops.equals("+")) {
			opcode = ADD;
			cmd.remove(0); // remove the parsed key from the cmd for the
							// terminal token
		} else if (ops.equals("-")) {
			opcode = SUB;
			cmd.remove(0); // remove the parsed key from the cmd for the
							// terminal token
		} else if (ops.equals("กั")) {
			opcode = MUL;
			cmd.remove(0); // remove the parsed key from the cmd for the
							// terminal token
		} else if (ops.equals("กา")) {
			opcode = DIV;
			cmd.remove(0); // remove the parsed key from the cmd for the
							// terminal token
		} else {
			return false;
		}
		return true;
	}

}