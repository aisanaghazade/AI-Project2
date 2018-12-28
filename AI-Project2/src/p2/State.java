package p2;

/**
 * Created by aisanaghazade on 5/20/17.
 */
public class State {
    int[]  path;
    int pathCost;
    int values;
    String id = "";
    int iteration;
    public State(int[] path, Problem p, int iteration){
        this.path = new int [path.length];
        pathCost = 0;
        values = 0;
        this.iteration = iteration + 1;
        for(int i = 0; i < path.length; i++){
            pathCost += path[i]*p.weight[i];
            id += ""+path[i];
            values += path[i] * p.value[i];
        }

    }

}
