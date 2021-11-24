# Clean Code

## 二、有意义的命名

### 2.2 名副其实

下面代码的问题不在于简洁度而在于模糊度：

```java
public List<Int[]> getThem(){
	List<int[]> list1 = new ArrayList<>();
  for (int[] x : theList) { 						// theList是什么东西？
    if (x[0] == 4)  // theList下标为0的意义是什么  
      list1.add(x);  //  值4的意义是什么？
  return list1;    // 我怎么使用返回的列表
}
```

如果我们需要做一个扫雷游戏，盘面是名为theList的单元格列表，那就将其改名为gameBoard。盘面上每一个单元格都用一个简单的数组表示。我们还发现，零下表条目其实是一种状态，而这种状态值为4表示为以标记。

__改进版本1__

```java
public List<int[]> getFlaggedCells() {
  List<int[]> flaggedCells = new ArrayList<>();
  for (int[] cell : gameBoard) {
    if (cell[STATUS_VALUE] == FLAGGED) {
      flaggedCells.add(cell);
    }
  }
  return flaggedCells;
}
```

__改进版本2:可以创建一个类，其中包含一个isFlagged函数表示是否被标记，从而掩盖magic number（魔术数） 4__

```java
public List<Cell> getFlaggedCells() {
  List<Cell> flaggedCells = new ArrayList<>();
  for (Cell cell : gameBoard) {
    if (cell.isFlagged()) {
      flaggedCells.add(cell);
    }
  }
  return flaggedCells;
}
```

==只需要简单得改一下名称，就能轻易地知道发生了什么，这就是选好名字的力量:bulb:==

### 2.3 避免误导

1. 程序员应该避免留下掩盖代码本意的错误线索。例如hp（hypotenuse）
2. 别用accountList来代表一组账号，除非他真的是List类型。因为LIst对程序员有特殊含义。我们可以采用accountGroup、bankOfAccounts甚至直接使用accounts都会好一些
3. 提防使用不同之处很少的名称。例如区分XYZControllerForEfficientHandlingOfStrings和XYZControllerForEfficient StorageOfStrings。
4. 我们也要避免使用小写字母"l"和大写字母"O"，因为他们实在太像数字1和0了



### 2.4 做有意义的区分

1. ==以数字命名是以定义命名的对立面，这样纯属误导--完全没有提供正确的信息==  

```java
public static void copyChars(char a1[], char a2[]) {
  for (int i = 0; i < a1.length; i++) {
    a2[i] = a1[i];
  }
}

// 如果我们讲参数名改为source和destination，这个函数就会像样很多
public static void copyChars(char source[], char destination[]) {
  for (int i = 0; i < source.length; i++) {
    destination[i] = source[i];
  }
}
```

2. ==另外一种没有意义的区分==

- 假如你有一个Product类。如果还有一个productInfo或ProductData类，那他们的名称虽然不同，意义却无差别，Info和Data就像a、an和the一样，是容易搞混的废话。
- ⚠️：__主要体现有意义的区分，使用a和an这样的前缀就没有问题。例如，你可以把a用于域内变量，把the用于函数参数__
- 废话都是冗余的。variable就不该出现在变量中，Table就不该出现在表名中 `getActiveAccount` `getActiveAccounts` `getActiveAccountInfo` 程序员该怎么知道该调用哪个函数



### 2.5 使用读得出来的名称

反例：genymdhms（生产日期、年、月、日、时、分、秒）

比以下两端代码

```java
class DtaRcrd102 {
  private Date genymdhms;
  private Date modymdhms;
  private final String pszqint = "102";
}

class Customer {
  private Date generationTimestamp;
  private Date modificationTimestamp;
  private final String recordId = "102";
}
```

### 2.6 使用可搜索的名称

==名称的长短应该与其作用域大小成正比，如果变量或常量可能在代码中多处使用，则应该赋予其便于搜索的名称==

比较如下代码: （注意：下面的sum虽然不是很有用的名称，不过至少它搜得到）

```java
for (int j = 0; j < 34; j++) {
  s += (t[j]*4)/5;
}

int realDaysPerIdealDay = 4;
const int WORK_DAY_PER_WEEK = 5;
int sum = 0;
for (int j = 0; j < NUMBER_OF_TASKS; j++) {
  int realTaskDays = taskEstimate[j] * realDaysPerIdealDay;
  int realTaskWeeks = (realdays / WORK_DAY_PER_WEEK);
  sum += realTaskWeeks;
}
```

