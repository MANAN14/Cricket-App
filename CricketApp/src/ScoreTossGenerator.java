import java.util.Random;

public class ScoreTossGenerator {
    static int getRuns(){
        int x=(int)(Math.random()*8);
        return x;
    }
    static int getToss()
    {
        double x=Math.random();
        if(x<0.5) {
            return 1;
        } else {
            return 2;
        }
    }
}
