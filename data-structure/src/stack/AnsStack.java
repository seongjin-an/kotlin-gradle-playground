package stack;

import array.Array;

public class AnsStack<T> {
    int top;
    Array<T> arrayStack;

    public AnsStack(){
        this.top = 0;
        this.arrayStack = new Array<>();
    }

    public AnsStack(int size){
        this.top = 0;
        this.arrayStack = new Array<>(size);
    }

    public T push(T data){
        if(isFull()){
            throw new IllegalAccessError("stack is full already");
        }
        arrayStack.add(data);
        top++;
        return data;
    }

    public T pop() {
        if(isEmpty()){
            throw new IllegalAccessError("empty");
        }
        return arrayStack.remove(--top);
    }

    public T peek() {
        if(isEmpty()){
            throw new IllegalAccessError("empty");
        }
        return arrayStack.get(top-1);
    }

    public boolean isFull(){
        return top == arrayStack.getSize();
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public void printAll(){
        arrayStack.printAll();
    }
}
