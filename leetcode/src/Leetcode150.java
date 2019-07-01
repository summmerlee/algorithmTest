import java.util.Stack;

public class Leetcode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack  = new Stack<>();
        for(String value: tokens){
            switch(value){
                case "+":
                    int ans = stack.pop()+stack.pop();
                    stack.push(ans);
                    break;
                case "-":
                    int mb= stack.pop();
                    int mz = stack.pop();
                    int ans1 = mz-mb;
                    stack.push(ans1);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer pop = stack.pop();
                    Integer pop1 = stack.pop();
                    stack.push(pop1 / pop);
                    break;
                default:
                    stack.push(Integer.valueOf(value));

            }
        }
        return stack.pop();
    }
}
