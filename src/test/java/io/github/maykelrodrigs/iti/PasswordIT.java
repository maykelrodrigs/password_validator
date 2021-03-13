package io.github.maykelrodrigs.iti;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PasswordIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void when_password_is_invalid_return_false() throws Exception {
        var content = this.mockMvc.perform(get("/api/password/AbTp9 fok/validate"))
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertEquals("false", content.getResponse().getContentAsString());
    }

    @Test
    void when_password_is_invalid_with_duplicate_char_return_false() throws Exception {
        var content = this.mockMvc.perform(get("/api/password/AbTp9!foA/validate"))
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertEquals("false", content.getResponse().getContentAsString());
    }

    @Test
    void when_password_is_valid_return_true() throws Exception {
        var content = this.mockMvc.perform(get("/api/password/AbTp9!fok/validate"))
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertEquals("true", content.getResponse().getContentAsString());
    }

}
