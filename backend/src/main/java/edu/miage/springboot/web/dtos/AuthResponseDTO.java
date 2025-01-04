package edu.miage.springboot.web.dtos;

public class AuthResponseDTO {

    private String accessToken;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;



    public AuthResponseDTO() {
    }

    public AuthResponseDTO(String accessToken,String username) {
        this.accessToken = accessToken;
        this.username = username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
