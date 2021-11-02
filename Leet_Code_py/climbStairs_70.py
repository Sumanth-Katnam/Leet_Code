def climbStairs(n: int) -> int:
    # return 0
    # works in case of non class methods only
    # waysDict = {}
    # if n in waysDict:
    #     return waysDict[n]
    # if n <= 1:
    #     return 1
    # res = climbStairs(n - 1) + climbStairs(n - 2)
    # waysDict[n] = res
    # return res

    # waysDict = {1: 1, 2: 2}
    # for i in range(3, n + 1):
    #     waysDict[i] = waysDict[i - 1] + waysDict[i - 2]
    # return waysDict[n]

    if n == 1:
        return 1
    waysDict = {'penUltimate': 1, 'ultimate': 2}
    for i in range(3, n + 1):
        curr = waysDict['ultimate'] + waysDict['penUltimate']
        waysDict['penUltimate'] = waysDict['ultimate']
        waysDict['ultimate'] = curr
    return waysDict['ultimate']


if __name__ == "__main__":
    print(climbStairs(5))
