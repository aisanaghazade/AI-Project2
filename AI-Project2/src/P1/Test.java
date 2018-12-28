package P1;

/**
 * Created by aisanaghazade on 5/21/17.
 */
public class Test {

    public static void main(String[] args){
        char[] path = {'A', 'B', 'C' , 'D' , 'E', 'A'};
        int pathCost = 0;
        int[][] matrix = {{0, 10, 5, 7, 4}, {10, 0, 2, 3, 7}, {5, 2, 0, 8, 8}, {7, 3, 8, 0, 5}, {4, 7, 8, 5, 0}};
        for (int i = 0; i < path.length - 1; i++){
            int k = (int)(path[i]) - 65;
            int l = (int)(path[i+1]) -65;
            pathCost += matrix[l][k];
        }
//        System.out.print(pathCost);
        for(int i = 0; i < 10; i++)
            System.out.println(Math.random());
    }
}
