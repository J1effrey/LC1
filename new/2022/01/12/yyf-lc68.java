// T: O(N) N是单词个数 
// S: O(L) L是所有单词长度和
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int index = 0;
        
        // 遍历所有的单词
        while (index < n) {
            // 第index个单词的长度
            int totalChars = words[index].length();
            // 下一个单词
            int last = index + 1;
            /* 
                此while loop用来找到可以插入单词的下标last
                实际插入到last-1
                例如："This", "is", "an", "example"
                      index                 last
            */
            while (last < n) {
                // 如果放置下一个单词长度超过了maxWidth直接另起一行
                if (totalChars + 1 + words[last].length() > maxWidth) {
                    break;
                }
                // 增加此时字符串长度(空格+last.length)
                totalChars += 1 + words[last].length();
                last++;
            }
            // 计算有多少个gap需要填补
            // 例如"This    is    an" => 有两个gap需要用空格填补
            int gaps = last - index - 1;
            StringBuilder sb = new StringBuilder();
            
            // 如果是最后一个单词或当前行只能放一个单词(gap==0) 后面全部补空格
            if (last == n || gaps == 0) {
                // 将index~last之间的单词用一个空格拼接到一起
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                }
                
                // 去掉尾部多余的空格
                sb.deleteCharAt(sb.length() - 1);
                // 补剩下的空格
                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
            } else {
                // 计算平均每个gap需要多少个空格
                int spaces = (maxWidth - totalChars) / gaps;
                // 计算多出来的空格
                int rest = (maxWidth - totalChars) % gaps;
                /* 
                maxWidth: 16
                gaps: 3
                spaces: 5  => 每个单词之间空格基础是5
                rest: 1  => 有1个gap需要多加1个空格
                */
                
                // 这里last-1是为了去掉尾部空格
                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                    // (i - index < rest ? 1 : 0) 用来判断如果是前rest个单词需要多加1个空格
                    for (int j = 0; j < spaces + (i - index < rest ? 1 : 0); j++) {
                        sb.append(' ');
                    }
                }
                sb.append(words[last - 1]);
            }

            res.add(sb.toString());
            // 更新index
            index = last;
        }

        return res;
    }
}
