package com.hrk.nikestore.config;

import com.hrk.nikestore.jwt.CustomTokenEnhancer;
import com.hrk.nikestore.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;

//    private final JwtTokenStore jwtTokenStore;
//    private final JwtAccessTokenConverter accessTokenConverter;
    public static final String PRIVATE_KEY = "secret";


    @Autowired
    public AuthorizationServerConfig(AuthenticationManager authenticationManager, UserService userService, ClientDetailsService clientDetailsService) {
        this.authenticationManager = authenticationManager;
//        this.jwtTokenStore = jwtTokenStore;
//        this.accessTokenConverter = accessTokenConverter;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("my-trusted-client")
                .authorizedGrantTypes("client_credentials", "password", "refresh_token")
                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
                .scopes("read","write","trust")
                .resourceIds("oauth2-resource")
                .accessTokenValiditySeconds(50000)
                .refreshTokenValiditySeconds(100000)
                .secret(PRIVATE_KEY);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager)
        .accessTokenConverter(tokenEnhancer());
    }

    @Bean
    public JwtAccessTokenConverter tokenEnhancer() {
        JwtAccessTokenConverter converter = new CustomTokenEnhancer();
        converter.setSigningKey(PRIVATE_KEY);
        return converter;
    }

    @Bean
    public JwtTokenStore tokenStore(){
        return new JwtTokenStore(tokenEnhancer());
    }

}
