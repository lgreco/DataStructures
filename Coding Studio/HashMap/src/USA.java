import java.util.HashMap;

public class USA {

    static class State{
        String code;
        String abbreviation;
        String name;
        String stateBird;
        public State(String code, String abbreviation, String name, String stateBird) {
            this.code = code;
            this.abbreviation = abbreviation;
            this.name = name;
            this.stateBird = stateBird;
        }
    }

    public static void main(String[] args) {
        HashMap<String, State> state = new HashMap<>();
        State newState = new State("IL", "Ill.", "Illinois", "Norther Cardinal");
        state.put(newState.code, newState);
    }
}
