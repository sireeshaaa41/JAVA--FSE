public class EmployeeManagementSystem {
    static class Employee {
        private int employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        // Getters
        public int getEmployeeId() { return employeeId; }
        public String getName() { return name; }
        public String getPosition() { return position; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return String.format("ID: %-5d | Name: %-15s | Position: %-15s | Salary: $%,8.2f",
                    employeeId, name, position, salary);
        }
    }

    static class EmployeeDatabase {
        private Employee[] employees;
        private int size;
        private int capacity;

        public EmployeeDatabase(int initialCapacity) {
            this.capacity = initialCapacity;
            this.employees = new Employee[capacity];
            this.size = 0;
        }

        // Add employee - O(1) amortized (with resizing), O(n) worst case when resizing
        public void addEmployee(Employee emp) {
            if (size == capacity) {
                resizeArray();
            }
            employees[size++] = emp;
        }

        // Linear search by ID - O(n)
        public Employee searchById(int employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId() == employeeId) {
                    return employees[i];
                }
            }
            return null;
        }

        // Traverse all employees - O(n)
        public void displayAllEmployees() {
            System.out.println("\nCurrent Employees:");
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
            System.out.println("Total employees: " + size);
        }

        // Delete employee by ID - O(n) for search + O(n) for shift = O(n)
        public boolean deleteEmployee(int employeeId) {
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId() == employeeId) {
                    index = i;
                    break;
                }
            }
            
            if (index == -1) return false;
            
            // Shift all elements after the index left by one
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[--size] = null; // Clear last reference
            return true;
        }

        // Resize array when full - O(n)
        private void resizeArray() {
            capacity *= 2;
            Employee[] newArray = new Employee[capacity];
            System.arraycopy(employees, 0, newArray, 0, size);
            employees = newArray;
        }
    }

    public static void main(String[] args) {
        // Initialize database with capacity 3 (to demonstrate resizing)
        EmployeeDatabase database = new EmployeeDatabase(3);

        // Add employees
        database.addEmployee(new Employee(101, "John Smith", "Manager", 75000.00));
        database.addEmployee(new Employee(102, "Sarah Johnson", "Developer", 65000.00));
        database.addEmployee(new Employee(103, "Michael Brown", "Designer", 60000.00));
        database.addEmployee(new Employee(104, "Emily Davis", "HR Specialist", 55000.00)); // Triggers resize

        // Display all employees
        database.displayAllEmployees();

        // Search operations
        System.out.println("\nSearching for employee 102:");
        Employee found = database.searchById(102);
        System.out.println(found != null ? found : "Employee not found");

        System.out.println("\nSearching for non-existent employee 999:");
        Employee notFound = database.searchById(999);
        System.out.println(notFound != null ? notFound : "Employee not found");

        // Delete operation
        System.out.println("\nDeleting employee 103:");
        boolean deleted = database.deleteEmployee(103);
        System.out.println(deleted ? "Employee deleted successfully" : "Employee not found");
        database.displayAllEmployees();

        // Attempt to delete non-existent employee
        System.out.println("\nAttempting to delete employee 999:");
        deleted = database.deleteEmployee(999);
        System.out.println(deleted ? "Employee deleted successfully" : "Employee not found");

        // Array representation and characteristics explanation
        System.out.println("\n--- Array Representation and Analysis ---");
        System.out.println("How arrays are represented in memory:");
        System.out.println("- Contiguous block of memory");
        System.out.println("- Elements stored sequentially");
        System.out.println("- Fixed size (though we implemented dynamic resizing)");
        System.out.println("- Direct access via index (base address + index * element size)");

        System.out.println("\nTime Complexity Analysis:");
        System.out.println("- Add employee: O(1) amortized (with resizing), O(n) worst case");
        System.out.println("- Search by ID: O(n) (linear search)");
        System.out.println("- Traverse all: O(n)");
        System.out.println("- Delete employee: O(n)");

        System.out.println("\nAdvantages of Arrays:");
        System.out.println("1. Fast random access (O(1) with known index)");
        System.out.println("2. Memory efficient (no overhead for pointers/links)");
        System.out.println("3. Cache friendly (contiguous memory improves locality)");
        System.out.println("4. Simple to implement and understand");

        System.out.println("\nLimitations of Arrays:");
        System.out.println("1. Fixed size (unless implementing dynamic resizing)");
        System.out.println("2. Insertions/deletions in middle are expensive (O(n))");
        System.out.println("3. Wasted space if allocated more than needed");
        System.out.println("4. Need to shift elements for deletions");

        System.out.println("\nWhen to Use Arrays:");
        System.out.println("- When the number of elements is known in advance");
        System.out.println("- When frequent random access is needed");
        System.out.println("- For small datasets where O(n) operations are acceptable");
        System.out.println("- When memory efficiency is critical");

        System.out.println("\nWhen to Consider Alternatives:");
        System.out.println("- For large, frequently changing datasets (consider ArrayList or LinkedList)");
        System.out.println("- When frequent insertions/deletions are needed (consider LinkedList)");
        System.out.println("- When fast search is critical (consider HashSet or TreeMap)");
    }
}
