package com.example.attornatus.test;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.attornatus.controller.EnderecoContoller;
import com.example.attornatus.model.Endereco;
import com.example.attornatus.service.EnderecoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class EnderecoTest {

    @Autowired
    private EnderecoContoller enderecoContoller;

    @MockBean
    EnderecoService enderecoService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(enderecoContoller).build();
    }

    @Test
    public void deve_adicionar_um_endereco() throws Exception {

        Endereco endereco = new Endereco();

        endereco.setLogradouro("coronel luiz favila");
        endereco.setCep(25270393);
        endereco.setNumero(4);
        endereco.setCidade("Duque de Caxias");
        endereco.setIsprincipal(true);

        String json = new ObjectMapper().writeValueAsString(endereco);
        var requestBuilder = MockMvcRequestBuilders.post("/enderecos")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON);

        endereco.setId(1L);

        when(this.enderecoService.criarEndereco(endereco)).thenReturn(endereco);

        this.mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}
