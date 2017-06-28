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

//        m3Machine.processBatchInput("Researchers are still investigating the software behind the attack, warning that it's more sophisticated than the WannaCry worm that struck hundreds of thousands of computers across the globe last month.\n" +
//                "\"WannaCry was a tremendous failure. It was a lot of noise, very little money, and everyone noticed it,\" said Craig Williams, an expert at cybersecurity firm Cisco Talos. \"What we're seeing today is a much more intelligent worm.\"");

//        m3Machine.processBatchInput("JFDDGHTWGJUWHNRCUQPTLFXBEZRXUAQZZDTOYQWVIYHDXDPXJHRXEXMXIRXRHXOMPWLXMJXTOTJTHTSGBMJMECJVWAFYGVDIBVIBYGHVTBGJRXEZDAWKBUZMQAZYUQVDOUSLEDWACVTBAQCGRGQRLZNVUAKDWWYTIQMFJNFJRHTZWZDMXYPEQROCGPAQEBCZVBYOSMISOGUEMJCNJCMWKVQWCYPRHSDOMTIMCTGMHCJDOHRXTTGLEDPSOSCBEOGOWWELAZRMZQLXJZOTWTUPHRDNIIDGADXULCKXSLEMNXSNUHZKVHERBTSEVXMOGIYSSHRFYWZCEPRAZGXAPJCIRAABEBRVYQ");

    }

}
