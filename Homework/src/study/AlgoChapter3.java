package study;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AlgoChapter3 {
	static Scanner sc = new Scanner(System.in);

	// ? ?κ²??
	int seqSearch(int[] a, int n, int key) {
		int i = 0;

		// ? ?κ²?? while
//		while(true) {
//			if(i==n){
//				return -1;
//			}
//			if(a[i]==key)
//				return i;
//			i++;
//		}

		// ? ?κ²?? for
		for (int j = 0; j < n; j++) {
			if (a[j] == key)
				return i;
		}
		return -1;
	}

	void doSearch() {
		System.out.println("??? κ°μ: ");
		int num = sc.nextInt();
		int[] x = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		System.out.println("κ²???  κ°? : ");
		int ky = sc.nextInt();
		int idx = seqSearch(x, num, ky);

		if (idx == -1)
			System.out.println("κ·? κ°μ ??κ°? ??΅??€");
		else
			System.out.println(ky + "??(?) x[" + idx + "]? ??΅??€.");
	}

	// ? ?κ²?? (λ³΄μ΄λ²?) sentinel
	// if λ¬Έμ΄ ? κ³? λΉκ΅?΄? ??λ§? ?¬?©
	// ==> λ°λ³΅μ’λ£? ??? ??¨??κ°? ?€? λ‘? ? λ°μΌλ‘? μ€μ΄?¦
	int seqSearchSen(int[] a, int n, int key) {
		int i = 0;
		a[n] = key;
		while (true) {
			if (a[i] == key)
				break;
			i++;
		}
		return i == n ? -1 : i;
	}

	void doSearchSen() {
		System.out.println("??? κ°μ: ");
		int num = sc.nextInt();
		int[] x = new int[num + 1];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		System.out.println("κ²???  κ°? : ");
		int ky = sc.nextInt();
		int idx = printSearch(x, num, ky);

		if (idx == -1)
			System.out.println("κ·? κ°μ ??κ°? ??΅??€");
		else
			System.out.println(ky + "??(?) x[" + idx + "]? ??΅??€.");
	}

	// Q1
	// seqSearchSen()? whileλ¬Έμ forλ¬ΈμΌλ‘? λ°κΎΈκΈ?
	int seqSearchSen2(int[] a, int n, int key) {
		int i = 0;
		a[n] = key;
		for (int j = 0; j < n; j++) {
			if (a[j] == key) {
				i = j;
				break;
			}
		}
		return i == n ? -1 : i;
	}

	int seqSearchSen3(int[] a, int n, int key) {
		int i;
		a[n] = key; // λ³΄μ΄λ₯? μΆκ?
		for (i = 0; a[i] != key; i++);
		return i == n ? -1 : i;
	}

	// Q2
	int printSearch(int[] a, int n, int key) {
		System.out.print("   |");
		for (int k = 0; k < n; k++)
			System.out.printf("%4d", k);
		System.out.println();

		System.out.print("---+");
		for (int k = 0; k < 4 * n + 2; k++)
			System.out.print("-");
		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.print("   |");
			System.out.printf(String.format("%%%ds*\n", (i * 4) + 3), "");
			System.out.printf("%3d|", i);
			for (int k = 0; k < n; k++)
				System.out.printf("%4d", a[k]);
			System.out.println("\n   |");
			if (a[i] == key)
				return i; // κ²???±κ³?
		}
		return -1; // κ²???€?¨
	}
	
	//Q3
	void searchIdx() {
		System.out.print("???οΌ?");
		int num = sc.nextInt();
		int[] x = new int[num]; // ??? num?Έ λ°°μ΄
		int[] y = new int[num]; // ??? num?Έ λ°°μ΄

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]οΌ?");
			x[i] = sc.nextInt();
		}
		System.out.print("μ°Ύλ κ°οΌ"); // ?€ κ°μ ?? ₯ λ°μ
		int ky = sc.nextInt();

		int count = 0;
		for (int i = 0; i < num; i++) {
			if (x[i] == ky)
				y[count++] = i;
		}

		if (count == 0)
			System.out.println("κ·? κ°μ ??κ°? ??΅??€.");
		else
			for (int i = 0; i < count; i++) {
				System.out.println("κ·? κ°μ? " + "x[" + y[i] + "]? ??΅??€.");
			}
		System.out.println(y.length);
	}
	
	//Q4
	//?΄μ§? κ²??κ³Όμ  μΆλ ₯
	void printBinSearch() {
		System.out.print("???οΌ?");
		int num = sc.nextInt();
		int[] x = new int[num]; // ??? num?Έ λ°°μ΄

		System.out.println("?€λ¦μ°¨??Όλ‘? ?? ₯??Έ?.");

		System.out.print("x[0]οΌ?"); // λ§? ? ??λ₯? ?½?΄ ?€?
		x[0] = sc.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "]οΌ?");
				x[i] = sc.nextInt();
			} while (x[i] < x[i - 1]); // ?? ?? ??λ³΄λ€ ??Όλ©? ?€? ?? ₯
		}

		System.out.print("μ°Ύλ κ°οΌ"); // ?€ κ°μ ?? ₯ λ°μ
		int ky = sc.nextInt();

		int idx = binSearchEx(x, num, ky); // λ°°μ΄ x?? κ°μ΄ ky?Έ ??λ₯? κ²??

		if (idx == -1)
			System.out.println("κ·? κ°μ ??κ°? ??΅??€.");
		else
			System.out.println(ky + "?? x[" + idx + "]? ??΅??€.");
	}
	private int binSearchEx(int[] a, int n, int key) {
		System.out.print("   |");
		for (int k = 0; k < n; k++)
			System.out.printf("%4d", k);
		System.out.println();

		System.out.print("---+");
		for (int k = 0; k < 4 * n + 2; k++)
			System.out.print("-");
		System.out.println();

		int pl = 0; // κ²??λ²μ λ§? ?? index
		int pr = n - 1; // κ²??λ²μ λ§? ?€? index

		do {
			int pc = (pl + pr) / 2; // μ€μ??? index
			System.out.print("   |");
			if (pl != pc)
				System.out.printf(String.format("%%%ds<-%%%ds+", (pl * 4) + 1, (pc - pl) * 4), "", "");
			else
				System.out.printf(String.format("%%%ds<-+", pc * 4 + 1), "");
			if (pc != pr)
				System.out.printf(String.format("%%%ds->\n", (pr - pc) * 4 - 2), "");
			else
				System.out.println("->");
			System.out.printf("%3d|", pc);
			for (int k = 0; k < n; k++)
				System.out.printf("%4d", a[k]);
			System.out.println("\n   |");
			if (a[pc] == key)
				return pc; // κ²???±κ³?
			else if (a[pc] < key)
				pl = pc + 1; // κ²??λ²μλ₯? ?€μͺ? ? λ°μΌλ‘? μ’ν
			else
				pr = pc - 1; // κ²??λ²μλ₯? ?μͺ? ? λ°μΌλ‘? μ’ν
		} while (pl <= pr);
		return -1;
	}

	public static void main(String[] args) {
		AlgoChapter3 ag = new AlgoChapter3();
		ag.printBinSearch();
		sc.close();
	}
}
