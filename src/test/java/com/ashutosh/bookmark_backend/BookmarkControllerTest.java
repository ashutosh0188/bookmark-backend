package com.ashutosh.bookmark_backend;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
})
public class BookmarkControllerTest {

    @Autowired
    private MockMvc mvc;

    @ParameterizedTest
    @CsvSource({
            "1,true,false,true,false,15,10,1,2",
            "2,false,true,false,true,15,5,2,2"
    })
    void getAllBookmarksTest(int pageNo, boolean hasNext, boolean hasPrevious, boolean isFirst, boolean isLast,
                             int totalElements, int currentPageSize, int currentPage, int totalPages) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/bookmarks?page="+pageNo))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.hasNext",
                        CoreMatchers.is(hasNext)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hasPrevious",
                        CoreMatchers.is(hasPrevious)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.first",
                        CoreMatchers.is(isFirst)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.last",
                        CoreMatchers.is(isLast)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalElements",
                        CoreMatchers.equalTo(totalElements)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currentPageSize",
                        CoreMatchers.equalTo(currentPageSize)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currentPage",
                        CoreMatchers.equalTo(currentPage)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalPage",
                        CoreMatchers.equalTo(totalPages)));
    }

    @ParameterizedTest
    @CsvSource({
            "2,false,false,true,true,2,2,1,1",
            "te,true,false,true,false,15,10,1,2",
            "'',true,false,true,false,15,10,1,2", //If query is null
    })
    void searchBookmarks(String query, boolean hasNext, boolean hasPrevious, boolean isFirst, boolean isLast,
                         int totalElements, int currentPageSize, int currentPage, int totalPages) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/bookmarks?query="+query))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.hasNext",
                        CoreMatchers.is(hasNext)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.hasPrevious",
                        CoreMatchers.is(hasPrevious)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.first",
                        CoreMatchers.is(isFirst)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.last",
                        CoreMatchers.is(isLast)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalElements",
                        CoreMatchers.equalTo(totalElements)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currentPageSize",
                        CoreMatchers.equalTo(currentPageSize)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.currentPage",
                        CoreMatchers.equalTo(currentPage)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalPage",
                        CoreMatchers.equalTo(totalPages)));
    }
}
