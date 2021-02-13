import java.util.ArrayList;
import java.util.HashMap;

public class Set {


    public static void main(String[] args) {

// create object of ArrayList

        ArrayList<Integer> set1 = new ArrayList<Integer>();
        ArrayList<Integer> set2 = new ArrayList<Integer>();
        ArrayList<Integer> set3 = new ArrayList<Integer>();

// adding the set numbers

        set1.add(1);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

// Set 2

        set2.add(1);
        set2.add(10);
        set2.add(3);
        set2.add(9);
        set2.add(5);


// print if sets are identical or not

        System.out.println("\nSet1 : "+set1);
        System.out.println("Set2 : "+set2);


        System.out.println("Are both sets Identical : "+isidentical(set1, set2));


//   print union if sets

        System.out.println("\n\nSet1 : "+set1);
        System.out.println("Set2 : "+set2);

        set3 = union(set1, set2);

        System.out.println("Union : "+set3);

//       print intersection if sets

        System.out.println("\n\nSet1 : "+set1);
        System.out.println("Set2 : "+set2);

        set3 = intersection(set1, set2);

        System.out.println("Intersection : "+set3);
        System.out.println(set1);




    }

// method to find union of 2 sets(Arraylist)

    public static ArrayList<Integer> union(ArrayList<Integer> set1, ArrayList<Integer> set2){

        ArrayList<Integer> list = new ArrayList<Integer>();

// copy elements of set2

        for(int i=0; i<set2.size(); i++) {

            list.add(set2.get(i));

        }

// iterate over both sets using nested for loop

        for(int i=0; i<set1.size(); i++) {

            boolean flag = false;

            for(int j=0; j<set2.size(); j++) {

//               if element is in both sets the flag = true

                if(set1.get(i) == set2.get(j)) {

                    flag = true;

                }

            }

//           if the value is not in set2 then add it to list

            if(flag == false) {
                list.add(set1.get(i));
            }

        }

        return list;
    }

//   method to find the intersection of 2 sets

    public static ArrayList<Integer> intersection(ArrayList<Integer> set1, ArrayList<Integer> set2){

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<set1.size(); i++) {

            for(int j=0; j<set2.size(); j++) {

//   if both sets consists same value then add it to the list and set it to null,

                if(set1.get(i) == set2.get(j) && set1.get(i)!=null) {

                    list.add(set1.get(i));
                    set1.set(i, null);
                    set2.set(j, null);

                }

            }

        }

        return list;
    }

//   return if sets are identical or not

    public static boolean isidentical(ArrayList<Integer> set1, ArrayList<Integer> set2) {

//       create object if hashmap

        HashMap<Integer, Integer> map = new HashMap<>();

//       put all elements of set1 in hashmap

        for(int i=0;i<set1.size(); i++) {

            map.put(set1.get(i), 1);

        }

//       iterate through set2
//       if map does not contain any value of set2 then return false

        for(int i=0;i<set2.size(); i++) {

            if(! map.containsKey(set2.get(i))) {

                return false;
            }

        }

//       else return true

        return true;

    }


}