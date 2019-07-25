class Node{
    Object value;
    Node leftNode;
    Node rightNode;

    public void add(Object num){
        if(value == null){
            value = num;
        }else{
            if((Integer) num - ((Integer) value)<=0){
                if(leftNode==null)
                    leftNode = new Node();
                leftNode.add(num);
            }else{
                if(rightNode == null)
                    rightNode = new Node();
                rightNode.add(num);
            }
        }
    }

    public static void main(String[] args){
        int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
        Node root = new Node(); //因为这里新建了一个对象，所以下面可以调用非static方法
        for(int each:randoms){
            root.add(each);
        }
    }


}
