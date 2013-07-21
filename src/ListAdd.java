import java.util.ArrayList;
import java.util.List;


/*
 * ����������singly linked list����ÿһ���ڵ�����һ��0-9�����֣� ������൱�����������ˡ�
 * Ȼ�󷵻����������ĺͣ�һ����list���������������list ������ȡ� 
 * Ҫ���ǣ�1. ���õݹ顣2. Ҫ���㷨����õ�����£�ֻ��������listһ�Σ� ������������顣
 * 
 * ��Ȼֻ�ܱ���������������һ�Σ������ǾʹӸ�λ�����¡����������������£� ����Ψһ�ĳ�·��Ȼ���أ���λզ�����ȼӸ�λ���ټӵ�λ�� ��λ�����Ľ�λ��ô�ӵ���λȥ�����ǿ�û��ǰ��ָ��Ŷ�ס���Ȼû��ǰ��ָ�룬 ���Ǿ���һ����ʱָ��ָ���λ������λ��Ӳ�����λʱ�����ǾͿ��Բ�����λ�ˡ� �����ǿ���ͼʾ��

��������1�� 1 2 3
��������2�� 1 2 8
�������  2 4  
����ָ�룺    p q
��ָ���������ǰ����ָ��q����3+8=11��������λ��ָ���λ��p�ͽ����ֵ��1�� ע�⣬����0-9������ӣ�Ҫô����λ��Ҫô��λΪ1��ֻ�������������ˣ� ���ǲ��ÿ��ǽ�λ������������һ�����Ҫ������ῴ���ġ�
������OK���𣿵�Ȼ���ǣ����������������λ����ô�ƣ��뿴����������

��������1�� 1 2 3 4 5
��������2�� 1 7 6 5 9
��Ȼ��ָ���λ��ָ��p���ǽ�����ָ��ǰ����ָ��q�ǲ��еģ� ����������������λʱ����p����λ��λҲ��Ҫ�ı䡣��Ȼp���ܽ�����q�� ���ǾͲ������ǽ����ţ������ǲ�������롣����һ�£�ʲô����»����������λ�� 9! �ţ�����9��ʱ����Ҫ������λ����һλ����Ϊ9����һλ����ˣ�ָ��p Ҫͣ���ںͲ�Ϊ9����һλ�ϣ���ͼʾ��

��������1�� 1 2 3 4 5
��������2�� 1 7 6 5 9
�������  2 9 9 9
����ָ�룺  p       q
��ص�q���֣���Ҫ��λ�ˣ�ֻ��Ҫ��p��ָ����1��Ȼ���p��q��Ľ�㶼��0���ɡ� Ϊʲô����0���أ���Ϊ��λֻ������1��9+1=10�����ڸ�λ����Ȼ��0�ˡ�
������ϣ����ַ������κ�ʱ��ֻ��Ҫ������������һ�Σ��ռ临�Ӷ�O(1)��
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
