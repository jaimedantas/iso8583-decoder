package com.jaimedantas.iso8583decoder.controller;

import com.jaimedantas.iso8583decoder.processor.ProcessDataElement108;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@ContextConfiguration(classes = {RestController.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class RestControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    WebApplicationContext wContext;

    @MockBean
    private RestController newController;

    @Test
    public void shouldCallApiAndReturnSuccess() throws Exception {

        String dataElement108 = "12501540107CHASITY0304HOLT0511STOUCHSBURG0602SC1110103132224002470105KEITH0306HAYDEN0505CORAL0602ID11093725057470312030203050205";

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(post("/decoder/de108/transaction")
                .param("dataElement108", dataElement108)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldCallApiFileAndReturnSuccess() throws Exception {

        MockMultipartFile firstFile = new MockMultipartFile("file", "input_transactions.txt", MediaType.TEXT_PLAIN_VALUE,
                "14801630106BRENDA0209ANNABELLE0307MCGUIRE0505DATIL0602MO1110125446818902610104COOK0205MILES0307CLAYTON0510BAINBRIDGE0602MH11099651335060312030204050211".getBytes());

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockMvc.perform(multipart("/decoder/de108/file").file(firstFile)).andExpect(status().isOk());

    }
}
