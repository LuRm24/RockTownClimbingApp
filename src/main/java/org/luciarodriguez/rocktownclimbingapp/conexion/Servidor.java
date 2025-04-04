package org.luciarodriguez.rocktownclimbingapp.conexion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public void arrancarServidor() {

        try {
            //Conectamos servidor al puerto
            ServerSocket serverSocket = new ServerSocket(49300);
            //Creamos el socket para la conexión con cliente
            Socket socket = new Socket();

            System.out.println("Esperando conexiones del cliente");

            //Llamamos al metodo accept del socket que acepta la conexión de un cliente
            //y queda a la espera hasta que el cliente se conecta
            socket = serverSocket.accept();

            //Recibe del cliente el nombre nada mas conectarse
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje = entrada.readLine();

            //Indicamos que se ha recibido el nombre y se ha conectado el ciente
            System.out.println("Cliente conectado: " + mensaje);
        }
        catch (IOException io){
            io.printStackTrace();
        }
    }
}
