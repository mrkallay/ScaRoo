import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner.*;

public class NumberPuzzleTestClass
{
    public static void main(String[] args) {
        ArrayList<Integer> solution = new ArrayList();
        solution.add(1);
        solution.add(2);
        solution.add(3);

        NumberPuzzle thePuzzle = new NumberPuzzle(solution);
        int numberInput = -100;

        for (int i = 0; i < solution.size(); i++)
        {
            Scanner numberInputScanner = new Scanner(System.in);
            System.out.println("INPUT CODE COMBINATION OR INPUT 'reset' to clear your code");
            numberInput = numberInputScanner.nextInt();
            thePuzzle.setAnswer(i, numberInput);
        }

        if (thePuzzle.checkSolution())
        {
            System.out.println("Congrats, you solved the puzzle");
        }
        else {
            System.out.println("You failed");
        }

    }
}
