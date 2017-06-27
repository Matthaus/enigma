package br.com.matthaus.enigma.rotors;

public class RotorTwo extends DefaultRotor {

    private static final char[] INPUT = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static final char[] OUTPUT = {'A', 'J', 'D', 'K', 'S', 'I', 'R', 'U', 'X', 'B', 'L',
            'H', 'W', 'T', 'M', 'C', 'Q', 'G', 'Z', 'N', 'P', 'Y', 'F', 'V', 'O', 'E'};

    public RotorTwo() {
        this.setReference(INPUT);
        this.setConversion(OUTPUT);
    }

}
