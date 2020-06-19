package tech.donau.course;

import io.netty.util.internal.StringUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/book")
public class BookResource {
    private static ArrayList<String> books = new ArrayList<>();

    static {
        books.add("Приключения Тома Сойера");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBooks() {
        return StringUtil.join(", ", books).toString();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(String book) {
        books.add(book);
        return book;
    }

    @PUT
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateBook(@PathParam("id") int index, String book) {
        books.remove(index);
        books.add(index, book);
        return book;
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteBook(@PathParam("id") int index) {
        return books.remove(index);
    }
}