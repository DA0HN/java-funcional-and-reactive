package org.da0hn.queue;

class Application {

  public static void main(final String[] args) {
    final FunctionalQueue<String> queue = FunctionalQueue.queue();
    final var newQueue = queue.enqueue("Hey")
      .enqueue("How are you?!")
      .enqueue("Fine!");

    forEach(newQueue);

    final var newQueueDequeued = newQueue.dequeue();
    forEach(newQueueDequeued);

    final var peek = newQueueDequeued.peek();
    System.out.printf("peek: %s%n", peek);

    final var length = newQueueDequeued.length();
    System.out.printf("length: %d%n", length);

    final var newQueueEmpty = newQueueDequeued.dequeue()
      .dequeue()
      .dequeue();

    System.out.printf("Queue is Empty? %s%n", newQueueEmpty.isEmpty());

  }

  private static <T> void forEach(final FunctionalQueue<T> newQueue) {
    System.out.println();
    newQueue.forEach(System.out::println);
  }


}
