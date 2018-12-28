package P1;

import java.util.Random;
import java.util.Vector;

/**
 * Created by aisanaghazade on 5/21/17.
 */
public class SA_2 {
    double T = 1000;
    double p = 1;
    int f = 0;
    int e = 0;
    Problem problem;
    Vector<State> s;
    Vector<State> r;
    State state;
    public SA_2(int[][] matrix, int number){
//        System.out.print(number);
        problem = new Problem(matrix, number);
        s = new Vector<State>();
        r = new Vector<State>();
        s.add(problem.initState);
        f++;
        state = problem.initState;
    }

    public void optimization(){
        while(true){
            if(problem.GoalTest(state)){
                return;
            }else{

                Action_set actions = problem.actions(state);
//                System.out.print(actions.action_set.size());
                Random r = new Random();
                int x = r.nextInt(actions.action_set.size()-1);
                f++;
//                    System.out.println(actions.action_set.elementAt(i).i+" "+actions.action_set.elementAt(i).j);
                State ns = problem.result(state, actions.action_set.elementAt(x));
//                System.out.println(ns.id);
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e1) {
//                        e1.printStackTrace();
//                    }
                if(state.pathCost > ns.pathCost) {
                    state = ns;
                    e++;
                }else {
                    double rnd = Math.random();
                    p = Math.exp((double) ((ns.pathCost - state.pathCost) / T));
                    System.out.println(p);
                    if (rnd > p) {
                        state = ns;
                        e++;
                    }else{
                        state.iteration++;
                    }
                }


                T = T * Math.pow(0.1, state.iteration);
            }
        }
    }

    public static void main(String[] args){
        int number = 5;
        int[][] matrix = {{0, 10, 5, 7, 4}, {10, 0, 2, 3, 7}, {5, 2, 0, 8, 8}, {7, 3, 8, 0, 5}, {4, 7, 8, 5, 0}};
        SA_2 s = new SA_2(matrix, number);
        s.optimization();
//        for(int i = 0; i < s.state.path.length; i++)
//            System.out.print(s.state.path[i]);
        System.out.println(s.state.id + "   hazine:" + s.state.pathCost +"   tolid shode:" + ""+s.f + "    gostaresh dade shode:"+s.e);
    }
}
