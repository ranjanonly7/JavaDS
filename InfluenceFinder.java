package LinkedInQuestions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rmukherj on 8/20/16.
 * public interface InfluencerFinder {

 /**
 * Given a matrix of following between N LinkedIn users (with ids from 0 to N-1):
 * followingMatrix[i][j] == true iff user i is following user j
 * thus followingMatrix[i][j] doesn't imply followingMatrix[j][i].
 * Let's also agree that followingMatrix[i][i] == false
 *
 * Influencer is a user who is:
 * - followed by everyone else and
 * - not following anyone himself
 *
 * This method should find an Influencer by a given matrix of following,
 * or return -1 if there is no Influencer in this group.
 */

public class InfluenceFinder {

    int getInfluencer(boolean[][] followingMatrix) {
        Set<Integer> candidates = new HashSet<Integer>();
        for (int i = 0; i < followingMatrix.length; i++)
            candidates.add(i);

        while (candidates.size() != 0) {
            Integer cur = 0;
            for (Integer i : candidates) {
                cur = i;
                candidates.remove(cur);
                break;
            }

            // Check row
            boolean breakFlag = false;
            for (int i = 0; i < followingMatrix.length; i++) {
                if (breakFlag)
                    break;
                if (i != cur) {
                    if (followingMatrix[cur][i]) {
                        breakFlag = true;
                        break;
                    }
                }
            }
            if (breakFlag)
                continue;

            // Check column
            for (int i = 0; i < followingMatrix.length; i++) {
                if (breakFlag)
                    break;
                if (i != cur) {
                    if (!followingMatrix[i][cur]) {
                        breakFlag = true;
                        break;
                    }
                }
                candidates.remove(i);
            }

            if (!breakFlag)
                return cur;
        }

        return -1;
    }

    public static int getInfluncer(boolean [][] followingMatrix){
        // if i is follows by j, following[i][j] = ttrue;
        int n = followingMatrix.length;
        int influencer = 0;
        for(int i=1; i<n;i++){
            if(followingMatrix[influencer][i]){
                // influencer is following someone. So it cant be.
                influencer = i;
            }

        }
        // All other nodes except influencer follow at least 1 other person. Hence, we just need
        // to check that the surviving influencer is not following anyone else.
        // All nodes after influencer have already been checked.
        for(int i=0; i<influencer;i++){
            if(followingMatrix[i][influencer])
                return -1;
        }

        return influencer;
    }

    //linear time and linear memory
    public static int getInfluencerInt(int[][] followingMatrix) {
        int n = followingMatrix.length;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        int i = n - 1, j = 0;

        while(i >= 0 && j < n && !set.isEmpty()) {
            if (i == j) {
                j++;
                continue;
            }
            if (followingMatrix[i][j] == 1) {
                if (set.contains(i)) {
                    set.remove(i);
                }
                i--;
            } else {
                if (set.contains(j)) {
                    set.remove(j);
                }
                j++;
            }
        }
        if (set.isEmpty()) {
            // no influencer
            return -1;
        }

        Integer[] influencers = set.toArray(new Integer[1]);
        int influencer = influencers[0];
        System.out.println("Possible influencer: " + influencer);
        for (int k = 0; k < n; k++) {
            if (k == influencer) continue;
            if (followingMatrix[k][influencer] == 0) return -1;
        }
        for (int k = 0; k < n; k++) {
            if (k == influencer) continue;
            if (followingMatrix[influencer][k] == 1) return -1;
        }
        return influencer;
    }

    public static void main(String[] args) {
//
  //      boolean[][] input = new boolean[][]{
//                {false, true, true, false},
//                {true, false, true, true},
//                {false, false, false, false},
//                {true, true, true, false}
//        };

        boolean[][] input = new boolean[][]{
                {false, true, true, false},
                {true, false, true, true},
                {false, false, false, false},
                {true, true, true, false}
        };

        int[][] i = new int[][]{
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {0, 0, 0, 0},
                {1, 1, 1, 0}
        };
    InfluenceFinder inf = new InfluenceFinder();
        int x = inf.getInfluencer(input);
        System.out.println(x);
        x = getInfluncer(input);
        System.out.println(x);
        x = getInfluencerInt(i);
        System.out.println(x);


    }
}
