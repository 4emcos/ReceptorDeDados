import java.io.*;
import java.net.*;
import java.util.Scanner;

class ReceptorDados {

    public static void main(String args[]) throws Exception, SocketException
    {
        Socket clientSocket = new Socket();
        int porta = 0;
        String servidor = " ";
        Scanner teclado = new Scanner(System.in);

        //recebendo servidor e porta
        System.out.println("Digite o servidor");
        servidor = teclado.nextLine();
        System.out.println("Digite a porta");
        porta = teclado.nextInt();

        do
        {
            try {
                System.out.println("Conectando ao servidor " + servidor + ":" + porta);
                clientSocket.connect(new InetSocketAddress(servidor, porta));
                 BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));

                    while (clientSocket.isConnected())
                    {

                        //Scanner teclado = new Scanner(System.in);
                        PrintStream saida = new PrintStream(clientSocket.getOutputStream());
                        //System.out.printf(": ");
                        Thread.sleep(10000);
                        saida.append("#");
                        //saida.println(teclado.nextLine());
                        int i = 0;
                        while (i != 5) {
                            System.out.println(inFromServer.readLine());
                            i++;
                        }
                    }
                } catch (Exception e)
                    {
                        System.err.println("Nao foi possivel conectar.");
                        Thread.sleep(100000);
                    }

        } while (true);

        }




    }

