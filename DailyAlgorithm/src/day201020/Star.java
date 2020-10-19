package day201020;

import java.util.Scanner;

//	● 직사각형 별찍기
//	- 문제 설명 
//		이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다. 
//		별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.
//	
//	- 제한 조건 
//		n과 m은 각각 1000 이하인 자연수입니다.
public class Star {

	public static void solution(int a, int b) {
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < a; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("가로 길이 입력");
		int a = sc.nextInt();
		System.out.println("세로 길이 입력");
		int b = sc.nextInt();
		solution(a, b);
	}
}
