package algorithms.array;

/**
 * 12.整数转罗马数字
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M
 *
 * 字符          数值
 *  I             1
 *  V             5
 *  X             10
 *  L             50
 *  C             100
 *  D             500
 *  M             1000
 *
 *  例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II
 *  通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV，这个特殊的规则只适用于以下六种情况
 *  I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9
 *  X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 *  C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900
 *  给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内
 *
 *  示例:
 *  输入: 58
 *  输出: "LVIII"
 */
public class IntegerToRoman_12 {

    /**
     * 贪心法
     * 时间复杂度 O(1)
     * 空间复杂度 O(1)
     */
    public String intToRoman(int num) {
        // 由大到小创建罗马数字与阿拉伯数字的对应表
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        /**
         * 采用类似找钱的思想, 收银员在收钱的时候肯定希望我们支付较大面额的纸币, 这样我们给出的张数最少, 对方点钱也比较方便
         * 同样在构造罗马数字的时候, 罗马数字的设计者肯定不希望我们把数字全部用I累加起来, 应该是希望出现的罗马数字越少越好
         * 所以我们从最大的罗马数字开始遍历, 从大到小开始构造罗马数字
         */
        for (int index = 0; index < nums.length; ) {
            // 当前阿拉伯数字大于指针所指罗马数字时, 拼接罗马数字并减去对应阿拉伯数字的值, 否则移动指针
            if (num >= nums[index]) {
                sb.append(romans[index]);
                num -= nums[index];
            } else {
                index++;
            }
        }
        return sb.toString();
    }
}