import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingWithLambdas {

    public static void main(String[] args) {

        // A string array with some of my best friends' names
        String[] friends = {
                "Frodo", // a land owner in Hobbiton
                "Saruman", // Current resident of Orthanc
                "Gandalf", // a minor deity
                "Galadriel", // the Lady of light
                "Elrond", // Agent Smith from the Matrix, undercover
                "Y" // A french politician
        };

        System.out.println("Original list of friends:");
        for (String s:friends) {
            System.out.println(s);
        }

        System.out.println("\nNatural ordering sorted list of friends:");
        Arrays.sort(friends);
        for (String s:friends) {
            System.out.println(s);
        }

        System.out.println("\nFriends sorted by name length using anonymous class:");
        Arrays.sort(friends, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.length()+o2.length();
            }
        });
        for (String s:friends) {
            System.out.println(s);
        }

        System.out.println("\nFriends sorted by lambda expression:");
        Arrays.sort(friends, (String o1, String o2) -> o1.length()-o2.length());
        for (String s:friends) {
            System.out.println(s);
        }

        System.out.println("\nJust printing names fresh off the stream() pipeline:");
        Arrays.stream(friends).forEach(s -> System.out.println(s.charAt(0)));

        List<String> friendsList =  Arrays.asList(friends);
        // friendsList.add("Barak");
        // friendsList.add("Legolas");
        List<String> friendsListSorted = friendsList.stream().sorted().collect(Collectors.toList());
        System.out.println("\nSorted list with additional friends");
        friendsListSorted.forEach(s -> System.out.println(s));

    }
}
