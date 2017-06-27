package br.com.matthaus.enigma.reflectors;

import br.com.matthaus.enigma.rotors.DefaultRotor;

public class ReflectorB extends DefaultRotor {

    private static final char[] INPUT = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static final char[] OUTPUT = {'Y', 'R', 'U', 'H', 'Q', 'S', 'L', 'D', 'P', 'X', 'N',
            'G', 'O', 'K', 'M', 'I', 'E', 'B', 'F', 'Z', 'C', 'W', 'V', 'J', 'A', 'T', };

    public ReflectorB() {
        this.setInput(INPUT);
        this.setOutput(OUTPUT);
    }

}
