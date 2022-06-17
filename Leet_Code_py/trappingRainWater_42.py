def trap(height: list[int]) -> int:

    def get_volume(heights: list[int], max_height: int) -> int:
        volume = 0
        for h in heights:
            volume += max_height - h
        
        return volume

    start, end = -1, -1
    volume = 0 
    height_stack = []
    for h in height:
        if start == -1:
            start = h
        elif h >= start:
            end = h
            
            # Calculate volume
            volume += get_volume(height_stack, min(start, end))

            # reset 
            start = h
            end = -1
            height_stack = []
        else:
            height_stack.append(h)

    # need to handle the rest of them
    if len(height_stack):
        rev = height_stack[::-1]
        rev.append(start)
        volume += trap(rev)
    return volume


def trap_two_pointers(height: list[int]) -> int:
    l, r = 0, len(height) - 1
    volume = 0
    l_max, r_max = 0, 0
    while l < r :
        if height[l] < height[r]:
            if (height[l] >= l_max): 
                l_max = height[l] 
            else: 
                volume = volume + (l_max - height[l])
            l += 1
        
        else:
            if height[r] >= r_max: 
                r_max = height[r]
            else:
                volume += (r_max - height[r])
            r -= 1
    return volume

if __name__ == "__main__":
    print(trap([1,3,2,4,1,3,1,4,5,2,2,1,4,2,2]))
    print(trap([0,1,0,2,1,0,1,3,2,1,2,1]))
    print(trap([4,2,0,3,2,5]))

    print(trap_two_pointers([1,3,2,4,1,3,1,4,5,2,2,1,4,2,2]))
    print(trap_two_pointers([0,1,0,2,1,0,1,3,2,1,2,1]))
    print(trap_two_pointers([4,2,0,3,2,5]))