
public class SoundLabProbs {

//2
public void triangle(int n){
	for(int i = 1; i <= n; i++){
		for(int j = 0; j < i; j++){
			System.out.print(i);
		}
		System.out.println();
	}
	
}

//3
public int lastIndexOf(int[] nums, int value){ 
	for(int i = nums.length-1; i >=0; i--){
		if(nums[i]==value)
			return i;
	}
	return -1;
}

//5
public int range(int nums[]){
	int smallest = 100;
	int largest = 0;
		for(int number: nums){
			if(number < smallest)
				smallest = number;
			if(number > largest)
				largest = number;
		}
	return largest-smallest;
}

//6
public int minDifference (int[] nums){
	int minDifference = 100;
		for(int i = 0;  i < nums.length-2;i++){
			if(Math.abs(nums[i]-nums[i+1])<minDifference)
				minDifference = Math.abs(nums[i]-nums[i+1]); 
		}	
	return minDifference;
}

//7
public int priceIsRight(int[] bids, int price){
	int winner = 0;
		for(int number: bids){
			if(number>winner && price-number>=0)
				winner = number;
		}
	if(winner==0)
		return -1;
	else
		return winner;
}

//8
public int[] productExceptSelf(int[] nums){
	int[] result = new int[nums.length];
		for(int i = 0; i < nums.length-1; i++){
			for(int j = 0; j < nums.length-1; j++){
			if(i==j)
				break;
			else
				result[i] *= nums[j];
			}
		}
	return result;
}

//Sound Lab
}

