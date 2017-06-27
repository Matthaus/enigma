package br.com.matthaus.enigma;

import br.com.matthaus.enigma.reflectors.ReflectorB;
import br.com.matthaus.enigma.rotors.DefaultRotor;
import br.com.matthaus.enigma.rotors.RotorOnWorkedListener;
import br.com.matthaus.enigma.rotors.RotorOne;
import br.com.matthaus.enigma.rotors.RotorThree;
import br.com.matthaus.enigma.rotors.RotorTwo;

public class M3Machine {

    private MachineOnWorkedListener listener;

    private RotorOne rotorOne;
    private RotorTwo rotorTwo;
    private RotorThree rotorThree;

    private ReflectorB reflectorB;

    private int offsetRotorOne, offsetRotorTwo, offsetRotorThree = 0;

    public M3Machine() {
        rotorOne = new RotorOne();
        rotorTwo = new RotorTwo();
        rotorThree = new RotorThree();
        reflectorB = new ReflectorB();

        rotorOne.setOnProcessedListener(rotorOnWorkedListener);
        rotorTwo.setOnProcessedListener(rotorOnWorkedListener);
        rotorThree.setOnProcessedListener(rotorOnWorkedListener);

        reflectorB.setOnProcessedListener(rotorOnWorkedListener);

    }

    public void setMachineOnWorkedListener(MachineOnWorkedListener listener) {
        this.listener = listener;
    }

    public void processInput(char letter) {
        offsetRotorOne++;
        rotorOne.process(letter, offsetRotorOne);
    }

    public RotorOnWorkedListener rotorOnWorkedListener = new RotorOnWorkedListener() {
        @Override
        public void onProcessed(char output, DefaultRotor rotor) {
            if (rotor instanceof RotorOne) {
                if (offsetRotorOne == 17) {
                    offsetRotorTwo++;
                } else if (offsetRotorOne == 26) {
                    offsetRotorOne = 0;
                }
                rotorTwo.process(output, (offsetRotorTwo - offsetRotorOne));
            } else if (rotor instanceof RotorTwo) {
                if (offsetRotorTwo == 5) {
                    offsetRotorThree++;
                } else if (offsetRotorTwo == 26) {
                    offsetRotorTwo = 0;
                }
                rotorThree.process(output, (offsetRotorThree - offsetRotorTwo));
            } else if (rotor instanceof RotorThree) {
                reflectorB.process(output, 0);
            } else if (rotor instanceof ReflectorB) {
                rotorThree.propagate(output, 0);
            }
        }

        @Override
        public void onPropagated(char output, DefaultRotor rotor) {
            if (rotor instanceof RotorOne) {
                listener.onProcessed(output);
            } else if (rotor instanceof RotorTwo) {
                rotorOne.propagate(output, -offsetRotorOne);
            } else if (rotor instanceof RotorThree) {
                rotorTwo.propagate(output, -offsetRotorTwo);
            }
        }
    };

}
