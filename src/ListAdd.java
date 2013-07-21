import java.util.ArrayList;
import java.util.List;


/*
 * 两个单链表（singly linked list），每一个节点里面一个0-9的数字， 输入就相当于两个大数了。
 * 然后返回这两个数的和（一个新list）。这两个输入的list 长度相等。 
 * 要求是：1. 不用递归。2. 要求算法在最好的情况下，只遍历两个list一次， 最差的情况下两遍。
 * 
 * 既然只能遍历两个输入链表一次，那我们就从高位加起呗。在这种限制条件下， 这是唯一的出路。然后呢？进位咋整？先加高位，再加低位， 低位产生的进位怎么加到高位去？我们可没有前向指针哦亲。既然没有前向指针， 我们就让一个临时指针指向高位，当低位相加产生进位时，我们就可以操作高位了。 让我们看看图示：

输入链表1： 1 2 3
输入链表2： 1 2 8
输出链表：  2 4  
两个指针：    p q
当指向输出链表当前结点的指针q发现3+8=11，产生进位，指向高位的p就将结点值加1。 注意，两个0-9的数相加，要么不进位，要么进位为1，只有两种情况。因此， 我们不用考虑进位是其它数，这一点很重要，后面会看到的。
这样就OK了吗？当然不是，如果你遇上连续进位，怎么破？请看下面的情况：

输入链表1： 1 2 3 4 5
输入链表2： 1 7 6 5 9
显然，指向高位的指针p总是紧跟着指向当前结点的指针q是不行的， 这样当遇上连续进位时，比p更高位的位也需要改变。既然p不能紧跟着q， 我们就不让它们紧挨着，给它们产生点距离。考虑一下，什么情况下会产生连续进位？ 9! 嗯，遇上9的时候。它要连续进位到哪一位？不为9的那一位。因此，指针p 要停留在和不为9的那一位上，看图示：

输入链表1： 1 2 3 4 5
输入链表2： 1 7 6 5 9
输出链表：  2 9 9 9
两个指针：  p       q
这回当q发现，需要进位了，只需要把p所指结点加1，然后把p，q间的结点都置0即可。 为什么都置0了呢，因为进位只可能是1，9+1=10，留在该位的自然是0了。
分析完毕，这种方法在任何时候都只需要遍历输入链表一次，空间复杂度O(1)。
 */

public class ListAdd {
	
	private static void printList(List<Integer> list){
		int begin = 0;
		while(list.get(begin) == 0) begin++;
		
		for(int i = begin; i < list.size(); i++){
			System.out.print(list.get(i));
		}
		System.out.println();
		
	}
	private static void sameSize(List<Integer> a, List<Integer> b){
		return;
	}
	private static void carrySum(List<Integer> sum, int p, int q){
		sum.set(p, sum.get(p)+1);
		for(int i = p+1; i < q; i++){
			sum.set(i, Integer.valueOf(0));
		}
	}
	private static List<Integer> listAdd(List<Integer> listA, List<Integer> listB){
		
		sameSize(listA, listB);
		
		List<Integer> outList = new ArrayList<Integer>();
		outList.add(0);
		
		int indexCarry = 0;
		
		int size = listA.size();
		
		for(int i = 0; i < size; i++){
			
			int sum = listA.get(i) + listB.get(i);
			
			if(sum > 9){
				carrySum(outList, indexCarry, i);
				sum = sum - 10;
			}
			if(sum != 9){
				indexCarry = i+1;
			}
			
			outList.add(sum);
		}
		return outList;
	}
	
	private static void makeList(List<Integer> aIntegers,String in){
		for(int i = 0; i < in.length(); i++){
			aIntegers.add(Integer.valueOf(in.charAt(i) - '0'));
		}
	}
	
	private static void test(){
		List<Integer> aIntegers = new ArrayList<Integer>();
		List<Integer> bIntegers = new ArrayList<Integer>();
		
		makeList(aIntegers, "1119991119988111");
		makeList(bIntegers, "9999991117777999");
		printList(aIntegers);
		printList(bIntegers);
		printList(listAdd(aIntegers,bIntegers));
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		test();
	}

}
