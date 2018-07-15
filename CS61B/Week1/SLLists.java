/* An SSLists is an list of integer */

public class SLLists {

	public class IntNode {
		public int item;
		public IntNode next;
		public IntNode(int i,IntNode n){
			item = i;
			next = n;
		}
	}

	/*private IntNode first;*/
	private IntNode sentinel;

	public SLLists (){
		sentinel = new IntNode (63,null);
	}

	public SLLists (int x){
		sentinel = new IntNode(63,null);
		sentinel.next = new IntNode(x,null);
	}

	public static void main (String[] args){
		/* Creat a new Nodelist */
		SLLists L = new SLLists (15);
		L.addFirst(10);
		L.addFirst(5);
		L.addLast(20);
		System.out.println(L.getFirst());
		System.out.println(L.size());
	}

	/* Add x to he front of the list */
	public void addFirst (int x){
		sentinel.next = new IntNode (x,sentinel.next);
	}
	/* Return the first item of in the list */
	public int getFirst(){
		return sentinel.next.item;
	}

	private static int size(IntNode p){
		if (p.next == null){
			return 1;
		}
		return 1+ size(p.next);
	}

	public int size(){
		return size(sentinel.next)-1;
	}


	/* Add an item to the end of list */
	public void addLast (int x){
		IntNode p = sentinel;
		while (p.next != null){
			p = p.next;
		}
		p.next = new IntNode(x,null);
	}
}