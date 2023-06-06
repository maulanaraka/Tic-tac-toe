import java.util.*;
public class checkwin {
    
    public String equalArrays(int []f ,int [] g){
        //duplicate player array
        int[] player = {0,0,0};
        for (int x=0;x<3;x++){
            player[x]=f[x];
        }

        //sort array player and win condition
        Arrays.sort(player);
        Arrays.sort(g);
        if (Arrays.equals(player, g)){
            return "Player win";
        }
        return " ";
    }
}
