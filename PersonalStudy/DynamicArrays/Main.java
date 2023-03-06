package PersonalStudy.DynamicArrays;

public class Main {
    public static void main(String[] args) {
        //Taking default capacity from DynamicArray class
        DynamicArray dynamicArray = new DynamicArray(5);
        //System.out.println(dynamicArray.capacity); //result is 10

        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        dynamicArray.add("D");
        dynamicArray.add("E");
        dynamicArray.add("F"); //Once the array gets to the point of being full it doubles in capacity

        //keep deleting and the capcity shrinks back down to half to avoid wasted space
        dynamicArray.delete("A");
        dynamicArray.delete("B");
        dynamicArray.delete("C");
        

        //dynamicArray.insert(0, "X");
        //dynamicArray.delete("A");
        //System.out.println(dynamicArray.search("C"));
        

        System.out.println(dynamicArray);
        System.out.println("capacity:" + dynamicArray.capacity); //10
        System.out.println("size:" + dynamicArray.size); //4
        System.out.println("empty:" + dynamicArray.isEmpty()); //true

        //Setting out own capacity
        //DynamicArray dynamicArray = new DynamicArray(5);
        //System.out.println(dynamicArray.capacity); //result is 5
    }
}
