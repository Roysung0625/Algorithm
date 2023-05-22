class Solution {
    val fatigueList = ArrayList<Int>()

    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer: Int = 0
        val one = picks.clone()
        val two = picks.clone()
        val three = picks.clone()
        mining(0, one, minerals.toCollection(ArrayList<String>()), 0)
        mining(1, two, minerals.toCollection(ArrayList<String>()), 0)
        mining(2, three, minerals.toCollection(ArrayList<String>()), 0)
        answer = minVal(fatigueList)
        return answer
    }

    fun mining(selected:Int, picks: IntArray, minerals: ArrayList<String>, fatigue:Int){
        var next = " "
        var cal = fatigue
        var flag = 0
        picks[selected]--
        if(picks[selected] < 0){
            for(i in 0..2)
                if(picks[i] <= 0)
                    flag++
            if(flag == 3)
                fatigueList.add(cal)
            return
        }
        for (i in 0..4){
            if(minerals.isNotEmpty())
                next = minerals.removeAt(0)
            else {
                fatigueList.add(cal)
            }
            cal += fatigueCal(selected, next)
        }
        val one = picks.clone()
        val two = picks.clone()
        val three = picks.clone()
        mining(0, one, minerals.toCollection(ArrayList<String>()), cal)
        mining(1, two, minerals.toCollection(ArrayList<String>()), cal)
        mining(2, three, minerals.toCollection(ArrayList<String>()), cal)

    }

    fun fatigueCal(pickaxe:Int, mineral:String) : Int{
        when(mineral){
            "diamond" -> return when(pickaxe){
                0 -> 1
                1 -> 5
                else -> 25
            }
            "iron" -> return when(pickaxe){
                0 -> 1
                1 -> 1
                else -> 5
            }
            "stone" -> return when(pickaxe){
                0 -> 1
                1 -> 1
                else -> 1
            }
        }
        return 0
    }

    fun minVal(list:ArrayList<Int>):Int{
        if(list.size == 0)
            return 0
        var returnVal = list[0]
        for(i in list.indices)
            if(list[i] < returnVal)
                returnVal = list[i]
        return returnVal
    }
}