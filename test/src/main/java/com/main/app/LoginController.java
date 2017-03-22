
package com.main.app;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jogish
 */
@RestController
public class LoginController {

    @RequestMapping("/authenticate/{userId}/{password}")
    public String generate(@PathVariable
    String userId, @PathVariable
    String password) {
        return authenticate(userId, password) ? "SUCCESS" : "FAIL";
    }

    private boolean authenticate(String username, String password) {
        boolean ctx = false;
        try {
            Hashtable ldapEnv = new Hashtable(11);
            ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            ldapEnv.put(Context.PROVIDER_URL, "ldap://vps2cadc02syntelorg.com:389");
            ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
            ldapEnv.put(Context.SECURITY_PRINCIPAL, "syntelorg\\" + username);
            ldapEnv.put(Context.SECURITY_CREDENTIALS, password+"");
            LdapContext context = new InitialLdapContext(ldapEnv, null);
            ctx = true;
        } catch (NamingException nex) {
            nex.printStackTrace();
        }
        return ctx;
    }

}
