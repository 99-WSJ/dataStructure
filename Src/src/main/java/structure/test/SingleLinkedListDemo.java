package test;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		//进行测试
		//先创建节点
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

		//创建要给链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();

		//加入
//		singleLinkedList.add(hero1);
//		singleLinkedList.add(hero4);
//		singleLinkedList.add(hero2);
//		singleLinkedList.add(hero3);
		// 按no插入
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero3);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.list();

		//根据no修改
		HeroNode node = new HeroNode(2, "小卢", "玉麒麟");
		singleLinkedList.updata(node);
		System.out.println("修改后的链表情况");
		singleLinkedList.list();


		singleLinkedList.del(1);
		System.out.println("删除后的链表情况");
		singleLinkedList.list();
	}
}


class SingleLinkedList {
	private HeroNode head = new HeroNode(0,"","");

	public void add(HeroNode heroNode) {

		HeroNode temp = head;
		while (true) {
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
	}

	//根据排名no加入链表
	public void addByOrder(HeroNode heroNode) {
		HeroNode temp = head;
		boolean flag = false;
		while(true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no > heroNode.no) {
				break;
			}
			else if (temp.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.printf("准备插入的编号%d已经不存在了，不能加入\n", heroNode.no);
		}else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	public void list() {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head.next;
		while(true)  {
			if(temp.next == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}


	public void updata(HeroNode node) {
		boolean flag = false;
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}

		//为什么是head.next,不是head；考虑最后一个节点updata
		//先if(temp.no == node.no)，可以不用head.next
//		HeroNode temp = this.head.next;
		HeroNode temp = this.head;


		while(true) {
			if(temp.no == node.no) {
				flag = true;
				break;

			}
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = node.name;
			temp.nickname = node.nickname;
		}else {
			System.out.printf("没有找到编号为%d的节点", node.no);
		}
	}

	public void del(int no) {
		boolean flag = false;
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = this.head;


		while(true) {
			if (temp.next == null) {
				break;
			}
			if(temp.next.no == no) {
				flag = true;
				break;

			}
			temp = temp.next;
		}
		if (flag) {


			temp.next = temp.next.next;
		}else {
			System.out.printf("没有找到编号为%d的节点", no);
		}
	}
}


//定义HeroNode ， 每个HeroNode 对象就是一个节点
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
