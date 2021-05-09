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

    public void mostratLista(Nodo PTR) {

        System.out.println(PTR.getCasilla() + " xd" + PTR.getColor() + "xd" + PTR.getUsuario());
        Nodo P = PTR.getLink();

        while (P != PTR) {
            System.out.println(P.getCasilla() + " xd" + P.getColor() + "xd" + P.getUsuario());
            P = P.getLink();
        }

    }

    public void actualizarLista(int actual, int siguiente, String usuario, boolean carcel, String encarcelado) {
        Nodo P = PTR;
        int i = 0;
        while (i < 2) {

            if (P == PTR) {
                i++;
            }
            if (i < 2) {
                if (P.getCasilla() == actual) {
                    P.setUsuario("");
                    P.setColor(250);
                }

                if (P.getCasilla() == siguiente) {
                    
                    if ((P.getUsuario()).equals("")) {
                        P.setUsuario(usuario);
                        P.setColor(0);
                     
                    } else {
                    carcel = true;
                    encarcelado = P.getUsuario();
                    
                    }
                   

                }
            }
            P = P.getLink();
        }
        System.out.println("salió");
    }
}
