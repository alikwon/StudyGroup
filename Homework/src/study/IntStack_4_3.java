package study;

public class IntStack_4_3 {
	private int max; // ?€?? ?©? (A?»B? ?©κ³?)
	private int ptrA; // ?€? ?¬?Έ?° A
	private int ptrB; // ?€? ?¬?Έ?° B
	private int[] stk; // ?€? λ³Έμ²΄

	public enum AorB {
		StackA, StackB
	};

	// ?€??  ? ??ΈοΌμ€??΄ λΉμ΄ ??
	public class EmptyIntStackX2Exception extends RuntimeException {
		public EmptyIntStackX2Exception() {
		}
	}

	// ?€??  ? ??ΈοΌμ€??΄ κ°?? μ°?
	public class OverflowIntStackX2Exception extends RuntimeException {
		public OverflowIntStackX2Exception() {
		}
	}

	// ??±?
	public IntStack_4_3(int capacity) {
		ptrA = 0;
		ptrB = capacity - 1;
		max = capacity;
		try {
			stk = new int[max]; // ?€? λ³Έμ²΄?© λ°°μ΄? ??±
		} catch (OutOfMemoryError e) { // ??±?  ? ??΅??€.
			max = 0;
		}
	}

	// ?€?? xλ₯? ?Έ?
	public int push(AorB sw, int x) throws OverflowIntStackX2Exception {
		if (ptrA >= ptrB + 1) // ?€??΄ κ°?? μ°?
			throw new OverflowIntStackX2Exception();
		switch (sw) {
		case StackA:
			stk[ptrA++] = x;
			break;
		case StackB:
			stk[ptrB--] = x;
			break;
		}
		return x;
	}

	// ?€??? ?°?΄?°λ₯? ?(κΌ???κΈ°μ ?°?΄?°λ₯? κΊΌλ)
	public int pop(AorB sw) throws EmptyIntStackX2Exception {
		int x = 0;
		switch (sw) {
		case StackA:
			if (ptrA <= 0) // ?€? Aκ°? λΉμ΄ ??
				throw new EmptyIntStackX2Exception();
			x = stk[--ptrA];
			break;
		case StackB:
			if (ptrB >= max - 1) // ?€? Bκ°? λΉμ΄ ??
				throw new EmptyIntStackX2Exception();
			x = stk[++ptrB];
			break;
		}
		return x;
	}

	// ?€??? ?°?΄?°λ₯? ?Ό?¬(κΌ???κΈ°μ ?°?΄?°λ₯? ?΄?΄ λ΄?)
	public int peek(AorB sw) throws EmptyIntStackX2Exception {
		int x = 0;
		switch (sw) {
		case StackA:
			if (ptrA <= 0) // ?€? Aκ°? λΉμ΄ ??
				throw new EmptyIntStackX2Exception();
			x = stk[ptrA - 1];
			break;
		case StackB:
			if (ptrB >= max - 1) // ?€? Bκ°? λΉμ΄ ??
				throw new EmptyIntStackX2Exception();
			x = stk[ptrB + 1];
			break;
		}
		return x;
	}

	// ?€??? xλ₯? κ²????¬ index(μ°Ύμ? λͺ»νλ©? -1)λ₯? λ°ν
	public int indexOf(AorB sw, int x) {
		switch (sw) {
		case StackA:
			for (int i = ptrA - 1; i >= 0; i--) // κΌ???κΈ°μͺ½λΆ??° ? ? κ²??
				if (stk[i] == x)
					return i; // κ²???±κ³?
			break;
		case StackB:
			for (int i = ptrB + 1; i < max; i++) // κΌ???κΈ°μͺ½λΆ??° ? ? κ²??
				if (stk[i] == x)
					return i; // κ²???±κ³?
			break;
		}
		return -1; // κ²???€?¨
	}

	// ?€?? λΉμ?
	public void clear(AorB sw) {
		switch (sw) {
		case StackA:
			ptrA = 0;
			break;
		case StackB:
			ptrB = max - 1;
			break;
		}
	}

	// ?€?? ?©?? λ°ν (A?? B? ?©κ³?)
	public int capacity() {
		return max;
	}

	// ?€?? ??¬?? ?°?΄?° ?λ₯? λ°ν
	public int size(AorB sw) {
		switch (sw) {
		case StackA:
			return ptrA;
		case StackB:
			return max - ptrB - 1;
		}
		return 0;
	}

	// ?€??΄ λΉμ΄ ??κ°??
	public boolean isEmpty(AorB sw) {
		switch (sw) {
		case StackA:
			return ptrA <= 0;
		case StackB:
			return ptrB >= max - 1;
		}
		return true;
	}

	// ?€??΄ κ°?? μ°Όλκ°??
	public boolean isFull() {
		return ptrA >= ptrB + 1;
	}

	// ?€? ?? ?°?΄?°λ₯? λ°λ₯ ? κΌ???κΈ°μ μ°¨λ?λ‘? ????
	public void dump(AorB sw) {
		switch (sw) {
		case StackA:
			if (ptrA <= 0)
				System.out.println("?€??΄ λΉμ?΅??€.");
			else {
				for (int i = 0; i < ptrA; i++)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
			break;
		case StackB:
			if (ptrB >= max - 1)
				System.out.println("?€??΄ λΉμ?΅??€.");
			else {
				for (int i = max - 1; i > ptrB; i--)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
			break;
		}
	}
}