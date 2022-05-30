package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

//실제 객체와 모양이 같다
@Slf4j
public class CacheProxy implements Subject {

    private Subject target;
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");
        //접근제어
        if(cacheValue == null) {
            cacheValue = target.operation();
        }
        return cacheValue;
    }
}
