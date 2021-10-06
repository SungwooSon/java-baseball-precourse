package baseball;

import nextstep.utils.Randoms;

public class BaseballGameController {

    final StringBuilder generatedNumberString = new StringBuilder();
    static final int NUMBER_LENGTH = 3;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Referee referee;

    static void run() {
        BaseballGameController controller = new BaseballGameController();
        controller.initGame();
        controller.startGame();
    }

    private void initGame() {
        referee = new Referee(generateNumberString());
    }

    private void startGame() {
        do{
            String inputUserNumber = inputView.inputUserNumber();
            referee.judge(inputUserNumber);
            outputView.outputResult(referee);
            referee.initBallCount();
        }while(!referee.isThreeStrike());

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
}
