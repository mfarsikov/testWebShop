package com.myshop.web;

import com.myshop.book.Book;
import com.myshop.service.BookShop;
import com.myshop.service.BookShopService;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by max on 12.12.2015.
 */
public class BookShopControllerTest {
    @Test
    public void shouldReturnAllItems() throws Exception {
        BookShopService service = Mockito.mock(BookShopService.class);
        Mockito.when(service.bookList()).thenReturn(
                Arrays.asList(new Book(1, "Pushkin", "Eugen O."), new Book(2, "A.S.", "Ps"))
        );
        BookShopController controller = new BookShopController(service);

        MockMvc mockMvc = standaloneSetup(controller)
                .build();

        mockMvc.perform(get("/shop/books/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(result -> System.out.println("result: " + result))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[0].author", is("Pushkin")))
                .andExpect(jsonPath("$[1].author", is("A.S.")))
                .andExpect(jsonPath("$[0].title", is("Eugen O.")))
                .andExpect(jsonPath("$[1].title", is("Ps")));
    }
}
