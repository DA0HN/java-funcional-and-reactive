package org.da0hn.usecases.customspliterator;

import org.da0hn.domain.Book;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author daohn
 * @since 27/06/2021
 */
public class BookSpliterator implements Spliterator<Book> {

  private String name;
  private String author;
  private String genre;
  private Double rating;

  private final Spliterator<String> lineSpliterator;

  public BookSpliterator(Spliterator<String> lineSpliterator) {
    this.lineSpliterator = lineSpliterator;
  }

  @Override public boolean tryAdvance(Consumer<? super Book> action) {

    if(
      this.lineSpliterator.tryAdvance(name -> this.name = name) &&
      this.lineSpliterator.tryAdvance(author -> this.author = author) &&
      this.lineSpliterator.tryAdvance(genre -> this.genre = genre) &&
      this.lineSpliterator.tryAdvance(rating -> this.rating = Double.valueOf(rating))
    ) {
      action.accept(new Book(this.name, this.author, this.genre, this.rating));
      return true;
    }

    return false;
  }

  @Override public Spliterator<Book> trySplit() {
    return null;
  }

  @Override public long estimateSize() {
    return this.lineSpliterator.estimateSize() / 4;
  }

  @Override public int characteristics() {
    return this.lineSpliterator.characteristics();
  }
}
