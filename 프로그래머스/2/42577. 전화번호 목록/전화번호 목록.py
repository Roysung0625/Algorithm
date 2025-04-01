def solution(phone_book):
    hash_map = {}
    
    # 모든 전화번호를 해시맵에 저장
    for phone_number in phone_book:
        hash_map[phone_number] = 1
        
    # 각 전화번호의 접두어가 해시맵에 있는지 확인
    for phone_number in phone_book:
        prefix = ""
        for number in phone_number[:-1]:  # 마지막 숫자 제외
            prefix += number
            if prefix in hash_map:  # 접두어가 해시맵에 있다면
                return False
    return True