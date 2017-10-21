package com.hencoder.hencoderpracticedraw1.practice;

import android.graphics.Color;

/**
 * @author hanlyjiang on 2017/10/21-14:57.
 * @version 1.0
 */

public class Utils {
    public static final double RAD2ANGLE = 180 / Math.PI;
    public static final double ANGLE2RAD = Math.PI / 180f;

    /**
     *  角度转弧度 π/180×角度
     弧度变角度 180/π×弧度
     */

    /**
     * 弧度转角度
     *
     * @param rad
     * @return
     */
    public static double radToAngle(double rad) {
        return RAD2ANGLE * rad;
    }


    /**
     * 角度转弧度
     *
     * @param angle
     * @return
     */
    public static double angleToRad(double angle) {
        return ANGLE2RAD * angle;
    }

    /**
     * 生成一个随机颜色
     *
     * @return
     */
    public static int randomColor() {
        return Color.argb(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255)
        );
    }
}
