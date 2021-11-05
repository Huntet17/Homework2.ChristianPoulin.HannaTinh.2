public class LegoRobotResult implements IResult{

    LegoRobotTeam team1;
    LegoRobotTeam team2;
    double team1points;
    double team2points;
    int team1tasks;
    int team2tasks;
    boolean team1fell;
    boolean team2fell;
    IResult contestant;

    public LegoRobotResult(LegoRobotTeam team1, LegoRobotTeam team2,
                    double team1points, int team1tasks, boolean team1fell,
                    double team2points, int team2tasks, boolean team2fell) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1points = team1points;
        this.team2points = team2points;
        this.team1tasks = team1tasks;
        this.team2tasks = team2tasks;
        this.team1fell = team1fell;
        this.team2fell = team2fell;
    }

    public boolean isValid(){
        if(((this.team1tasks < 8) && (this.team2tasks < 8)) &&
                ((this.team1points <= 16) && (this.team2points <= 16)))
            return true;
        else
            return false;
    }

    public double getScore(double numOfPoints, int tasks, boolean robotFell){
        double finalScore;
        finalScore = numOfPoints + tasks;
        if (robotFell) {
            finalScore -= 5;
        }
        return finalScore;
    }

    public LegoRobotTeam getWinner(){
        if(getScore(this.team1points, this.team1tasks, this.team1fell) >
                getScore (this.team2points, this.team2tasks, this.team2fell)){
            return this.team1;
        } else
            return this.team2;
    }
}


