import java.util.ArrayList;
import java.util.Arrays;

public class NumberPuzzle implements Puzzle{

    ArrayList<Integer> display = new ArrayList<>();

    ArrayList<Integer> solution;

    boolean isSolved = false;

    //Constructs NumberPuzzle Object with solution
    public NumberPuzzle(ArrayList<Integer> solution){
        this.solution = solution;
    }

    //Checks solution
    @Override
    public boolean checkSolution() {
        if(solution.equals(display)){
            isSolved = true;
            return true;
        }
        else{
            return false;
        }
    }

    //Returns if the Puzzle is solved
    @Override
    public boolean isSolved() {
        return isSolved;
    }

    //Sets the internal arraylist with an value and index
    public void setAnswer(int index, int value) {
        display.set(index,value);
    }

    //Gets a value with a given index
    public int getAnswer(int index){
        return display.get(index);
    }


}
