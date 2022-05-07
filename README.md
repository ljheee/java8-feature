

##### collector
    java8自定义收集器，stream操作完的数据集合、进行数据收集时自定义实现。

##### list
    List切分
##### optional
    
##### sort
    集合数据排序foods.stream().sorted(Comparator.comparing(Food::getPrice))
##### stream
    数据分组、转map
##### wordfrequency
    词频统计


##### interface
Java8 接口支持带方法体的default、static方法。
接口中使用static修饰的方法，不能被子类继承。
Java8中Interface支持静态成员，成员默认是public final static的，可以在类外直接调用。

default函数，实现类可以不实现这个方法，如果不想子类去实现的一些方法，可以写成default函数。


##### CompletableFuture
CompletableFuture.runAsync 异步执行任务，底层采用ForkJoinPool，可以通过异步任务方法体内打印线程名验证。

taskA.thenRun(() ->taskB());
taskA 外抛异常，不会执行后续的taskB；taskB不会执行。
可用jstack 查看线程堆栈状态。


A完成，再执行B的情况总结：
- taskA.thenRun 在A外抛异常时，thenRun()不会执行，除非A任务内部吞掉异常；
- taskA.whenComplete A完成时可检查A是否抛了异常，进行决定是否执行B；
- 无论 taskA.thenRunAsync还是thenRun，在A执行完去执行B时，总会复用上一个ForkJoinPool的线程


A完成，再执行B；还能通过A返回特定的结果，让B执行。
可以使用taskA.thenApply、thenAccept向B任务传递A的结果值。
