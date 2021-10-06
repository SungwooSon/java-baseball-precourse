package baseball;

import nextstep.utils.Console;

public class Prompter {
    private static final String errorMessage = "[ERROR]3자리 숫자를 정확히 입력하세요.";

    public static String queryForUserInputNumber() {
        try {
            System.out.print("숫자를 입력해 주세요 : ");
            String userInputNumber = Console.readLine();
            validateUserInput(userInputNumber);
            return userInputNumber;
        }  catch (UserInputException exception) {
            System.out.println(exception.getMessage());
            return queryForUserInputNumber();
        }
    }

    private static void validateUserInput(String userInputNumber) throws UserInputException{
        validateNumberForamt(userInputNumber);
        validateNumberLength(userInputNumber);
    }

    private static void validateNumberLength(String userInputNumber) throws UserInputException {
        if(userInputNumber.length() != 3)
            throw new UserInputException(errorMessage);
    }

    private static void validateNumberForamt(String userInputNumber) throws UserInputException{
        try {
            Integer.parseInt(userInputNumber);
        } catch (NumberFormatException e) {
            throw new UserInputException(errorMessage);
        }
    }

    public static String queryForContinuousGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public static void printResult(Referee referee) {
        printStrike(referee);
        printBall(referee);
        printNothing(referee);
        System.out.println();
        if(referee.isThreeStrike()){
            printThreeStrike();
        }
    }

    private static void printThreeStrike() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    private static void printStrike(Referee referee) {
        if(referee.getStrike() > 0) {
            System.out.print(String.format("%d%s ", referee.getStrike(), "스트라이크"));
        }
    }

    private static void printBall(Referee referee) {
        if(referee.getBall() > 0) {
            System.out.print(String.format("%d%s  ", referee.getBall(), "볼"));
        }
    }

    private static void printNothing(Referee referee) {
        if(referee.getNothing() == 3) {
            System.out.print("낫싱");
        }
    }
}
