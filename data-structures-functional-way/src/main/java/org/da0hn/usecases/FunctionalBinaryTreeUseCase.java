package org.da0hn.usecases;

import org.da0hn.collections.functinal.FunctionalBinaryTree;

final class FunctionalBinaryTreeUseCase {

  public static void main(final String[] args) {
    final FunctionalBinaryTree<Integer> tree = FunctionalBinaryTree.tree(
      23, 6, 76, 10, 3, 45,
      78, 4, 2, 95, 102, 7, 1, 0, 2
    );
    asTable(tree);

    final var newTree = tree.remove(76);

    asTable(newTree);

    System.out.println(newTree.isMember(76));
    System.out.println(newTree.isMember(1));
    System.out.println(newTree.max());

  }

  private static <T extends Comparable<T>> void asTable(final FunctionalBinaryTree<T> tree) {
    System.out.println(tree.asTable());
    System.out.println();
  }

}
