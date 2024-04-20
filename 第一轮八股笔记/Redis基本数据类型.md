![image-20240417153348813](C:/Users/WSJ/Desktop/704Sync_dataStructure/dataStructure/%E7%AC%AC%E4%B8%80%E8%BD%AE%E5%85%AB%E8%82%A1%E7%AC%94%E8%AE%B0/Redis.assets/image-20240417153348813.png)

## 基本数据类型的实现

![image-20240417154125404](C:/Users/WSJ/Desktop/704Sync_dataStructure/dataStructure/%E7%AC%AC%E4%B8%80%E8%BD%AE%E5%85%AB%E8%82%A1%E7%AC%94%E8%AE%B0/Redis.assets/image-20240417154125404.png)

## 基本数据结构

* Redis 共有 5 种基本数据类型：String（字符串）、List（列表）、Set（集合）、Hash（散列）、Zset（有序集合）。

* 这 5 种数据类型是直接提供给用户使用的，是数据的保存形式，其底层实现主要依赖这 8 种数据结构：简单动态字符串（SDS）、LinkedList（双向链表）、Dict（哈希表/字典）、SkipList（跳跃表）、Intset（整数集合）、ZipList（压缩列表）、QuickList（快速列表）。

* Redis 5 种基本数据类型对应的底层数据结构实现如下表所示：

| String | List                         | Hash          | Set          | Zset              |
| :----- | :--------------------------- | :------------ | :----------- | :---------------- |
| SDS    | LinkedList/ZipList/QuickList | Dict、ZipList | Dict、Intset | ZipList、SkipList |

------

#### String 字符串

* 内部数据结构是SDS（简单动态字符串），可以用来存储任何类型的数据比如字符串、整数、浮点数，还可以获取字符串长度，复杂度为O(1)

* 使用于储存常规场景（缓存Session Token 图片地址等）、需要计数的场景

#### List 列表

* 数据结构是双向链表 LinkedList
* ![image-20240416161642947](C:/Users/WSJ/Desktop/704Sync_dataStructure/dataStructure/%E7%AC%AC%E4%B8%80%E8%BD%AE%E5%85%AB%E8%82%A1%E7%AC%94%E8%AE%B0/Redis.assets/image-20240416161642947.png)
* 适用于：**信息流展示**，比如：最新文章、最新动态

#### Hash 哈希

* 数据结构类似于JDK8里面的HashMap（数组+链表+红黑树），做了优化；属于Key-Value型数据
* 适用于：存储用户信息，商品信息，文章信息，购物车信息

#### Set 集合

* 类似于JAVA里面的HashSet；如果集合中的元素都是整数且元素个数小于 512 个，Redis 会使用**整数集合**作为 Set 类型的底层数据结构；不满足时，使用HashMap作为底层结构
* 交集并集差集等

#### ZSet 有序集合

* 底层实现是跳表，而不是红黑树、平衡树、B+树
* 相比于set，多了一个score，使得集合中元素能够有序排列
* 交集并集差集等

## 特殊数据类型

#### Bitmap位图（2.2版）

* Bitmap 存储的是连续的二进制数字（0 和 1），通过 Bitmap, 只需要一个 bit 位来表示某个元素对应的值或者状态，key 就是对应元素本身 。我们知道 8 个 bit 可以组成一个 byte，所以 Bitmap 本身会极大的节省储存空间。
* 你可以将 Bitmap 看作是一个存储二进制数字（0 和 1）的数组，数组中每个元素的下标叫做 offset（偏移量）。
* ![image-20240416163838229](C:/Users/WSJ/Desktop/704Sync_dataStructure/dataStructure/%E7%AC%AC%E4%B8%80%E8%BD%AE%E5%85%AB%E8%82%A1%E7%AC%94%E8%AE%B0/Redis.assets/image-20240416163838229.png)

####　HyperLogLog(基数统计)（2.8版）

* 一种有名的基数计数概率算法 ，基于 LogLog Counting(LLC)优化改进得来，并不是 Redis 特有的，Redis 只是实现了这个算法并提供了一些开箱即用的 API。
* 基数计数概率算法为了节省内存并不会直接存储元数据，而是通过一定的概率统计方法预估基数值（集合中包含元素的个数）。因此， HyperLogLog 的计数结果并不是一个精确值，存在一定的误差（标准误差为 `0.81%` ）。
* ![image-20240416164420208](C:/Users/WSJ/Desktop/704Sync_dataStructure/dataStructure/%E7%AC%AC%E4%B8%80%E8%BD%AE%E5%85%AB%E8%82%A1%E7%AC%94%E8%AE%B0/Redis.assets/image-20240416164420208.png)

## Geospatial (地理位置)（3.2版）

* Geospatial index（地理空间索引，简称 GEO） 主要用于存储地理位置信息，基于 Sorted Set 实现。

* 通过 GEO 我们可以轻松实现两个位置距离的计算、获取指定位置附近的元素等功能。

  ![img](C:/Users/WSJ/Desktop/704Sync_dataStructure/dataStructure/%E7%AC%AC%E4%B8%80%E8%BD%AE%E5%85%AB%E8%82%A1%E7%AC%94%E8%AE%B0/Redis.assets/image-20220720194359494.png)

## Stream





## 特殊类型

#### 布隆过滤器



##  补充

![image-20240417154333530](C:/Users/WSJ/Desktop/704Sync_dataStructure/dataStructure/%E7%AC%AC%E4%B8%80%E8%BD%AE%E5%85%AB%E8%82%A1%E7%AC%94%E8%AE%B0/Redis.assets/image-20240417154333530.png)

