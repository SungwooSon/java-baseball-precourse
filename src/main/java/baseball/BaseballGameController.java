package baseball;

import nextstep.utils.Randoms;

public class BaseballGameController {
    final private String CONTINUE = "1";
    final private int NUMBER_LENGTH = 3;

    private StringBuilder generatedNumberString;
    private Referee referee;

    void run() {
        do {
            initGame();
            startGame();
        }while(isStopOrRestart());
    }

    private void initGame() {
        generatedNumberString = new StringBuilder();
        referee = new Referee(generateNumberString());
    }

    private String generateNumberString() {
        for(int i=0; i<NUMBER_LENGTH; i++) {
            generatedNumberString.append(getOneRandomNumber());
        }
        return generatedNumberString.toString();
    }

    private int getOneRandomNumber() {
        int pickedNumber = Randoms.pickNumberInRange(1, 9);
        if(isDuplicate(pickedNumber)) {
            pickedNumber = getOneRandomNumber();
        }
        return pickedNumber;
    }

    private boolean isDuplicate(int number) {
        return generatedNumberString.toString().contains(String.valueOf(number));
    }

    private void startGame() {
        do{
            referee.initBallCount();
            String inputUserNumber = Prompter.queryForUserInputNumber();
            referee.judge(inputUserNumber);
            Prompter.printResult(referee);
        }while(!referee.isThreeStrike());
    }

    private boolean isStopOrRestart() {
        return Prompter.queryForContinuousGame().equals(CONTINUE);
    }
}