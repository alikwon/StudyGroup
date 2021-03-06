package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class AlgoChapter4 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		AlgoChapter4 ag = new AlgoChapter4();
		ag.practice4_2();
		sc.close();
	}

	//Q1
	//?€?΅ 4-2λ₯? ? ?Έ?κ³? IntStack?΄? ?€? λ©μ?λ₯? ?¬?©?? ?λ‘κ·Έ?¨ ??±
	private void practice4_2() {
		IntStack is = new IntStack(64);
		
		while(true) {
			System.out.println("??¬ ?°?΄?°? : "+is.size()+"/"+is.capacity());
			System.out.println("[1]?Έ? [2]? [3]?Ό?¬ [4]??? [5]?Έ?±?€?€λΈ? \n[6]?΄λ¦¬μ΄ [7]?΄μ¦μ ??° [8]?΄μ¦ν? [0]μ’λ£");
			
			int menu = sc.nextInt();
			if(menu==0) break;
			
			int x;
			switch (menu) {
			case 1:	//?Έ?¬
				System.out.println("?°?΄?°: ");
				x=sc.nextInt();
				try {
					is.push(x);
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("?€??΄ κ°??μ°Όμ΅??€");
				}
				break;
			case 2:	//?
				try {
					x=is.pop();
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("?€??΄ λΉμ΄??΄?");
				}
				break;
			case 3:	//?Ό?¬
				try {
					x=is.peek();
					System.out.println("?Ό?¬? ?°?΄?°? "+x+"???€");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("?€??΄ λΉμ΄??΄?");
				}
				break;
			case 4: //?€?
				is.dump();
				break;
			case 5:	//?Έ?±?€?€λΈ?
				try {
					System.out.println("μ°Ύμ ?«?λ₯? ?? ₯??Έ?>>>");
					int a = sc.nextInt();
					x=is.indexOf(a);
					if(x==-1) {
						System.out.println("?? ₯κ°μ΄ ?€?? ??΄?");
					}else {
						System.out.println("?? ₯κ°μ? ?€?? ["+x+"]λ²? index? ??΅??€");
					}
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("?€??΄ λΉμ΄??΄?");
				}
				break;
			case 6:
				is.clear();
				System.out.println("?€?? λͺ¨λ κ°μ΄ ?­? ??΄?");
				break;
			case 7:
				if(is.isEmpty()) System.out.println("?€??΄ λΉμ΄??΅??€");
				else System.out.println("?€??΄ λΉμ΄?μ§? ??΅??€");
				break;
			case 8:
				if(is.isFull()) System.out.println("?€??΄ κ°??μ°Όμ΅??€");
				else System.out.println("?€?? ?¬? κ³΅κ°?΄ ?¨???΄?");
			default:
				System.out.println("?λ§μ? ?­λͺ©μ ? ???Έ?");
				break;
			}
		}
	}
	
	//Q2
	//??? κ°μ²΄? ?°?΄?°λ₯? ?? ? ?? ? ?€λ¦? ?€??΄??€ Gstack<E> λ₯? ??±??Έ?
	// ???΄ >>> Gstack ?΄??€ ??Ό
	
	//Q3
	//??? λ°°μ΄? κ³΅μ ??¬ 2κ°μ ?€?? κ΅¬ν?? int? ?°?΄?°?© ?€? ?΄??€λ₯? λ§λ?Έ?
	//?€?? ???₯?? ?°?΄?°? int? κ°?, λ°°μ΄? μ²μκ³? ?? ?¬?©
	// ???΄ >>> IntStack_4_3 ?΄??€??Ό
	
}
