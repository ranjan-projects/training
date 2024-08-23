package com.example.testing;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.PasswordLookup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class JwksGenerator {
    //newcert_1 is the cert given by capita
    //capita.jks of our unique keystore
    //PASSWORD is the password we have specified in code below
    //keytool -importcert -file newcert_1.crt -keystore capita.jks -alias <<any_name>>>

    private static String PASSWORD ="abcdef";
    public static void main(String[] args)
                    throws KeyStoreException, URISyntaxException, IOException, CertificateException,
                    NoSuchAlgorithmException, JOSEException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        char[] password = PASSWORD.toCharArray();
        Path path = Paths.get("/Users/s610231/work/example/micro-services/Testing/src/main/resources/static/capita.jks");
        File file = new File(path.toUri());
        keyStore.load(new FileInputStream(file), password);
        JWKSet jwkSet = JWKSet.load(keyStore, new PasswordLookup() {
            public char[] lookupPassword(String name) {
                return PASSWORD.toCharArray();
            }
        });
        System.out.printf("jwk is" + jwkSet);
    }
}
