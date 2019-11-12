package com.corelogic.reissue.controller;

import com.corelogic.reissue.domain.ReissueEntity;
import com.corelogic.reissue.service.ReissueService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PublishControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private ReissueService reissueService;

    private PublishController subject;

    @Before
    public void setUp() {
        subject = new PublishController(reissueService);
    }

    @Test
    public void publish_savesPublishDTO() {
        ReissueEntity request = new ReissueEntity();

        subject.publish(request);

        verify(reissueService).save(request);
    }

    @Test
    public void publish_returnsSavedPublishDTO() {
        ReissueEntity request = new ReissueEntity();

        ReissueEntity savedRequest = new ReissueEntity();
        when(reissueService.save(request)).thenReturn(savedRequest);

        ReissueEntity result = subject.publish(request);

        assertThat(result).isSameAs(savedRequest);
    }
}
