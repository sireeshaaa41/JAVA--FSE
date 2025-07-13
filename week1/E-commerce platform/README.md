OUTPUT
Available Products:
ID: P1003  | Name: Wireless Mouse   | Category: Electronics | Price: $24.99
ID: P1001  | Name: Bluetooth Speaker | Category: Electronics | Price: $59.99
ID: P1005  | Name: Mechanical Keyboard | Category: Electronics | Price: $89.99
ID: P1002  | Name: Yoga Mat         | Category: Fitness     | Price: $29.99
ID: P1004  | Name: Water Bottle     | Category: Fitness     | Price: $12.99

[Best Case Scenario - First Element]
Performing Linear Search for ID: P1001
Comparisons made: 2
Linear Search Result: ID: P1001  | Name: Bluetooth Speaker | Category: Electronics | Price: $59.99

Performing Binary Search for ID: P1001
Comparisons made: 2
Binary Search Result: ID: P1001  | Name: Bluetooth Speaker | Category: Electronics | Price: $59.99

[Worst Case Scenario - Last Element]
Performing Linear Search for ID: P1005
Comparisons made: 3
Linear Search Result: ID: P1005  | Name: Mechanical Keyboard | Category: Electronics | Price: $89.99

Performing Binary Search for ID: P1005
Comparisons made: 3
Binary Search Result: ID: P1005  | Name: Mechanical Keyboard | Category: Electronics | Price: $89.99

Algorithm Analysis:
Linear Search Time Complexity:
- Best case: O(1) (first element)
- Average case: O(n/2) ≈ O(n)
- Worst case: O(n) (last element or not present)

Binary Search Time Complexity:
- Best case: O(1) (middle element)
- Average case: O(log n)
- Worst case: O(log n)
