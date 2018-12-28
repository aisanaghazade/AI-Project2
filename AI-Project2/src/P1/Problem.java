package P1;

/**
 * Created by aisanaghazade on 5/20/17.
 */
public class Problem {
    State initState;
    int [][] matrix;
    int number;
    public Problem(int[][] matrix, int number){

        this.matrix = matrix;
        this.number = number;
        initState = initialState();
    }

    public State initialState(){
//        System.out.print(number);
        char[] path = new char[number+1];
        for(int i = 0; i < number; i++){
            path[i] = (char)(65+i);
        }
        path[number] = 'A';
        State s = new State(path, this, 0);
//        System.out.print(path.length);
//        System.out.print(s.id);
        return s;

    }

    public boolean GoalTest(State s){
        if(s.iteration > 1000)
            return true;
        else
            return false;
    }

    public Action_set actions(State s){
        Action_set actionset = new Action_set();
//        System.out.println(s.path.length);
        for(int i = 1; i < s.path.length-2; i++){
            for(int j = i+1; j < s.path.length-1; j++){
//                System.out.print(i + ""+j);
                Action a = new Action(i, j);
//                System.out.println(a.i+""+a.j);
                actionset.action_set.add(a);
            }
        }
//        System.out.println(actionset.action_set.size());
        return actionset;
    }

    public State result(State s, Action a){
        char[] c = new char[s.path.length];
        for(int i = 0; i < s.path.length; i++)
            c[i] = s.path[i];
//        System.out.print(""+a.i + " " + a.j);
        char c1 = c[a.i];
        c[a.i] = c[a.j];
        c[a.j] = c1;
        State sate = new State(c, this, s.iteration);
        return sate;
    }

    public int pathCost(State s){
        return s.pathCost;
    }

    public int ActionCost(Action a){
        return 1;
    }


}
