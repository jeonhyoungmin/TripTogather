package com.surup.triptogather.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.surup.triptogather.service.KTOTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;

@RestController
public class KTOTourApi {

    private final RestTemplate restTemplate;
    private final KTOTourService ktoTourService;

    public KTOTourApi(
            @Autowired RestTemplateBuilder restTemplateBuilder,
            @Autowired KTOTourService ktoTourService
    ) {
        this.restTemplate = restTemplateBuilder.build();
        this.ktoTourService = ktoTourService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> getKTOTourApi(){
        String numOfRows = "100";
        String apiEncoding = "";
        String apiDecoding = "";

        ResponseEntity<String> responseEntity = null;

        try {
            responseEntity = restTemplate.getForEntity(apiEncoding, String.class);
        } catch (Exception e) {
            responseEntity = restTemplate.getForEntity(apiDecoding, String.class);
        }

        String responseBody = responseEntity.getBody();

        try {
            // ObjectMapper 객체 생성
            ObjectMapper objectMapper = new ObjectMapper();

            // JSON 문자열을 JsonNode 객체로 변환
            JsonNode rootNode = objectMapper.readTree(responseBody);
            System.out.println("rootNode = " + rootNode);

            // "response" 객체 안에 있는 "body" 객체 안에 있는 "items" 객체 안에 있는 "item" 배열을 가져옴
            JsonNode itemList = rootNode.get("response").get("body").get("items").get("item");
            System.out.println("itemList = " + itemList);

            // 각각의 아이템에서 "name", "code" 값을 AreaCode 테이블에 저장
            ktoTourService.insertAreaCode(itemList);
        } catch (InvocationTargetException e) {
            // 리플렉션 API를 사용할 때 발생하는 예외
            // 올바르지 않은 서비스키 값으로 XML 형식의 에러 코드가 응답되었고, 맞지 않는 형식으로 인해 예외 발생
            return ResponseEntity.badRequest().body("올바르지 않은 secretKey 입니다.");
        } catch (UnknownHostException e) {
            return ResponseEntity.badRequest().body("호스트의 IP 주소를 찾을 수 없습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("여행 정보 API를 저장하는데 오류가 발생했습니다.");
        }

        return responseEntity;
    }
}
