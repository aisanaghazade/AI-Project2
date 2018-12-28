package p2;

import java.util.Vector;

/**
 * Created by aisanaghazade on 5/21/17.
 */
public class genetic {
    int[] wight;
    int[]value;
    int number;
    int maxw;
    Problem p ;
    Vector<State> cs;
    Vector<State> ns;
    public genetic(int[] wight, int[]value, int number, int maxw){
        this.wight = wight;
        this.value = value;
        this.number = number;
        this.maxw = maxw;
        p =  new Problem(wight,value, number, maxw);
        cs = new Vector<State>();
        ns = new Vector<State>();
        for(int i = 0; i < 20; i++){
            cs.add(p.initialState());
        }


    }

    public void optimization(){
        while(true){
            if(p.GoalTest(cs.elementAt(0))){
                return;
            }else{
                boolean b = false;
                while(cs.size()>0){
                    State s1 = cs.elementAt(0);
                    int x = 0;
                    int [] p1 = new int[p.number];
                    int k = 0;
                    for(int i = 1; i < cs.size(); i++){
                        for(int j = 0; j < p.number/2; j++){
                            p1[j] = s1.path[j];
                            x += p1[j] * wight[j];
                        }
                        for (int j = p.number/2; j < number; j++){
                            p1[j] = cs.elementAt(i).path[j];
                            x += p1[j] * wight[j];
                        }
                        if(x <= maxw){
                            b = true;
                            k = i;
                            break;
                        }
                    }
                    if(b){
                        ns.add(cs.elementAt(0));
                        ns.add(cs.elementAt(k));
                        ns.add(new State(p1, p, cs.elementAt(0).iteration));

                        ns.removeElementAt(0);
                        ns.removeElementAt(k);
                    }else{
                        ns.add(cs.elementAt(0));
                        cs.removeElementAt(0);
                    }
                }
                for(int i = 0; i < 20; i++){
                    int v = 0;
                    int v1 = 10000000;
                    int v2 = 0;
                    int k = 0;
                    int t = 0;
                    for (int j = 0; j < ns.size(); j++){
                        v2 += ns.elementAt(j).values;
                        if(ns.elementAt(j).values >= v){
                            k = j;
                            v = ns.elementAt(k).values;
                        }
                        if(ns.elementAt(j).values < v1) {
                            v1 = ns.elementAt(j).values;
                        }
                    }
                    for(int l = 0; l < number; l++){
                        if(1/l > Math.random()){
                            if(ns.elementAt(k).path[l] == 1)
                                ns.elementAt(k).path[l] = 0;
                            else{
                                int pc = 0;
                                for(int m = 0; m < number; m++){
                                    pc+= p.value[m]*ns.elementAt(k).path[m];
                                }
                                pc+= p.value[l];
                                if(pc <= maxw)
                                    ns.elementAt(k).path[l] = 1;
                            }
                        }
                    }
                    cs.add(new State(ns.elementAt(k).path, p, ns.elementAt(k).iteration));
                    if(i == 0){
                        v2 = v2 / ns.size();
                        System.out.println("behtarin:"+v+"  badtarin:"+v1+"     motevaset:"+v2);
                    }
                    ns.removeElementAt(k);

                }
                ns.clear();
            }
        }
    }

    public static void main(String[] args){
        int [] weight = {10,12,3,6,9};
        int [] value = {12,14,9,12,14};

        genetic g = new genetic(weight,value,5,25);
        g.optimization();
        System.out.print(g.cs.elementAt(0).id);

    }
}
