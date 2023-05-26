package Lab11;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * The main() program in this class is designed to read requests from
 * a Web browser and display the requests on standard output.  The
 * program sets up a listener on port 50505.  It can be contacted
 * by a Web browser running on the same machine using a URL of the
 * form  http://localhost:505050/path/to/resource.html  This method
 * does not return any data to the web browser.  It simply reads the
 * request, writes it to standard output, and then closes the connection.
 * The program continues to run, and the server continues to listen
 * for new connections, until the program is terminated (by clicking the
 * red "stop" square in Eclipse or by Control-C on the command line).
 */
public class ReadRequest {
	
    private static class ConnectionThread extends Thread {
        Socket connection;
        ConnectionThread(Socket connection) {
           this.connection = connection;
        }
        public void run() {
           handleConnection(connection);
        }
     }
    
    /**
	 * The server listens on this port.  Note that the port number must
	 * be greater than 1024 and lest than 65535.
	 */
	private final static int LISTENING_PORT = 50505;
	private final static String rootDir = System.getProperty("user.dir") + "/src/lab_11/www";
	
	/**
	 * Main program opens a server socket and listens for connection
	 * requests.  It calls the handleConnection() method to respond
	 * to connection requests.  The program runs in an infinite loop,
	 * unless an error occurs.
	 * @param args ignored
	 */
	public static void main(String[] args) {
		System.out.println(rootDir);
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(LISTENING_PORT);
		} catch (Exception e) {
			System.out.println("Failed to create listening socket.");
			return;
		}
		System.out.println("Listening on port " + LISTENING_PORT);
		try {
			while (true) {
				Socket connection = serverSocket.accept();
				System.out.println("\nConnection from " 
						+ connection.getRemoteSocketAddress());
				//handleConnection(connection);
				ConnectionThread thread = new ConnectionThread(connection);
				thread.start();
			}
		} catch (Exception e) {
			System.out.println("Server socket shut down unexpectedly!");
			System.out.println("Error: " + e);
			System.out.println("Exiting.");
		} 
		try {
			serverSocket.close();
		} catch (Exception e) {
			System.out.println("Failed to close listening socket.");
		}
	}
	
	/**
	 * Returns the Mime Type of a file based on the file's extension.
	 * 
	 * Taken verbatim from Lab 11.
	 * 
	 * @param fileName
	 * @return
	 */
	private static String getMimeType(String fileName) {
		int pos = fileName.lastIndexOf('.');
		if (pos < 0)  // no file extension in name
			return "x-application/x-unknown";
		String ext = fileName.substring(pos+1).toLowerCase();
		if (ext.equals("txt")) return "text/plain";
		else if (ext.equals("html")) return "text/html";
		else if (ext.equals("htm")) return "text/html";
		else if (ext.equals("css")) return "text/css";
		else if (ext.equals("js")) return "text/javascript";
		else if (ext.equals("java")) return "text/x-java";
		else if (ext.equals("jpeg")) return "image/jpeg";
		else if (ext.equals("jpg")) return "image/jpeg";
		else if (ext.equals("png")) return "image/png";
		else if (ext.equals("gif")) return "image/gif";
		else if (ext.equals("ico")) return "image/x-icon";
		else if (ext.equals("class")) return "application/java-vm";
		else if (ext.equals("jar")) return "application/java-archive";
		else if (ext.equals("zip")) return "application/zip";
		else if (ext.equals("xml")) return "application/xml";
		else if (ext.equals("xhtml")) return"application/xhtml+xml";
		else return "x-application/x-unknown";
		// Note:  x-application/x-unknown  is something made up;
		// it will probably make the browser offer to save the file.
	}
	
	/**
	 * Sends a file to a web client.
	 * 
	 * Taken verbatim from Lab 11.
	 * 
	 * @param file
	 * @param socketOut
	 * @throws IOException
	 */
	private static void sendFile(File file, OutputStream socketOut) throws
	IOException {
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		OutputStream out = new BufferedOutputStream(socketOut);
		while (true) {
			int x = in.read(); // read one byte from file
			if (x < 0)
				break; // end of file reached
			out.write(x);  // write the byte to the socket
		}
		in.close();
		out.flush();
		out.close();
	}
	
	/**
	 * Sends an error message to web client.
	 * 
	 * @param errorNum
	 * @param socketOut
	 */
	private static void sendError(int errorNum, OutputStream socketOut) {
		String error, errorMessage;
		PrintWriter out = new PrintWriter(socketOut);
		
		switch (errorNum) {
		case 400:
			error = " Bad Request.";
			errorMessage = "Your client has issued a malformed or illegal request.";
			break;
		case 403:
			error = " Forbidden";
			errorMessage = "You do not have permission to view this resource.";
			break;
		case 404:
			error = " Not Found";
			errorMessage = "The resource that you requested does not exist on this server.";
			break;
		case 501:
			error = " Not Implemented";
			errorMessage = "The server either does not recognize the request method, "
					+ "or it lacks the ability to fulfill the request.";
			break;
		default:
			error = " Internal Server Error";
			errorMessage = "The server encountered an internal error or "
					+ "misconfiguration and was unable to complete your request."; 
		}
		out.print("HTTP/1.1 " + errorNum + error + "\r\n");
		out.print("Connection: close\r\n");
		out.print("Content-Type: text/html\r\n");
		out.print("\r\n");
		out.print("<html>\r\n");
		out.print("    <head>\r\n");
		out.print("        <title>Error</title>\r\n");
		out.print("    </head>\r\n");
		out.print("    <body>\r\n");
		out.print("        <h2>Error: " + errorNum + error + "</h2>\r\n");
		out.print("        <p>" + errorMessage + "</p>\r\n");
		out.print("    </body>\r\n");
		out.print("</html>\r\n");
		out.print("\r\n");
		out.flush();
		out.close();
	}
	
	/**
	 * Handle communication with one client connection.
	 * 
	 * NOTE:  This method does not throw any exceptions.  Exceptions are
	 * caught and handled in the method, so that they will not shut down
	 * the server.
	 * @param connection the connected socket that will be used to
	 *    communicate with the client.
	 */
	private static void handleConnection(Socket connection) {
		OutputStream out;
		InputStream in;
		try {
			in = connection.getInputStream();
			out = connection.getOutputStream();
			try {
				Scanner inReader = new Scanner(in);
				PrintWriter outWriter = new PrintWriter(out);
				
				if (inReader.hasNextLine()) {
					String[] lines = inReader.nextLine().trim().split(" ");
					if (!lines[0].equals("GET")) {
						System.out.println("Not Implemented");
						sendError(501, out);
					} else if (!lines[2].contains("HTTP/1")) {
						System.out.println("Bad Request.");
						sendError(400, out);
					} else {
						File file = new File(rootDir + lines[1]);
						if (file.isDirectory()) {
							file = new File(file, "index.html");
						}
						if (file.exists()) {
							if (file.canRead()) {
								System.out.println(file.getPath());
								System.out.println(getMimeType(file.getPath()));
								outWriter.print("HTTP/1.1 200 OK\r\n");
								outWriter.print("Connection: close\r\n");
								outWriter.print("Content-Type: " + getMimeType(file.getPath()) + "\r\n");
								outWriter.print("Content-Length: " + file.length() + "\r\n");
								outWriter.print("\r\n");

								outWriter.flush();
								sendFile(file, out);
							} else {
								System.out.println("Forbidden");
								sendError(403, out);
							}
						} else {
							System.out.println("Not Found");
							sendError(404, out);
						}
					}
				}
				inReader.close();
				outWriter.close();
			} catch (IOException e) {
				System.out.println("Internal Server Error");
				sendError(500, out);
			} finally {
				in.close();
				out.close();
			}
		} catch (Exception e) {
			System.out.println("Error while communicating with client: " + e);
		} finally {  // make SURE connection is closed before returning!
			try {
				connection.close();
			} catch (Exception e) {
			}
			System.out.println("Connection closed.");
		}
	}
}
