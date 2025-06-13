package com.hazavao.dev.endpoint.rest.controller.health;

import com.hazavao.dev.PojaGenerated;
import com.hazavao.dev.service.HazavaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PojaGenerated
@AllArgsConstructor
public class HazavaoController {

    private final HazavaoService hazavaoService;

    @GetMapping("/hazavao")
    public String hazavao(@RequestParam String teny){
        return hazavaoService.hazavao(teny);
    }
}
