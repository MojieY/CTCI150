package stack_queue;

import java.util.ArrayList;

import stack_queue.Stacks;

public class StackSet extends Stacks {
	
private int limit = 10;
private ArrayList<Stacks> sets;
int sizeall = 0;
	
		public StackSet() {
	
		sets = new ArrayList<Stacks>();
		
		}
		
		public void push(int x) {
			if(sets.size() == 0){
				Stacks newStack = new Stacks();
				sets.add(newStack);
			}
			Stacks last = sets.get(sets.size()-1);
			if(last.getSize() >= limit){
				Stacks newStack = new Stacks();
				newStack.push(x);
				sets.add(newStack);
				sizeall++;
				
			}
			else{
				last.push(x);
				sizeall++;
			}
		}
		
		public void pop(){
			Stacks last = sets.get(sets.size()-1);
			last.pop();
			sizeall--;
			if(last.getSize() == 0){
				sets.remove(sets.size()-1);
			}
				
		}

		public Stacks getStack(int i) {
			return sets.get(i);
		}
		
		public int get2(int i){
			int count = i/limit;
			
			if(i%limit == 0){
				System.out.println();
				System.out.println("stack "+(count+1)+": ");
			}
			return sets.get(count).get(i%limit);
		}
	}


