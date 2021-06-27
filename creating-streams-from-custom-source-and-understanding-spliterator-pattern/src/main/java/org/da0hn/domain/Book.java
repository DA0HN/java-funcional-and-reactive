package org.da0hn.domain;

/**
 * @author daohn
 * @since 27/06/2021
 */
public record Book(
  String name,
  String author,
  String genre,
  Double rating
) {
}
