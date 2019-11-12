package com.corelogic.reissue.service;

import com.corelogic.reissue.domain.ReissueEntity;
import com.corelogic.reissue.repository.ReissueRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReissueServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private ReissueRepository reissueRepository;

    private ReissueService subject;

    @Before
    public void setUp() {
        subject = new ReissueService(reissueRepository);
    }

    @Test
    public void save_callsReissueRepositoryToSaveEntity() {
        ReissueEntity request = new ReissueEntity();

        subject.save(request);

        verify(reissueRepository).save(request);
    }

    @Test
    public void save_returnsSavedEntity() {
        ReissueEntity request = new ReissueEntity();

        ReissueEntity savedRequest = new ReissueEntity();
        when(reissueRepository.save(request)).thenReturn(savedRequest);

        ReissueEntity result = subject.save(request);

        assertThat(result).isSameAs(savedRequest);
    }
}
