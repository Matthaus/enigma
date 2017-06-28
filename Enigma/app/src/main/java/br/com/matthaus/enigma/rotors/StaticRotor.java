package br.com.matthaus.enigma.rotors;

public class StaticRotor extends DefaultRotor {

    private static final char[] INPUT = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static final char[] OUTPUT = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public StaticRotor() {
        this.setReference(INPUT);
        this.setConversion(OUTPUT);
    }

    @Override
    public void process(char letter, int offset) {
        listener.onProcessed(letter, this);
    }

    @Override
    public void propagate(char letter, int offset) {
        int outputIndex = indexInRotor(reference, letter);
        int shiftedIndex = adjustIndex(outputIndex + offset);
        listener.onPropagated(reference[shiftedIndex], this);
    }
}
