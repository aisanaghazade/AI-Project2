package P1;

/**
 * Created by aisanaghazade on 5/21/17.
 */
public class HillC_1 {

    int f = 0;
    int e = 0;
    Problem p;
    State state;
    public HillC_1(int[][] matrix, int number){
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
                boolean x = false;
                for(int i = 0; i < actions.action_set.size(); i++){
                    State ns = p.result(state, actions.action_set.elementAt(i));
                    if(ns.pathCost < state.pathCost){
                        state = ns;
                        e++;
                        x = true;
                        break;
                    }
                    f++;
                }
                if(!x)
                    state.iteration++;
            }
        }
    }

    public static void main(String [] args){
        int number = 5;
        int[][] matrix = {{0, 10, 5, 7, 4}, {10, 0, 2, 3, 7}, {5, 2, 0, 8, 8}, {7, 3, 8, 0, 5}, {4, 7, 8, 5, 0}};
        HillC_1 h = new HillC_1(matrix, number);
        h.optimization();
        System.out.println(h.state.id + "   hazine:" + h.state.pathCost +"   tolid shode:" + ""+h.f + "    gostaresh dade shode:"+h.e);
    }
}
