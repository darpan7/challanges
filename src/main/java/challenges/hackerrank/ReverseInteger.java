package challenges.hackerrank;
/**
* @date	Aug 30, 2018 4:34:20 PM
* @author Darpan Shah
*/

public class ReverseInteger {
	public static void main(String[] args) {
		long x1 = -2147483648 + (-1);
		int y1 = (int)x1;
		String s = String.valueOf("54545454189").replace("-", "");
		System.out.println(Integer.MIN_VALUE);
		System.out.println(x1);
		int limit = -Integer.MAX_VALUE;
		System.out.println("limit: " + limit + ", max: " + Integer.MAX_VALUE);
		System.out.println(y1);
		System.out.println(reverse(4560009));
		System.out.println("     -42   x   ".trim());
		System.out.println(parseInt("2147483647", 10));
	}

	public static int parseInt(String s, int radix) throws NumberFormatException {
		/*
		 * WARNING: This method may be invoked early during VM initialization
		 * before IntegerCache is initialized. Care must be taken to not use the
		 * valueOf method.
		 */

		if (s == null) {
			throw new NumberFormatException("null");
		}

		if (radix < Character.MIN_RADIX) {
			throw new NumberFormatException("radix " + radix + " less than Character.MIN_RADIX");
		}

		if (radix > Character.MAX_RADIX) {
			throw new NumberFormatException("radix " + radix + " greater than Character.MAX_RADIX");
		}

		int result = 0;
		boolean negative = false;
		int i = 0, len = s.length();
		int limit = -Integer.MAX_VALUE;
		int multmin;
		int digit;

		if (len > 0) {
			char firstChar = s.charAt(0);
			if (firstChar < '0') { // Possible leading "+" or "-"
				if (firstChar == '-') {
					negative = true;
					limit = Integer.MIN_VALUE;
				} else if (firstChar != '+')
					throw new NumberFormatException(s);

				if (len == 1) // Cannot have lone "+" or "-"
					throw new NumberFormatException(s);
				i++;
			}
			multmin = limit / radix;
			while (i < len) {
				// Accumulating negatively avoids surprises near MAX_VALUE
				digit = Character.digit(s.charAt(i++), radix);
				if (digit < 0) {
					throw new NumberFormatException(s);
				}
				if (result < multmin) {
					throw new NumberFormatException(s);
				}
				result *= radix;
				System.out.println("A: " + result);
				System.out.println("B: " + (limit + digit));
				if (result < limit + digit) {
					throw new NumberFormatException(s);
				}
				result -= digit;
			}
		} else {
			throw new NumberFormatException(s);
		}
		return negative ? result : -result;
	}
	public static int reverse(int x) {
        int result = 0;
        while(x!=0){
        	int tail = x%10;
        	int nwresult = result*10 + tail;
        	if(nwresult/10 != result)
        		return 0;
        	result = nwresult;
        	x /= 10;
        }
        return result;
    }
}
