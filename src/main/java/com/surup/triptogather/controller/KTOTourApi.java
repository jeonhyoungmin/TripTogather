package com.surup.triptogather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class KTOTourApi {

    private final RestTemplate restTemplate;

    public KTOTourApi(@Autowired RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/test")
    public ResponseEntity<String> getKTOTourApi(){
        String api = "https://apis.data.go.kr/B551011/KorService1/areaBasedSyncList1?serviceKey=       &numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&showflag=1&listYN=Y&arrange=A&contentTypeId=12&areaCode=4&sigunguCode=4";

        ResponseEntity<String> response = restTemplate.getForEntity(api, String.class);

        String responseData = response.getBody();

        System.out.println("responseData = " + responseData);

        return response;
    }
}
