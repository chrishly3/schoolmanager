package com.schoolmanager.controller.adminLogin;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.schoolmanager.entity.SchoolUserinfo;

public class JwtUtil {

    public static String getToken(SchoolUserinfo user) {
        String token = "";
        token = JWT.create().withAudience(user.getRybm())
                .sign(Algorithm.HMAC256(user.getUserPassword()));
        return token;
    }
}
