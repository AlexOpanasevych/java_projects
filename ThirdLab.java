import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/* ThirdLab Якщо у списку студентів є претенденти на відрахування з тих, що
 * навчаються за рахунок бюджету (прізвище, середній бал, форма навчання -
 * бюджетна, контрактна), перевести на їх місце кращих з тих, що навчається за
 * контрактом. Претендентів на відрахування занести у текстовий файл.
 */
public class ThirdLab {
    private static ArrayList<String> set;

    static class Students implements Comparable<Students> {
        String secondName;
        int averageScore;
        String formEd;
        @Override
        public int compareTo(Students another) {
            return (this.averageScore > another.averageScore) ? -1 : 1;
        }
    };

    public static ArrayList<Students> scanFile(String filename) throws FileNotFoundException {
        ArrayList<Students> students = new ArrayList<Students>();
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            Students student = new Students();
            student.secondName = sc.next();
            student.averageScore = sc.nextInt();
            student.formEd = sc.next();
            students.add(student);
        }
        sc.close();
        return students;
    }

    public static void createSet() {
        set = new ArrayList<String>();
        String input;
        while (!((input = System.console().readLine()).equals(""))) {
            set.add(input);
        }
    }

    public static ArrayList<Students> parseStrings() {
        ArrayList<Students> students = new ArrayList<Students>();
        for (String infoAbout : set) {
            String[] words = infoAbout.split("\\s");
            Students student = new Students();
            student.secondName = words[0];
            student.averageScore = Integer.parseInt(words[1]);
            student.formEd = words[2];
            students.add(student);
        }
        return students;
    }

    public static void printStudents(ArrayList<Students> students) {
        for (Students var : students) {
            System.out.print("Second name: " + var.secondName);
            System.out.print(" Average score: " + Integer.toString(var.averageScore));
            System.out.print(" Form of education: " + var.formEd);
            System.out.print('\n');
        }
    }

    public static void createFile(ArrayList<Students> students, String filename) throws IOException {
        File file = new File(filename);
        FileWriter fw = new FileWriter(file);
        for (Students var : students) {
            fw.write(var.secondName + " ");
            fw.write(Integer.toString(var.averageScore) + " ");
            fw.write(var.formEd);
            fw.write(System.lineSeparator());
        }
        fw.close();
    }

    public static void sortByAverageAndFormEd(ArrayList<Students> students) throws IOException {
        ArrayList<Students> students_budget = new ArrayList<Students>();
        ArrayList<Students> students_contract = new ArrayList<Students>();
        int counter = 0;
        FileWriter fWriter = new FileWriter("otchislen.txt");
        for (Students var : students) {
            if (var.formEd.equals("budget") && var.averageScore >= 60) {
                students_budget.add(var);
            } else {
                if (var.formEd.equals("budget")) {
                    var.formEd = "contract";
                    fWriter.write("applicants for deductions:");
                    fWriter.write(System.lineSeparator());
                    fWriter.write(var.secondName + " ");
                    fWriter.write(Integer.toString(var.averageScore) + " ");
                    fWriter.write(var.formEd);
                    fWriter.write(System.lineSeparator());
                }
                students_contract.add(var);
                counter++;
            }
        }
        Collections.sort(students_contract);
        for (int i = 0; i < counter - 1; i++) {
            students_contract.get(i).formEd = "budget";
            students_budget.add(students_contract.get(i));
            students_contract.remove(students_contract.get(i));
        }
        Collections.sort(students_budget);
        printStudents(students_budget);
        printStudents(students_contract);
        fWriter.close();
    }
    public static void main(String[] args) throws IOException {
        createSet();
        ArrayList<Students> students = new ArrayList<Students>();
        students = parseStrings();
        /*try {
            students = scanFile("students.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        
        printStudents(students);
        sortByAverageAndFormEd(students);
        try {
            createFile(students, "students.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}