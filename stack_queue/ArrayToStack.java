package stack_queue;

public class ArrayToStack {
	
	static int stackSize = 10;
	static int[] buffer = new int[stackSize*3];
	static int[] stackPointer = {-1, -1, -1};

	public static void push(int value, int number) throws Exception{
		if(stackPointer[number]+1 >= stackSize){
			throw new Exception("Out of bound");
		}
		stackPointer[number]++;
		buffer[stackSize*number+stackPointer[number]] = value;
		
	}
	
	public static void pop(int number) throws Exception{
		if(stackPointer[number]<0){
			throw new Exception("Empty");
		}
		stackPointer[number]--;
		buffer[stackSize*number+stackPointer[number]] = 0;
	}

	public static void main(String[] args) throws Exception {
		
		push(2,1);
		push(3,1);
		push(2,1);
		push(3,1);
		push(2,1);
		push(3,1);
		push(2,1);
		push(3,1);
		push(2,1);
		push(3,1);
		
		pop(2);
		
		for(int i = 0; i<buffer.length; i++){
			if(i%10==0){
				System.out.println();
			}
			System.out.print(buffer[i]+" ");
		
		}

	}

}
