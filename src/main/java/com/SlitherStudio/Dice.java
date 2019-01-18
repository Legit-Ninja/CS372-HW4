package com.SlitherStudio;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ImageView;

import com.SlitherStudio.R;

import java.util.Random;
public class Dice implements Runnable{
    private ImageView image;
    private int value;
    private int[] dicesides = {
            R.drawable.onedie, R.drawable.twodie, R.drawable.threedie, R.drawable.fourdie,
            R.drawable.fivedie, R.drawable.sixdie,
    };
    Dice(ImageView _label)
    {
        image = _label;

    }

    public void run() {

        for (int i = 0; i < 10; i++) {
            //image.setImageResource(dicesides[r]);
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Random rand = new Random(System.currentTimeMillis());
                    int r = rand.nextInt(6);
                    image.setImageResource(dicesides[r]);
                }
            });            try {
                Thread.sleep(500);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
