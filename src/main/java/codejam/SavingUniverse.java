package codejam;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
* @date	Apr 13, 2018 12:19:10 PM
* @author Darpan Shah
*/
/*
Problem:
=======
Saving The Universe Again
https://codejam.withgoogle.com/2018/challenges/00000000000000cb/dashboard
Code Jam Qualification Round 2018
*/
public class SavingUniverse {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int t = 1;
		while (T > 0) {
			int D = scanner.nextInt();
			String input = scanner.next();
			Action[] program = convertToAction(input);
			int hacks = findMinHacks(program, D, Action.totalDamage);
			String tc = "Case #" + (t++) + ": ";
			if(hacks==-1){
				System.out.println(tc + "IMPOSSIBLE");
			} else{
				System.out.println(tc + hacks);
			}
			scanner.nextLine();
			Action.reset();
			--T;
		}
		scanner.close();
	}
	public static Stack<Action> buildStack(Action[] input){
		Stack<Action> stack = new Stack<Action>();
		for(Action ac: input){
			stack.push(ac);
		}
		while(stack.peek().code=='C')
			stack.pop();
		return stack;
	}
	public static int findMinHacks(Action[] program, int D, int totalDamage){
		if(totalDamage <= D){
			return 0;
		}
		int minHacks = 0;
		int needZero = totalDamage - D;
		Stack<Action> stack = buildStack(program);
		Stack<Action> buff = new Stack<Action>();
		while(!stack.isEmpty() && needZero > 0){
			char code = stack.peek().code;
			switch(code){
				case 'S':
					buff.push(stack.pop());
					break;
				case 'C':
					int size = buff.size();
					minHacks += size;
					stack.pop();
					while(!buff.isEmpty() && needZero>0){
						int before = buff.peek().power;
						buff.peek().power /= 2;
						int after = buff.peek().power;
						needZero -= (before - after);
						stack.push(buff.pop());
					}
					if(!buff.isEmpty()){
						return minHacks;
					}
			}
		}
		return needZero > 0?-1:minHacks;
	}
	public static Action[] convertToAction(String input){
		Action[] program = new Action[input.length()];
		int currentBeamCharge = 1;
		int i=0;
		for(char ch: input.toCharArray()){
			Action code = null;
			switch(ch){
				case 'C':
					currentBeamCharge *= 2;
					code = new Action(ch, currentBeamCharge);
					break;
				case 'S':
					code = new Action(ch, currentBeamCharge);
					break;
			}
			program[i++] = code;
			
		}
		return program;
	}
}
class Action {
	char code;
	int power;
	static int totalDamage = 0;
	
	public Action(char code, int power){
		this.code = code;
		this.power = power;
		updateDamage();
	}
	void updateDamage(){
		if(this.code=='S') {
			totalDamage += this.power;
		}
	}
	public static void reset(){
		totalDamage = 0;
	}
	
	@Override
	public String toString() {
		return code + "" + power;
	}
	
}
