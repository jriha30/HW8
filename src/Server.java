import java.io.*;
import java.net.*;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Server
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket s = new ServerSocket(2222);
        while(true)
        {
            System.out.println("Listening for Connection...");
            Socket client = s.accept(); //blocks
            WorkerThread t = new WorkerThread(client);
            t.start();
        }
    }
}
