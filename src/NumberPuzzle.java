import java.util.ArrayList;
import java.util.Arrays;

public class NumberPuzzle implements Puzzle
{
    private ArrayList<Integer> display = new ArrayList<>();

    private ArrayList<Integer> solution = new ArrayList<>();

    private int length;

    private boolean isSolved = false;

    //Constructs NumberPuzzle Object with solution
    public NumberPuzzle(int length)
    {
        this.length = length;

        for(int i = 0; i < length; i++)
        {
            solution.add((int)((Math.random()*(10))) + 1);
        }
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
    public int getLength()
    {
        return length;
    }
}
