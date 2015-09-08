//Creates a new data structure from Stack with added functionality of returning max element from it

import java.io.*;
import java.util.*;

class Stack {
  List<Integer> stack = new ArrayList<Integer>();
  int stackPointer = -1;
  
  Stack() {
  }
  
  public void push(int element) {
    this.stackPointer++;
    stack.add(stackPointer, element);
  }
  	
  public int pop() {
    int element = this.stack.get(stackPointer);
    this.stack.remove(stackPointer);
    this.stackPointer--;
    return element;
  }
  
  public int peek() {
	if(this.stack.isEmpty()) {
		return -1;
	}
	else {
		return this.stack.get(stackPointer);
	}
  }
 
}
  class MaxStack {
    Stack elementStack;
    Stack maxElements;
    
  MaxStack() {
      this.elementStack = new Stack();
      this.maxElements = new Stack();
      this.maxElements.push(0);
    }
    
    public void push(int element) {
      this.elementStack.push(element);
      if(this.maxElements.peek() == -1) {
    	  return;
      }
      else if(this.maxElements.peek() < element) {
        maxElements.push(element);
      }
    }
    
    public int peek() {
      return this.elementStack.peek();
    }
    
    public int pop() {
      int element = this.elementStack.pop();
      if(element == this.maxElements.peek()) {
        int removeMax = this.maxElements.pop();
      }
      return element;
    }
    
    public int getMax() {
      return this.maxElements.peek();
    }
  }


class MaxStackImpl {
  public static void main(String[] args) {
	  MaxStack newStack = new MaxStack();
	  newStack.push(0);
	  System.out.println(newStack.getMax());
	  newStack.push(6);
	  System.out.println(newStack.getMax());
	  newStack.push(9);
	  System.out.println(newStack.getMax());
	  newStack.pop();
	  System.out.println(newStack.getMax());
  }
}


