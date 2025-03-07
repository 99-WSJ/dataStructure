package structure.test;
import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试一下ArrayStack 是否正确
        //先创建一个ArrayStack对象->表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~~");
    }


}

//数组模拟栈结构
class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int size) {
        this.maxSize = size;
        this.stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return this.top == maxSize -1;
    }
    public boolean isEmpty() {
        return this.top == -1;
    }

    public void push(int value) {
        if(isFull()) {
            System.out.println("栈满，无法放入");
        } else {
            top ++;
            stack[top] = value;
        }

    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("");
            throw new RuntimeException("栈空，无法出栈");
        }else {
            int value = stack[top];
            top --;
            return value;
        }
    }
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空，无法出栈");
            return;
        }
        for (int i = top; i > -1; i--) {
            System.out.printf("stack[%d]: %d", top, stack[top]);

        }
    }
}

//单链表实现栈结构
class LinkedStack {
    private HeroNode head = new HeroNode(0,"","");
    public boolean isEmpty() {
        return head.next == null;
    }
    public LinkedStack() {

    }
    public void push(HeroNode node) {
        HeroNode temp = head;
        while(true) {
            if(temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }
    public int getLength() {
        if(isEmpty()){
            return 0;
        }
        int length = 0;
        HeroNode temp  = head;
        while(temp.next != null) {
            length ++;
            temp = temp.next;
        }
        return length;
    }

    public void list() {
        if(isEmpty()) {
            return;
        }
        HeroNode temp = this.head.next;
        while(temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void pop() {
        if(isEmpty()) {
            System.out.println("已经为空");
            return;
        }

        System.out.println(head.next);
        HeroNode temp = head.next.next;
        head.next.next = null;
        head.next = temp;

    }
    //单链表反转
    public  void reverseList() {
        //如果为空或者只有一个元素，不需要反转
        if(head.next == null) {
            return ;
        }
        if(head.next.next == null) {
            return ;
        }
        HeroNode cur = head.next;
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode next = null;

        while(cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next =  reverseHead.next;
    }
}
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点
    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
    }

}