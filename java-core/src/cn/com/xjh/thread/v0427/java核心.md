#java.核心知识
##数据结构
###数组
####特点
#####1.内存地址连续，使用之前必须指定数组长度
#####2.可以通过数组下标进行查询，效率高
#####3.增删操作会给系统带来性能消耗，保证下标越界问题，需要动态扩容
###链表
###特点
#####1.灵活的空间
#####2.不支持下标的访问支持顺序访问
#####3.针对增删效率高，查询效率低

```JAVA
private static Node<E> {
    E item; //节点的元素
    Node<E> next;
    Node<E> prev;
    
    Node(Node<E> prev, E element ,Node<E> next){
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
   
}
```

### 树

#### 红黑树

#### 特点

##### 1. 红黑树首先是一个二叉树 

##### 2.红黑树的节点，要么是红色，要么是黑色

##### 3.根节点必须是黑色

##### 4.叶子节点【空节点】是黑色

##### 5.每个红色节点的子节点必须是黑色 

##### 6. 从根节点查找，每条节点支 有相同的黑色节点

##### 7.相邻两个节点不能都是红色



总结 黑平衡二叉树

1. recolor 重新标志颜色 红或黑
2.  默认插入 颜色为红色，并且判断父节点是否为红，根据特点7判断父节点是否需要变色
3.  rotation 旋转， 达到平衡的关键操作
4. ![1650085524880](C:\Users\77539\AppData\Local\Temp\1650085524880.png)
5. ![1650085493255](C:\Users\77539\AppData\Local\Temp\1650085493255.png)



### 集合

```java
/**
 * Default initial capacity.
 集合初始长度
 */
private static final int DEFAULT_CAPACITY = 10;

/**
 * Shared empty array instance used for empty instances.
 空数组
 */
private static final Object[] EMPTY_ELEMENTDATA = {};

/**
 * Shared empty array instance used for default sized empty instances. We
 * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
 * first element is added.
 */
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

/**
 * The array buffer into which the elements of the ArrayList are stored.
 * The capacity of the ArrayList is the length of this array buffer. Any
 * empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
 * will be expanded to DEFAULT_CAPACITY when the first element is added.
 集合存储数据的数组
 */
transient Object[] elementData; // non-private to simplify nested class access

/**
 * The size of the ArrayList (the number of elements it contains).
 *
 * @serial
 集合长度
 */
private int size;
```

1.初始化操作

无参构造

```java
	/**
     * Constructs an empty list with an initial capacity of ten.
     */
    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
```

有参构造

```java
	/**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param  initialCapacity  the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        }
    }	
```

### add操作

```java
/**
     * This helper method split out from add(E) to keep method
     * bytecode size under 35 (the -XX:MaxInlineSize default value),
     * which helps when add(E) is called in a C1-compiled loop.
     */
    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size = s + 1;
    }
```

第一次add 创建默认长度的集合 10 

第二次add 经过判断，直接在内部数组的size+1的位置上赋值

第十一次add 经过判断需要扩容，扩容到size+sizi>>1 这个大小，约为1.5倍 然后把旧数组copy到新数组来

### set操作

set（size，value）判断size是否越界，没有则添加进去

### remove操作

remove（size） 底层剖出[size+1 , max]的数组，移动到 [size,max-1]位置，最后一位被设置为null 则新数组就出来了

## 集合的FailFast机制

![1650099463255](C:\Users\77539\AppData\Local\Temp\1650099463255.png)

## LinkedList

![1650099677455](C:\Users\77539\AppData\Local\Temp\1650099677455.png)





### get 方法  根据index 和 数组的大小 判断是从头部开始循环获取，还是从尾部循环获取

![1650100598277](C:\Users\77539\AppData\Local\Temp\1650100598277.png)

## Vector集合

本质上和ArrayList没什么区别，就是全部方法都加入了synchronized 使全部方法都同步，所以效率很低

CollectionUtils.synchronizedList(List); 可以将一个list包装为方法同步的集合，处理某些灵活的需要使用同步方法的场景













###栈



###队列
###堆