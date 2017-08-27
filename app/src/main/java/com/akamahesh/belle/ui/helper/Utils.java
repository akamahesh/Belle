package com.akamahesh.belle.ui.helper;


import android.graphics.Color;

import java.util.Random;

/**
 * Created by akaMahesh on 18/8/17
 * contact : mckay1718@gmail.com
 */

public class Utils {
    public static int generateRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

    }
}
