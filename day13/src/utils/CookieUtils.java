package utils;

import javax.servlet.http.Cookie;

public class CookieUtils {
    public static Cookie getCookieName(Cookie[] cookies, String lastVisit){
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (lastVisit.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
