package com.surup.triptogather.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.surup.triptogather.domain.AreaCode;
import com.surup.triptogather.repository.AreaCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class KTOTourServiceImpl implements KTOTourService {

    private final AreaCodeRepository areaCodeRepository;

    @Override
    @Transactional
    public void insertAreaCode(JsonNode itemList) {
        for (JsonNode item : itemList) {
            String name = item.get("name").asText();
            String code = item.get("code").asText();
            AreaCode areaCode = new AreaCode(Long.valueOf(code), name);
            areaCodeRepository.save(areaCode);
        }
    }
}
