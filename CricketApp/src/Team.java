public class Team {
    Team(String s){
        name=s;
    }
    String name;
    private int score;

    private int wickets;

    // getter and setter for score
    public void setScore(int x)
    {
        score=x;
    }
    public int getScore()
    {
        return score;
    }
    // getter and setter for wickets
    public void setWickets(int x)
    {
        wickets=x;
    }
    public int getWickets()
    {
        return wickets;
    }


}
