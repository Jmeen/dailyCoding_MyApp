package JavaStudy.Q200;

import java.util.Random;
import java.util.Scanner;

public class Ch07_Method {

	public static void main(String[] args) {
//		System.out.println(med(444, 33, 2212));
//		System.out.println(signOf(999));
//		System.out.println(sumUp(10));
//		Hello();
//		printSeason(1565);
//		putstart();

//		System.out.println(random(10, 30));

//		System.out.println(readplusint(inputInt()));
		q0714();

	}
	

	private static void q0714() {
		// 정ㅅ x의 pos번째 있는 비트부터 n개 연속되는 비트를 1로 변경하는 값은 반환하는 setN메서드, 0으로 변환하는 resetN메서드,
		// 반전시킨 값을 반환하는 inserseN을 작성하자.
		int x = 12332;
		int pos = 5;
		int n = 14;
		printbit(x);
		printbit(setN(x, pos, n));
		printbit(resetN(x, pos, n));
	}

	private static int setN(int x, int pos, int n) {
		return x | ~(~0 << n) << pos;
	}
	
	private static int resetN(int x , int pos, int n) {
		return x & ~(~(~0 << n) << pos);
	}

	private static void q0713() {
		// 정수 x의 pos번째 있는 비트(최하위 비트부터 0,1,2)를 1로 변경한 값을 반환하는 set메서드, 0으로 변경하는 reset메서드.
		// 그리고 해당위치의 비트를 반전시켜서 반환하는 inverse를 작성하자.
		int x = 11111;
		int pos = 3;
		printbit(x);
		printbit(q0713_set(x, pos));
		printbit(q0713_reset(x, pos));
		printbit(q0713_inverse(x, pos));
	}

	private static int q0713_inverse(int x, int pos) {
		return x ^ (1 << pos);
	}

	private static int q0713_reset(int x, int pos) {
		return x & ~(1 << pos);
	}

	private static int q0713_set(int x, int pos) {
		return x | (1 << pos);
	}

	private static void printbit(int n) {
		// 정수 비트 출력. 옆으로 i값만큼 이동한것이 1이면 1, 아니면 0 프린트.
		for (int i = 31; i >= 0; i--) {
			System.out.print(((n >>> i & 1) == 1) ? 1 : 0);
		}
		System.out.println();

	}

	private static void rRotate() {
		// q07_12
		// 정수 x를 오른쪽으로 n 비트 회전한 값을 반환하는 rRotate메서드를 작성하라.
		int x = 1565857138;
		printbit(x);
		int n = 6;
		n = n % 32;
		printbit(((x >>> n | x << (32 - n))));

	}

	private static void q0711() {
		// 정수를 좌우로 시프트한 값이 "정수 X 2의 거듭제곱"과 같은지 확인하는 프로그램을 작성하자.
		Scanner sc = new Scanner(System.in);
		System.out.print("x : ");
		int x = sc.nextInt();
		System.out.print("n : ");
		int n = sc.nextInt();

		int mpow = x * pow2(n);
		int spow = x / pow2(n);

		int lshift = x << n;
		int rshift = x >> n;

		if (mpow == lshift) {
			System.out.println("거듭제곱과 왼쪽 쉬프트의 값이 같습니다.");
		}
	}

	private static int pow2(int n) {
		int pw = 1;
		while (n-- > 0) {
			pw *= 2;
		}
		return pw;
	}

	private static void cacul() {
		// q07-10
		// 다음 4개의 계산 문제중 하나를 무작위로 출제하는 암산 훈련 프로그램을 작성하자.
		// 이때 x,y,z에 3자리의 정수값을 난수로 생성할 것.

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		int repeat = 1;
		do {
			int a = 1 + rd.nextInt(4);
			int x = 100 + rd.nextInt(900);
			int y = 100 + rd.nextInt(900);
			int z = 100 + rd.nextInt(900);
			String strx = null;
			int answer = 0;

			switch (a) {
			case 1:
				strx = String.format("%d + %d + %d =", x, y, z);
				answer = x + y + z;
				break;
			case 2:
				strx = String.format("%d + %d - %d =", x, y, z);
				answer = x + y - z;
				break;
			case 3:
				strx = String.format("%d - %d + %d =", x, y, z);
				answer = x - y + z;
				break;
			case 4:
				strx = String.format("%d - %d - %d =", x, y, z);
				answer = x - y - z;
				break;
			default:
				break;
			}

			System.out.println(answer);

			int inputanswer = 0;
			do {
				System.out.print("문제!! " + strx + " ");
				inputanswer = sc.nextInt();
				if (inputanswer == answer) {
					System.out.println("정답!");
				} else {
					System.out.println("땡!");
				}
			} while (inputanswer != answer);

			System.out.print("계속할까? 1-yes 0-no");
			repeat = sc.nextInt();
		} while (repeat == 1);
	}

	private static int inputInt() {
		// q07-09
		Scanner sc = new Scanner(System.in);

		int n = 0;
		do {
			System.out.print("양의 정수값 : ");
			n = sc.nextInt();
		} while (n == 0 || n <= 0);

		sc.close();
		return n;
	}

	private static int readplusint(int n) {
		// q07-09
		// "양이 정수값:" 이라는 메세지에 정수값을 입력하면 값을 거꾸로 반환하는 readplusint 를 메서드를 작성하자.
		// 0 이나 음수가 입력되면 재입력 하도록 할 것.
		int result = 0;
		while (n % 10 != 0) {
			int t = n % 10;
			result = (result * 10) + t;
			n /= 10;
		}
		return result;
	}

	private static int random(int a, int b) {
		// q07-08
		// 난수(a=<난수=<b)를 생성하여 반환하는 random 메서드를 작성하라.
		// 메서드 안에서 난수를 생성하는 표준 라이브러리를 호출할 것.
		// 단, b<=a인 경우 a값을 그대로 반환할 것.
		Random rd = new Random();
		int result = 0;
		do {
			result = a + rd.nextInt(b - a + 1);
		} while (a > result && b < result);
		return result;

	}

	private static void putstart() {
		// q07-07
		// 문자 c를 n개 표시하는 puchar메서드와 이 메서드를 내부에서 호출해서 문자 '*'를 n개 연속으로 표시하는 putstart메서드를
		// 작성하자.
		// 이 메서드를 이용해서 직삼각형을 만드는 프로그램을 작성하자.
		Scanner sc = new Scanner(System.in);
		System.out.println("몇단짜리 삼각형을 만들까요");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			putStar(i);
			System.out.println();
		}

	}

	private static void putchar(char c, int n) {
		for (int i = 1; i <= n; i++) {
			System.out.print(c);
		}
	}

	private static void putStar(int n) {
		putchar('*', n);

	}

	private static void printSeason(int n) {
		// Q07_06
		// 인수 n에 지정단 달의 계절을 표시하는 printseason 메서드를 작성하자.
		// n의 값에 따라 봄(3,4,5) 여름(6,7,8) 가을 (9,10,11) 겨울 (12,1,2) 표시하고, 그 이외의 값이오면 아무것도
		// 표시하지 않는다.

		switch (n) {
		case 3:
		case 4:
		case 5:
			System.out.println("봄이에요!");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("여름이에요!");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("가을이에요!");
			break;
		case 12:
		case 1:
		case 2:
			System.out.println("겨울이에요!");
			break;
		default:
			break;

		}
	}

	private static void Hello() {
		// Q0705
		// 안녕하세요 라고 표시하는 메서드를 만들자.
		System.out.println("안녕하세요!");
	}

	private static int sumUp(int n) {
		// Q07_04
		// 1부터 n까지의 정수의 합을 구해서 반환하는 메서드를 구하자.
		int sum = (n * (1 + n)) / 2;
		return sum;
	}

	private static int med(int a, int b, int c) {
		// Q07_03
		// 3개의 int 형 인수 a,b,c중 중간값을 구하는 med메서드를 작성하라.

		int med = 0;

		if (a >= b) {
			if (c >= a) {
				return a;
			} else if (c >= b) {
				return c;
			} else {
				return b;
			}
		} else if (c >= b) {
			return b;
		} else if (a > c) {
			return c;
		} else {
			return a;
		}

//		if (a >= b)
//
//		{
//			if (b >= c) {
//				return b;
//			} else if (a <= c) {
//				return a;
//			} else {
//				return b;
//			}
//		} else if (c < a) {
//			return a;
//		} else if (b > c) {
//			return c;
//		} else {
//			return b;
//		}
	}

	private static int min(int a, int b, int c) {
		// Q07-02
		// 3개의 int형 인수 a,b,c중 최소값을 구하는 min 매서드를 작성하라.
		int[] abc = { a, b, c };
		int min = a;
		for (int i = 1; i < 3; i++) {
			if (abc[i] < min) {
				min = abc[i];
			}
		}
		return min;

	}

	private static int signOf(int i) {
		// Q07-01
		// 입력한 int형 정수값이 음수이면 -1을 0이면 0을 양수이면 1을 반환하는 signOf메서드를 작성하자.
		if (i < 0) {
			return -1;
		} else if (i > 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
