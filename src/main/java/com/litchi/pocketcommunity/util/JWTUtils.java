package com.litchi.pocketcommunity.util;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName: JWTUtils
 * @Description: TODO
 * @author: litchi
 */
public class JWTUtils {
    private Long EXPIRATION_TIME;
    private String SECRET;
    private final String TOKEN_PREFIX = "Bearer";
    private final String HEADER_STRING = "Authorization";

    public JWTUtils(String secret, long expire) {
        this.EXPIRATION_TIME = expire;
        this.SECRET = secret;
    }

    /**
     * @description: get a Token and save claims to Token
     * TODO
     * @param:
     * @return:
     * @author: litchi
     */
    public JSONObject generateToken(Map<String, Object> claims) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.SECOND, EXPIRATION_TIME.intValue());
        Date d = c.getTime();
        String jwt = Jwts.builder()
                .setClaims(claims)
                .setExpiration(d)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        System.out.println(jwt);
        JSONObject json = new JSONObject();
        json.put("token", TOKEN_PREFIX + " " + jwt);
        json.put("expireTime", d.getTime());
        return json;
    }

    /**
     * @description: check whether the Token is validate and get the claims
     * TODO
     * @param:
     * @return:
     * @author: litchi
     */
    public Claims validateTokenAndGetClaims(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token == null) {
            return null;
        }
        try{
            return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.trim().replace(TOKEN_PREFIX,""))
                .getBody();
        } catch (Exception e){
            e.getMessage();
            return null;
        }
    }
}
