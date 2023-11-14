package CodSoft;
import java.util.Scanner;
public class studentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of the subjects: ");
        int nSub = sc.nextInt();

        int totalMarks = 0;
        for(int i = 1; i <= nSub; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = sc.nextInt();
            totalMarks += marks;
        }

        double avgPer = (double) totalMarks / nSub;

        String grade;
        if(avgPer >= 90) {
            grade = "O";
        } else if(avgPer >= 80) {
            grade = "A";
        } else if(avgPer >= 70) {
            grade = "B";
        } else if(avgPer >= 60) {
            grade = "C";
        } else if(avgPer >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + avgPer);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}