/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miprimerparques;

import processing.core.PApplet;
import miprimerparques.MiPrimer;
import processing.core.PImage;

public class Dado extends PApplet {

    PImage fondopar;
    boolean empezarAnimation = true;
    int start = 0;

    @Override
    public void settings() {

        size(1000, 700);
        fondopar = loadImage("Sources/Fondoparques.jpg");

    }

    @Override
    public void draw() {

        background(255, 0, 0);
        // fondo
        background(255, 40, 0);

        // pantalla con jugadores
        stroke(0);
        strokeWeight(5);
        textSize(18);

        float largo = 39,
                ancho = 61;

        //tablero
        stroke(0);
        strokeWeight(3);
        noFill();
        image(fondopar, 0, 150, 709, 550);
        rect(0, 150, 709, 550);
        //casillas

        //columna izquierda
        rect(0, 230, ancho, largo);  //1
        rect(0, 230 + largo, ancho, largo); //2
        rect(0, 230 + 2 * largo, ancho, largo); //3
        rect(0, 230 + 3 * largo, ancho, largo); //4
        rect(0, 230 + 4 * largo, ancho, largo); //5
        rect(0, 230 + 5 * largo, ancho, largo); //6
        rect(0, 230 + 6 * largo, ancho, largo); // 7
        rect(0, 230 + 7 * largo, ancho, largo); //8
        rect(0, 230 + 8 * largo, ancho, largo); //9
        rect(0, 230 + 9 * largo, ancho, largo);

        //fila superior
        rect(80, 150, ancho, largo); //1
        rect(80 + ancho, 150, ancho, largo); //2
        rect(80 + (2 * ancho), 150, ancho, largo); // 3
        rect(80 + 3 * ancho, 150, ancho, largo); //4
        rect(80 + 4 * ancho, 150, ancho, largo); //5
        rect(80 + 5 * ancho, 150, ancho, largo); //6
        rect(80 + 6 * ancho, 150, ancho, largo);//7
        rect(80 + 7 * ancho, 150, ancho, largo); //8
        rect(80 + 8 * ancho, 150, ancho, largo); //9

        // Esquina 1 curveada
        beginShape();
        vertex(ancho, 230);
        quadraticVertex(60, 210, 80, 150 + largo);
        endShape();
        // esquina 2
        beginShape();
        vertex(648, 230);
        quadraticVertex(649, 210, 80 + 9 * ancho, 150 + largo);
        endShape();

        // esquina 3
        beginShape();
        vertex(648, 230 + 10 * largo);
        quadraticVertex(649, 640, 80 + 9 * ancho, 661);
        endShape();

        //esquina 4
        beginShape();
        vertex(ancho, 230 + 10 * largo);
        quadraticVertex(60, 640, 80, 661);
        endShape();

        // esquina (80, 80)
        //fila inferior
        rect(80, 700 - largo, ancho, largo); //1
        rect(80 + ancho, 700 - largo, ancho, largo); //2
        rect(80 + (2 * ancho), 700 - largo, ancho, largo); // 3
        rect(80 + 3 * ancho, 700 - largo, ancho, largo); //4
        rect(80 + 4 * ancho, 700 - largo, ancho, largo); //5
        rect(80 + 5 * ancho, 700 - largo, ancho, largo); //6
        rect(80 + 6 * ancho, 700 - largo, ancho, largo);//7
        rect(80 + 7 * ancho, 700 - largo, ancho, largo); //8
        rect(80 + 8 * ancho, 700 - largo, ancho, largo); //9

        //columna derecha
        rect(648, 230, ancho, largo);  //1
        rect(648, 230 + largo, ancho, largo); //2
        rect(648, 230 + 2 * largo, ancho, largo); //3
        rect(648, 230 + 3 * largo, ancho, largo); //4
        rect(648, 230 + 4 * largo, ancho, largo); //5
        rect(648, 230 + 5 * largo, ancho, largo); //6
        rect(648, 230 + 6 * largo, ancho, largo); // 7
        rect(648, 230 + 7 * largo, ancho, largo); //8
        rect(648, 230 + 8 * largo, ancho, largo); //9
        rect(648, 230 + 9 * largo, ancho, largo); //10

        enviarCarcelAnimation();

        if (empezarAnimation) {
            enviarCarcelAnimation();
            start = millis();
            empezarAnimation = false;
        }

    }

    @Override
    public void mouseClicked() {

    }

    float py1 = 100, py2 = 100, py3 = 100, py4 = 100;
    float px1 = 5, px2 = 25, px3 = 45, px4 = 65, by = 125, ty = 70;

//    int py1 = 130, py2 = 130, py3 = 130, py4 = 130;
//    int px1 = 5, px2 = 25, px3 = 45, px4 = 65;
    public void enviarCarcelAnimation() {
        int separation = 280;
        fill(138, 149, 151);

        if (millis() - start >= separation && millis() - start < separation * 2) {

            by += 2;
            // System.out.println(by);
            noStroke();
            //base
            rect(3, by, 74, 35, 10);

        } else if(millis() - start >= separation * 2){
            noStroke();
            rect(3, by, 74, 35, 10);

        }

        if (millis() - start >= separation * 2 && millis() - start < separation * 3) {
            stroke(0);
            py1 += 2.2968;
            rect(px1, py1, 10, 60);
            //System.out.println(py1);
        } else if (millis() - start >= separation * 3) {
            stroke(0);
            rect(px1, 130, 10, 60);

        }

        if (millis() - start >= separation * 3 && millis() - start < separation * 4) {
            
            stroke(0);
            py2 += 2.2968;
            rect(px2, py2, 10, 60);
            //System.out.println(py2);
        } else if(millis() - start >= separation * 4 ){
            stroke(0);
            rect(px2, 130, 10, 60);

        }

        if (millis() - start >= separation * 4 && millis() - start < separation * 5) {
            stroke(0);
            py3 += 2.2968;
            rect(px3, py3, 10, 60);
           // System.out.println(py3);
            
        } else if(millis() - start >= separation * 5 ){
            stroke(0);
            rect(px3, 130, 10, 60);

        }

        if (millis() - start >= separation * 5 && millis() - start < separation * 6) {
            stroke(0);
            py4 += 2.18;
            rect(px4, py4, 10, 60);
            System.out.println(py4);

        } else if(millis() - start >= separation * 6 ){
            stroke(0);
            rect(px4, 130, 10, 60);

        }

        if (millis() - start >= separation * 6 && millis() - start <= separation * 7) {
            ty += 2.2968;
            rect(3, ty, 74, 35, 10);
        } else  if(millis() - start >= separation * 7 ) {
            stroke(0);
            rect(3, ty, 74, 35, 10);

        }

    }

}
