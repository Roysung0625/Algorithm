def solution(nums):
    
    pickNum = len(nums) // 2
    pokemons = dict()
    for p in nums:
        if p in pokemons:
            pokemons[p] += 1
        else:
            pokemons[p] = 1
    
    if len(pokemons) > pickNum:
        return pickNum
    else:
        return len(pokemons)