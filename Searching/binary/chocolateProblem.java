/*You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the
array sweetness.

You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces
using K cuts, each piece consists of some consecutive chunks.

Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your
friends.

Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.

Example 1:

Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
Output: 6
Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]

Example 2:

Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
Output: 1
Explanation: There is only one way to cut the bar into 9 pieces.

Example 3:

Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
Output: 5
Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]

Constraints:

    0 <= K < sweetness.length <= 10^4
    1 <= sweetness[i] <= 10^5
Binary Search
the same with 410. Split Array Largest Sum which is to minimize the maximum
this is to maximize the minimum*/
class chocolateProblem {
    public int maximizeSweetness(int[] nums, int m) {
        m++;
        long l = Integer.MAX_VALUE, r = 0;
        for (int n : nums) {
            r += n;
            l = Math.min(l, n);
        }
        while (l + 1 < r) {
            long mid = l + (r - l) / 2;
            if (canSplit(nums, m, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (canSplit(nums, m, r))
            return (int) r;
        else
            return (int) l;
    }

    public boolean canSplit(int[] nums, int m, long target) {
        long sum = 0, cnt = 0;
        for (int n : nums) {
            if (sum + n >= target) {
                sum = 0;
                cnt++;
            } else {
                sum += n;
            }
        }
        return cnt >= m;
    }
}