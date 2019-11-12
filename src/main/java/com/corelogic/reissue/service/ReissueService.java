package com.corelogic.reissue.service;

import com.corelogic.reissue.domain.ReissueEntity;
import com.corelogic.reissue.repository.ReissueRepository;
import org.springframework.stereotype.Service;

@Service
public class ReissueService {

    private final ReissueRepository reissueRepository;

    public ReissueService(ReissueRepository reissueRepository) {
        this.reissueRepository = reissueRepository;
    }

    public ReissueEntity save(ReissueEntity request) {
        return reissueRepository.save(request);
    }
}
