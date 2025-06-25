package Sire.tech.profiles;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(ProfileController.class)
class ProfileControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProfileService profileService;


    @BeforeEach
    void setUP() {
        Profile profile1 = Profile.builder()
            .lastName("Sire")
            .firstName("Bah")
            .email("bahsire1@gmail.com")
            .build();

        Profile profile2 = Profile.builder()
            .lastName("Moussa")
            .firstName("Diallo")
            .email("diallo@mail.test")
            .build();

        when(profileService.findProfiles()).thenReturn(List.of(profile1, profile2));



    }

    @DisplayName("Tester pour lire une liste de profiles")
    @Test
    void findAllProfilesTest() throws Exception {
        this.mockMvc.perform(get("/profiles"))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(content().string(containsString("bahsire1@gmail.com")));
    }
    @DisplayName("Teste pour creer un profile")
    @Test
    void createProfileTest() throws Exception {
        Profile profile2 = Profile.builder()
            .lastName("Moussa")
            .firstName("Diallo")
            .email("diallo@mail.test")
            .build();

        String profileAsString = new ObjectMapper().writeValueAsString(profile2);

        this.mockMvc.perform(post("/profiles")
            .contentType(MediaType.APPLICATION_JSON)
            .content(profileAsString)


        ).andExpect(status().isCreated());



    }


}