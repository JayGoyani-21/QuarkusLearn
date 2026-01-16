package org.acme.service;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.logging.Logger;

@ApplicationScoped
public class PasswordService {
    private static final Logger Log = Logger.getLogger("PasswordService.class");
    public String hash(String password) {

        Log.info("Hashed");
        return BcryptUtil.bcryptHash(password);

    }

    public boolean matches(String password, String hash) {
        boolean flag = BcryptUtil.matches(password, hash);
        if(flag) {
            Log.info("matched");
        }

        return flag;
    }
}
