package application;

import java.util.ArrayList;

public class DecPoint extends Token {

	@Override
	public boolean parse(ArrayList<Key> cmd) {
		/*Digit d = new Digit();
		if(!d.parse(cmd))
			return true;
		return false;*/
		if (cmd.size() == 0)
			return false;
		char ch = (cmd.get(0).ch.charAt(0));
		if (ch == '.'){
			cmd.remove(0);
			return true;
		}
		 // remove the parsed key from the cmd for the terminal
						// token
		return false;
	}

}
