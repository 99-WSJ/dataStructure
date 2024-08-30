package rateLimit;

/**
 * @program: Src
 * @description: 限流器抽象类
 * @author: wsj
 * @create: 2024-08-27 16:51
 **/
public abstract class MyRateLimiter {
    /**
     * @return 尝试获取
     */
    abstract boolean tryAcquire() ;
}
