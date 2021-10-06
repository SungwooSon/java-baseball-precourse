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

    private void judgeOneBall(String number, int ballCount) {
        if(number.indexOf(number) == ballCount)
            strike++;

        if(number.indexOf(number) != -1 && number.indexOf(number) != ballCount)
            ball++;

        if(number.indexOf(number) == -1)
            nothing++;
    }
}
