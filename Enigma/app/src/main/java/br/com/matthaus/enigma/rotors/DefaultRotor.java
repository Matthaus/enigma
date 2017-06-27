package br.com.matthaus.enigma.rotors;

public class DefaultRotor {


    private char[] input, output;
    private int currentPosition = 0;
    private RotorOnProcessedListener listener;
    private boolean isRotative = true;
    private int fullRoundStepCount = 1;
    private int stepProcessed = 0;

    public void process(char letter, int offset) {
        stepProcessed++;
        if (isRotative && stepProcessed % fullRoundStepCount == 0) {
            currentPosition++;
        }
        int indexInput = indexInRotor(letter) + currentPosition - offset;
        if (indexInput >= 26) {
            indexInput -= 26;
        }
        char returnChar = output[indexInput];
        listener.onProcessed(returnChar, currentPosition);
    };

    public void setIsRotative(boolean isRotative) {
        this.isRotative = isRotative;
    }

    public void setInput(char[] input) {
        this.input = input;
    }

    public void setOutput(char[] output) {
        this.output = output;
    }

    public void fullRoundStepCount(int fullRoundStepCount) {
        this.fullRoundStepCount = fullRoundStepCount;
    }

    public void setOnProcessedListener(RotorOnProcessedListener listener) {
        this.listener = listener;
    }

    private int indexInRotor(char letter) {
        for (int i = 0; i < 26; i++) {
            if (input[i] == letter)
                return i;
        }
        return -1;
    }

}
