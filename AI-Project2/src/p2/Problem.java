package p2;

import java.util.Random;

/**
 * Created by aisanaghazade on 5/20/17.
 */
public class Problem {
    State initState;
    int [] weight;
    int [] value;
    int number;
    int maxw;
    public Problem(int[] wight, int[]value, int number, int maxw){

        this.weight = wight;
        this.number = number;
        this.maxw = maxw;
        this.value = value;
        initState = initialState();
    }

    public State initialState(){
        Random r = new Random();
        int i = r.nextInt(number-1);
        int [] path = new int[number];
        for(int j = 0; j < number; j++){
            path[j] = 0;
        }
        path[i] = 1;
        State s = new State(path, this, 0);
        return s;
    }

    public boolean GoalTest(State s){
        if(s.iteration > 1000)
            return true;
        else
            return false;
    }


    public int pathCost(State s){
        return s.pathCost;
    }




}
