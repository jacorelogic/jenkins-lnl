package com.corelogic.reissue.integration;

import com.corelogic.reissue.domain.ReissueEntity;
import com.corelogic.reissue.repository.ReissueRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PublishIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ReissueRepository reissueRepository;

    @Test
    @Transactional
    public void publish_whenRequestIsValid_returnsOKWithSavedRequest() throws Exception {
        mockMvc.perform(post("/publish")
            .contentType(APPLICATION_JSON)
            .accept(APPLICATION_JSON)
            .content("{\n"
                + "  \"orderData\": \"some data\",\n"
                + "  \"orderStatus\": \"COMPLETED\",\n"
                + "  \"productCode\": \"VOE\"\n"
                + "}"))
            .andExpect(status().isOk())
            .andExpect(content().json("{\n"
                + "  \"id\": 1,\n"
                + "  \"orderData\": \"some data\",\n"
                + "  \"orderStatus\": \"COMPLETED\",\n"
                + "  \"productCode\": \"VOE\"\n"
                + "}"));

        Iterable<ReissueEntity> reissueEntities = reissueRepository.findAll();

        assertThat(reissueEntities).hasSize(1);
        ReissueEntity savedEntity = reissueEntities.iterator().next();
        assertThat(savedEntity.getOrderData()).isEqualTo("some data");
        assertThat(savedEntity.getOrderStatus()).isEqualTo("COMPLETED");
        assertThat(savedEntity.getProductCode()).isEqualTo("VOE");
    }
}
