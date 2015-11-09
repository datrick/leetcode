package leet042;

public class Solution {

	public String multiply(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		if (num1.length() == 0 || num2.length() == 0)
			return sb.toString();
		if (num1.compareTo("0") == 0 || num2.compareTo("0") == 0)
			return "0";	
		for (int i = 0; i < num1.length(); i ++){
			int carry_mul = 0, carry_add = 0;
			for (int j = 0; j < num2.length(); j ++){
				int p1 = (int)num1.charAt(num1.length() - 1 - i) - (int)('0');
				int p2 = (int)num2.charAt(num2.length() - 1 - j) - (int)('0');
				int productWithCarry = p1 * p2 + carry_mul;
				carry_mul = productWithCarry / 10;
				int digitFromResult = (i + j) >= sb.length() ? 0 : (int)sb.charAt(i + j) - (int)('0');
				int sum = carry_add + productWithCarry % 10 + digitFromResult;
				carry_add = sum / 10;
				char newDigit = (char) (sum % 10 + (int) '0' );
				if (i + j >= sb.length())
					sb.append(newDigit);
				else
					sb.setCharAt(i + j, newDigit);
			}
			if (carry_mul + carry_add > 0)
				sb.append(carry_mul + carry_add);
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1 = "99999", num2 = "1";
		System.out.println(new Solution().multiply(num1, num2));
	}

}
