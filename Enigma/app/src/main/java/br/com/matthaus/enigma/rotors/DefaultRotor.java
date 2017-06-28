package br.com.matthaus.enigma.rotors;

public class DefaultRotor {

    protected char[] reference, conversion;
    protected RotorOnWorkedListener listener;

    public void process(char letter) {
        this.process(letter, 0);
    }

    public void process(char letter, int offset) {
        int inputIndex = indexInRotor(reference, letter);
        int shiftedIndex = inputIndex + offset;

        shiftedIndex = adjustIndex(shiftedIndex);

        listener.onProcessed(conversion[shiftedIndex], this);
    };

    public void propagate(char letter, int offset) {
        int outputIndex = indexInRotor(reference, letter);
        int shiftedIndex = adjustIndex(outputIndex - offset);
        char shiftedChar = reference[shiftedIndex];
        shiftedIndex = indexInRotor(conversion, shiftedChar);
        listener.onPropagated(reference[shiftedIndex], this);
    }

    public void setReference(char[] reference) {
        this.reference = reference;
    }

    public void setConversion(char[] conversion) {
        this.conversion = conversion;
    }

    public void setOnProcessedListener(RotorOnWorkedListener listener) {
        this.listener = listener;
    }

    protected int indexInRotor(char[] side, char letter) {
        for (int i = 0; i < 26; i++) {
            if (side[i] == letter)
                return i;
        }
        return -1;
    }

    protected int adjustIndex(int index) {
        if (index >= reference.length) {
            return index - reference.length;
        } else if (index < 0) {
            return reference.length + index;
        } else {
            return index;
        }
    }

}
