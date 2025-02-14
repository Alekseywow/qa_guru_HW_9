import com.fasterxml.jackson.databind.ObjectMapper;
import modal.Book;
import org.junit.jupiter.api.Test;


import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonParsingTest {

    private ClassLoader cl = JsonParsingTest.class.getClassLoader();

    @Test
    void jsonFileParsingTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("Book.json")) {
            assert is != null;
            try (InputStreamReader isr = new InputStreamReader(is)) {
                ObjectMapper objectMapper = new ObjectMapper();
                Book book = objectMapper.readValue(isr, Book.class);
                assertEquals("Война и мир", book.getTitle());
                assertEquals(1869, book.getPublishedYear());
                assertEquals("Роман", book.getGenre());
                assertEquals(1225, book.getPages());
                assertEquals("Лев Толстой", book.getAuthor().get(0).getName());
                assertEquals("Русский", book.getAuthor().get(0).getNationality());
                assertEquals("Лев Толстой", book.getAuthor().get(0).getName());
            }

        }
    }

}
