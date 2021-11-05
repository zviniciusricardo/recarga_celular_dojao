package br.com.zupacademy.grupolaranja.recargacelular;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@AutoConfigureWireMock(port = 8080)
@ActiveProfiles("test")
class RecargaCelularControllerTest {

    @Autowired protected MockMvc mockMvc;
    @Autowired protected RecargaCelularRepository recargaCelularRepository;

    @Test
    public void fazerUmaRecargaComSucesso() throws Exception {
        RecargaCelularRequest requestBody = new RecargaCelularRequest("123",
                "(46) 999990800","user@com.br",Operadora.VIVO,new BigDecimal("100"));

        System.out.println(new ObjectMapper().writeValueAsString(requestBody));
        RequestBuilder builder = MockMvcRequestBuilders.post("/recarga-celulares")
                .content(new ObjectMapper().writeValueAsString(requestBody))
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
    }
}