
# Brute Force Approach
""" Brute Force Solution:
        T.C: O(1)
        S.C: O(1)

        This approach involves implementing an array where the length is equal to the number of inputs plus one.
        For example, if we have 7 inputs, the range of possible values is from 0 to 7.
        To store numbers from 0 to 7, we would need an array of size 8.

        Problem with the brute force approach:

        Let's consider an example where the input is [2, 999]. Although the list itself is small, the large value in the input (999) would require creating a significantly larger array. This leads to higher space complexity.
    """
# Code


class MyHashSetApproach1:

    def __init__(self):
        # Use a direct-address table for brute force
        self.size = 10**6 + 1  # Support keys up to 10^6
        self.hashSet = [None] * self.size

    def add(self, key: int) -> None:
        self.hashSet[key] = key

    def remove(self, key: int) -> None:
        self.hashSet[key] = None

    def contains(self, key: int) -> bool:
        return self.hashSet[key] is not None

# Optimized Approach

        """ In this approach, I aim to reduce the size of the array. In the earlier approach, the array size was 10^6 + 1 However, I can reduce the size to 10^3 using a collision reduction technique called double hashing.
        In double hashing, I use the first hash function as the modulus operator (mod) to get values between 0 and 10^3 - 1
        At each of these indices, I define a local boolean array of size 10^3.
        In the worst-case scenario, if I have 10^6 keys to add, I would end up using all the space in the 2D array. However, collisions typically occur only when keys are duplicates. In such cases, a secondary array is created only when a collision occurs.

        Time Complexity (T.C.): O(1)
        Space Complexity (S.C.):O(1)(but logically more efficient than the first approach)
        """


class MyHashSetApproach2:

    def __init__(self):
        self.size = 10**3+1
        self.array = [None] * self.size

    def firstHashing(self, key: int) -> int:
        return key % self.size

    def secondHashing(self, key: int) -> int:
        return key // self.size

    def initializeSecond(self, index: int) -> None:
        # at the given index create boolen array of self.size
        # initialize all values to False
        self.array[index] = [False] * self.size

    def add(self, key: int) -> None:
        # get index
        first_index = self.firstHashing(key)
        second_index = self.secondHashing(key)

        # check whats there at that index
        if self.array[first_index] is None:
            # define seconday array a that index
            self.initializeSecond(first_index)

        self.array[first_index][second_index] = True

    def remove(self, key: int) -> None:
        # get index
        first_index = self.firstHashing(key)
        second_index = self.secondHashing(key)

        # first ccheck if its available
        is_available = self.contains(key)

        if is_available:
            self.array[first_index][second_index] = False

    def contains(self, key: int) -> bool:
        # get index
        first_index = self.firstHashing(key)
        second_index = self.secondHashing(key)

        return self.array[first_index] is not None and self.array[first_index][second_index]

# Further Optimization:

        """the largest key we have is 10^6 and it will always fall on 0th place 
        because 10^6 % 10^3 = 0 so sonly at 0th index we need the secondary array of size 10^6 + 1 otherwise, 10^6 works
        """


class MyHashSet:

    def __init__(self):
        self.size = 10**3
        self.array = [None] * self.size

    def firstHashing(self, key: int) -> int:
        return key % self.size

    def secondHashing(self, key: int) -> int:
        return key // self.size

    def initializeSecond(self, index: int) -> None:
        # at the given index create boolen array of self.size
        # initialize all values to False
        if not index:
            # if index is zero
            self.array[index] = [False] * (self.size + 1)
        else:
            self.array[index] = [False] * self.size

    def add(self, key: int) -> None:
        # get index
        first_index = self.firstHashing(key)
        second_index = self.secondHashing(key)

        # check whats there at that index
        if self.array[first_index] is None:
            # define seconday array a that index
            self.initializeSecond(first_index)

        self.array[first_index][second_index] = True

    def remove(self, key: int) -> None:
        # get index
        first_index = self.firstHashing(key)
        second_index = self.secondHashing(key)

        # first ccheck if its available
        is_available = self.contains(key)

        if is_available:
            self.array[first_index][second_index] = False

    def contains(self, key: int) -> bool:
        # get index
        first_index = self.firstHashing(key)
        second_index = self.secondHashing(key)

        return self.array[first_index] is not None and self.array[first_index][second_index]
