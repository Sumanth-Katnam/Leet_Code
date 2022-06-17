def isHappy(n: int) -> bool:
    def square_sum(num):
        return sum(int(i) ** 2 for i in str(num))

    mem = []
    ss = square_sum(n)
    
    while ss != 1 and (not ss in mem):
        mem.append(ss)
        ss = square_sum(ss)

    return ss == 1



if __name__ == "__main__":
    print(isHappy(19))
    print(isHappy(2))