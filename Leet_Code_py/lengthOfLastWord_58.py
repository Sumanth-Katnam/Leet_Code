def lengthOfLastWord(s: str) -> int:
    words = list(filter(lambda a: a != '', s.split(" ")))
    return len(words[-1])


if __name__ == "__main__":
    print(lengthOfLastWord("   fly me   to   the moon  "))
