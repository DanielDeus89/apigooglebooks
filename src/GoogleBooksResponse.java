import java.util.List;

// Represents the response from the Google Books API,
// containing a list of items (books)
public record GoogleBooksResponse(List<Item> items) {}
