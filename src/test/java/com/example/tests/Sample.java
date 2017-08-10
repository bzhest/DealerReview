package com.example.tests;

import java.util.Random;

/**
 * Created by SYSTEM on 09.02.2017.
 */
public class Sample {

    public static void main(String[] args) {
                double a = 3;
                double b = 2.5;
                double c = -0.5;
                int d;
                //дискреминант
                d = (int)((b*b) - (4 *a*c));
                if(d>0){
                    double x1;
                    double x2;
                    x1 = (-b+Math.sqrt(b*b-4*a*c))/2*a;
                    x2 = (-b-Math.sqrt(b*b-4*a*c))/2*a;
                }
                else if (d==0){
                    double x1;
                    double x2;
                    x1=-b/2*a;
                    x2=-b/2*a;
                }



                //PUT YOUR CODE HERE
            }
        }



