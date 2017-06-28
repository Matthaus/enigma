package br.com.matthaus.enigma;

import br.com.matthaus.enigma.reflectors.ReflectorB;
import br.com.matthaus.enigma.rotors.DefaultRotor;
import br.com.matthaus.enigma.rotors.RotorOnWorkedListener;
import br.com.matthaus.enigma.rotors.RotorOne;
import br.com.matthaus.enigma.rotors.RotorThree;
import br.com.matthaus.enigma.rotors.RotorTwo;
import br.com.matthaus.enigma.rotors.StaticRotor;

public class M3Machine {

    private MachineOnWorkedListener listener;

    private RotorOne rotorOne;
    private RotorTwo rotorTwo;
    private RotorThree rotorThree;
    private StaticRotor staticRotor;

    private ReflectorB reflectorB;

    private int offsetRotorOne, offsetRotorTwo, offsetRotorThree = 0;
    private boolean notchAnomaly;

    public M3Machine() {
        rotorOne = new RotorOne();
        rotorTwo = new RotorTwo();
        rotorThree = new RotorThree();
        reflectorB = new ReflectorB();
        staticRotor = new StaticRotor();

        rotorOne.setOnProcessedListener(rotorOnWorkedListener);
        rotorTwo.setOnProcessedListener(rotorOnWorkedListener);
        rotorThree.setOnProcessedListener(rotorOnWorkedListener);

        reflectorB.setOnProcessedListener(rotorOnWorkedListener);

        staticRotor.setOnProcessedListener(rotorOnWorkedListener);

    }

    public void setMachineOnWorkedListener(MachineOnWorkedListener listener) {
        this.listener = listener;
    }

    public void processSingleInput(char letter) {
        rotateAndProcessTurnoverNotchPositions();
        staticRotor.process(letter);
    }

    public void processBatchInput(String batch) {
        batch = batch.toUpperCase().replace(" ", "").replaceAll("[^A-Za-z]", "");
        for (char chr : batch.toCharArray()) {
            processSingleInput(chr);
        }
    }

    private void rotateAndProcessTurnoverNotchPositions() {
        offsetRotorOne++;
        if (notchAnomaly) {
            offsetRotorTwo++;
            offsetRotorThree++;
            notchAnomaly = false;
        }
        if (offsetRotorOne == 17) {
            offsetRotorTwo++;
            if (offsetRotorTwo == 4) {
                notchAnomaly = true;
            }
        } else if (offsetRotorOne == 26) {
            offsetRotorOne = 0;
        }
        if (offsetRotorTwo == 26) {
            offsetRotorTwo = 0;
        }
    }

    private RotorOnWorkedListener rotorOnWorkedListener = new RotorOnWorkedListener() {
        @Override
        public void onProcessed(char output, DefaultRotor rotor) {
            if (rotor instanceof StaticRotor) {
                rotorOne.process(output, offsetRotorOne);
            } else if (rotor instanceof RotorOne) {
                rotorTwo.process(output, (offsetRotorTwo - offsetRotorOne));
            } else if (rotor instanceof RotorTwo) {
                rotorThree.process(output, (offsetRotorThree - offsetRotorTwo));
            } else if (rotor instanceof RotorThree) {
                reflectorB.process(output, -offsetRotorThree);
            } else if (rotor instanceof ReflectorB) {
                rotorThree.propagate(output, -offsetRotorThree);
            }
        }

        @Override
        public void onPropagated(char output, DefaultRotor rotor) {
            if (rotor instanceof RotorThree) {
                rotorTwo.propagate(output, (offsetRotorThree-offsetRotorTwo));
            } else if (rotor instanceof RotorTwo) {
                rotorOne.propagate(output, (offsetRotorTwo - offsetRotorOne));
            } else if (rotor instanceof RotorOne) {
                staticRotor.propagate(output, -offsetRotorOne);
            } else if (rotor instanceof  StaticRotor) {
                listener.onProcessed(output);
            }
        }
    };

}
