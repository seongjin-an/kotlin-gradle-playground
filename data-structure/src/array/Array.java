package array;

import java.util.Arrays;

public class Array<T> {
    Object[] elements;
    int count;

    public int size;

    public Array(){
        this.count = 0;
        this.size = 10;
        elements = new Object[size];
    }

    public Array(int size){
        this.count = 0;
        this.size = size;
        elements = new Object[size];
    }

    public T add(T data){
        ensureCapacityHelper(count + 1);
        elements[count++] = data;
        return data;
    }

    public T get(int position){
        if(position < 0 || position > count - 1){
            throw new ArrayIndexOutOfBoundsException("not enough");
        }
        return (T)elements[position];
    }

    public T insert(int position, T data){
        if(position < 0 || position > count){
            throw new ArrayIndexOutOfBoundsException("not enough");
        }
        ensureCapacityHelper(count + 1);
        System.arraycopy(elements, position, elements, position + 1, count - position);
        elements[position] = data;
        count++;
        return data;
    }

    public T remove(int position){
        if(count == 0){
            throw new ArrayIndexOutOfBoundsException("ERROR");
        }
        if(position < 0 || position > count - 1){
            throw new ArrayIndexOutOfBoundsException("ERROR");
        }
        T obj = (T)elements[position];
        System.arraycopy(elements, position + 1, elements, position, count - position - 1);
        elements[--count] = null;
//        count--;
        return obj;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void printAll(){
        if(count == 0){
            System.out.println("NO DATA");
            return;
        }
        for(int i = 0; i < count; i++){
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    private void ensureCapacityHelper(int minCapacity) {
        if (minCapacity - this.size > 0)
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        this.size = this.size + 3;
        this.elements = Arrays.copyOf(elements, this.size + 3);
    }
}
