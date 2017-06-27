package br.com.matthaus.enigma;

import android.util.Log;

import org.junit.Test;

import br.com.matthaus.enigma.reflectors.ReflectorB;
import br.com.matthaus.enigma.rotors.RotorOnProcessedListener;
import br.com.matthaus.enigma.rotors.RotorOne;
import br.com.matthaus.enigma.rotors.RotorThree;
import br.com.matthaus.enigma.rotors.RotorTwo;

import static junit.framework.Assert.assertEquals;

public class RotorOneTest {

    @Test
    public void output_isCorrect() {

        final RotorOne rotorOne = new RotorOne();
        final RotorTwo rotorTwo = new RotorTwo();
        final RotorThree rotorThree = new RotorThree();
        final ReflectorB reflectorB = new ReflectorB();


        rotorTwo.fullRoundStepCount(25);
        rotorThree.fullRoundStepCount(625);
        reflectorB.setIsRotative(false);

        rotorOne.setOnProcessedListener(new RotorOnProcessedListener() {
            @Override
            public void onProcessed(char output, int offset) {
                rotorTwo.process(output, offset);
            }
        });

        rotorTwo.setOnProcessedListener(new RotorOnProcessedListener() {
            @Override
            public void onProcessed(char output, int offset) {
                rotorThree.process(output, offset);
            }
        });

        rotorThree.setOnProcessedListener(new RotorOnProcessedListener() {
            @Override
            public void onProcessed(char output, int offset) {
                reflectorB.process(output, 0);
            }
        });

        reflectorB.setOnProcessedListener(new RotorOnProcessedListener() {
            @Override
            public void onProcessed(char output, int offset) {

            }
        });

        rotorOne.process('A', 0);

    }

}
