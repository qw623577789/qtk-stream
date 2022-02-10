YTK-Stream
================
增强JDK8的``Stream``,像Node.js数组``forEach``、``reduce``等函数那样,在遍历时可以获取**当前下标**、**长度**、**数组对象**

```java
@Test
void test() {
    List<Integer> array = new ArrayList<>() {
        {
            add(11);
            add(22);
            add(33);
        }
    };

    Stream
        .from(array.stream())
        .forEach(
            item -> {
                System.out.format(
                    "index:%s, value:%s, size:%s, list:%s\n",
                    item.index,
                    item.value,
                    item.size,
                    item.list
                );
            }
        );
}
```