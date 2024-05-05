package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {
    public static final double CONCERT_A = 440.0;
    public static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    private static String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static char[] notes = keyboard.toCharArray();

    private static double getFreq(int keyIndex) {
        return 440.0 * Math.pow(2.0, (keyIndex - 24) / 12.0);
    }
    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        ArrayList<GuitarString> strings = new ArrayList<>();
        for(int i = 0; i < 37; i ++) {
            strings.add(new GuitarString(getFreq(i)));
            System.out.println(notes[i]);
       }
        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int theNote = keyboard.indexOf(key);
                if (theNote != -1) {
                    strings.get(theNote).pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0.0;
            for(int i = 0; i < 37;i ++) {
                sample += strings.get(i).sample();
                strings.get(i).tic();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

        }
    }
}

