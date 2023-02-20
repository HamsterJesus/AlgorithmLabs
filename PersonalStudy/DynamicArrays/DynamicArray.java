package PersonalStudy.DynamicArrays;

public class DynamicArray {
    //creating my own dynamic array instead of using arraylist
    int size;
    int capacity = 10;
    Object[] array;

    //constructor for fixed array
    public DynamicArray(){
        this.array = new Object[capacity];

    }

    //second overloading constructor incase the user wishes to specify their own capacity
    public DynamicArray(int capacity){
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    //method for adding data to out dynamicArray
    public void add(Object data){ //takes in the data we'd like to add
        if(size >= capacity){ //checks if array is at capacity
            grow(); //if it is implement the grow method
        }
        array[size] = data; //add data at the index of size (the end of the array)
        size++; //increase size by one
    }

    //method for inserting new data in to our dynamic array
    public void insert(int index, Object data){ //takes in the data and index we'd like to insert
        if(size >= capacity){ //checks if array is at capacity
            grow(); //if it is implement the grow method
        }

        for(int i = size; i > index; i--){ //shifting our array to the right for inserstion
            array[i] = array[i-1];
        }
        array[index] = data; //set element at index to data
        size++;
    }

    //method for removing data from our dynamicArray
    public void delete(Object data) { //takes in the data we'd like to remove
        for(int i = 0; i < size; i++){ //iterate over array
            if(array[i] == data){ //if data is found to be equal to element in position of the array
                for(int j = 0; j < (size - i - 1); j++){ //shift elements after where we are deleting one spot to the left
                    array[i + j] = array[i + j + 1];
                }
                array[size - 1] = null;
                size--;

                if(size<= (int) (capacity/3)){
                    shrink();
                }
                break;
            }
        }
    }

    //method for searching for element in dynamic array
    public int search(Object data){ //takes in the specific element we are looking for

        for(int i = 0; i < size; i++){
            if(array[i] == data){
                return i;
            }
        }
        return -1;
    }

    //expands the size of our dynamicArray
    private void grow(){
        int newCapacity = (int) capacity * 2; //double capacity
        Object[] newArray = new Object[newCapacity]; //create new array with new capacity

        for(int i = 0; i < size; i++){
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    //reduces the size of our dynamicArray
    private void shrink(){
        int newCapacity = (int) capacity / 2; //double capacity
        Object[] newArray = new Object[newCapacity]; //create new array with new capacity

        for(int i = 0; i < size; i++){
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    //method checks if dynamicArray is empty
    public boolean isEmpty(){
        return size == 0; //if size is anything other than 0 we return false
    }

    public String toString(){
        String string = "";

        for(int i = 0; i < size; i++){ //iterate over the size of the array
            string += array[i] + ", "; //add value at index of the array to string
        }

        //formatting
        if(string != ""){
            string = "[" + string.substring(0, string.length() - 2) + "]"; //removes last space and comma and add []
        } else {
            string = "[]"; //if string is empty assign empty []
        }

        return string; 
    }
}
