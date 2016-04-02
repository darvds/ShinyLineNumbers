package com.darvds.shinylinenumbers.model;

import java.security.InvalidParameterException;

/**
 * Get the points for each digit to draw the path
 */
public class NumberUtils {

    private static final float[][] ZERO = {
            {0.50769230769231f, 1.0f},
            {0.77866923076923f,0.99927692307692f}, {0.99927692307692f,0.77862307692308f}, {1.0f,0.50769230769231f},
            {0.99934615384615f,0.23675384615385f}, {0.77863846153846f,0.01603076923077f}, {0.50769230769231f,0.01538461538462f},
            {0.23714615384615f,0.01648461538462f}, {0.01603846153846f,0.23219230769231f}, {0.01538461538462f,0.50769230769231f},
            {0.0162f,0.77832307692308f}, {0.23708461538462f,0.99909230769231f}, {0.50769230769231f,1.0f}
    };

    private static final float[][] ONE = {
            {0.38461538461538f, 0.01538461538462f},
            {0.463623077f,0.015384615f}, {0.542630769f,0.015384615f}, {0.621638462f,0.015384615f},
            {0.621638462f,0.343589744f}, {0.621638462f,0.671794872f}, {0.621638462f,1.0f},
            {0.542630769f,1.0f}, {0.463623077f,1.0f}, {0.384615385f,1.0f}
    };

    private static final float[][] TWO = {
            {0.833884615384615f, 1.00000192307692f},
            {0.661053846153846f, 1.00000192307692f}, {0.488223076923077f,1.00000192307692f}, {0.315392307692308f,1.00000192307692f},
            {0.315392307692308f,1.00000192307692f},{0.391715384615385f,0.935563461538461f},{0.436446153846154f,0.898078846153846f},
            {0.485084615384615f,0.857317307692308f},{0.542207692307692f,0.809994230769231f},{0.678384615384615f,0.673132689230769f},
            {0.707692307692308f,0.638461538461538f},{0.730769230769231f,0.615384615384615f},{0.746153846153846f,0.592307692307692f},
            {0.815384615384615f,0.507692307692308f},{0.823076923076923f,0.446153846153846f},{0.823076923076923f,0.376923076923077f},
            {0.823076923076923f,0.276923076923077f},{0.723076923076923f,0.146153846153846f},{0.538461538461538f,0.153846153846154f},
            {0.361538461538462f,0.169230769230769f},{0.315384615384615f,0.338461538461538f},{0.315384615384615f,0.338461538461538f},
            {0.269230769230769f, 0.28974358974359f}, {0.223076923076923f,0.241025641025641f}, {0.176923076923077f,0.192307692307692f},
            {0.176923076923077f,0.192307692307692f},{0.223076923076923f,0.0230769230769231f},{0.4f,0.0153846153846154f},
            {0.584615384615385f,0f},{0.684615384615385f,0.130769230769231f},{0.684615384615385f,0.230769230769231f},
            {0.684615384615385f,0.323076923076923f},{0.669230769230769f,0.392307692307692f},{0.538461538461538f,0.523076923076923f},
            {0.515384615384615f,0.546153846153846f},{0.5f,0.561538461538462f},{0.484615384615385f,0.576923076923077f},
            {0.384615384615385f,0.676923076923077f},{0.330769230769231f,0.723076923076923f},{0.284615384615385f,0.753846153846154f},
            {0.246153846153846f,0.792307692307692f},{0.176923076923077f,0.853846153846154f},{0.176923076923077f,0.853846153846154f},
            {0.351282051282051f, 0.853846153846154f}, {0.525641025641026f,0.853846153846154f}, {0.7f,0.853846153846154f},
            {0.743589743589744f, 0.902564102564103f}, {0.787179487179487f,0.951282051282051f}, {0.830769230769231f,1f}
    };

    private static final float[][] THREE = {
            {0.3f, 0.792307692307692f},
            {0.3f,0.792307692307692f},{0.323076923076923f,0.869230769230769f},{0.384615384615385f,0.930769230769231f},
            {0.453846153846154f,1f},{0.6f,1.02307692307692f},{0.707692307692308f,0.961538461538462f},
            {0.815384615384615f,0.9f},{0.853846153846154f,0.769230769230769f},{0.823076923076923f,0.684615384615385f},
            {0.792307692307692f,0.569230769230769f},{0.7f,0.553846153846154f},{0.7f,0.553846153846154f},
            {0.7f,0.553846153846154f},{0.707692307692308f,0.538461538461538f},{0.723076923076923f,0.530769230769231f},
            {0.753846153846154f,0.507692307692308f},{0.8f,0.461538461538462f},{0.8f,0.376923076923077f},
            {0.8f,0.261538461538462f},{0.715384615384615f,0.207692307692308f},{0.684615384615385f,0.184615384615385f},
            {0.653846153846154f,0.161538461538462f},{0.584615384615385f,0.138461538461538f},{0.476923076923077f,0.169230769230769f},
            {0.369230769230769f,0.192307692307692f},{0.315384615384615f,0.323076923076923f},{0.315384615384615f,0.323076923076923f},
            {0.271794871794872f, 0.274358974358974f}, {0.228205128205128f,0.225641025641026f}, {0.184615384615385f,0.176923076923077f},
            {0.184615384615385f,0.176923076923077f},{0.223076923076923f,0.0615384615384615f},{0.338461538461538f,0.0230769230769231f},
            {0.446153846153846f,0f},{0.523076923076923f,0.0230769230769231f},{0.553846153846154f,0.0461538461538462f},
            {0.584615384615385f,0.0692307692307692f},{0.669230769230769f,0.130769230769231f},{0.669230769230769f,0.238461538461538f},
            {0.669230769230769f,0.353846153846154f},{0.561538461538462f,0.407692307692308f},{0.561538461538462f,0.407692307692308f},
            {0.561538461538462f,0.407692307692308f},{0.6f,0.430769230769231f},{0.630769230769231f,0.461538461538462f},
            {0.661538461538462f,0.492307692307692f},{0.692307692307692f,0.538461538461538f},{0.692307692307692f,0.576923076923077f},
            {0.692307692307692f,0.661538461538462f},{0.669230769230769f,0.753846153846154f},{0.576923076923077f,0.815384615384615f},
            {0.469230769230769f,0.884615384615385f},{0.315384615384615f,0.853846153846154f},{0.253846153846154f,0.784615384615385f},
            {0.192307692307692f,0.723076923076923f},{0.169230769230769f,0.653846153846154f},{0.169230769230769f,0.653846153846154f},
            {0.212820512820513f, 0.7f}, {0.256410256410256f,0.746153846153846f}, {0.3f,0.792307692307692f}
    };

    private static final float[][] FOUR = {
            {0.888830769230769f, 0.823784615384615f},
            {0.682830769230769f, 0.823784615384615f}, {0.476830769230769f,0.823784615384615f}, {0.270830769230769f,0.823784615384615f},
            {0.270830769230769f, 0.795230769230769f}, {0.270830769230769f,0.766676923076923f}, {0.270830769230769f,0.738123076923077f},
            {0.40014358974359f, 0.546402564102564f}, {0.52945641025641f,0.354682051282051f}, {0.658769230769231f,0.162961538461538f},
            {0.699558974358974f, 0.162961538461538f}, {0.740348717948718f,0.162961538461538f}, {0.781138461538462f,0.162961538461538f},
            {0.781138461538462f, 0.441974358974359f}, {0.781138461538462f,0.720987179487179f}, {0.781138461538462f,1f},
            {0.734451282051282f, 0.950810256410256f}, {0.687764102564103f,0.901620512820513f}, {0.641076923076923f,0.852430769230769f},
            {0.641076923076923f, 0.573415384615385f}, {0.641076923076923f,0.2944f}, {0.641076923076923f,0.0153846153846154f},
            {0.600284615384615f, 0.0153846153846154f}, {0.559492307692308f,0.0153846153846154f}, {0.5187f,0.0153846153846154f},
            {0.389389743589744f, 0.207107692307692f}, {0.260079487179487f,0.398830769230769f}, {0.130769230769231f,0.590553846153846f},
            {0.130769230769231f, 0.619107692307692f}, {0.130769230769231f,0.647661538461538f}, {0.130769230769231f,0.676215384615385f},
            {0.238953846153846f, 0.676215384615385f}, {0.347138461538462f,0.676215384615385f}, {0.455323076923077f,0.676215384615385f},
            {0.553135897435897f, 0.676215384615385f}, {0.650948717948718f,0.676215384615385f}, {0.748761538461538f,0.676215384615385f},
            {0.795451282051282f, 0.725405128205128f}, {0.842141025641026f,0.774594871794872f}, {0.888830769230769f,0.823784615384615f},
            {0.888830769230769f, 0.823784615384615f}, {0.888830769230769f,0.823784615384615f}, {0.888830769230769f,0.823784615384615f}
    };


    private static final float[][] FIVE = {
            {0.153846153846154f, 0.630769230769231f},
            {0.197435897435897f, 0.679487179487179f}, {0.241025641025641f,0.728205128205128f}, {0.284615384615385f,0.776923076923077f},
            {0.284615384615385f,0.776923076923077f},{0.315384615384615f,0.853846153846154f},{0.323076923076923f,0.861538461538462f},
            {0.330769230769231f,0.876923076923077f},{0.407692307692308f,1f},{0.561538461538462f,1f},
            {0.723076923076923f,1f},{0.846153846153846f,0.869230769230769f},{0.846153846153846f,0.723076923076923f},
            {0.846153846153846f,0.569230769230769f},{0.715384615384615f,0.446153846153846f},{0.576923076923077f,0.446153846153846f},
            {0.569230769230769f,0.446153846153846f},{0.546153846153846f,0.453846153846154f},{0.538461538461538f,0.453846153846154f},
            {0.415384615384615f,0.469230769230769f},{0.315384615384615f,0.569230769230769f},{0.315384615384615f,0.569230769230769f},
            {0.333333333333333f, 0.430769230769231f}, {0.351282051282051f,0.292307692307692f}, {0.369230769230769f,0.153846153846154f},
            {0.512820512820513f, 0.153846153846154f}, {0.656410256410257f,0.153846153846154f}, {0.8f,0.153846153846154f},
            {0.753846153846154f, 0.107692307692308f}, {0.707692307692308f,0.0615384615384615f}, {0.661538461538462f,0.0153846153846154f},
            {0.517948717948718f, 0.0153846153846154f}, {0.374358974358974f,0.0153846153846154f}, {0.230769230769231f,0.0153846153846154f},
            {0.212820512820513f, 0.153846153846154f}, {0.194871794871795f,0.292307692307692f}, {0.176923076923077f,0.430769230769231f},
            {0.176923076923077f,0.430769230769231f},{0.284615384615385f,0.323076923076923f},{0.407692307692308f,0.307692307692308f},
            {0.423076923076923f,0.307692307692308f},{0.430769230769231f,0.307692307692308f},{0.438461538461538f,0.307692307692308f},
            {0.584615384615385f,0.307692307692308f},{0.707692307692308f,0.423076923076923f},{0.707692307692308f,0.576923076923077f},
            {0.707692307692308f,0.723076923076923f},{0.584615384615385f,0.853846153846154f},{0.430769230769231f,0.853846153846154f},
            {0.269230769230769f,0.853846153846154f},{0.192307692307692f,0.730769230769231f},{0.184615384615385f,0.715384615384615f},
            {0.176923076923077f,0.707692307692308f},{0.153846153846154f,0.630769230769231f},{0.153846153846154f,0.630769230769231f}
    };


    private static final float[][] SIX = {
            {0.5f, 0.476923076923077f},
            {0.5f,0.476923076923077f},{0.530769230769231f,0.469230769230769f},{0.538461538461538f,0.469230769230769f},
            {0.535897435897436f, 0.469230769230769f}, {0.533333333333333f,0.469230769230769f}, {0.530769230769231f,0.469230769230769f},
            {0.569230769230769f,0.469230769230769f},{0.630769230769231f,0.461538461538462f},{0.7f,0.492307692307692f},
            {0.815384615384615f,0.546153846153846f},{0.846153846153846f,0.653846153846154f},{0.846153846153846f,0.738461538461539f},
            {0.838461538461538f,0.815384615384615f},{0.769230769230769f,0.961538461538462f},{0.623076923076923f,0.992307692307692f},
            {0.592307692307692f,0.992307692307692f},{0.561538461538462f,1f},{0.538461538461538f,0.992307692307692f},
            {0.430769230769231f,0.984615384615385f},{0.346153846153846f,0.907692307692308f},{0.307692307692308f,0.815384615384615f},
            {0.261538461538462f,0.7f},{0.330769230769231f,0.576923076923077f},{0.353846153846154f,0.523076923076923f},
            {0.384615384615385f,0.469230769230769f},{0.607692307692308f,0.153846153846154f},{0.607692307692308f,0.153846153846154f},
            {0.579487179487179f, 0.123076923076923f}, {0.551282051282051f,0.0923076923076923f}, {0.523076923076923f,0.0615384615384615f},
            {0.561538461538462f, 0.107692307692308f}, {0.515384615384615f,0.0615384615384615f}, {0.469230769230769f,0.0153846153846154f},
            {0.469230769230769f,0.0153846153846154f},{0.246153846153846f,0.330769230769231f},{0.223076923076923f,0.384615384615385f},
            {0.192307692307692f,0.430769230769231f},{0.130769230769231f,0.553846153846154f},{0.169230769230769f,0.669230769230769f},
            {0.215384615384615f,0.776923076923077f},{0.330769230769231f,0.861538461538462f},{0.453846153846154f,0.853846153846154f},
            {0.469230769230769f,0.853846153846154f},{0.476923076923077f,0.853846153846154f},{0.484615384615385f,0.846153846153846f},
            {0.630769230769231f,0.815384615384615f},{0.707692307692308f,0.669230769230769f},{0.707692307692308f,0.592307692307692f},
            {0.715384615384615f,0.515384615384615f},{0.676923076923077f,0.4f},{0.569230769230769f,0.353846153846154f},
            {0.469230769230769f,0.307692307692308f},{0.369230769230769f,0.338461538461538f},{0.369230769230769f,0.338461538461538f},
            {0.412820512820513f, 0.384615384615385f}, {0.456410256410256f,0.430769230769231f}, {0.5f,0.476923076923077f}
    };

    private static final float[][] SEVEN = {
            {0.437346153846154f, 1f},
            {0.570133333333333f, 0.757623076923077f}, {0.702920512820513f,0.515246153846154f}, {0.835707692307692f,0.272869230769231f},
            {0.835707692307692f, 0.235271794871795f}, {0.835707692307692f,0.197674358974359f}, {0.835707692307692f,0.160076923076923f},
            {0.659325641025641f, 0.160076923076923f}, {0.48294358974359f,0.160076923076923f}, {0.306561538461538f,0.160076923076923f},
            {0.260784615384615f, 0.111846153846154f}, {0.215007692307692f,0.0636153846153846f}, {0.169230769230769f,0.0153846153846154f},
            {0.34561282051282f, 0.0153846153846154f}, {0.521994871794872f,0.0153846153846154f}, {0.698376923076923f,0.0153846153846154f},
            {0.698376923076923f, 0.0529794871794872f}, {0.698376923076923f,0.090574358974359f}, {0.698376923076923f,0.128169230769231f},
            {0.565541025641026f, 0.370548717948718f}, {0.432774358974359f,0.612928205128205f}, {0.300007692307692f,0.855307692307692f},
            {0.345787179487179f, 0.903538461538462f}, {0.391566666666667f,0.951769230769231f}, {0.437346153846154f,1f}

    };


    private static final float[][] EIGHT = {
            {0.192307692307692f, 0.630769230769231f},
            {0.2f,0.615384615384615f},{0.215384615384615f,0.592307692307692f},{0.223076923076923f,0.576923076923077f},
            {0.253846153846154f,0.538461538461538f},{0.292307692307692f,0.507692307692308f},{0.338461538461538f,0.484615384615385f},
            {0.338461538461538f, 0.482051282051282f}, {0.338461538461538f,0.47948717948718f}, {0.338461538461538f,0.476923076923077f},
            {0.3f,0.453846153846154f},{0.269230769230769f,0.423076923076923f},{0.246153846153846f,0.392307692307692f},
            {0.223076923076923f,0.353846153846154f},{0.215384615384615f,0.315384615384615f},{0.215384615384615f,0.276923076923077f},
            {0.215384615384615f,0.223076923076923f},{0.230769230769231f,0.169230769230769f},{0.261538461538462f,0.130769230769231f},
            {0.269230769230769f,0.115384615384615f},{0.276923076923077f,0.1f},{0.292307692307692f,0.0846153846153846f},
            {0.346153846153846f,0.0384615384615385f},{0.415384615384615f,0.0153846153846154f},{0.5f,0.0153846153846154f},
            {0.584615384615385f,0.0153846153846154f},{0.653846153846154f,0.0384615384615385f},{0.707692307692308f,0.0846153846153846f},
            {0.761538461538461f,0.138461538461538f},{0.784615384615385f,0.2f},{0.784615384615385f,0.276923076923077f},
            {0.784615384615385f,0.292307692307692f},{0.784615384615385f,0.315384615384615f},{0.776923076923077f,0.330769230769231f},
            {0.776923076923077f,0.346153846153846f},{0.761538461538461f,0.376923076923077f},{0.753846153846154f,0.392307692307692f},
            {0.730769230769231f,0.423076923076923f},{0.7f,0.453846153846154f},{0.661538461538462f,0.476923076923077f},
            {0.661538461538462f, 0.47948717948718f}, {0.661538461538462f,0.482051282051282f}, {0.661538461538462f,0.484615384615385f},
            {0.707692307692308f,0.507692307692308f},{0.746153846153846f,0.538461538461538f},{0.776923076923077f,0.576923076923077f},
            {0.807692307692308f,0.615384615384615f},{0.815384615384615f,0.661538461538462f},{0.815384615384615f,0.715384615384615f},
            {0.815384615384615f,0.776923076923077f},{0.792307692307692f,0.838461538461538f},{0.753846153846154f,0.884615384615385f},
            {0.746153846153846f,0.892307692307692f},{0.738461538461539f,0.907692307692308f},{0.723076923076923f,0.915384615384615f},
            {0.661538461538462f,0.969230769230769f},{0.592307692307692f,1f},{0.5f,1f},
            {0.407692307692308f,1f},{0.330769230769231f,0.969230769230769f},{0.269230769230769f,0.915384615384615f},
            {0.207692307692308f,0.861538461538462f},{0.184615384615385f,0.792307692307692f},{0.184615384615385f,0.715384615384615f},
            {0.184615384615385f,0.684615384615385f},{0.184615384615385f,0.661538461538462f},{0.192307692307692f,0.630769230769231f},
    };


    private static final float[][] NINE = {
            {0.476923076923077f, 0.946153846153846f},
            {0.494871794871795f, 0.964102564102564f}, {0.512820512820513f,0.982051282051282f}, {0.530769230769231f,1f},
            {0.530769230769231f,1f},{0.753846153846154f,0.676923076923077f},{0.776923076923077f,0.623076923076923f},
            {0.807692307692308f,0.576923076923077f},{0.876923076923077f,0.453846153846154f},{0.830769230769231f,0.338461538461538f},
            {0.784615384615385f,0.230769230769231f},{0.676923076923077f,0.146153846153846f},{0.546153846153846f,0.153846153846154f},
            {0.538461538461538f,0.153846153846154f},{0.523076923076923f,0.153846153846154f},{0.515384615384615f,0.161538461538462f},
            {0.369230769230769f,0.192307692307692f},{0.3f,0.338461538461538f},{0.292307692307692f,0.415384615384615f},
            {0.284615384615385f,0.492307692307692f},{0.323076923076923f,0.607692307692308f},{0.430769230769231f,0.653846153846154f},
            {0.530769230769231f,0.7f},{0.638461538461538f,0.669230769230769f},{0.638461538461538f,0.669230769230769f},
            {0.592307692307692f, 0.623076923076923f}, {0.546153846153846f,0.576923076923077f}, {0.5f,0.530769230769231f},
            {0.5f,0.530769230769231f},{0.469230769230769f,0.538461538461538f},{0.469230769230769f,0.538461538461538f},
            {0.48974358974359f, 0.533333333333333f}, {0.47948717948718f,0.535897435897436f}, {0.469230769230769f,0.538461538461538f},
            {0.438461538461538f,0.538461538461538f},{0.376923076923077f,0.546153846153846f},{0.3f,0.515384615384615f},
            {0.184615384615385f,0.461538461538462f},{0.153846153846154f,0.353846153846154f},{0.161538461538462f,0.269230769230769f},
            {0.161538461538462f,0.192307692307692f},{0.238461538461538f,0.0461538461538462f},{0.384615384615385f,0.0153846153846154f},
            {0.407692307692308f,0.0153846153846154f},{0.438461538461538f,0.00769230769230769f},{0.461538461538462f,0.0153846153846154f},
            {0.569230769230769f,0.0230769230769231f},{0.661538461538462f,0.1f},{0.692307692307692f,0.192307692307692f},
            {0.738461538461539f,0.307692307692308f},{0.669230769230769f,0.430769230769231f},{0.646153846153846f,0.484615384615385f},
            {0.615384615384615f,0.538461538461538f},{0.4f,0.853846153846154f},{0.4f,0.853846153846154f},
            {0.425641025641026f, 0.884615384615385f}, {0.451282051282051f,0.915384615384615f}, {0.476923076923077f,0.946153846153846f}
    };




    public static float[][] getPoints(int number){
        switch (number) {
            case 0:
                return ZERO;
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                return SIX;
            case 7:
                return SEVEN;
            case 8:
                return EIGHT;
            case 9:
                return NINE;
            default:
                throw new InvalidParameterException("Unsupported number requested");
        }
    }
}