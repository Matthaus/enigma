package br.com.matthaus.enigma.rotors;

public class RotorOne extends DefaultRotor {

    private static final char[] INPUT = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static final char[] OUTPUT = {'E', 'K', 'M', 'F', 'L', 'G', 'D', 'Q', 'V', 'Z', 'N',
            'T', 'O', 'W', 'Y', 'H', 'X', 'U', 'S', 'P', 'A', 'I', 'B', 'R', 'C', 'J'};

    public RotorOne() {
        this.setInput(INPUT);
        this.setOutput(OUTPUT);
    }

}
