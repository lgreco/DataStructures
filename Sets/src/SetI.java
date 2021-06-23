import java.util.ArrayList;

public class SetI {

    private ArrayList<Integer> set;

    public SetI() {

        set = new ArrayList<Integer>(0);

    }

    public ArrayList<Integer> getList() {
        return set;
    }

    public void add(int i) {
        if (!set.contains(i))
            set.add(i);
    }

    public String toString() {
        String s = "{";

        if (!set.isEmpty())
            for (int i = 0; i < set.size(); i++) {
                if (i > 0) s += ",";
                s += set.get(i);
            }

        s += "}";

        return s;
    }

    public SetI intersection(SetI A, SetI B) {
        SetI u = new SetI();

        /* If empty, just return empty set */
        if (A.set.isEmpty() || B.set.isEmpty())
            return u;

        for (int i = 0; i < A.getList().size(); i++) {

            for (int j = 0; j < B.getList().size(); j++) {
                /* If they are the same, put them in the new set */
                if (A.getList().get(i) == B.getList().get(j)) {
                    u.add(A.getList().get(i));
                    break;
                }
            }
        }

        return u;
    }

    public SetI union(SetI A, SetI B) {
        SetI u = new SetI();

        /* Add both of them in, add method will take care of
            duplicates */

        for (int i = 0; i < A.getList().size(); i++)
            u.add(A.getList().get(i));

        for (int j = 0; j < B.getList().size(); j++)
            u.add(B.getList().get(j));

        return u;
    }

    public static void main(String[] args) {
        SetLeo a = new SetLeo();
        SetLeo b = new SetLeo();
        SetLeo c = new SetLeo();

        a.add(1);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        b.add(2);
        b.add(6);
        b.add(7);
        b.add(8);
        b.add(9);
        a.add(7);

        System.out.println("A:" + a.toString());
        System.out.println("B:" + b.toString());
        System.out.println("C:" + c.toString());
        System.out.println("A union B:" + a.union(a,b).toString());
        System.out.println("A intersection B:" + a.intersection(a,b).toString());
        System.out.println("A union C:" + a.union(a,c).toString());
        System.out.println("A intersection C:" + a.intersection(a,c).toString());
    }
}