import java.util.Random;

public class PerformanceAnalysis {

    public static String randomLetters(int howMany) {
        Random rng = new Random();
        String output = "";
        for (int i = 0; i < howMany; i++) {
            output += (char)(65+rng.nextInt(26));
        }
        return output;
    }

    public static LinkedList populateList(int ofSize, int stringLength) {
        LinkedList newList = new LinkedList();
        for (int i = 0; i < ofSize; i++) {
            newList.addNode(randomLetters(stringLength));
        }
        return newList;
    }

    public static double[] countSteps(LinkedList listA, LinkedList listB, int smooth) {
        double stepsCount[] = new double[2];
        int eleganceAccumulator = 0;
        int efficiencyAccumulator = 0;
        for (int i = 0; i < smooth; i++) {
            listA.intersectionByCount(listB);
            listA.intersects(listB);
            eleganceAccumulator += listA.getElegantSteps();
            efficiencyAccumulator += listA.getEfficientSteps();
        }
        stepsCount[0] = ((double) eleganceAccumulator)/((double) smooth);
        stepsCount[1] = ((double) efficiencyAccumulator)/((double) smooth);
        return stepsCount; // [0] elegance; [1] efficiency
    }

    public static double probSameWord(int among, int length) {
        double amg = (double) among;
        double len = (double) length;
        return 1.0 - Math.exp((-Math.pow(amg,2)/2.0*(Math.pow(26,len))));
    }

    public static void collectData(int fromPower2, int toPower2, int stringLength, int smooth){
        int currentPower2 = fromPower2;
        while (currentPower2 <= toPower2) {
            int listSize = (int) Math.pow(2,currentPower2);
            LinkedList listA = populateList(listSize,stringLength);
            LinkedList listB = populateList(listSize,stringLength);
            double results[] = countSteps(listA, listB, smooth);
            double speedUp = 100.0*(results[0]-results[1])/results[1];
            double probability = probSameWord(listSize, stringLength);
            System.out.printf("%5d %10.6f %10.6f %10.6f %10.6f\n", listSize, probability, results[0], results[1], speedUp);
            currentPower2++;
        }
    }

    public static void main(String[] args) {
        collectData(0, 8, 2,100);
    }
}
