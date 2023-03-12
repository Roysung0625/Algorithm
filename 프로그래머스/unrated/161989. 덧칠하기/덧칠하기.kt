class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        var standard: Int = section[0]

        for(num in section){
            if((num - standard) >= m) {
                standard = num
                answer++
            }
        }
        answer++

        return answer
    }
}