public class Solution extends VersionControl {
 public int firstBadVersion(int n) {

		int low = 1;
		int high = n;

		// if low and high are same then it is the first bad version
		while (low < high) {
			// calculate mid
			int mid = (high- low)/ 2 + low;

			// check if mid is the bad version
			if (isBadVersion(mid)) {
				// if mid is bad version then either mid is first bad version or
				// version before it is
				// so in next iteration only check till mid
				high = mid;
			} else {
				// if mid is not bad version that means version before it is good
				// some version after it is bad
				// so check from the version + 1 to high
				low = mid + 1;
			}

		}
		return low;
	}
}