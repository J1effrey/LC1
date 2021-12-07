# hashMap

## 1. Iteration

```java
for (Map.Entry<K, V> entry : map.entrySet()) {
    entry.getValue();
    entry.getKey();
}
```

## 2. GET

```java
map.get(key);
map.getOrDefault(key, 0)
```

## 3. PUT

```java
map.put(k, v);

// 如果存在key，就不执行替换操作  返回值是key所对应的value值
map.putIfAbsent(k, v) 
```

## 4. merge

`hashmap.merge(key, value, remappingFunction)`

**参数说明：**

- key - 键
- value - 值
- remappingFunction - 重新映射函数，用于重新计算值

如果 key 对应的 value 不存在，则返回该 value 值，如果存在，则返回通过 remappingFunction 重新计算后的值。

```java
Map<String, Integer> counts = new HashMap<>();
for (String word : words) {
  counts.merge(word, 1, Integer::sum);
}
String[] wordSet = counts.keySet().toArray(new String[0]);
```

