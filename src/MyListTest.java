import java.util.ArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList=new MyList<>();
        myList.add(0,1);
        myList.add(1,2);
        myList.add(2,3);
        myList.add(3,4);
        myList.add(4,8);

        myList.remove(1);
//        System.out.println(myList.get(0));
//        System.out.println(myList.get(1));
//        System.out.println(myList.get(2));
//        System.out.println(myList.get(4));

        System.out.println(myList.indexOf(4));

        System.out.println(myList.contains(8));
    }
}
