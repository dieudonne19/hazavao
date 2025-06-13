package com.hazavao.dev.service;

import com.hazavao.dev.model.GptModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class HazavaoService {
    private final GptModel gptModel = new GptModel();

    public String hazavao(String teny) {
        return gptModel.hazavao(teny);
    }
}
