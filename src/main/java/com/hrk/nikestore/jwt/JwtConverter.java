package com.hrk.nikestore.jwt;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class JwtConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer {

    @Override
    public void configure(JwtAccessTokenConverter jwtAccessTokenConverter) {
        jwtAccessTokenConverter.setAccessTokenConverter(this);
    }

    @Override
    public OAuth2Authentication extractAuthentication(Map<String, ?> claims) {
        OAuth2Authentication auth = super.extractAuthentication(claims);
//        AccessTokenMapper details = new AccessTokenMapper();
//
//        if (claims.get("id") != null)
//            details.setId((Long) claims.get("id"));
//
//        if (claims.get("email") != null)
//            details.setEmail((String) claims.get("email"));
//
//        if (claims.get("name") != null)
//            details.setName((String) claims.get("name"));

        auth.setDetails(claims);
        return auth;
    }
}
