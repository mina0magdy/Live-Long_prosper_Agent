package AI;

import AI.Operator;

import java.util.ArrayList;

public class Problem {
    private ArrayList<Operator>operators;
    private State initialState;
    private final int goalTest=100;

    public Problem(ArrayList<Operator> operators, State initialState) {
        this.operators = operators;
        this.initialState = initialState;
    }

    public ArrayList<Operator> getOperators() {
        return operators;
    }

    public void setOperators(ArrayList<Operator> operators) {
        this.operators = operators;
    }

    public State getInitialState() {
        return initialState;
    }

    public void setInitialState(State initialState) {
        this.initialState = initialState;
    }

    public int getGoalTest() {
        return goalTest;
    }
}
