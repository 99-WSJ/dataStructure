# 苍穹外卖



####  Apache POI

```
POI是一个处理office各种文件格式的开源项目，
简单讲就是可以再JAVA程序里读取和写入office文件，常用于Excel表读取和写入
```

1、写入本地磁盘：

* 内存中创建excel对象
* 创建工作簿，也就是sheet表
* 在sheet页中创建行
* 在行里面创建单元格，并设置内容值
* 通过输出流将内存中的excel写入到磁盘
* 关闭资源

2、读取本地资源

* 文件输入流，读到内存
* 通过带参数的构造函数创建excel表，参数就是刚刚那个文件
* 获取行数
* 读取每行的数据，打印出来
* 关闭资源

### 导出报表（30天台账数据）存档

接口设计：

```json
path: /admin/report/export
Method: Get
无返回值，因为导出报表的功能就是下载文件
```

实现步骤：

* 做好基础的excel模板：可能单元格比较复杂需要合并，颜色，居中。
* 做好模板后再读取，查询数据库
* 将数据写入模板中对应的区域
* 通过输出流将Excel文件下载到客户端浏览器



