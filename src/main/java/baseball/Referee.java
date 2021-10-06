package baseball;

public class Referee {
    private String number;
    private int strike;
    private int ball;
    private int nothing;

    public Referee(String number) {
        this();
        this.number = number;
    }

    public Referee() {
        this.strike = 0;
        this.ball = 0;
        this.nothing = 0;
    }

    public void judge(String inputUserNumbers) {
        for(int ballCount=0; ballCount<3; ballCount++) {
            String oneUserNumber = String.valueOf(inputUserNumbers.charAt(ballCount));
            judgeOneBall(oneUserNumber, ballCount);
        }
    }

    private void judgeOneBall(String oneUserNumber, int ballCount) {
        if(number.indexOf(oneUserNumber) == ballCount)
            strike++;

        if(number.indexOf(oneUserNumber) != -1 && number.indexOf(oneUserNumber) != ballCount)
            ball++;

        if(number.indexOf(oneUserNumber) == -1)
            nothing++;
    }

    public boolean isThreeStrike() {
        return strike==3?true:false;
    }

    public void initBallCount() {
        this.strike = 0;
        this.ball = 0;
        this.nothing = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getNothing() {
        return nothing;
    }
}
