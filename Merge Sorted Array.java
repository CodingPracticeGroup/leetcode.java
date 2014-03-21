public class Solution {
	public void merge(int A[], int m, int B[], int n) {
		int a = m - 1;
		int b = n - 1;
		int i = m + n - 1;
		while (i >= 0 && a >= 0 && b >= 0) {
			A[i--] = A[a] > B[b] ? A[a--] : B[b--];
		}
		while (b >= 0) {
			A[i--] = B[b--];
		}
	}
}