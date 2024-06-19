SQL索引失效

* 不符合最左匹配原则、中间有> <等
* %开头
* 使用函数或者类型转换

删除`name`字段为“小王”的多条记录，只保留一条，可以使用带有子查询的`DELETE`语句

* ```sql
  DELETE FROM user
  WHERE name = '小王'
  AND id NOT IN (
      SELECT id FROM (
          SELECT id FROM user
          WHERE name = '小王'
          ORDER BY id
          LIMIT 1
      ) AS temp
  );
  ```

* 

