import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class WorkerThread extends Thread
{
    private Socket theClientSocket;
    private PrintStream clientOutput;
    private Scanner clientInput;

    public WorkerThread(Socket theClientSocket)
    {
        try
        {
            System.out.println("Connection Established...");
            this.theClientSocket = theClientSocket;
            this.clientOutput = new PrintStream(this.theClientSocket.getOutputStream());
            this.clientInput = new Scanner(this.theClientSocket.getInputStream());
        }
        catch (Exception e)
        {
            System.err.println("Bad things happened in thread!!!!!");
            e.printStackTrace();
        }

    }

    public void run()
    {
        //this is what the thread does
        while(true)
        {
            this.clientOutput.println("Inputs so far: " + Singleton.getInstance().clientInputs + "Please enter something: ");
            String name = clientInput.nextLine();
            Singleton.getInstance().clientInputs.add(name);
        }
    }
}