public class Leetcode14 {
    public static String myLongestCommonPrefix(String[] strs) {
        // 这是我的方法 9ms 很差了
        if(strs.length==0 || strs[0]=="")
            return "";
        StringBuffer sb = new StringBuffer();
        boolean flag = true;
        for(int i=0;i<strs[0].length();i++){
            sb.append(strs[0].charAt(i));
            for(String each:strs){
                if(!each.startsWith(sb.toString())){
                    flag = false;
                    sb.deleteCharAt(sb.length()-1);
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }

    // fixme: 这个是最好的方法
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        StringBuilder sb = new StringBuilder(strs[0]);
        if (strs.length == 1)
            return sb.toString();
        int i = sb.length() - 1, j = 1;
        while (i>=0 && j<strs.length){
            if(strs[j].indexOf(sb.toString()) !=0){
                sb.deleteCharAt(i);
                i--;
            }else
                j++;
        }

        return sb.toString();
    }


    public static void main(String[] args){
        String[] strs = {"","ha","shaz"};
        String res = myLongestCommonPrefix(strs);
        System.out.println(res);
    }

}