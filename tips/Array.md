# Array

## 1. Array -> ArrayList

`Arrays.asList(T[])` T must be a reference type

- char -> Character
- int -> Integer
- String no constraint

## 2. int[] -> String[]

`String[] strArray = Arrays.stream(intArray).mapToObj(String::valueOf).toArray(String[]::new);`
