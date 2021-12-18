package org.da0hn.collections.functinal;

import java.util.Objects;

import static java.lang.String.format;

public class FunctionalBinaryTree<E extends Comparable<E>> {

  private static final FunctionalBinaryTree NIL = Nil.getNil();
  private final E value;
  private final FunctionalBinaryTree<E> left;
  private final FunctionalBinaryTree<E> right;
  private final int size;
  private final int height;

  private FunctionalBinaryTree() {
    this.value = null;
    this.left = NIL;
    this.right = NIL;
    this.size = 0;
    this.height = -1;
  }

  private FunctionalBinaryTree(final FunctionalBinaryTree<E> left, final E value, final FunctionalBinaryTree<E> right) {
    this.left = left;
    this.value = value;
    this.right = right;
    this.size = 1 + this.left.size + this.right.size;
    this.height = 1 + Math.max(this.left.height, this.right.height);
  }

  @SafeVarargs
  public static <E extends Comparable<E>> FunctionalBinaryTree<E> tree(final E... nodes) {
    FunctionalBinaryTree<E> tree = NIL;
    for(int i = 0; i < nodes.length; i++) {
      tree = tree.insert(nodes[i]);
    }
    return tree;
  }

  public FunctionalBinaryTree<E> remove(final E element) {
    if(element.compareTo(this.value) < 0) {
      return new FunctionalBinaryTree<>(this.left.remove(element), this.value, this.right);
    }
    if(element.compareTo(this.value) > 0) {
      return new FunctionalBinaryTree<>(this.left, this.value, this.right.remove(element));
    }
    return this.left.merge(this.right);
  }

  private FunctionalBinaryTree<E> merge(final FunctionalBinaryTree<E> right) {
    if(this.isEmpty()) return right;
    if(right.isEmpty()) return this;
    return new FunctionalBinaryTree<>(this.left.merge(this.right), this.value, right);
  }

  private FunctionalBinaryTree<E> insert(final E newValue) {
    if(this.isEmpty()) {
      return new FunctionalBinaryTree<E>(NIL, newValue, NIL);
    }
    else {
      if(newValue.compareTo(this.value) < 0) {
        return new FunctionalBinaryTree<>(this.left.insert(newValue), this.value, this.right);
      }
      if(newValue.compareTo(this.value) > 0) {
        return new FunctionalBinaryTree<>(this.left, this.value, this.right.insert(newValue));
      }
      return new FunctionalBinaryTree<>(this.left, newValue, this.right);
    }
  }

  private boolean isEmpty() {
    return this.size == 0;
  }

  @Override public String toString() {
    return Integer.toHexString(Objects.hashCode(this));
  }

  public boolean isMember(final E value) {
    if(this.value == null) return false;
    if(value.compareTo(this.value) < 0) {
      return this.left.isMember(value);
    }
    if(value.compareTo(this.value) > 0) {
      return this.right.isMember(value);
    }
    return true;
  }

  public E max() {
    return this.right.equals(NIL) ? this.value : this.right.max();
  }

  private String internalToString(final FunctionalBinaryTree<E> node, final String table) {
    String newTable = table;
    if(node == null || node.equals(NIL)) {
      return table;
    }
    newTable += format("| %16s | %16s | %16s | %16s |%n", node, node.left, node.value, node.right);
    newTable = this.internalToString(node.right, newTable);
    newTable = this.internalToString(node.left, newTable);
    return newTable;
  }

  public String asTable() {
    final var header = format(
      "%s%n| %16s | %16s | %16s | %16s |%n%s%n",
      "-".repeat(77),
      "&Address",
      "Left",
      "Value",
      "Right",
      "-".repeat(77)
    );
    return this.internalToString(this, header);
  }

  private static class Nil<E extends Comparable<E>> extends FunctionalBinaryTree<E> {
    private static Nil<?> nil;

    Nil() {
    }

    static <E extends Comparable<E>> Nil<E> getNil() {
      if(nil == null) {
        nil = new Nil<E>();
      }
      return (Nil<E>) nil;
    }

    @Override public String toString() {
      return "NIL";
    }
  }


}
