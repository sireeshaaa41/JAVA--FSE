
class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}


class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("\nStudent Details:");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Grade: " + student.getGrade());
        System.out.println("---------------------");
    }
}

class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentId(String id) {
        model.setId(id);
    }

    public String getStudentId() {
        return model.getId();
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model);
    }
}


public class MVCPatternExample {
    public static void main(String[] args) {
       
        Student model = new Student("S001", "John Doe", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

     
        System.out.println("Initial Student Record:");
        controller.updateView();

       
        System.out.println("\nUpdating student record...");
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade("B+");

     
        System.out.println("\nUpdated Student Record:");
        controller.updateView();

        
        System.out.println("\nGetting individual attributes:");
        System.out.println("ID: " + controller.getStudentId());
        System.out.println("Name: " + controller.getStudentName());
        System.out.println("Grade: " + controller.getStudentGrade());
    }
}
