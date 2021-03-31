public class GemList{
	private class Node{
		private Gem gem;
		private Node next;
	}

	private int size;
	private Node head;

	public GemList(){
		size = 0;
		head = null;
	}

	public int size(){
		return this.size;
	}

	public void draw(double y){
		Node current = head;
		int index = 0;

		while(current != null){
			double x = GemGame.indexToX(index);
			current.gem.draw(x, y);

			//move onto next index
			current = current.next;
			index++;
		}
	}

	@Override
	public String toString(){
		String rep = new String();

		//traverses through linked list and adds gems to String
		Node current = head;
		while(current != null){
			rep += current.gem.toString()+", ";
			current = current.next;
		}

		return rep;
	}

	public void insertBefore(Gem gem, int index){
		if(head == null){
			head = new Node();
			head.gem = gem;
			this.size++;
		}
		else if(index >= size){
			//adds gem to the end
			Node current = head;
			while(current.next != null)
				current = current.next;
			current.next = new Node();
			current.next.gem = gem;
			this.size++;
		}
		else{
			//finds correct index to stop on
			Node current = head;
			for(int i = 0; i < index-1; i++)
				current = current.next;

			//creates new Node and sets its gem
			Node insert = new Node();
			insert.gem = gem;

			//if inserted at beginning
			if(index == 0){
				insert.next = head;
				head = insert;
			}
			//if inserted in the middle
			else{
				insert.next = current.next;
				current.next = insert;
			}
			this.size++;
		}
	}

	public int score(){
		//return variable
		int score = 0;
		
		if(this.size() != 0){
			//traversing variable
			Node now = head;
			int sameCount = 1;
			GemType current = now.gem.getType();
			int miniScore = now.gem.getPoints();
			
			if(now.next != null)
				now = now.next;
			else 
				return now.gem.getPoints();
			
			while(now != null){
				if(now.gem.getType() == current){
					miniScore += now.gem.getPoints();
					sameCount++;
				}
				else{
					score += miniScore*sameCount;
					miniScore = now.gem.getPoints();
					sameCount = 1; 
					current = now.gem.getType();
				}
				now = now.next;
			}
			score += miniScore*sameCount;
		}

		return score;
	}

	public static void main(String [] args){
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);		

		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);

		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);

		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);

		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);

		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);

		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);		
	}	
}
