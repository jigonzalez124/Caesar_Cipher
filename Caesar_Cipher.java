/*	Name:  Jesus Ivan Gonzalez
	Created: July 16th 2015
	Description:  Asks user to convert a phrase via Ceasar Cipher, direction of the alphabet, and # of spaces to shift.

import java.util.Arrays;		//uses Arrays utility
import java.util.Scanner;		//requires User input

public class Ceasar_Cipher {
	static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args){
		
		int numOfSpaces;
		int count = 0;
		
		System.out.print("Enter statement to code: ");	
		String mesg = userInput.nextLine();	//includes whitespace for sentences
		
		System.out.print("Shift (l)eft or (r)ight:");
		String path = userInput.next();		//asks user for left or right shift
		
		System.out.print("Number of spaces: ");
		numOfSpaces = userInput.nextInt();	//how many places to shift
		
		char[] newAlpha = shift(path, numOfSpaces).toCharArray();	//returns new alphabet
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";	//original alphabet
		char[] arrayAlphabet = alphabet.toCharArray();
		char[] arrayMesg = mesg.toCharArray();
		
		System.out.print("Org Message: " + mesg + "\n");	//for labeling purposes
		System.out.print("New Message: ");			//for labeling purposes
		for (int i = 0; i <mesg.length(); i++) {		//reads each character
			if (!Character.isWhitespace(arrayMesg[i])){	//if not whitespace
				for (int j = 0; j < alphabet.length(); j++) {	//uses orig alphabet to determne loc on ceasar alphabet
					if (arrayMesg[i] != arrayAlphabet[j]){	//increment if no match
						count += 1;
					}
					else {	
						System.out.print(newAlpha[count]);  //print proxy alphabet letter
						count = 0;	//reset search
						break;
					}
				}
			}
			else {
				System.out.print(" ");	//if whitespace, return whitespace
			}
		}
	}
	
	public static String shift(String direction, int shiftNum) {
		String ceasarAlpha =  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", trunCeasarAlpha, shiftLetter;
		System.out.println("\nOld: " + ceasarAlpha);
		
		if (direction.equals("left") || direction.equals("l")) {
			for (int i = 0; i < shiftNum; i++) {
				shiftLetter = ceasarAlpha.substring(0,1);	//grabs 1st letter of ceasar alphabet
				trunCeasarAlpha = ceasarAlpha.substring(1,52);	//grabs remaining letters
				ceasarAlpha = trunCeasarAlpha.concat(shiftLetter);	//concat previous lines of code together
			}
		}
		else if (direction.equals("right") || direction.equals("r")) {
			for (int i = 0; i < shiftNum; i++) {
				shiftLetter = ceasarAlpha.substring(51,52);  //grabs last letter of ceasar alphabet
				trunCeasarAlpha = ceasarAlpha.substring(0,51);	//grabs remainig letters
				ceasarAlpha = shiftLetter.concat(trunCeasarAlpha);	//concat previous lines of code together
			}
		}

		System.out.println("New: "+ ceasarAlpha + "\n");
		return ceasarAlpha;
	}
}