import java.util.ArrayList;
import java.util.Arrays;

public class NumberPuzzle implements Puzzle
{
    private ArrayList<Integer> display = new ArrayList<>();

    private ArrayList<Integer> solution;

    private boolean isSolved = false;

    //Constructs NumberPuzzle Object with solution
    public NumberPuzzle(ArrayList<Integer> solution)
    {
        this.solution = solution;
    }

    //Checks solution
    @Override
    public boolean checkSolution()
    {
        if(solution.equals(display))
        {
            isSolved = true;
            return true;
        }
        else {
            return false;
        }
    }

    //Returns if the Puzzle is solved
    @Override
    public boolean isSolved()
    {
        return isSolved;
    }

    //Sets the internal arraylist with an value and index
    public void setAnswer(int index, int value)
    {
        display.add(index,value);
    }

    //Gets a value with a given index
    public int getAnswer(int index)
    {
        return display.get(index);
    }

    //Reset display
    public void resetDisplay()
    {
        display.clear();
    }
}
