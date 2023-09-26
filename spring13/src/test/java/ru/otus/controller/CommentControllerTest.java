package ru.otus.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.dto.CommentDto;
import ru.otus.service.CommentService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Controller to work with comment should")
@WebMvcTest(CommentController.class)
public class CommentControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private CommentService commentService;

    @DisplayName("correctly add comment")
    @Test
    @WithMockUser(username = "user")
    public void shouldCorrectAddComment() throws Exception {
        CommentDto added = CommentDto.builder()
                .comments("New Comment")
                .build();

        given(commentService.create(any(CommentDto.class)))
                .willReturn(added);

        mvc.perform(post("/api/comment")
                        .with(csrf())
                        .header("Accept", "application/json")
                        .header("Content-Type", "application/json")
                        .content(mapper.writeValueAsString(added))
                ).andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(added)));

        verify(commentService, times(1))
                .create(any(CommentDto.class));
    }
}