package Sire.tech.security;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rsa")
public record RSA(
    RSAPrivateKey privateKey,
    RSAPublicKey publicKey
) {

}
