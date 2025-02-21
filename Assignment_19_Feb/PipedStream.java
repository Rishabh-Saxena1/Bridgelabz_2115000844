import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
class WriterThread extends Thread {
    private PipedOutputStream outputStream;
    public WriterThread(PipedOutputStream outputStream) {
        this.outputStream = outputStream;
    }
    public void run() {
        try {
            String message = "Hello I am WriterThread!";
            outputStream.write(message.getBytes());
            outputStream.close();
        }
        catch (IOException e) {
            System.err.println("WriterThread IOException: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream inputStream;
    public ReaderThread(PipedInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void run() {
        try {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
            inputStream.close();
        }
        catch (IOException e) {
            System.err.println("ReaderThread IOException: " + e.getMessage());
        }
    }
}

public class PipedStream {
    public static void main(String[] args) {
        try {
            PipedOutputStream outputStream = new PipedOutputStream();
            PipedInputStream inputStream = new PipedInputStream(outputStream);

            Thread writer = new WriterThread(outputStream);
            Thread reader = new ReaderThread(inputStream);

            writer.start();
            reader.start();
        } catch (IOException e) {
            System.err.println("Main IOException: " + e.getMessage());
        }
    }
}
