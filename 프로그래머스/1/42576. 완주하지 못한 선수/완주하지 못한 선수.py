def solution(participant, completion):
    
    participantSum = 0
    completionSum = 0
    partiDic = dict()
    completionDic = dict()
    for p in participant:
        partiDic[hash(p)] = p
        participantSum += hash(p)
    for c in completion:
        completionDic[hash(c)] = c
        completionSum += hash(c)
        
    return partiDic[participantSum - completionSum]
    