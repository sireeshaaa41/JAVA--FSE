OUTPUT
Library Catalog:
ID: B1003  | Title: The Great Gatsby       | Author: F. Scott Fitzgerald 
ID: B1001  | Title: To Kill a Mockingbird  | Author: Harper Lee         
ID: B1005  | Title: 1984                   | Author: George Orwell      
ID: B1002  | Title: Pride and Prejudice    | Author: Jane Austen       
ID: B1004  | Title: The Hobbit             | Author: J.R.R. Tolkien    

[Search for '1984']
Performing Linear Search for: 1984
Comparisons made: 3
Linear Search Result: ID: B1005  | Title: 1984 | Author: George Orwell

Performing Binary Search for: 1984
Comparisons made: 3
Binary Search Result: ID: B1005  | Title: 1984 | Author: George Orwell

[Search for 'Non-existent Book']
Performing Linear Search for: Non-existent Book
Comparisons made: 5
Linear Search Result: null

Performing Binary Search for: Non-existent Book
Comparisons made: 3
Binary Search Result: null

Search Algorithm Analysis:
Linear Search:
- Time Complexity: O(n) in all cases
- Works on unsorted data
- Simple implementation
- Efficient for small datasets

Binary Search:
- Time Complexity: O(log n) in average and worst case
- Requires sorted data (O(n log n) preprocessing)
- More complex implementation
- Much more efficient for large datasets
