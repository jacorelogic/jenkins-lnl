package com.corelogic.reissue.controller;

import com.corelogic.reissue.domain.ReissueEntity;
import com.corelogic.reissue.service.ReissueService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

    private final ReissueService reissueService;

    public PublishController(ReissueService reissueService) {
        this.reissueService = reissueService;
    }

    @PostMapping("/publish")
    public ReissueEntity publish(@RequestBody ReissueEntity request) {
        return reissueService.save(request);
    }
}
