package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee("123");
    }

    @Test
    void 쓰리_스트라이크_테스트() {
        referee.judge("123");
        Assertions.assertThat(referee.isThreeStrike()).isTrue();
    }

    @Test
    void 투_스트라이크_테스트() {
        referee.judge("124");
        Assertions.assertThat(referee.getStrike()).isEqualTo(2);
        Assertions.assertThat(referee.getBall()).isEqualTo(0);
        Assertions.assertThat(referee.getNothing()).isEqualTo(1);
        referee.initBallCount();
    }

    @Test
    void 원_스트라이크_테스트() {
        referee.judge("132");
        Assertions.assertThat(referee.getStrike()).isEqualTo(1);
        Assertions.assertThat(referee.getBall()).isEqualTo(2);
        Assertions.assertThat(referee.getNothing()).isEqualTo(0);
        referee.initBallCount();
    }

    @Test
    void 낫싱_테스트() {
        referee.judge("567");
        Assertions.assertThat(referee.getStrike()).isEqualTo(0);
        Assertions.assertThat(referee.getBall()).isEqualTo(0);
        Assertions.assertThat(referee.getNothing()).isEqualTo(3);
        referee.initBallCount();
    }
}