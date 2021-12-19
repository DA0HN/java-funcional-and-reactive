## Reactive Operators

### Supressing Operators

- Suppress the emissions which fails to meet some specific criteria.
  - `filter`- accepts a predicate for given observable and either passes or discards events.
  - `take`and skip() - captures a specified number of emissions from upstream and emits.
  - `distinct`- suppress the duplicates | emites unique emission.
  - `elementAt`- used to get element present at specified index.

### Transforming Operators

- Transforms the emissions.
- Type of returned observable may not be the same.
  - `map`- takes a function that changes the type of input to some other specific type.
  - `cast`- takes class name as argument.
  - `delay`- delay the emission with specified amount of time.
  - `delaySubscription`- delay subscription with specified amount of time.
  - `scan`- takes accumulator function and apply to the first item and feeds result to next.
  - `sorted`- sorts upstream emissions.

### Reducing Operators

- Take a series of emission and reduce them into single emission.
- Works with finite observables.
  - `count`- counts the number of emissions in upstream.
  - `reduce`- identical to scan, but emits the final accumulation.
  - `contains`- check whether specified element is emitted from the upstream or not.
  - `all`- verifies that each emission is satisfying the specified condition or not.
  - `any`- verifies whether any of emission is satisfying the specified condition or not.

### Collections Operators

- Combine all the emissions from upstream to some collection.
- Reduce emission to a single collection.
  - `toList`- combine upstream emissions into a List and emits entire list in a single emission.
  - `toSortedList`- combine upstream emissions into a sorted List.
  - `toMap`- collect upstream emissions into a Map.
  - `collect`- take emissions into any type of collection that we want.

### Error Recovery Operators

- Used to handle the errors and to recover from them.
  - `onErrorReturnItem`- return some default element when exception occurs.
  - `onErrorReturn`- takes lambda to yield default element.
  - `onErrorResumeNext`- emit multiple values instead of single when exception occurs.
  - `retry`- re-subscribe to the Observable hoping that it will complete without any error.

### Action Operators

- Used to do debugging in the observable chain
  - `doOnNext`
  - `doOnError`
  - `doOnSubscribe`
  - `doOnComplete`

