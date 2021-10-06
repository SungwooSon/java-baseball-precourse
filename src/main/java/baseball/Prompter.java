package baseball;

import nextstep.utils.Console;

public class Promp {

    public static String inputUserNumber() {
        try {
            System.out.print("숫자를 입력해 주세요 : ");
            String userInputNumber = Console.readLine();
            validateUserInput(userInputNumber);
            return userInputNumber;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR]숫자만 입력하세요.");
            return inputUserNumber();
        } catch (UserInputException e) {
            System.out.println(e.getMessage());
            return inputUserNumber();
        }
    }

    private static void validateUserInput(String userInputNumber) throws UserInputException {
        validateNumberForamt(userInputNumber);
        validateNumberLength(userInputNumber);
    }

    private static void validateNumberLength(String userInputNumber) throws UserInputException {
        if(userInputNumber.length() != 3)
            throw new UserInputException("[ERROR]3자리 숫자를 입력하세요.");
    }

    private static void validateNumberForamt(String userInputNumber) {
        Integer.parseInt(userInputNumber);
    }

    public static String queryForContinuousGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

}
