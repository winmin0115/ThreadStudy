package day4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerRunnable implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;

    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
        try {
            InputStream input  = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            long time = System.currentTimeMillis();
            output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " + serverText + " - " +  time + "").getBytes());
            output.close();
            input.close();
            System.out.println("Request processed:"+Thread.currentThread().getName()+"-" + time);
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
}

class ThreadPooledServer implements Runnable{

    protected int          serverPort;
    protected ServerSocket serverSocket = null;
    protected boolean      isStopped    = false;
    protected Thread       runningThread= null;
    protected ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public ThreadPooledServer(int port){
        serverPort = port;
    }

    public void run(){
        synchronized(this){
            runningThread = Thread.currentThread();
        }
        openServerSocket();
        while(! isStopped()){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server Stopped.") ;
                    break;
                }
                throw new RuntimeException("Error accepting client connection", e);
            }
            System.out.println("Client Request!!"+clientSocket );
            threadPool.execute( new WorkerRunnable(clientSocket, "Thread Pooled Server"));
        }
        this.threadPool.shutdown();
        System.out.println("Server Stopped.") ;
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 9000", e);
        }
    }
}

public class PoolExample7 {

	public static void main(String[] args) {
		ThreadPooledServer server = new ThreadPooledServer(9000);
		new Thread(server).start();

		try {
		    Thread.sleep(50 * 1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		System.out.println("Stopping Server");
		server.stop();

	}

}
