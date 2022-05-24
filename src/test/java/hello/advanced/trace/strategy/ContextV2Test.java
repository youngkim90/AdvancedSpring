package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.strategy.ContextV2;
import hello.advanced.trace.strategy.strategy.Strategy;
import hello.advanced.trace.strategy.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /* 전략을 인수로 전달 */
    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    /* 익명 내부클래스 사용 */
    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
    }

    /* 익명 내부클래스 사용 */
    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        /* 람다 사용 */
        context.execute(() -> log.info("비즈니스 로직1 실행"));
        context.execute(() -> log.info("비즈니스 로직2 실행"));
    }
}
