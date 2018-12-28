package P1;

/**
 * Created by aisanaghazade on 5/20/17.
 */
public class State {
    char[]  path;
    int pathCost;
    String id = "";
    int iteration;
    public State(char[] path, Problem p, int iteration){

        this.path = new char[path.length];
        this.iteration = iteration + 1;
        for(int i = 0; i < path.length; i++){
            this.path[i] = path[i];
            id += "" + path[i];
        }
        pathCost = 0;
        for (int i = 0; i < path.length - 1; i++){
            int k = (int)(path[i]) - 65;
            int l = (int)(path[i+1]) -65;
            pathCost += p.matrix[l][k];
        }

    }

}
