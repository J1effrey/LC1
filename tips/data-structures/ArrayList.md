# ArrayList



## 1. ArrayList -> Array

- `s.toArray()` Array must be a reference type
- `list.stream().mapToInt(i -> i).toArray();`
- `(int[])x.toArray(int[x.size()])` [link](https://stackoverflow.com/questions/718554/how-to-convert-an-arraylist-containing-integers-to-primitive-int-array)
- `res.stream().map(list -> list.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);`



​	

