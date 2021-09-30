public class CaesarCipher {

    private static final int valueA = (int) 'A';
    private static final int valueZ = (int) 'Z';

    public static String applyCipher(String inputMessage, int cipherShift) {
        String outputMessage = "";
        for (int i = 0; i < inputMessage.length(); i++) {
            char currentLetter = inputMessage.charAt(i);
            int currentLetterValue = (int) currentLetter;
            if ( (currentLetterValue >= valueA) && (currentLetterValue <= valueZ) ) {
                int shiftTo = currentLetterValue + cipherShift;
                if (shiftTo > valueZ) {
                    System.out.printf("\n ... We are passed Z and wrapping to the beginning ...");
                    shiftTo = valueA + cipherShift - (valueZ - currentLetterValue)-1;
                }
                if (shiftTo < valueA) {
                    shiftTo = valueZ - (currentLetterValue - valueA);
                    System.out.printf("\n ... input letter is %s, shifting by %d yields %s (%d) ...", currentLetter, cipherShift, ((char) shiftTo), shiftTo);
                }
                char cipherLetter = (char) shiftTo;
                outputMessage = outputMessage + cipherLetter;
            } else {
                System.out.printf("... non letter ... ( %s )", currentLetter);
                outputMessage = outputMessage + currentLetter;
            }
        }
        return outputMessage;
    }

    public static void main(String[] args) {
        String tryThis = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int shift = 12;
        String e = applyCipher(tryThis, shift);
        String d = applyCipher(e,-shift);
        System.out.printf("\n\nConverting between ASCII %d and ASCII %d", valueA,valueZ);
        System.out.printf("\n\nInput String: %s; Cipher shift: %d\n\n\tEncrypted message: %s\n\tDecrypted message: %s\n\n", tryThis, shift, e, d);
    }
}
