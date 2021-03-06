package study;


public class Gstack<E> {
	private int max;
	private int ptr;
	private E[] stk;

	// ?€??  ? ??ΈοΌμ€??΄ λΉμ΄ ??
	public static class EmptyGstackException extends RuntimeException {
		public EmptyGstackException() {
		}
	}

	// ?€??  ? ??ΈοΌμ€??΄ κ°?? μ°?
	public static class OverflowGstackException extends RuntimeException {
		public OverflowGstackException() {
		}
	}

	// ??±?
	public Gstack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = (E[]) new Object[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	// ?Έ?¬
	public E push(E x) throws OverflowGstackException {
		if (ptr >= max)
			throw new OverflowGstackException();
		return stk[ptr++] = x;
	}

	// ?€??? ?°?΄?°λ₯? ?(? ?? ?? ?°?΄?°λ₯? κΊΌλ)
	public E pop() throws EmptyGstackException {
		if (ptr <= 0) // ?€??΄ λΉμ΄ ??
			throw new EmptyGstackException();
		return stk[--ptr];
	}

	// ?€??? ?°?΄?°λ₯? ?Ό?¬(? ?? ?? ?°?΄?°λ₯? ?€?¬?€λ΄?)
	public E peek() throws EmptyGstackException {
		if (ptr <= 0) // ?€??΄ λΉμ΄ ??
			throw new EmptyGstackException();
		return stk[ptr - 1];
	}

	// ?€??? xλ₯? κ²????¬ index(μ°Ύμ? λͺ»νλ©? -1)λ₯? λ°ν
	public int indexOf(E x) {
		for (int i = ptr - 1; i >= 0; i--) // κΌ???κΈ°μͺ½λΆ??° ? ? κ²??
			if (stk[i].equals(x))
				return i; // κ²???±κ³?
		return -1; // κ²???€?¨
	}

	// ?€?? λΉμ?
	public void clear() {
		ptr = 0;
	}

	// ?€?? ?©?? λ°ν
	public int capacity() {
		return max;
	}

	// ?€?? ??¬?? ?°?΄?° ?λ₯? λ°ν
	public int size() {
		return ptr;
	}

	// ?€??΄ λΉμ΄ ??κ°??
	public boolean isEmpty() {
		return ptr <= 0;
	}

	// ?€??΄ κ°?? μ°Όλκ°??
	public boolean isFull() {
		return ptr >= max;
	}

	// ?€? ?? ?°?΄?°λ₯? λ°λ₯?κΌ???κΈ°μ μ°¨λ?λ‘? μΆλ ₯?¨
	public void dump() {
		if (ptr <= 0)
			System.out.println("?€??΄ λΉμ?΅??€.");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}
}
