package com.honglinktech.zbgj.admin.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 统计登录错误次数
 * Created by Dayong on 16/3/22.
 */
public class RetryLimitMatcher extends HashedCredentialsMatcher {
    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitMatcher(CacheManager cacheManager) {
        this.passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String user = token.getPrincipal().toString();
        // 使用线程安全的 AtomicInteger 类型
        AtomicInteger retryCount = passwordRetryCache.get(user);
        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(user, retryCount);
        }
        // 过度尝试抛出异常
        if (retryCount.incrementAndGet() > 5) {
            throw new ExcessiveAttemptsException();
        }
        boolean matches = super.doCredentialsMatch(token, info);
        // 验证通过则移除缓存
        if (matches) {
            passwordRetryCache.remove(user);
        }
        return matches;
    }
}
