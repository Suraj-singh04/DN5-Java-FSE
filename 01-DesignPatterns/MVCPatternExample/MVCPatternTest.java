public class MVCPatternTest {

    public static void main(String[] args) {

        Student model = new Student(
                        "Suraj",
                        "A"
                    );

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        controller.setStudentName(
                "Suraj Singh"
        );

        controller.updateView();
    }
}