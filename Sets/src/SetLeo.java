import java.util.ArrayList;

public class SetLeo<E> {

    ArrayList<E>  list;

    public SetLeo(){
        list = new ArrayList<>();
    }

    public boolean add(E e) {
        boolean success = false;
        if(!list.contains(e)){
            list.add(e);
            success = true;
        }
        return  success;
    }

    public void print(){
        System.out.println(list);
    }

    public <E> SetLeo<E> intersection(SetLeo<E> A, SetLeo<E> B) {
        SetLeo<E> result = new SetLeo<>();
        for(E a: A.list){
            for(E b: B.list){
                if(a.equals(b)){
                    result.add(a);
                }
            }
        }
        return result;
    }

    public <E> SetLeo union(SetLeo<E> A, SetLeo<E> B) {
        SetLeo<E> result = new SetLeo<>();
        for(E a : A.list) { result.add(a); }
        for(E b : B.list) { result.add(b); }
        return result;
    }
}
