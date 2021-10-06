package baseball;

public class OutputView {

    public void outputResult(Referee referee) {
        StringBuilder sb = new StringBuilder();

        if(referee.getStrike() > 0) {
            sb.append(String.format("%d%s ", referee.getStrike(), "스트라이크"));
        }

        if(referee.getBall() > 0) {
            sb.append(String.format("%d%s  ", referee.getBall(), "볼"));
        }

        if(referee.getNothing() == 3) {
            sb.append("낫싱");
        }

        if(referee.getNothing() > 0) {
            sb.append(String.format("%d%s", referee.getNothing(), "낫싱"));
        }

        System.out.println(sb.toString());

        if(referee.isThreeStrike()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        }
    }

}
