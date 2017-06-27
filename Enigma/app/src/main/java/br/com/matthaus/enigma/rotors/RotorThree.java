package br.com.matthaus.enigma.rotors;

public class RotorThree extends DefaultRotor {

    private static final char[] INPUT = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static final char[] OUTPUT = {'B', 'D', 'F', 'H', 'J', 'L', 'C', 'P', 'R', 'T', 'X',
            'V', 'Z', 'N', 'Y', 'E', 'I', 'W', 'G', 'A', 'K', 'M', 'U', 'S', 'Q', 'O' };

    public RotorThree() {
        this.setInput(INPUT);
        this.setOutput(OUTPUT);
    }

}
