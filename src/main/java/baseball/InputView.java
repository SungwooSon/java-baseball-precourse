package baseball;

import nextstep.utils.Console;

public class InputView {

    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

}
