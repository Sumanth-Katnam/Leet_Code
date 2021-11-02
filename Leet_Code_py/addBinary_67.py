def addBinary(a: str, b: str) -> str:
    # i, carry, ans = 0, 0, []
    # a, b = a[::-1], b[::-1]
    # while i < len(a) or i < len(b):
    #     res = carry + (int(a[i]) if i < len(a) else 0) + (int(b[i]) if i < len(b) else 0)
    #     ans.append(str(res % 2))
    #     carry = res // 2
    #     i += 1
    # if carry: ans.append('1')
    # return ''.join(ans[::-1])

    # c = int(a, 2) + int(b, 2)
    # return f'{c:b}'

    return str(bin(int(a, 2) + int(b, 2))).replace('0b', '')


if __name__ == "__main__":
    print(addBinary("11011", "11011"))
