package org.da0hn.usecases.customspliterator;

import org.da0hn.domain.Book;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Spliterator;
import java.util.stream.StreamSupport;

/**
 * @author daohn
 * @since 27/06/2021
 */
public class CustomSpliteratorUseCase {

  public static void main(String[] args) throws URISyntaxException {

    var uri = Objects.requireNonNull(
      CustomSpliteratorUseCase.class
        .getResource("/books.txt")
    ).toURI();

    var path = Paths.get(uri);

    try(var lines = Files.lines(path)) {

      Spliterator<String> lineSpliterator = lines.spliterator();
      Spliterator<Book> bookSpliterator = new BookSpliterator(lineSpliterator);

      StreamSupport.stream(bookSpliterator, false)
        .forEach(System.out::println);

    }
    catch(IOException e) {
      e.printStackTrace();
    }

  }

}
