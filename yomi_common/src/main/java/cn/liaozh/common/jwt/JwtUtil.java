package cn.liaozh.common.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static final String signature = "ChangeClass";

    public JwtUtil() {
    }

    public static void main(String[] args) {
        System.out.println(createToken(new HashMap<String, String>() {
            {
                this.put("id", "1570573572345217015");
            }
        }));
    }

    public static String createToken(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(5, 7);
        JWTCreator.Builder builder = JWT.create();
        map.forEach(builder::withClaim);
        return builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC512("ChangeClass"));
    }

    public static void checkToken(String token) {
        if (token == null) {
            throw new AlgorithmMismatchException("无效签名");
        } else {
            JWT.require(Algorithm.HMAC512("ChangeClass")).build().verify(token);
        }
    }

    public static DecodedJWT getTokenInfo(String token) {
        return JWT.require(Algorithm.HMAC512("ChangeClass")).build().verify(token);
    }

    public static String getUserIdByToken(String token) {
        try {
            DecodedJWT JWT = getTokenInfo(token);
            String userId = ((Claim)JWT.getClaims().get("id")).asString();
            return userId;
        } catch (Exception var4) {
            return null;
        }
    }
}
