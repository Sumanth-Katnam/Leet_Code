def mySqrt(x: int) -> int:
    # if x == 0 or x == 1:
    #     return x
    # low = 1
    # high = x
    #
    # while low < high:
    #
    #     mid = (low + high) // 2
    #     next = mid + 1
    #
    #     if mid * mid <= x and next * next > x:
    #         return mid
    #     elif mid * mid > x:
    #         high = mid
    #     else:
    #         low = mid

    currentSquareVal, i = 1, 1
    while currentSquareVal <= x:
        if currentSquareVal == x:
            return i
        i = i + 1
        currentSquareVal = i * i
    return i - 1


if __name__ == "__main__":
    print(mySqrt(36))
