package org.xq.shiro.common;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class JiaMi {
    /**
     * Shiro的加密工具, 对密码加密
     * @param args
     */
    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object credentials = "123";
        Object salt = ByteSource.Util.bytes("ccc");
        int hashIterations = 111;

        Object result = new SimpleHash(
                hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println("ssss");
        System.out.println(result);
    }

}
