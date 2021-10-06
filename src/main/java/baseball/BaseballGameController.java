package baseball;

import nextstep.utils.Randoms;

public class BaseballGameController {

    final StringBuilder generatedNumberString = new StringBuilder();;
    static final int NUMBER_LENGTH = 3;

    static void run() {
        BaseballGameController controller = new BaseballGameController();
        controller.initGame();
    }

    private void initGame() {
        generateNumberString();
    }

    String generateNumberString() {
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
