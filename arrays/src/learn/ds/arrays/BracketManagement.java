package learn.ds.arrays;

import java.util.Stack;

/**
 * Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

For example, given the string "([])[]({})", you should return true.

Given the string "([)]" or "((()", you should return false.
 * @author manoj
 *
 */
public class BracketManagement {

	public static void main(String[] args) {

		String brackets = "([])[]({})";
		System.out.println(bracketManagements(brackets.toCharArray()));
	}

	public static boolean bracketManagements(char[] brackets) {
		Stack<Character> stack = new Stack<>();
		for(int i =0; i< brackets.length; i++) {
			switch (brackets[i]) {
			case '(': 
			case '[': 
			case '{': stack.push(brackets[i]);break;
			case ')': 
			case ']': 
			case '}': if(!stack.isEmpty()) {
				        stack.pop();
						break;
					}
			        return false;
			}
				
		}
			
		return stack.isEmpty();
	}
}
