

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