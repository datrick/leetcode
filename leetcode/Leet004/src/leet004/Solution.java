package leet004;

public class Solution {

	public double findMedianSortedArrays(int A[], int B[]) {
		int sa = 0, ea = A.length - 1, sb = 0, eb = B.length - 1;
		while (ea > sa && eb > sb){
			int midA = (sa + ea) / 2, midB = (sb + eb) / 2;
			if (A[midA] <= B[midB]){
				if (A[midA + 1] > B[midB + 1]){
					ea = (ea - sa) % 2 == 0 ? midA : midA - 1;
					sa = midA;
				} else {
					int removeLen = Math.min(midA - sa + 1, eb - midB);
					if ((ea - sa) % 2 == 0 && removeLen == midA - sa + 1)
						removeLen -= 1;
					sa += removeLen;
					eb -= removeLen;
				}
			} else {
				if (B[midB + 1] > A[midA + 1]){
					eb = (eb - sb) % 2 == 0 ? midB : midB - 1;
					sb = midB;
				} else {
					int removeLen = Math.min(midB - sb + 1, ea - midA);
					if ((eb - sb) % 2 == 0 && removeLen == midB - sb + 1)
						removeLen -= 1;
					sb += removeLen;
					ea -= removeLen;
				}
			}
		}
		int[] onlyArray = null, longArray = null;
		int lonelyInt = 0, startIndex = sa, endIndex = ea;
		if (ea < sa || eb < sb){
			onlyArray = ea < sa ? B : A;
			if (ea < sa){
				startIndex = sb;
				endIndex = eb;
			}
		} else {
			if (ea == sa){
				if (sb == eb)
					return ((float)(A[sa] + B[sb])) / 2;
				longArray = B;
				startIndex = sb;
				endIndex = eb;
				lonelyInt = A[sa];
			} else {
				longArray = A;
				lonelyInt = B[sb];
			}
		}
		int index = (startIndex + endIndex) / 2;
		if (onlyArray != null){
			if ((endIndex - startIndex) % 2 == 0)
				return (float) onlyArray[index];
			else
				return ((float) onlyArray[index] + (float) onlyArray[index + 1]) / 2;
		}
		if ((endIndex - startIndex) % 2 == 0){
			if (lonelyInt <= longArray[index] && lonelyInt >= longArray[index - 1])
				return ((float) longArray[index] + (float) lonelyInt ) / 2;
			if (lonelyInt >= longArray[index] && lonelyInt <= longArray[index + 1])
				return ((float) longArray[index] + (float) lonelyInt ) / 2;
			if (lonelyInt > longArray[index])
				return ( (float) longArray[index] + (float) longArray[index + 1] ) / 2;
			if (lonelyInt < longArray[index])
				return ( (float) longArray[index] + (float) longArray[index - 1] ) / 2;
		} else {
			if (lonelyInt <= longArray[index])
				return (float) longArray[index];
			if (lonelyInt >= longArray[index] && lonelyInt <= longArray[index + 1])
				return (float) lonelyInt;
			if (lonelyInt > longArray[index])
				return (float) longArray[index + 1];
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 4, 5}, B = {2, 3, 6, 7, 8};
		System.out.println(new SolutionII().findMedianSortedArrays(A, B));
	}

}
