public class CharGridTest 
{

	public static void main(String[] args) 
	{
		CharGridTest.testCountPlus01();
	}
	
	public static 
	void testCharArea01()
	{
		char[][] grid = new char[][] {
			{'a', 'b', 'c', 'd'},
			{'a', ' ', 'c', 'b'},
			{'x', 'b', 'c', 'a'}
		};
		
		CharGrid c = new CharGrid(grid);

		System.out.println(c.charArea('a')); //should be 12 (3x4)
		System.out.println(c.charArea('c')); //should be 3  (3x1)
	}
	
	public static void testCharArea02()
	{
		char[][] grid = new char[][] {
			{'c', 'a', 'x'},
			{'b', ' ', 'b'},
			{' ', ' ', 'a'}
		};
		
		CharGrid c = new CharGrid(grid);

		System.out.println(c.charArea('a')); //should be 6 (2x3)
		System.out.println(c.charArea('c')); //should be 1 (1x1)
	}
	
	public static void testCountPlus01()
	{
		char[][] grid =
		   {{' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
			{' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
			{'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'},
			{' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
			{' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},
			{'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
			{' ', 'x', 'x', ' ', ' ', 'y', ' ', ' ', ' '}};

		CharGrid c = new CharGrid(grid);

		System.out.println(c.countPlus()); //should be 2
	}
}
