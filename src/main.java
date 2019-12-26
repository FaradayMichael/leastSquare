import com.sun.tools.javac.Main;

import javax.sound.sampled.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Frame f = new Frame();
        new Thread(() -> {
            try {
                File soundFile = new File("C:\\ideaProj\\leastSquare\\src\\homm.wav"); //Звуковой файл
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                FloatControl vc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                vc.setValue(-vc.getMaximum());
                clip.setFramePosition(0);
                clip.start();
                Thread.sleep(clip.getMicrosecondLength()/1000);
                clip.stop();
                clip.close();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
