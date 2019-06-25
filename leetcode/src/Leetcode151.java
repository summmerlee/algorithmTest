public class Leetcode151 {
    // Error 这个不能解决中间单词之间相差很多空格的问题 普通的测试用例可以
    public String reverseWordsError(String s) {
        if(s==null || s=="") return s;
        s=s.trim();
        String[] strs = s.split(" ");
        int i=0, j=strs.length-1;
        while(i<j){
            String temp = strs[i];
            strs[i]=strs[j];
            strs[j]=temp;
            i++;j--;
        }
        String res = String.join(" ",strs);
        return res;
    }

    // fixme 正确版本
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        String[] strs = s.trim().split(" ");
        for(int i=strs.length-1;i>=0;i--){
            if(!strs[i].trim().isEmpty()){ // fixme 也可以写 !strs[i].equals("")注意这里的引号内没有空格
                sb.append(strs[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }



}
