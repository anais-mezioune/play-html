package controllers.secure;

import controllers.Secure;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {

        if (username.equals("a")) {
            return true;
        }
        return false;
    }

}
