package tech.donau.course;

import tech.donau.course.entity.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;

@Path("/book")
public class BookResource {
    private static ArrayList<Book> books = new ArrayList<>();

    static {
        books.add(new Book("Tom Sawyer's adventures", "Mark Twain"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Book> getBooks() {
        return books;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book updateBook(@PathParam("id") int index, Book book) {
        books.remove(index);
        books.add(index, book);
        return book;
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book deleteBook(@PathParam("id") int index) {
        return books.remove(index);
    }
}
