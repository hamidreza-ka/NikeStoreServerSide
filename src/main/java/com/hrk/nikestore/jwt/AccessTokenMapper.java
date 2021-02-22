package com.hrk.nikestore.jwt;

public class AccessTokenMapper {

    private String accessToken;
    private Long id;
    private String email;
    private String name;

    public AccessTokenMapper() {
    }

    public AccessTokenMapper(String accessToken, Long id, String email, String name) {
        this.accessToken = accessToken;
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
