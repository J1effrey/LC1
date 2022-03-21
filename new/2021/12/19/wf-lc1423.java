// Time: O(K)
// Space; O(1)
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int frontScore = 0;
        int rearScore = 0;
        int n = cardPoints.length;

        for (int i = 0; i < k; i++) {
            frontScore += cardPoints[i];
        }

        // take all k cards from the beginning
        int maxScore = frontScore;

        // take i from the beginning and k - i from the end
        for (int i = k - 1; i >= 0; i--) {
            rearScore += cardPoints[n - (k - i)];
            frontScore -= cardPoints[i];
            int currentScore = rearScore + frontScore;
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
}

// sliding window
// O(N)
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int res = 0, len = cardPoints.length;
        for (int start = len - k, i = start, win = 0; i < len + k; ++i) {
            win += cardPoints[i % len]; // accumulate the value of the sliding window.
            if (i - start >= k) { // Is the sliding window wider than k?
                win -= cardPoints[(i - k) % len]; // deduct the element from the left of the window.
            }
            res = Math.max(win, res); // update the maximum.
        }
        return res;
    }
}

/*
1 2 3 4 [5 6 1 1 2 3] 4 5 6 1

len - k  k
*/
