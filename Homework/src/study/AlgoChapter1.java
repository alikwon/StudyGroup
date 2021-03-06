package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AlgoChapter1 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		AlgoChapter1 ag = new AlgoChapter1();
		ag.printSpira();
		sc.close();
	}

	void calcMaxOrMin() {
		System.out.println("1λ²μ§Έ ?«? ?? ₯ : ");
		int a = sc.nextInt();
		System.out.println("2λ²μ§Έ ?«? ?? ₯ : ");
		int b = sc.nextInt();
		System.out.println("3λ²μ§Έ ?«? ?? ₯ : ");
		int c = sc.nextInt();
		System.out.println("4λ²μ§Έ ?«? ?? ₯ : ");
		int d = sc.nextInt();
		System.out.println("[1]μ΅λ?κ°κ΅¬?κΈ?\t[2]μ΅μκ°κ΅¬?κΈ?>>>");
		int choice = sc.nextInt();
		if (choice == 1) {
			int result = max4(a, b, c, d);
			System.out.println("μ΅λ?κ°μ? " + result + "???€.");
		} else if (choice == 2) {
			int result = min4(a, b, c, d);
			System.out.println("μ΅μκ°μ? " + result + "???€.");
		} else {
			System.out.println("?λͺ»λ ?? ₯");
		}
	}

	void calcMin() {
		System.out.println("1λ²μ§Έ ?«? ?? ₯ : ");
		int a = sc.nextInt();
		System.out.println("2λ²μ§Έ ?«? ?? ₯ : ");
		int b = sc.nextInt();
		System.out.println("3μ²«λ²μ§? ?«? ?? ₯ : ");
		int c = sc.nextInt();

		int result = min3(a, b, c);
		System.out.println("μ΅μκ°μ? " + result + "???€");

	}

	// 4κ°? κ°μ€ μ΅λ?κ°?
	int max4(int a, int b, int c, int d) {
		int[] numList = { a, b, c, d };
		Arrays.sort(numList);
		return numList[numList.length - 1];
	}

	// 4κ°? κ°μ€ μ΅μκ°?
	int min4(int a, int b, int c, int d) {
		int[] numList = { a, b, c, d };
		Arrays.sort(numList);
		return numList[0];
	}

	// 3κ°? κ°μ€ μ΅μκ°?
	int min3(int a, int b, int c) {
		int[] numList = { a, b, c };
		int min = numList[0];
		for (int i = 1; i < numList.length; i++) {
			if (min > numList[i]) {
				min = numList[i];
			}
		}
		return min;
	}

	// Q6
	void sumWhile() {
		System.out.println("1λΆ??° nκΉμ?? ?©? κ΅¬ν©??€");
		System.out.println("n? κ°? : ");
		int n = sc.nextInt();

		int sum = 0;
		int i = 1;
		while (i <= n) {
			sum += i;
			i++;
		}
		System.out.println("i : " + i);
		System.out.println("1λΆ??° " + n + "κΉμ?? ?©?? " + sum + "???€");
	}

	// Q7
	void calcSum() {
		System.out.println("?«??? ₯ : ");
		int a = sc.nextInt();
		int result = 0;
		for (int i = a; i > 0; i--) {
			result += i;
		}
		System.out.println(result);
	}

	// Q8
	void calcSum2() {
		System.out.println("?«??? ₯??Έ? : ");
		int a = sc.nextInt();
		int sum = (1 + a) * a / 2;
		System.out.println(sum);
	}

	// Q9
	void calcSum3() {
		System.out.println("a ?? ₯ : ");
		int a = sc.nextInt();
		System.out.println("b ?? ₯ : ");
		int b = sc.nextInt();
		int sum = 0;
		if (a <= b)
			sum = (a + b) * (b - a + 1) / 2;
		else
			sum = (a + b) * (a - b + 1) / 2;
		System.out.println("a?? b?¬?΄ ? ?? ?© : " + sum);
	}

	// Q10
	void subBA() {
		System.out.println("a ?? ₯ : ");
		int a = sc.nextInt();
		while (true) {
			System.out.println("b ?? ₯ : ");
			int b = sc.nextInt();
			if (b <= a) {
				System.out.println("bκ°μ? aκ°λ³΄?€ μ»€μΌ?©??€");
				continue;
			} else {
				int result = b - a;
				System.out.println("b-a? " + result + "???€");
				break;
			}
		}
	}

	// Q11
	// ?? ? ?λ₯? ?? ₯?κ³? ?λ¦Ώμλ₯? μΆλ ₯
	void digitOfNum() {
		while (true) {
			System.out.print("?«? ?? ₯>>>");
			int a = sc.nextInt();
			if (a <= 0) {
				System.out.println("?? ? ?λ₯? ?? ₯??Έ?");
				continue;
			}
			int result = 0;
			while (true) {
				a /= 10;
				result++;
				if (a == 0) {
					System.out.println("a? " + result + "?λ¦? ?«??");
					break;
				}
			}
			break;
		}

	}

	// Q12
	// κ³±μ? μΆλ ₯
	void gugudanTable() {
		System.out.println(" ?1\t2\t3\t4\t5\t6\t7\t8\t9");
		System.out.println("???Ό????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		for (int i = 1; i < 10; i++) {
			System.out.print(i + "?");
			for (int j = 1; j < 10; j++) {
				System.out.print(i * j + "\t");
			}
			System.out.println();
		}
	}

	// Q13
	// ?§?? μΆλ ₯
	void plusTable() {
		System.out.println(" ?1\t2\t3\t4\t5\t6\t7\t8\t9");
		System.out.println("???Ό????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		for (int i = 1; i < 10; i++) {
			System.out.print(i + "?");
			for (int j = 1; j < 10; j++) {
				System.out.print(i + j + "\t");
			}
			System.out.println();
		}
	}

	// Q14
	// ?? ₯??λ₯? ?λ³??Όλ‘? ?? ? ?¬κ°ν? * κΈ°νΈλ‘?
	void printSquare() {
		while (true) {
			System.out.println("?¨ ?λ₯? ?? ₯??Έ?>>>");
			int a = sc.nextInt();
			if (a <= 0) {
				System.out.println("0λ³΄λ€ μ»€μΌ?©??€. ?€??? ₯??Έ?");
				continue;
			}
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < a; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		}
	}

	// Q15
	// μ§κ° ?΄?±λ³? ?Όκ°νμΆλ ₯
	void printTriangle() {
		while (true) {
			System.out.println("λͺ? ?¨ ?Όκ°ν?Έκ°?? ?>>>");
			int n = sc.nextInt();
			if (n <= 1) {
				System.out.println("1λ³΄λ€ ?°?λ₯? ?? ₯??Έ?!");
				continue;
			}
			System.out.println("μ§κ°?Έ λΆ?λΆμ? ?΄??Έκ°??");
			System.out.println("[1]?Ό??  [2]?Ό?  [3]?€λ₯Έμ?  [4]?€λ₯Έμ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				triangleLB(n);
				break;
			case 2:
				triangleLU(n);
				break;
			case 3:
				triangleRB(n);
				break;
			case 4:
				triangleRU(n);
				break;
			default:
				break;
			}
			break;
		}

	}

	// ?€λ₯Έμ
	void triangleRU(int n) {
		System.out.println("?€λ₯Έμͺ½ ?κ°? μ§κ°?Έ ?΄?±λ³? ?Όκ°ν? μΆλ ₯?©??€");
		int a = 0;
		for (int i = n; i >= 1; i--) {
			a = n - i;
			while (a > 0) {
				System.out.print(" ");
				a--;
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// ?€λ₯Έμ?
	void triangleRB(int n) {
		System.out.println("?€λ₯Έμͺ½ ??κ°? μ§κ°?Έ ?΄?±λ³? ?Όκ°ν? μΆλ ₯?©??€");
		int a = 0;
		for (int i = 1; i <= n; i++) {
			a = n - i;
			while (a > 0) {
				System.out.print(" ");
				a--;
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// ?Ό?
	void triangleLU(int n) {
		System.out.println("?Όμͺ? ?κ°? μ§κ°?Έ ?΄?±λ³? ?Όκ°ν? μΆλ ₯?©??€");
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// ?Ό??
	void triangleLB(int n) {
		System.out.println("?Όμͺ? ??κ°? μ§κ°?Έ ?΄?±λ³? ?Όκ°ν? μΆλ ₯?©??€");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// Q16
	// n?¨? ?Ό?Όλ―Έλ
	void printSpira() {
		int n=0;
		int space=0;
		while(true) {
			System.out.println("λͺ? ?¨ ?Ό?Όλ―Έλ ?Έκ°???>>");
			int a = sc.nextInt();
			
			System.out.println("[1]?«?λ‘? μΆλ ₯   [2]*λͺ¨μ?Όλ‘? μΆλ ₯");
			int choice= sc.nextInt();
			if(choice==1) {
				for (int i = 1; i <= a; i++) {
					space=a-i;
					n= (i-1)*2+1;
					while(space>0) {
						System.out.print(" ");
						space--;
					}
					for (int j = 1; j <= i; j++) {
						while(n>0) {
							System.out.print(i%10);
							n--;
						}
					}
					System.out.println();
				}
			}else if(choice==2) {
				for (int i = 1; i <= a; i++) {
					space=a-i;
					n= (i-1)*2+1;
					while(space>0) {
						System.out.print(" ");
						space--;
					}
					for (int j = 1; j <= i; j++) {
						while(n>0) {
							System.out.print("*");
							n--;
						}
					}
					System.out.println();
				}
			}
			System.out.println();
		}
	}

}
