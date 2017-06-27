package br.com.matthaus.enigma;

import org.junit.Test;

public class RotorOneTest {

    @Test
    public void output_isCorrect() {

        int controle = 0;

        final M3Machine m3Machine = new M3Machine();
        m3Machine.setMachineOnWorkedListener(new MachineOnWorkedListener() {
            @Override
            public void onProcessed(char letter) {
                System.err.print(letter);
            }
        });

        while (controle < 95) {
            m3Machine.processInput('A');
            controle++;
        }

        m3Machine.processInput('A');

    }

}
