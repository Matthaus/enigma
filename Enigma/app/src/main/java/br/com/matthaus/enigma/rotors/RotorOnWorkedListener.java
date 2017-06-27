package br.com.matthaus.enigma.rotors;

public interface RotorOnWorkedListener {

    void onProcessed(char output, DefaultRotor rotor);

    void onPropagated(char output, DefaultRotor rotor);

}
