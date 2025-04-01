package com.example.firstAPI.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.firstAPI.DTO.UserDetailDTO;

@Service
public class ApplicationCommons {
    private RestTemplate restTemplate;

    @Autowired
    public ApplicationCommons(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public UserDetailDTO validateToken(String token){

        ResponseEntity<UserDetailDTO> userDetailDTOResponse = restTemplate.postForEntity("http://localhost:8080/user/validate/"+token
                                                                    ,null,UserDetailDTO.class);
        return userDetailDTOResponse.getBody();
    }
}
