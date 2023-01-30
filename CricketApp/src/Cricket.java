import java.util.Scanner;

public class Cricket
{
    int balls=10;
    public void matchController()
    {
        System.out.println("Lets start the game");
        System.out.println("Please enter the name of Team1 ");
        Scanner s = new Scanner(System.in);
        String str1=s.nextLine();
        System.out.println("Please enter the name of Team2 ");
        String str2=s.nextLine();

        // call constructor with string in it for setting up the name.
        Team t1=new Team(str1);
        Team t2=new Team(str2);

//        System.out.println();

        // name,score,wickets
        System.out.println("Toss happening");

        int x = ScoreTossGenerator.getToss();

        if(x==1)
            System.out.println(t1.name+ " has won the toss and choose 1 for batting or 2 for bowling");
        else
            System.out.println(t2.name+ " has won the toss and choose 1 for batting or 2 for bowling");

        int n = s.nextInt();

        // in case if anyone enters a wrong number.
        while(!(n==1 || n==2))
        {
            System.out.println("Sorry you entered a wrong number");
            s = new Scanner(System.in);
            n = s.nextInt();
            if(n==1 || n==2) break;
        }

        int[] arr1;
        int[] arr2;

        if((x==1 && n==1) || (x==2 && n==2))
        {
            if(x==1){
                System.out.println(t1.name + " have won the toss and elected to bat first");
            }
            else
                System.out.println(t2.name + " have won the toss and elected to bowl first");

            arr1=scoreFinal(t1);
            arr2=scoreFinal(t2);
        }
        else
        {
            if(x==1){
                System.out.println(t1.name + " have won the toss and elected to bowl first");
            }
            else
                System.out.println(t2.name + " have won the toss and elected to bat first");

            arr2=scoreFinal(t2);
            arr1=scoreFinal(t1);
        }

        t1.setScore(arr1[0]);
        t1.setWickets(arr1[1]);

        t2.setScore(arr2[0]);
        t2.setWickets(arr2[1]);

        if(t1.getScore()>t2.getScore())
            System.out.println(t1.name+ " wins over "+t2.name);
        else System.out.println(t2.name+ " wins over "+t1.name);
    }
    // method to calculate final score of each team
    int[] scoreFinal(Team t)
    {
        int i=0;
        while(t.getWickets()<10 && i<balls)
        {
            int x=ScoreTossGenerator.getRuns();
            if(x==7)
                t.setWickets(t.getWickets()+1);
            else
                t.setScore(t.getScore()+x);

            System.out.println(t.name + " has a score of "+ t.getScore()+"/"+t.getWickets());
            i++;
        }
        int[] arr= new int[2];
        arr[0]=t.getScore();
        arr[1]=t.getWickets();
        return arr;
    }

}
