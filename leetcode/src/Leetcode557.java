public class Leetcode557 {
    public String reverseWords(String s) {
        if(s==null || s=="") return s;
        StringBuffer sb = new StringBuffer();
        String[] strs = s.split(" ");
        for(int i = 0;i<strs.length;i++){
            StringBuffer sub = new StringBuffer(strs[i]); //fixme 这样子做就可以reverse()
            sub.reverse();
            sb.append(sub.toString()).append(" ");
        }
        return sb.toString().trim();
    }
}
