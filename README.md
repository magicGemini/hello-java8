## java8

### 1.lambda
筛选List<Apple> -> 把条件作为参数 -> 行为参数化 -> 策略模式 -> 使用匿名类 -> lambda表达式 -> 谓词

函数式接口
@FunctionalInterface: Predicate Consumer Supplier Function

方法推断

小结：
* Lambda表达式可以理解为一种匿名函数：它没有名称，但有参数列表、函数主体、返回
  类型，可能还有一个可以抛出的异常的列表。
* Lambda表达式让你可以简洁地传递代码。
* 函数式接口就是仅仅声明了一个抽象方法的接口。
* 只有在接受函数式接口的地方才可以使用Lambda表达式。
* Lambda表达式允许你直接内联，为函数式接口的抽象方法提供实现，并且将整个表达式
  作为函数式接口的一个实例。
* Java 8自带一些常用的函数式接口，放在java.util.function包里，包括Predicate
  <T>、Function<T,R>、Supplier<T>、Consumer<T>和BinaryOperator<T>，如表
  3-2所述。
* 为了避免装箱操作，对Predicate<T>和Function<T, R>等通用函数式接口的原始类型
  特化：IntPredicate、IntToLongFunction等。
* 环绕执行模式（即在方法所必需的代码中间，你需要执行点儿什么操作，比如资源分配
  和清理）可以配合Lambda提高灵活性和可重用性。
* Lambda表达式所需要代表的类型称为目标类型。
* 方法引用让你重复使用现有的方法实现并直接传递它们。
* Comparator、Predicate和Function等函数式接口都有几个可以用来结合Lambda表达
  式的默认方法。


### 2.stream



### 3.Optional




### 4.Collectors

| 序号   | Modifier and Type | Method               |                Parameter                 |
| ---- | ----------------- | -------------------- | :--------------------------------------: |
| 1    |                   | averagingDouble      |             ToDoubleFunction             |
| 2    |                   | averagingInt         |              ToIntFunction               |
| 3    |                   | averagingLong        |              ToLongFunction              |
| 4    |                   | collectingAndThen    |          downstream,  finisher           |
| 5    |                   | counting             |                                          |
| 6    |                   | groupingBy           |                classifier                |
| 7    |                   | groupingBy           |          classifier, downstream          |
| 8    |                   | groupingBy           |     classifier, supplier, downstream     |
| 9    |                   | groupingByConcurrent |                classifier                |
| 10   |                   | groupingByConcurrent |          classifier, downstream          |
| 11   |                   | groupingByConcurrent |     classifier, supplier, downstream     |
| 12   |                   | joining              |                                          |
| 13   |                   | joining              |                delimiter                 |
| 14   |                   | joining              |       delimiter,  prefix,  suffix        |
| 15   |                   | mapping              |           mapper,  downstream            |
| 16   |                   | maxBy                |                comparator                |
| 17   |                   | minBy                |                comparator                |
| 18   |                   | partitioningBy       |                predicate                 |
| 19   |                   | partitioningBy       |          predicate, downstream           |
| 20   |                   | reducing             |            BinaryOperator<T>             |
| 21   |                   | reducing             |       identity, BinaryOperator<T>        |
| 22   |                   | reducing             |   identity, mapper, BinaryOperator<T>    |
| 23   |                   | summarizingDouble    |             ToDoubleFunction             |
| 24   |                   | summarizingInt       |              ToIntFunction               |
| 25   |                   | summarizingLong      |              ToLongFunction              |
| 26   |                   | summingDouble        |             ToDoubleFunction             |
| 27   |                   | summingInt           |              ToIntFunction               |
| 28   |                   | summingLong          |              ToLongFunction              |
| 30   |                   | toCollection         |               Supplier<C>                |
| 31   |                   | toConcurrentMap      |         keyMapper,  valueMapper          |
| 32   |                   | toConcurrentMap      |  keyMapper,  valueMapper, mergeFunction  |
| 33   |                   | toConcurrentMap      | keyMapper,  valueMapper, mergeFunction, mapSupplier |
| 34   |                   | toList               |         keyMapper,  valueMapper          |
| 35   |                   | toMap                |  keyMapper,  valueMapper, mergeFunction  |
| 36   |                   | toMap                | keyMapper,  valueMapper, mergeFunction, mapSupplier |
| 37   |                   | toSet                |                                          |

