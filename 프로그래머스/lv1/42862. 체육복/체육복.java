import java.util.Arrays;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        System.out.println(answer);
        int curLost = 0;
        int curReserve = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i = 0; i < lost.length; i++)
            for(int j = 0; j < reserve.length; j++)
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    System.out.println(answer);
                    break;
                }


        for(int i = 0; i < lost.length; i++) {
            curLost = lost[i];
            if(curLost == -1)
                continue;
            for (int j = 0; j < reserve.length; j++) {
                if (curLost == reserve[j] || (curLost - 1) == reserve[j] || (curLost + 1) == reserve[j]) {
                    reserve[j] = -1;
                    answer++;
                    System.out.println(answer);
                    break;
                }
            }
        }

        return answer;
    }
}