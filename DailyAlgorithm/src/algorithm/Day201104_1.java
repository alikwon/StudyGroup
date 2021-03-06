package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*
● 스킬트리
	문제 설명
		선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
		
		예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 
		썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
		
		위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 
		따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 
		썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
		
		선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 
		가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
	
	제한 조건
		- 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
		- 스킬 순서와 스킬트리는 문자열로 표기합니다.
		- 예를 들어, C → B → D 라면 CBD로 표기합니다
		- 선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
		- skill_trees는 길이 1 이상 20 이하인 배열입니다.
		- skill_trees의 원소는 스킬을 나타내는 문자열입니다.
		- skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
*/
public class Day201104_1 {

	public int solution(String skill, String[] trees) {
//		List<String>list2= Arrays.asList(tmp); //java.util.Arrays.ArrayList
		int answer = 0;
		for (String tree : trees) {
			int cont = 0;
			int chk = 0;
			for (int j = 0; j < tree.length(); j++) {
				String s = String.valueOf(tree.charAt(j));
				int idx = skill.indexOf(s);
				if (idx == -1) {
					chk++;
				}

				if (cont == idx) {
					cont++;
				} else if (cont < idx) {
					cont = 0;
					break;
				}
			}
			if (cont > 0 || chk == tree.length()) {
				answer++;
			}
		}
		return answer;
	}

	public int solution2(String skill, String[] trees) {
		int answer = 0;
		ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(trees));
		Iterator<String> it = skillTrees.iterator();

		while (it.hasNext()) {
			String s = it.next();
			if (skill.indexOf(s.replaceAll("[^" + skill + "]", "")) != 0) {
				it.remove();
			}
		}
		answer = skillTrees.size();
		return answer;
	}

	public int solution2_2(String skill, String[] trees) {
		int answer = 0;
		for (String s : trees) {
			if (skill.indexOf(s.replaceAll("[^" + skill + "]", "")) == 0)
				answer++;
		}
		return answer;
	}

	public int solution3(String skill, String[] trees) {
		int answer = 0;
		StringBuffer sb = new StringBuffer();
		String[] arr = null;
		for (String s : trees) {
			arr = s.split("");
			sb.delete(0, sb.length());
			for (int j = 0; j < arr.length; j++) {
				if (skill.indexOf(arr[j]) != -1)
					sb.append(arr[j]);
			}
			if (skill.indexOf(sb.toString()) == 0) {
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Day201104_1 d = new Day201104_1();
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA", "CED", "OPQ" };
		System.out.println(d.solution3(skill, skill_trees));
	}
}
