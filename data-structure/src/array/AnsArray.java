package array;

public class AnsArray {
    int[] intArr;
    int count;

    public int ARRAY_SIZE;
    public static final int ERROR_NUM = -999999999;

    public AnsArray(){
        count = 0;
        ARRAY_SIZE = 10;
        intArr = new int[ARRAY_SIZE];
    }

    public AnsArray(int size){
        count = 0;
        ARRAY_SIZE = size;
        intArr = new int[size];
    }

    public void addElement(int num){
        if(count >= ARRAY_SIZE){
            System.out.println("not enough memory");
            return;
        }
        intArr[count++] = num;
    }

    public int getElement(int position){
        if(position < 0 || position > count - 1) {
            System.out.println("ERROR");
            return ERROR_NUM;
        }
        return intArr[position];
    }

    public void insertElement(int position, int num){
        if(position < 0 || position > count) {
            return;
        }
        if(count >=ARRAY_SIZE) {
            return;
        }
        for(int i = count - 1; i >= position; i--){
            intArr[i+1] = intArr[i];
        }
        intArr[position] = num;
        count++;
    }

    public int removeElement(int position){
        int ret = ERROR_NUM;
        if(isEmpty()){
            System.out.println("Array is empty");
            return ret;
        }

        if(position < 0 || position > count - 1){
            System.out.println("ERROR");
            return ret;
        }

        ret = intArr[position];

        for(int i = position; i < count - 1; i++){
            intArr[i] = intArr[i+1];
        }
        count--;

        return ret;

    }

    public int getSize(){
        return count;
    }

    public boolean isEmpty(){
        if(count == 0){
            return true;
        }else{
            return false;
        }
    }

    public void printAll(){
        if(count == 0) {
            System.out.println("NO DATA");
            return;
        }
        for(int i = 0; i < count; i++) {
            System.out.print(intArr[i] + " ");
        }
        System.out.println();
    }

}
