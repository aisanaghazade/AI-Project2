package P1;

import java.util.Random;
import java.util.Vector;

/**
 * Created by aisanaghazade on 5/21/17.
 */
public class HillC_2 {

    int f = 0;
    int e = 0;
    Problem p;
    State state;
    public HillC_2(int[][] matrix, int number){
        p = new Problem(matrix, number);
        f++;
        state = p.initState;
    }

    public void optimization(){
        while(true){
            if(p.GoalTest(state)){
                return;
            }else{
                Action_set actions = p.actions(state);
                Vector<State> v = new Vector<State>();
                for(int i = 0; i < actions.action_set.size(); i++){
                    State ns = p.result(state, actions.action_set.elementAt(i));
                    if(ns.pathCost < state.pathCost){
                        v.add(ns);
                    }
                    f++;
                }
                if(v.size()>0){
                    Random r = new Random();
                    int x = r.nextInt(v.size()-1);
                    state = v.elementAt(x);
                    e++;
                }else{
                    state.iteration++;
                }
            }
        }
    }

    public static void main(String [] args){
        int number = 5;
        int[][] matrix = {{0, 10, 5, 7, 4}, {10, 0, 2, 3, 7}, {5, 2, 0, 8, 8}, {7, 3, 8, 0, 5}, {4, 7, 8, 5, 0}};
        HillC_2 h = new HillC_2(matrix, number);
        h.optimization();
        System.out.println(h.state.id + "   hazine:" + h.state.pathCost +"   tolid shode:" + ""+h.f + "    gostaresh dade shode:"+h.e);
    }
}
