/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miprimerparques;

import estructura_de_datos.ListaCircular;
import estructura_de_datos.Nodo;
import javax.swing.JOptionPane;
import processing.core.PApplet;
import processing.core.PImage;

public class MiPrimer extends PApplet {

    int op = 0, start, start2, start3, start4;
    PImage boton, fondopar;
    public int[][] color = new int[6][4];
    public int[] disponibles = new int[3];
    int i = 0, i2 = 1, i3 = 2;
    boolean controlA = false, controlA2 = false, starter = true;

    String user1 = "Usuario_1",
            user2 = "Usuario_2",
            user3 = "Usuario_3",
            anuncio = "Es el turno de ";
    static boolean empezarDado = false;
    boolean tirar = true;
    boolean controlB = false, controlB2 = false;
    boolean sw1 = true, sw2 = true, sw3 = true, sw4 = true, sw5 = true,
            sw6 = true, controlC = true;
    int resultadoDado;
    boolean uno = false, dos = false, tres = false, cuatro = false,
            cinco = false, seis = false;
    int sx1 = 0, sx2 = 0, sx3 = 0, sy1 = 0, sy2 = 0, sy3 = 0, cont = 0;
    boolean seacabo = false; // Activador de la Tercera escena 
    double altoC = 0, altoDer = 0, altoIzq = 0, ubiy = height / 2 + 75,
            ubiy2 = height / 2 + 75, ubiy3 = height / 2 + 75;
    String ganador = "", segundo = "", perdedor = "";
    String userSelected = "";
    boolean controlD = false;

    // instanciación de la clase Lista circular
    ListaCircular listaCircular = new ListaCircular();

    int casillaActual = 0, casillaActual2 = 0, casillaActual3 = 0, rachaConsecutiva = 0;
    String encarcelado = " ", encarcelado2 = " ", userEnRacha = "";
    boolean carcel = false, comienzaMovimiento = false, inicializar = true,
            pasarTurno = false, aplicarRegla1 = false, carcel2 = false, carcel3 = false;

    String[] ordenDeTiro = new String[3];
    int puesto = 0;
    float[] puntoR = new float[2];
    float[] puntoR2 = new float[2];
    float[] puntoR3 = new float[2];
    int casillaAnt1, casillaAnt2, casillaAnt3 = 0;

    boolean quieto = true, interrumpirTurno = true, casoEspecial = false;

    @Override
    public void settings() {
        size(1000, 700);
        boton = loadImage("Sources/Starbuttom.png");
        fondopar = loadImage("Sources/Fondoparques.jpg");
        // colores de las fichas
        //color1
        color[0][0] = 250;
        color[0][1] = 0;
        color[0][2] = 0;
        color[0][3] = 1;

        //color2
        color[1][0] = 10;
        color[1][1] = 73;
        color[1][2] = 123;
        color[1][3] = 1;

        //color3
        color[2][0] = 229;
        color[2][1] = 190;
        color[2][2] = 1;
        color[2][3] = 1;

        for (int i = 3; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                color[i][j] = (100 * i) / (j + 1);
            }
        }

        for (int i = 4; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                color[i][j] = 2 * 100 - i * 20 + j * 14;
            }
        }

        for (int i = 5; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                color[i][j] = 255 - i * 15 - j * 30;
            }
        }

        for (int i = 0; i < 3; i++) {
            disponibles[i] = i + 3;
        }
        iniciarLista();

        //inicializar puntos para las fichas
        puntoR[0] = 18;
        puntoR[1] = 140;

        puntoR2[0] = 35;
        puntoR2[1] = 140;

        puntoR3[0] = 55;
        puntoR3[1] = 140;

        listaCircular.inicializarValores();
        listaCircular.inicializarPositions();

//        // prueba podio_animación 
//        
//        seacabo = true;
//        ganador = "Usuario_1"; 
//        segundo = "Usuario_2";
//        perdedor = "Usuario_3"; 
// prueba 3 seis consecutivos animation
//    aplicarRegla1 = true;
//    resultadoDado = 6; 
//    rachaConsecutiva = 3; 
    }

    @Override
    public void draw() {
        // System.out.println(mouseX + "\n " + mouseY);
        switch (op) {
            case 0:
                //asignación del orden
                ordenDeTiro[0] = user1;
                ordenDeTiro[1] = user2;
                ordenDeTiro[2] = user3;

                background(255, 40, 0);
                String title = "Bienvenido a tu primer parqués";
                textSize(20);
                text(title, width / 2 - textWidth(title) / 2, height / 6);

                // espacio entre cuadros: 50
                // rectangulos donde aparecen las fichas
                rect(250, 225, 130, 170, 7);
                rect(430, 225, 130, 170, 7);
                rect(610, 225, 130, 170, 7);

                textSize(18);

                //visualización de los nicknames
                text(user1, 250 + 130 / 2 - textWidth(user1) / 2, 200);
                text(user2, 430 + 130 / 2 - textWidth(user2) / 2, 200);
                text(user3, 610 + 130 / 2 - textWidth(user3) / 2, 200);

                // ficha jugador 1
                fill(color[i][0], color[i][1], color[i][2]);
                ellipse(250 + 130 / 2, 270, 50, 50);
                noStroke();
                triangle(250 + 130 / 2, 270, 250 + 130 / 2 - 40, 380,
                        250 + 130 / 2 + 40, 380);

                //ficha jugador 2
                fill(color[i2][0], color[i2][1], color[i2][2]);

                ellipse(430 + 130 / 2, 270, 50, 50);
                noStroke();
                triangle(430 + 130 / 2, 270, 430 + 130 / 2 - 40, 380,
                        430 + 130 / 2 + 40, 380);

                // ficha jugador 3
                fill(color[i3][0], color[i3][1], color[i3][2]);
                ellipse(610 + 130 / 2, 270, 50, 50);
                noStroke();
                triangle(610 + 130 / 2, 270, 610 + 130 / 2 - 40, 380,
                        610 + 130 / 2 + 40, 380);

                //flechas para cambiar el color
                //ficha1
                fill(255);
                //triangle(256, 310, 276, 290, 276, 330);
                triangle(374, 310, 354, 290, 354, 330);

                //ficha2
                //triangle(436, 310, 456, 290, 456, 330);
                triangle(554, 310, 534, 290, 534, 330);

                //ficha3
                //triangle(616, 310, 636, 290, 636, 330);
                triangle(734, 310, 714, 290, 714, 330);

                //botones para cambiar el color
                // zona para cambiarle el nombre a los usuarios
                fill(255);
                rect(250, 410, 130, 30, 7);
                rect(430, 410, 130, 30, 7);
                rect(610, 410, 130, 30, 7);

                fill(0);
                textSize(10);
                String cambia = "Cambiar el nombre";
                text(cambia, 250 + 130 / 2 - textWidth(cambia) / 2, 430);
                text(cambia, 430 + 130 / 2 - textWidth(cambia) / 2, 430);
                text(cambia, 610 + 130 / 2 - textWidth(cambia) / 2, 430);

                //Boton
                image(boton, width / 2 - 75, height / 2 + 150, 150, 150);

                break;
            case 1:
                if (inicializar) {
                    mantenerTurno();
                    inicializar = false;
                }

                // metodo que corre la escena 1
                cargarEscena1();

                //animación del dado
                if (empezarDado) {
                    if (controlA) {
                        start = millis();
                        start3 = millis();
                        controlA = false;
                    }
                    dadoAnimation();

                } else {

                    //numero por defecto del dado: 1
                    fill(0);
                    circle((float) 854.50, 485, 15);
                }

                if (millis() - start3 > 5000 && controlD) {
                    comienzaMovimiento = true;
                    aplicarRegla1 = true;
                    controlD = false;
                    System.out.println("no se mueve porque  " + interrumpirTurno);
                }

                if (comienzaMovimiento && interrumpirTurno) {

                    System.out.println("El ganador es " + ganador);

                    if (userSelected.equals(user1)) {

                        casillaAnt1 = casillaActual;
                        if (casillaActual + resultadoDado > 41) {

                            listaCircular.actualizarLista(casillaActual, 0,
                                    userSelected);

                            casillaActual = 0;

                            if (puesto == 0) {
                                puesto++;
                                ganador = user1;

                            } else {

                                segundo = user1;
                                seacabo = true;
                            }

                        } else {

                            listaCircular.actualizarLista(casillaActual, casillaActual
                                    + resultadoDado, userSelected);

                            casillaActual += resultadoDado;
                            System.out.println("se movió el user1");

                            // System.out.println("Carcel " + carcel + " encarcelado " + encarcelado);
                        }

                    } else if (userSelected.equals(user2)) {
                        casillaAnt2 = casillaActual2;

                        if (casillaActual2 + resultadoDado > 41) {
                            listaCircular.actualizarLista(casillaActual2, 0,
                                    userSelected);
                            casillaActual2 = 0;

                            if (puesto == 0) {
                                puesto++;
                                ganador = user2;

                            } else {

                                segundo = user2;
                                seacabo = true;
                            }

                        } else {

                            listaCircular.actualizarLista(casillaActual2, casillaActual2
                                    + resultadoDado, userSelected);
                            casillaActual2 += resultadoDado;
                            System.out.println("se movió el user2");

                            //  System.out.println("Carcel " + carcel + " encarcelado " + encarcelado);
                        }

                    } else if (userSelected.equals(user3)) {
                        casillaAnt3 = casillaActual3;
                        if (casillaActual3 + resultadoDado > 41) {
                            listaCircular.actualizarLista(casillaActual3, 0,
                                    userSelected);

                            casillaActual3 = 0;

                            if (puesto == 0) {
                                puesto++;
                                ganador = user3;

                            } else {

                                segundo = user3;
                                seacabo = true;
                            }

                        } else {
                            listaCircular.actualizarLista(casillaActual3, casillaActual3
                                    + resultadoDado, userSelected);

                            casillaActual3 += resultadoDado;

                            System.out.println("se movió el user3");

                            //  System.out.println("Carcel " + carcel + " encarcelado " + encarcelado);
                        }

                    }

                    comienzaMovimiento = false;
                    //System.out.println("esta es "+ casillaActual);

                    //Determinar al prisionero/s y aparición de la carcel
                    //delay(300);
                    System.out.println("Queso " + listaCircular.carcel);
                    System.out.println("XD " + listaCircular.encarcelado);
                    mandarReoALaPrision();

                    // mover la ficha encarcelada a la zona
//                    if (resultadoDado == 6 && (casillaActual == 6
//                            || casillaActual2 == 6 || casillaActual3 == 6)
//                            && (!encarcelado.equals(userSelected) || !encarcelado2.equals(userSelected))) {
//
//                        moverCarcel();
//
//                    }
                    if (resultadoDado != 6 && (encarcelado.equals(user1) || encarcelado.equals(user2)
                            || encarcelado.equals(user3))
                            || (encarcelado2.equals(user1)
                            || encarcelado2.equals(user2)
                            || encarcelado2.equals(user3))) {

                        moverCarcel();

                    }

                    if ((!userSelected.equals(encarcelado)) && (!(userSelected.equals(encarcelado2))) && !interrumpir2) {
                        fichaMovement();
                    }

                }

                //fichas
                fichaAnimation();
                mostrarMensajes();

                line(25, 0, 25, height);
                line(0, 560, width, 560);

                if (userSelected.equals(encarcelado) || userSelected.equals(encarcelado2)) {
                    casoEspecial = true;
                    //System.out.println("CasoEspecial ON");
                } else {

                    casoEspecial = false;
                }

                if (aplicarRegla1) {

                    if (resultadoDado == 6 && !(userSelected.equals(ganador))) {
                        System.out.println("En racha");

                        if (casoEspecial) {
                            pasarTurno = true;
                            casoEspecial = false;
                        }

                        userEnRacha = userSelected;
                        rachaConsecutiva++;

//                        if (rachaConsecutiva > 1 && rachaConsecutiva < 3) {
//                            comienzaMovimiento = true;
//                        }
                        if (rachaConsecutiva == 3) {

                            if (puesto == 0) {
                                ganador = userEnRacha;
                                System.out.println(ganador);

                                if (ordenDeTiro[0].equals(ganador)) {

                                    listaCircular.actualizarLista(casillaActual,
                                            0, userSelected);

                                    casillaActual = 0;

                                } else if (ordenDeTiro[1].equals(ganador)) {
                                    listaCircular.actualizarLista(casillaActual2,
                                            0, userSelected);
                                    casillaActual2 = 0;

                                } else if (ordenDeTiro[2].equals(ganador)) {

                                    listaCircular.actualizarLista(casillaActual3,
                                            0, userSelected);
                                    casillaActual3 = 0;

                                }
                                fichaMovement();

                            } else {
                                segundo = userEnRacha;

                                seacabo = true;

                            }
                            puesto++;

                        }
                    } else {
                        userEnRacha = "";
                        rachaConsecutiva = 0;
                        pasarTurno = true;
                        System.out.println("Pasaturno verdadero ** ");

                    }
                    aplicarRegla1 = false;
                }

                if (carcel) {
                    quieto = true;
                    if (starter) {

                        start4 = millis();
                        py1 = 100;
                        py2 = 100;
                        py3 = 100;
                        py4 = 100;
                        px1 = 5;
                        px2 = 25;
                        px3 = 45;
                        px4 = 65;
                        by = 125;
                        ty = 70;
                    }
                    enviarCarcelAnimation();

                } else if (carcel2) {

                    quieto = false;
                    enviarCarcelAnimation();
                }

                ///  Revisar
                //pasar al siguiente
                if (pasarTurno) {
                    System.out.println("Pasa Turno");
                    mantenerTurno();
                    pasarTurno = false;

                }

                if (seacabo) {
                    op = 2;
                    determinarPerdedor();
                }

                // botón para ir al inicio 
                fill(0);
                rect(960, 660, 40, 40);

                break;

            case 2:
                //fondo escena 3
                background(255, 40, 0);

                // podio
                if (seacabo) {
                    start2 = millis();
                    seacabo = false;
                }
                podioAnimation();

                if (millis() - start2 >= 6000) {
                    fill(0);
                    textSize(30);
                    String mensajeF = "Felicitaciones a " + ganador + " por ganar";
                    text(mensajeF, width / 2 - textWidth(mensajeF) / 2, 500);
                    String mensajeL = "Dale click al botón para empezar una nueva partida";
                    textSize(15);
                    text(mensajeL, width / 2 - textWidth(mensajeL) / 2, 580);
                    rect(width / 2 - 75, 600, 150, 60);
                    String mensajeR = "Regresar al menú";

                    fill(250);
                    text(mensajeR, width / 2 - textWidth(mensajeR) / 2, 635);

                }

                break;

            case 3:
                // escena de empate

                //fondo escena 4
                background(255, 40, 0);

                break;

        }

    }

    int aument1 = 0, aument2 = 0, aument3 = 0;

    @Override
    public void mouseClicked() {
        if (mouseX >= width / 2 - 75 && mouseX <= width / 2 - 75 + 150
                && mouseY >= height / 2 + 150
                && mouseY <= height / 2 + 150 + 150 && op == 0) {
            op += 1;

        }

        if (tirar) {
            if (mouseX >= 854.5 - 50 && mouseX <= 854.5 + 50
                    && mouseY >= 550 && mouseY <= 650 && op == 1) {
                empezarDado = true;

                //indicador de accion del botón
                //reinicia los valores necesarios para que se efectue la tirada del dado
                controlA = true;
                controlB = true;
                controlC = true;
                controlD = true;
                sw1 = true;
                sw2 = true;
                sw3 = true;
                sw4 = true;
                sw5 = true;
                sw6 = true;

                uno = false;
                dos = false;
                tres = false;
                cuatro = false;
                cinco = false;
                seis = false;
                cont = 0;
            }
        }

        //cambiar los nombres del usuario
        if (mouseX >= 250 && mouseX <= 380 && mouseY >= 410 && mouseY <= 440 && op == 0) {
            user1 = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre de usuario");
            
            
            try{
             if (user1.equals("") ) {
                user1 = "Usuario_1";

            }
            
            }catch(NullPointerException e){
                user1 = "Usuario_1";
            
            }

           
        }

        if (mouseX >= 430 && mouseX <= 560 && mouseY >= 410 && mouseY <= 440 && op == 0) {
            user2 = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre de usuario");
            
            try{
              if (user2.equals("")) {
                user2 = "Usuario_2";

            }
            
            }catch(NullPointerException e){
                user2 = "Usuario_2";
            
            }

          

        }

        if (mouseX >= 610 && mouseX <= 740 && mouseY >= 410 && mouseY <= 440 && op == 0) {
            user3 = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre de usuario");

             try{
              if (user3.equals("") ) {
                user3 = "Usuario_3";

            }
            
            }catch(NullPointerException e){
                user3 = "Usuario_3";
            
            }
            
            

        }

        // cambiar colores de la ficha
        //ficha1 izquierda-derecha
        if (mouseX >= 354 && mouseX <= 374 && mouseY >= 290 && mouseY <= 330 && op == 0) {
            if (aument1 < 3) {
                System.out.println(i);
                this.actualizarDisponibles();
                this.actualizarOcupados(disponibles[aument1], i);
                i = disponibles[aument1];
                aument1++;

            }

            if (aument1 == 3) {
                aument1 = 0;
                this.actualizarDisponibles();
                this.actualizarOcupados(disponibles[aument1], i);
                i = disponibles[aument1];
            }
        }

        // ficha2
        if (mouseX >= 534 && mouseX <= 554 && mouseY >= 290 && mouseY <= 330 && op == 0) {
            if (aument2 < 3) {
                this.actualizarDisponibles();
                this.actualizarOcupados(disponibles[aument2], i2);
                i2 = disponibles[aument2];
                aument2++;
            }

            if (aument2 == 3) {
                aument2 = 0;
                this.actualizarDisponibles();
                this.actualizarOcupados(disponibles[aument2], i2);
                i2 = disponibles[aument2];
            }
        }
        //ficha3 izquierda-derecha

        if (mouseX >= 714 && mouseX <= 734 && mouseY >= 290 && mouseY <= 330 && op == 0) {
            if (aument3 < 3) {
                this.actualizarDisponibles();
                this.actualizarOcupados(disponibles[aument3], i3);
                i3 = disponibles[aument3];
                aument3++;
            }

            if (aument3 == 3) {
                aument3 = 0;
                this.actualizarDisponibles();
                this.actualizarOcupados(disponibles[aument3], i3);
                i3 = disponibles[aument3];
            }
        }

        // para ir al menu (op = 0) en op = 1
        if (mouseX >= 960 && mouseX <= 1000 && mouseY >= 660 && mouseY <= 700 && op == 1) {

            op = 0;
            controlA = false;
            controlA2 = false;
            starter = true;

            user1 = "Usuario_1";
            user2 = "Usuario_2";
            user3 = "Usuario_3";
            anuncio = "Es el turno de ";

            empezarDado = false;
            tirar = true;
            controlB = false;
            controlB2 = false;
            sw1 = true;
            sw2 = true;
            sw3 = true;
            sw4 = true;
            sw5 = true;
            sw6 = true;
            controlC = true;

            uno = false;
            dos = false;
            tres = false;
            cuatro = false;
            cinco = false;
            seis = false;
            sx1 = 0;
            sx2 = 0;
            sx3 = 0;
            sy1 = 0;
            sy2 = 0;
            sy3 = 0;
            cont = 0;
            seacabo = false; // Activador de la Tercera escena 
            altoC = 0;
            altoDer = 0;
            altoIzq = 0;
            ubiy = height / 2 + 75;
            ubiy2 = height / 2 + 75;
            ubiy3 = height / 2 + 75;
            ganador = "";
            segundo = "";
            perdedor = "";
            userSelected = "";
            controlD = false;
            encarcelado = " ";
            encarcelado2 = " ";
            userEnRacha = "";
            carcel = false;
            comienzaMovimiento = false;
            inicializar = true;
            pasarTurno = false;
            aplicarRegla1 = false;
            carcel2 = false;
            carcel3 = false;

            puesto = 0;

            casillaAnt1 = 0;
            casillaAnt2 = 0;
            casillaAnt3 = 0;

            quieto = true;
            interrumpirTurno = true;
            casoEspecial = false;
            i = 0;
            i2 = 1;
            i3 = 2;
            controlA = false;
            controlA2 = false;
            starter = true;

            iniciarLista();

            //inicializar puntos para las fichas
            puntoR[0] = 18;
            puntoR[1] = 140;

            puntoR2[0] = 35;
            puntoR2[1] = 140;

            puntoR3[0] = 55;
            puntoR3[1] = 140;

            // colores de las fichas
            //color1
            color[0][0] = 250;
            color[0][1] = 0;
            color[0][2] = 0;
            color[0][3] = 1;

            //color2
            color[1][0] = 10;
            color[1][1] = 73;
            color[1][2] = 123;
            color[1][3] = 1;

            //color3
            color[2][0] = 229;
            color[2][1] = 190;
            color[2][2] = 1;
            color[2][3] = 1;

            listaCircular.inicializarValores();
            listaCircular.inicializarPositions();

            quieto = true;
            interrumpirTurno = true;
            casoEspecial = false;

            aument1 = 0;
            aument2 = 0;
            aument3 = 0;
            py1 = 100;
            py2 = 100;
            py3 = 100;
            py4 = 100;
            px1 = 5;
            px2 = 25;
            px3 = 45;
            px4 = 65;
            by = 125;
            ty = 70;

            cont2 = 0;
            liberar = false;

        }

        if (mouseX >= width / 2 - 75 && mouseX <= width / 2 + 75 && mouseY >= 600 && mouseY <= 660 && op == 2) {

            op = 0;
            controlA = false;
            controlA2 = false;
            starter = true;

            user1 = "Usuario_1";
            user2 = "Usuario_2";
            user3 = "Usuario_3";
            anuncio = "Es el turno de ";

            empezarDado = false;
            tirar = true;
            controlB = false;
            controlB2 = false;
            sw1 = true;
            sw2 = true;
            sw3 = true;
            sw4 = true;
            sw5 = true;
            sw6 = true;
            controlC = true;

            uno = false;
            dos = false;
            tres = false;
            cuatro = false;
            cinco = false;
            seis = false;
            sx1 = 0;
            sx2 = 0;
            sx3 = 0;
            sy1 = 0;
            sy2 = 0;
            sy3 = 0;
            cont = 0;
            seacabo = false; // Activador de la Tercera escena 
            altoC = 0;
            altoDer = 0;
            altoIzq = 0;
            ubiy = height / 2 + 75;
            ubiy2 = height / 2 + 75;
            ubiy3 = height / 2 + 75;
            ganador = "";
            segundo = "";
            perdedor = "";
            userSelected = "";
            controlD = false;
            encarcelado = " ";
            encarcelado2 = " ";
            userEnRacha = "";
            carcel = false;
            comienzaMovimiento = false;
            inicializar = true;
            pasarTurno = false;
            aplicarRegla1 = false;
            carcel2 = false;
            carcel3 = false;

            puesto = 0;

            casillaAnt1 = 0;
            casillaAnt2 = 0;
            casillaAnt3 = 0;

            quieto = true;
            interrumpirTurno = true;
            casoEspecial = false;
            i = 0;
            i2 = 1;
            i3 = 2;
            controlA = false;
            controlA2 = false;
            starter = true;

            iniciarLista();

            //inicializar puntos para las fichas
            puntoR[0] = 18;
            puntoR[1] = 140;

            puntoR2[0] = 35;
            puntoR2[1] = 140;

            puntoR3[0] = 55;
            puntoR3[1] = 140;

            // colores de las fichas
            //color1
            color[0][0] = 250;
            color[0][1] = 0;
            color[0][2] = 0;
            color[0][3] = 1;

            //color2
            color[1][0] = 10;
            color[1][1] = 73;
            color[1][2] = 123;
            color[1][3] = 1;

            //color3
            color[2][0] = 229;
            color[2][1] = 190;
            color[2][2] = 1;
            color[2][3] = 1;

            listaCircular.inicializarValores();
            listaCircular.inicializarPositions();

            quieto = true;
            interrumpirTurno = true;
            casoEspecial = false;

            aument1 = 0;
            aument2 = 0;
            aument3 = 0;
            py1 = 100;
            py2 = 100;
            py3 = 100;
            py4 = 100;
            px1 = 5;
            px2 = 25;
            px3 = 45;
            px4 = 65;
            by = 125;
            ty = 70;
            cont2 = 0;
            liberar = false;

        }
    }

    public static void main(String[] args) {
        String[] processingArgs = {"Miprimer"};
        MiPrimer mySketch = new MiPrimer();
        PApplet.runSketch(processingArgs, mySketch);

//        String[] processingArgs = {"Zona de pruebas"};
//        Dado mySketch = new Dado();
//        PApplet.runSketch(processingArgs, mySketch);
    }

    public void cargarEscena1() {

        // fondo
        background(255, 40, 0);

        // pantalla con jugadores
        stroke(0);
        strokeWeight(5);
        textSize(18);

        //cuadro jugador 1
        fill(color[i][0], color[i][1], color[i][2]);
        rect(0, 0, width / 3, 50);
        fill(250);
        text(user1, width / 6 - textWidth(user1) / 2, 25);

        //cuadro jugador 2
        fill(color[i2][0], color[i2][1], color[i2][2]);
        rect(width / 3, 0, width / 3, 50);
        fill(250);
        text(user2, width / 3 + width / 6 - textWidth(user2) / 2, 25);

        //cuadro jugador 3
        fill(color[i3][0], color[i3][1], color[i3][2]);
        rect(2 * (width / 3), 0, width / 3, 50);
        fill(250);
        text(user3, 2 * (width / 3) + width / 6 - textWidth(user3) / 2, 25);

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

        //decoración del tablero 
        fill(161, 130, 98);
        noStroke();
        circle((float) 354.5, 425, 300);
        fill(0);
        textSize(25);
        String mensajeM = "MI";
        text(mensajeM, (float) 354.5 - 110, 390);

        String mensajeP = "PRIMER";
        text(mensajeP, (float) 354.5 - 70, 420);

        String mensajePa = "PARQUÉS";
        text(mensajePa, (float) 354.5 + 10, 460);
        // 0, 150, 709, 550

        // zona del dado
        // botón para tirar
        stroke(0);
        fill(0);

        ellipse((float) 854.50, 600, 50, 50);

        // fondo del dado
        fill(250);
        square((float) 854.50 - 35, 450, 70);

    }

    //proceso del juego
    //orden 
    public void mantenerTurno() {

        System.out.println("Estado Carcel 1: " + carcel + " Estado Carcel 2 " + carcel2);
        if (interrumpirTurno()) {

            interrumpirTurno = false;
            System.out.println("Interrumpido");

            System.out.println("se bloquean movimientos");
            // se mantiene el mismo userSelected hasta que de tres tiros o saque un seis
        } else {
            interrumpirTurno = true;

            if (!liberar) {
                //System.out.println("El userSelected" + userSelected);

                System.out.println("siguiente");

                System.out.println(userSelected);
                if (userSelected.equals(ordenDeTiro[0])) {

                    if (ordenDeTiro[1].equals(encarcelado) || ordenDeTiro[1].equals(encarcelado2)) {
                        interrumpirTurno = false;
                    }

                    if (ordenDeTiro[1].equals(ganador)) {
                        userSelected = ordenDeTiro[2];

                    } else {
                        userSelected = ordenDeTiro[1];
                    }

                } else if (userSelected.equals(ordenDeTiro[1])) {

                    if (ordenDeTiro[2].equals(encarcelado) || ordenDeTiro[2].equals(encarcelado2)) {
                        interrumpirTurno = false;
                    }

                    if (ordenDeTiro[2].equals(ganador)) {
                        userSelected = ordenDeTiro[0];

                    } else {
                        userSelected = ordenDeTiro[2];
                    }

                } else if (userSelected.equals(ordenDeTiro[2])) {

                    if (ordenDeTiro[1].equals(encarcelado) || ordenDeTiro[1].equals(encarcelado2)) {
                        interrumpirTurno = false;
                    }

                    if (ordenDeTiro[0].equals(ganador)) {
                        userSelected = ordenDeTiro[1];

                    } else {
                        userSelected = ordenDeTiro[0];
                    }

                } else if (userSelected.equals("")) {
                    userSelected = ordenDeTiro[0];

                }

            }
            liberar = false;

        }

    }

    boolean interrumpir2;

//Metodos relacionados con el dado 
    public void dadoAnimation() {
        noStroke();
        fill(0);

        int separation = 100;

        if (controlB) {
            delay(1000);
            start = millis();
            controlB = false;
        } else {

            // uno
            if (millis() - start < separation && sw1) {
                circle((float) 854.50, 485, 15);
            }

            if (uno) {
                circle((float) 854.50, 485, 15);

            }

            //dos
            if (millis() - start >= separation && millis() - start < 2
                    * separation && sw2) {
                circle((float) 854.50 - 21, 462, 15);
                circle((float) 854.50 + 20, 508, 15);
            }
            if (dos) {
                circle((float) 854.50 - 21, 462, 15);
                circle((float) 854.50 + 20, 508, 15);
//                comienzaMovimiento = true;
//                aplicarRegla1 = true;
            }

            //tres
            if (millis() - start >= 2 * separation && millis() - start
                    < 3 * separation && sw3) {
                circle((float) 854.50 + 21, 462, 15);
                circle((float) 854.50, 485, 15);
                circle((float) 854.50 - 21, 508, 15);

            }
            if (tres) {
                circle((float) 854.50 + 21, 462, 15);
                circle((float) 854.50, 485, 15);
                circle((float) 854.50 - 21, 508, 15);
//                comienzaMovimiento = true;
//                aplicarRegla1 = true;
            }
            // cuatro
            if (millis() - start >= 3 * separation && millis() - start
                    < 4 * separation && sw4) {
                circle((float) 854.50 - 21, 462, 15);
                circle((float) 854.50 - 21, 508, 15);

                circle((float) 854.50 + 21, 462, 15);
                circle((float) 854.50 + 21, 508, 15);
            }
            if (cuatro) {
                circle((float) 854.50 - 21, 462, 15);
                circle((float) 854.50 - 21, 508, 15);

                circle((float) 854.50 + 21, 462, 15);
                circle((float) 854.50 + 21, 508, 15);
//                comienzaMovimiento = true;
//                aplicarRegla1 = true;
            }

            //cinco
            if (millis() - start >= 4 * separation && millis() - start
                    < 5 * separation && sw5) {
                circle((float) 854.50 - 21, 462, 15);
                circle((float) 854.50 - 21, 508, 15);

                circle((float) 854.50, 485, 15);

                circle((float) 854.50 + 21, 462, 15);
                circle((float) 854.50 + 21, 508, 15);

            }
            if (cinco) {
                circle((float) 854.50 - 21, 462, 15);
                circle((float) 854.50 - 21, 508, 15);

                circle((float) 854.50, 485, 15);

                circle((float) 854.50 + 21, 462, 15);
                circle((float) 854.50 + 21, 508, 15);
//                comienzaMovimiento = true;
//                aplicarRegla1 = true;
            }
            //seis 

            if (millis() - start >= 5 * separation && millis() - start
                    < 6 * separation && sw6) {
                circle((float) 854.50 - 21, 462, 15);
                circle((float) 854.50 - 21, 485, 15);
                circle((float) 854.50 - 21, 508, 15);

                circle((float) 854.50 + 21, 462, 15);
                circle((float) 854.50 + 21, 485, 15);
                circle((float) 854.50 + 21, 508, 15);

            }
            if (seis) {
                circle((float) 854.50 - 21, 462, 15);
                circle((float) 854.50 - 21, 485, 15);
                circle((float) 854.50 - 21, 508, 15);

                circle((float) 854.50 + 21, 462, 15);
                circle((float) 854.50 + 21, 485, 15);
                circle((float) 854.50 + 21, 508, 15);
//                comienzaMovimiento = true;
//                aplicarRegla1 = true;
            }

            if (millis() - start >= 6 * separation && cont <= 3) {
                start = millis();

                //System.out.println("contador es " + cont);
                cont++;
            }

            if (cont > 3) {
                if (controlC) {
                    darResultadoDado();
                    //System.out.println("funciona");
                    //System.out.println(" el resultado es " + resultadoDado);

                    switch (resultadoDado) {
                        case 1:
                            sw1 = false;
                            sw2 = false;
                            sw3 = false;
                            sw4 = false;
                            sw5 = false;
                            sw6 = false;
                            uno = true;

                            break;
                        case 2:
                            sw1 = false;
                            sw2 = false;
                            sw3 = false;
                            sw4 = false;
                            sw5 = false;
                            sw6 = false;
                            dos = true;
                            break;

                        case 3:
                            sw1 = false;
                            sw2 = false;
                            sw3 = false;
                            sw4 = false;
                            sw5 = false;
                            sw6 = false;
                            tres = true;

                            break;
                        case 4:
                            sw1 = false;
                            sw2 = false;
                            sw3 = false;
                            sw4 = false;
                            sw5 = false;
                            sw6 = false;

                            cuatro = true;

                            break;
                        case 5:
                            sw1 = false;
                            sw2 = false;
                            sw3 = false;
                            sw4 = false;
                            sw5 = false;
                            sw6 = false;

                            cinco = true;

                            break;
                        case 6:
                            sw1 = false;
                            sw2 = false;
                            sw3 = false;
                            sw4 = false;
                            sw5 = false;
                            sw6 = false;

                            seis = true;

                            break;

                    }
                    controlC = false;
                }

            }

        }

    }

    public void darResultadoDado() {
        //Random radom = new Random(); 
        int rand = (int) (Math.random() * 6) + 1;

        resultadoDado = rand;

    }

    //mover las fichas
    public void fichaAnimation() {

        //ficha_jugador_1
        fill(color[i][0], color[i][1], color[i][2]);
        stroke(0);
        strokeWeight(1);

        triangle(puntoR[0], puntoR[1], puntoR[0] - 15, puntoR[1] + 40,
                puntoR[0] + 15, puntoR[1] + 40);
        ellipse(puntoR[0], puntoR[1], 10, 10);
        //ficha_jugador_2

        fill(color[i2][0], color[i2][1], color[i2][2]);

        triangle(puntoR2[0], puntoR2[1], puntoR2[0] - 15, puntoR2[1] + 40,
                puntoR2[0] + 15, puntoR2[1] + 40);
        ellipse(puntoR2[0], puntoR2[1], 10, 10);

        //ficha_jugador_3
        fill(color[i3][0], color[i3][1], color[i3][2]);

        triangle(puntoR3[0], puntoR3[1], puntoR3[0] - 15, puntoR3[1] + 40,
                puntoR3[0] + 15, puntoR3[1] + 40);
        ellipse(puntoR3[0], puntoR3[1], 10, 10);

    }

    public void fichaMovement() {

        //System.out.println(userSelected);
        //mover las fichas a través del incremento de los atributos de movimiento 
        //resultadoDado 
        // sx y sy   
        //System.out.println(casillaActual);
        int x = 0, y = 0;
        //usuario 1 
        System.out.println("Estas dentron fichaMovement");
        if (userSelected.equals(user1)) {
            moverFicha(user1);

            //System.out.println("entró al user1\n " + casillaActual + " " + sx1 + " " + sy1);
        }
        // usuario 2
        if (userSelected.equals(user2)) {
            moverFicha(user2);
            //System.out.println("entró al user2\n " + casillaActual2 + " " + sx2 + " " + sy2);
        }
        // usuario 3
        if (userSelected.equals(user3)) {
            moverFicha(user3);
            //System.out.println("entró al user3\n " + casillaActual3 + " " + sx3 + " " + sy3);
        }
    }

    public void moverFicha(String user) {

        System.out.println("el valor de carcel2 es " + carcel2);

        if (user.equals(user1)) {
//        
            listaCircular.getPositions(casillaActual, puesto, carcel2, carcel);
            puntoR[0] = listaCircular.px;
            puntoR[1] = listaCircular.py;
            System.out.println(puntoR[0] + "  " + puntoR[1]);

        } else if (user.equals(user2)) {
            listaCircular.getPositions(casillaActual2, puesto, carcel2, carcel);
            puntoR2[0] = listaCircular.px;
            puntoR2[1] = listaCircular.py;

        } else if (user.equals(user3)) {
            listaCircular.getPositions(casillaActual3, puesto, carcel2, carcel);
            puntoR3[0] = listaCircular.px;
            puntoR3[1] = listaCircular.py;

        }

    }

    // 
    public void mandarReoALaPrision() {

        if (carcel == false) {

            carcel = listaCircular.carcel;

            if (listaCircular.carcel) {

                listaCircular.carcel = false;
            }

            System.out.println("el encarcelado uno es " + listaCircular.encarcelado);

        } else {

            if (carcel2 == false) {

                carcel2 = listaCircular.carcel;
                System.out.println("Carcel2 fue alterada");

            }
        }

        if (encarcelado.equals(" ") && carcel) {

            encarcelado = listaCircular.encarcelado;
            listaCircular.encarcelado = " ";

            // inicia la animación de carcel
            starter = true;

        } else if (encarcelado2.equals(" ") && carcel2) {

            encarcelado2 = listaCircular.encarcelado;
            System.out.println("el encarcelado dos es " + listaCircular.encarcelado);

        }

    }

    public void moverCarcel() {

        if ((encarcelado.equals(user1) || encarcelado.equals(user2) || encarcelado.equals(user3)) && !carcel2) {

            if (encarcelado.equals(user1)) {

                listaCircular.actualizarLista(0,
                        0, userSelected);
                casillaActual = 0;
                moverFicha(user1);
                System.out.println("encarcelado es user1");

            } else if (encarcelado.equals(user2)) {

                listaCircular.actualizarLista(0,
                        0, userSelected);

                casillaActual2 = 0;
                moverFicha(user2);
                System.out.println("encarcelado es user2");
            } else if (encarcelado.equals(user3)) {

                listaCircular.actualizarLista(0,
                        0, userSelected);
                casillaActual3 = 0;
                moverFicha(user3);
                System.out.println("encarcelado es user3");
            }
            System.out.println("pa la carcel1");

        }

        if (encarcelado2.equals(user1) || encarcelado2.equals(user2) || encarcelado2.equals(user3)) {
            if (encarcelado2.equals(user1)) {
                listaCircular.actualizarLista(0,
                        0, userSelected);
                casillaActual = 0;
                moverFicha(user1);
                System.out.println("encarcelado2 es user1");
            } else if (encarcelado2.equals(user2)) {
                listaCircular.actualizarLista(0,
                        0, userSelected);
                casillaActual2 = 0;
                moverFicha(user2);
                System.out.println("encarcelado2 es user2");

            } else if (encarcelado2.equals(user3)) {
                listaCircular.actualizarLista(0,
                        0, userSelected);
                casillaActual3 = 0;
                moverFicha(user3);
                System.out.println("encarcelado2 es user3");
            }
            System.out.println("pa la carcel2");

        }

    }

    //animacion intro de la carcel
    float py1 = 100, py2 = 100, py3 = 100, py4 = 100;
    float px1 = 5, px2 = 25, px3 = 45, px4 = 65, by = 125, ty = 70;

//    int py1 = 130, py2 = 130, py3 = 130, py4 = 130;
//    int px1 = 5, px2 = 25, px3 = 45, px4 = 65;
    public void enviarCarcelAnimation() {
        int separation = 280;
        fill(138, 149, 151);

//        if (millis() - start4 >= separation && millis() - start4 < separation * 2 && quieto) {
//
//            by += 2;
//            // System.out.println(by);
//            noStroke();
//            //base
//            rect(3, by, 74, 35, 10);
//
//        } else if (millis() - start4 >= separation * 2) {
//            noStroke();
//            rect(3, by, 74, 35, 10);
//
//        }
        if (millis() - start4 >= separation * 2 && millis() - start4 < separation * 3 && quieto) {
            stroke(0);
            py1 += 2.2968;
            rect(px1, py1, 10, 60);
            //System.out.println(py1);
        } else if (millis() - start4 >= separation * 3) {
            stroke(0);
            rect(px1, 130, 10, 60);

        }

        if (millis() - start4 >= separation * 3 && millis() - start4 < separation * 4 && quieto) {

            stroke(0);
            py2 += 2.2968;
            rect(px2, py2, 10, 60);
            //System.out.println(py2);
        } else if (millis() - start4 >= separation * 4) {
            stroke(0);
            rect(px2, 130, 10, 60);

        }

        if (millis() - start4 >= separation * 4 && millis() - start4 < separation * 5 && quieto) {
            stroke(0);
            py3 += 2.2968;
            rect(px3, py3, 10, 60);
            // System.out.println(py3);

        } else if (millis() - start4 >= separation * 5) {
            stroke(0);
            rect(px3, 130, 10, 60);

        }

        if (millis() - start4 >= separation * 5 && millis() - start4 < separation * 6 && quieto) {
            stroke(0);
            py4 += 2.18;
            rect(px4, py4, 10, 60);
            //System.out.println(py4);

        } else if (millis() - start4 >= separation * 6) {
            stroke(0);
            rect(px4, 130, 10, 60);

        }

        if (millis() - start4 >= separation * 6 && millis() - start4 <= separation * 7 && quieto) {
            ty += 2.2968;
            rect(3, ty, 74, 35, 10);
        } else if (millis() - start4 >= separation * 7) {
            stroke(0);
            rect(3, 100, 74, 35, 10);

        }

        starter = false;

    }

    int cont2 = 0;

    public boolean interrumpirTurno() {

        boolean interrumpir = false;
        int who = 0;
        //System.out.println(encarcelado + "\n"+ encarcelado2);

        if (userSelected.equals(encarcelado) || userSelected.equals(encarcelado2)) {

            interrumpir = true;
            cont2++;
            System.out.println("Cont2 es " + cont2);

            //System.out.println("Estás en la carcel");
            if (userSelected.equals(encarcelado)) {
                who = 1;

            } else {
                who = 2;

            }

            // System.out.println("entró a interrupción");
        }

        if (cont2 == 3 || resultadoDado == 6) {

            interrumpir = false;
            System.out.println("Está en el cont = 3");

            if (resultadoDado == 6) {

                switch (who) {

                    case 1:
                        carcel = false;
                        encarcelado = " ";
                        System.out.println("Se va el encarcelado1 ");

                        break;
                    case 2:
                        encarcelado2 = " ";
                        carcel2 = false;

                        System.out.println("Se va el encarcelado2 ");

                        break;

                }

                comienzaMovimiento = true;
                liberar = true;
            } else {
                comienzaMovimiento = false;
            }

            cont2 = 0;

            casoEspecial = false;
        }
        interrumpir2 = interrumpir;
        return interrumpir;

    }
    boolean liberar = false;

    public void determinarPerdedor() {

        if (!(user1.equals(ganador) || user1.equals(segundo))) {
            perdedor = user1;
        }

        if (!(user2.equals(ganador) || user2.equals(segundo))) {
            perdedor = user2;
        }
        if (!(user3.equals(ganador) || user3.equals(segundo))) {
            perdedor = user3;
        }

    }

    //otros
    public void mostrarMensajes() {

        String message1 = anuncio + userSelected;
        fill(250);
        textSize(18);
        text(message1, (float) 854.50 - textWidth(message1) / 2, 150);

        String message2 = "Es hora de tirar el dado";
        text(message2, (float) 854.50 - textWidth(message2) / 2, 400);

    }

    public void actualizarDisponibles() {
        int cont = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 3; j <= 3; j++) {
                if (color[i][j] == 0) {
                    disponibles[cont] = i;
                    cont++;
                }

            }
        }

    }

    public void actualizarOcupados(int camb, int ant) {
        color[camb][3] = 1;
        color[ant][3] = 0;

    }

    public void podioAnimation() {

        double inc1 = 4.5, inc2 = 2, inc3 = 3;
        noStroke();
        //animacion del rectangulo del centro
        if (millis() - start2 < 1000) {
            altoC += inc1;

            ubiy = height / 2 - altoC + 75;

        }

        //animacion del rectangulo de izquierda
        if (millis() - start2 < 2000 && millis() - start2 >= 1000) {
            altoIzq += inc2;

            ubiy3 = height / 2 - altoIzq + 75;

            controlA2 = true;
        }

        //animación del rectangulo derecho
        if (millis() - start2 < 3000 && millis() - start2 >= 2000) {
            altoDer += inc3;

            ubiy2 = height / 2 - altoDer + 75;

            //System.out.println(ubiy2 + " " + altoDer);
            controlB2 = true;
        }

        stroke(0);
        fill(255);
        //parte del podio
        if (controlA2) {
            rect(width / 2 - 120, (float) ubiy3, 80, (float) altoIzq);
        }

        //parte del podio----  centro
        rect(width / 2 - 40, (float) ubiy, 80, (float) altoC);
        //System.out.println(ubiy);

        if (controlB2) {
            //parte del podio
            rect(width / 2 + 40, (float) ubiy2, 80, (float) altoDer);
        }

        if (millis() - start2 >= 3000) {

            //ficha jugador ganador
            if (ordenDeTiro[0].equals(ganador)) {
                fill(color[i][0], color[i][1], color[i][2]);

            } else if (ordenDeTiro[1].equals(ganador)) {
                fill(color[i2][0], color[i2][1], color[i2][2]);

            } else if (ordenDeTiro[2].equals(ganador)) {
                fill(color[i3][0], color[i3][1], color[i3][2]);

            }

            triangle(width / 2, (float) ubiy - 60, width / 2 - 25, (float) ubiy,
                    width / 2 + 25, (float) ubiy);
            ellipse(width / 2, (float) ubiy - 60, 20, 20);
            textSize(14);
            fill(0);
            text("Ganador", width / 2 - textWidth("Ganador") / 2, 75);
            //text(ganador, width / 2 - 40 - textWidth(ganador) / 2, 225);
        }

        if (millis() - start2 >= 5000) {

            //perdedor
            if (ordenDeTiro[0].equals(perdedor)) {
                fill(color[i][0], color[i][1], color[i][2]);

            } else if (ordenDeTiro[1].equals(perdedor)) {
                fill(color[i2][0], color[i2][1], color[i2][2]);

            } else if (ordenDeTiro[2].equals(perdedor)) {
                fill(color[i3][0], color[i3][1], color[i3][2]);

            }

            triangle(width / 2 - 80, (float) ubiy3 - 60, width / 2 - 105, (float) ubiy3,
                    width / 2 - 55, (float) ubiy3);
            ellipse(width / 2 - 80, (float) ubiy3 - 60, 20, 20);
            textSize(14);
            fill(0);
            text("Perdedor", width / 2 - 80 - textWidth("Perdedor") / 2, 225);
            //text(perdedor, width / 2 - 120 - textWidth(perdedor) / 2, 225);

        }

        if (millis() - start2 >= 4000) {

            //segundo
            if (ordenDeTiro[0].equals(segundo)) {
                fill(color[i][0], color[i][1], color[i][2]);

            } else if (ordenDeTiro[1].equals(segundo)) {
                fill(color[i2][0], color[i2][1], color[i2][2]);

            } else if (ordenDeTiro[2].equals(segundo)) {
                fill(color[i3][0], color[i3][1], color[i3][2]);

            }

            triangle(width / 2 + 80, (float) ubiy2 - 60, width / 2 + 55, (float) ubiy2,
                    width / 2 + 105, (float) ubiy2);
            ellipse(width / 2 + 80, (float) ubiy2 - 60, 20, 20);
            textSize(14);
            fill(0);
            text("2do Lugar", width / 2 + 80 - textWidth("2do Lugar") / 2, 170);
            //text(segundo, width / 2 + 40 - textWidth(segundo) / 2, 225);

        }

    }

    public void iniciarLista() {
        Nodo PTR, ULT;
        PTR = null;
        ULT = null;
        int n = 42;

        listaCircular.crearLista(PTR, ULT, i - 1, "", 250, n);

    }
}
