/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura_de_datos;

/**
 *
 * @author Ricardo
 */
public class ListaCircular {

    public Nodo PTR;
    public Nodo ULT;
    public float px, py;
    public boolean carcel = false;
    public String encarcelado = " ";

    public float[][] positions = new float[45][2];

    public void crearLista(Nodo PTR, Nodo ULT, int casilla, String usuario, int color, int n) {

        int i = 0;

        while (i < n) {
            Nodo Q = new Nodo();
            Q.setCasilla(i);
            Q.setColor(250);
            Q.setUsuario("");

            if (PTR == null) {
                PTR = Q;
                this.PTR = PTR;

            } else {
                ULT.setLink(Q);
            }

            ULT = Q;
            this.ULT = ULT;

            if (i == n - 1) {
                ULT.setLink(PTR);
            }

            i++;
        }

    }

    // metodo de prueba  nunca usado dentro del proyecto
    public void mostrarLista(Nodo PTR) {

        System.out.println(PTR.getCasilla() + " xd" + PTR.getColor() + "xd" + PTR.getUsuario());
        Nodo P = PTR.getLink();

        while (P != PTR) {
            System.out.println(P.getCasilla() + " xd" + P.getColor() + "xd" + P.getUsuario());
            P = P.getLink();
        }

    }
    //

    public void actualizarLista(int actual, int siguiente, String usuario) {
//        if (carcel) {
//            carcel = false;
//
//        }
//
//        if (!encarcelado.equals(" ")) {
//            encarcelado = " ";
//        }

        Nodo P = PTR;
        int i = 0;
        while (i < 2) {

            if (P == PTR) {
                i++;
            }
            if (i < 2) {

                //  se desocupa la casilla a dejar
                if (P.getCasilla() == actual) {
                    P.setUsuario("");
                    P.setColor(250);
                }

                if (P.getCasilla() == siguiente) {

                    System.out.println("Casilla # " + P.getCasilla());
                    
                    if (P.getCasilla() != 0) {
                        // si está vacia se escribe el usuario
                        if ((P.getUsuario()).equals("")) {
                            System.out.println("Casilla Vacia");
                            P.setUsuario(usuario);
                             System.out.println("Usuario sobreescrito <= " + usuario);
                            P.setColor(0);

                        } else {
                            // sino se va a la carcel
                            carcel = true;
                            encarcelado = P.getUsuario();
                            System.out.println("Usuario encanao es " + encarcelado);
                            P.setUsuario(usuario);
                            P.setColor(0);

                        }
                        System.out.println("Es diferente de cero");
                    }

                }
            }
            //System.out.println("getLink2" + P.getLink());
            P = P.getLink();
        }

        System.out.println("salió actualizarLista\n" + carcel + " " + encarcelado);
    }

    public void inicializarPositions() {

        Nodo P = new Nodo();

        P = PTR.getLink();

        int i = 1, i2 = 0;

        while (i < 2) {

            P.position[0] = positions[i2][0];
            P.position[1] = positions[i2][1];
            i2++;

            P = P.getLink();

            if (P == PTR) {
                PTR.position[0] = positions[41][0];
                PTR.position[1] = positions[41][1];

                PTR.position2[0] = positions[42][0];
                PTR.position2[1] = positions[42][1];

                PTR.position3[0] = positions[43][0];
                PTR.position3[1] = positions[43][1];

                PTR.position4[0] = positions[44][0];
                PTR.position4[1] = positions[44][1];

                i++;

            }

        }
        //System.out.println(" Salió 2");  // todo bien   
    }

    public void inicializarValores() {

        float acum = 110, acum2 = 219;

        for (int i = 0; i < 10; i++) {

            if (i == 0) {
                positions[i][0] = acum;
                positions[i][1] = 140;

            } else if (i == 9) {
                acum = 678;
                positions[i][0] = acum;
                positions[i][1] = 140;

            } else {
                acum += 60;
                positions[i][0] = acum;
                positions[i][1] = 140;

            }

        }

        for (int i = 10; i < 21; i++) {

            if (i == 10) {
                positions[i][0] = acum;
                positions[i][1] = acum2;

            } else if (i == 20) {
                acum2 = 640;
                positions[i][0] = acum;
                positions[i][1] = acum2;

            } else {
                acum2 += 38;
                positions[i][0] = acum;
                positions[i][1] = acum2;

            }

        }

        acum = 600;

        for (int i = 21; i < 31; i++) {

            if (i == 21) {
                positions[i][0] = acum;
                positions[i][1] = acum2;

            } else if (i == 30) {
                acum = 30;
                positions[i][0] = acum;
                positions[i][1] = acum2;

            } else {
                acum -= 60;
                positions[i][0] = acum;
                positions[i][1] = acum2;

            }

        }

        acum2 = 560;
        for (int i = 31; i <= 40; i++) {

            if (i == 31) {
                positions[i][0] = acum;
                positions[i][1] = acum2;

            } else {

                positions[i][0] = acum;
                acum2 -= 38;
                positions[i][1] = acum2;

            }

        }

        positions[41][0] = 25;
        positions[41][1] = 180;

        positions[42][0] = 35;
        positions[42][1] = 180;

        //posiciones con carcel 
        //position 1 carcel
        positions[43][0] = 30;
        positions[43][1] = 140;

        //position 2 carcel
        positions[44][0] = 50;
        positions[44][1] = 140;

        //System.out.println("Positivo");
    }

    public void getPositions(int casillaActual, int puesto, boolean carcel2, boolean carcel) {

        Nodo P;
        P = PTR;
        int i = 0;
        while (i < 2) {
            // System.out.println("Casilla #" + P.getCasilla());

            if (P.getCasilla() == casillaActual) {

                if (casillaActual == 0 && puesto == 1) {
                    px = PTR.position[0];
                    py = PTR.position[1];
                } else if (casillaActual == 0 && puesto == 2) {
                    px = PTR.position2[0];
                    py = PTR.position2[1];

                } 
                
                if (casillaActual == 0 && carcel) {

                    px = PTR.position3[0];
                    py = PTR.position3[1];
                    System.out.println("lugar 1 carcel");

                }  
                
                if (casillaActual == 0 && carcel2) {

                    px = PTR.position4[0];
                    py = PTR.position4[1];
                    System.out.println("lugar 2 carcel");

                } 
                
                if(casillaActual != 0){
                    px = P.position[0];
                    py = P.position[1];

                }

                //System.out.println("Chao pescao");
                //System.out.println(px + " " + py);
                break;

            }
            //  System.out.println("getLink es " + P.getLink());
            P = P.getLink();
            if (P == PTR) {
                i++;
            }

            // System.out.println(i);
        }
        // System.out.println(" Salió 3");
    }

}
