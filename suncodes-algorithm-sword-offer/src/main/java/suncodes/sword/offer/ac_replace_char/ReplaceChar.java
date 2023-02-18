package suncodes.sword.offer.ac_replace_char;

public class ReplaceChar {

    public static void main(String[] args) {
        System.out.println(new ReplaceChar().replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {

        // StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象
        // 由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类
        StringBuilder res = new StringBuilder();

        // 利用方法 toCharArray 将字符串 s 转换成一个新的字符数组
        // 获取这个字符数组中的每个字符
        for (Character c : s.toCharArray()) {
            // 1、如果发现该字符为空格，即 ' '
            if (c == ' ') {
                // 那么在 res 中添加 %20
                res.append("%20");
                // 2、否则，如果发现该字符不是空格
            } else {
                // 那么在 res 中原字符
                res.append(c);
            }
        }
        // 最后把字符串返回
        return res.toString();
    }
}
