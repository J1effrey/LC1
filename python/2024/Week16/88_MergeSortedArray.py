def merge1(nums1, m, nums2, n):
    """
    Append to end + sort
    TC: O((m+n)log(m+n))
    SC: O(n)
    """
    for i in nums2:
        nums1.append(i)
    nums1.sort()


def merge2(nums1, m, nums2, n):
    """
    Copy nums1 arr then two pointer
    TC: O(n+m)
    SC: O(m)
    """
    nums1_copy = nums1[:m]

    p1 = 0
    p2 = 0

    for i in range(m + n):
        if p2 == n or (p1 < m and nums1_copy[p1] <= nums2[p2]):
            nums1[i] = nums1_copy[p1]
            p1 += 1
        else:
            nums1[i] = nums2[p2]
            p2 += 1

def merge3(nums1, m, nums2, n):
    """
    replace from end to start
     TC: O(n+m)
    SC: O(1)
    """
    # Set p1 and p2 to point to the end of their respective arrays.
    p1 = m - 1
    p2 = n - 1

    # And move p backward through the array, each time writing
    # the smallest value pointed at by p1 or p2.
    for p in range(n + m - 1, -1, -1):
        if p2 < 0:
            break
        if p1 >= 0 and nums1[p1] > nums2[p2]:
            nums1[p] = nums1[p1]
            p1 -= 1
        else:
            nums1[p] = nums2[p2]
            p2 -= 1


if __name__ == '__main__':
    nums1 = [1, 2, 3, 0, 0, 0]
    m = 3
    nums2 = [2, 5, 6]
    n = 3
    merge1(nums1, m, nums2, n)
    print(nums1)
