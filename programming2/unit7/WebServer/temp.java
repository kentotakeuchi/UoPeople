import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

/**
 * The main() program in this class is designed to read requests from
 * a Web browser and display the requests on standard output. The
 * program sets up a listener on port 50505. It can be contacted
 * by a Web browser running on the same machine using a URL of the
 * form http://localhost:505050/path/to/resource.html This method
 * does not return any data to the web browser. It simply reads the
 * request, writes it to standard output, and then closes the connection.
 * The program continues to run, and the server continues to listen
 * for new connections, until the program is terminated (by clicking the
 * red "stop" square in Eclipse or by Control-C on the command line).
 */
public class ReadRequest {

	/**
	 * The server listens on this port. Note that the port number must
	 * be greater than 1024 and lest than 65535.
	 */
	private final static int LISTENING_PORT = 50505;

	private final static String ROOT_DIRECTORY = "/Users/kento/Documents/github/UoPeople";

	/**
	 * Main program opens a server socket and listens for connection
	 * requests. It calls the handleConnection() method to respond
	 * to connection requests. The program runs in an infinite loop,
	 * unless an error occurs.
	 * * @param args ignored
	 */
	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(LISTENING_PORT);
		} catch (Exception e) {
			System.out.println("Failed to create listening socket.");
			return;

			System.out.println("Listening on port " + LISTENING_PORT);

			while (true) {
				Socket connection = serverSocket.accept();
				System.out.println("\nConnection from "
						+ connection.getRemoteSocketAddress());
				// ! handleConnection(connection);
				ConnectionThread thread = new ConnectionThread(connection);
				thread.start();
			}
		} catch (Exception e) {
			System.out.println("Server socket shut down unexpectedly!");
			System.out.println("Error: " + e);
			System.out.println("Exiting.");
		}
	}

	/**
	 * Handle commuincation with one client connection. This method reads
	 * lines of text from the client and prints them to standard output.
	 * 
	 * It continues to read until the client closes the connection or
	 * il an error occurs or until a blank line is read. In a connection
	 * from a Web browser, the first blank line marks the end of the request.
	 * This method can run indefinitely, waiting for the client to send a
	 * blank line.
	 * NOTE: This method does not throw any exceptions. Exceptions are
	 * caught and handled in the method, so that they will not shut down
	 * the ever.
	 * 
	 * @param connection the connected socket that will be used to
	 *                   communicate with the client.
	 */
	private static void handleConnection(Socket connection) {
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		PrintWriter out = new PrintWriter(connection.getOutputStream(), true);

		try {
			// Scanner in = new Scanner(connection.getInputStream());
			// while (true) {
			// if ( ! in.hasNextLine() )
			// break;
			// String line = in.nextLine();
			// if (line.trim().length() == 0)
			// break;
			// System.out.println(" " + line);
			// }

			// Read the request
			String requestLine = in.readLine();
			if (requestLine == null) {
				return;
			}

			String[] requestParts = requestLine.split(" ");
			if (requestParts.length != 3) {
				sendErrorResponse(400, out);
				return;
			}

			String method = requestParts[0];
			String path = requestParts[1];
			String protocol = requestParts[2];

			if (!method.equals("GET")) {
				sendErrorResponse(501, out);
				return;
			}

			// Construct the file path
			String filePath = ROOT_DIRECTORY + path;

			// Check if the file exists and is readable
			File file = new File(filePath);
			if (!file.exists() || !file.canRead()) {
				sendErrorResponse(404, out);
				return;
			}

			// Send the file in the response
			sendFile(file, out);
		} catch (Exception e) {
			System.out.println("Error while communicating with client: " + e);
		} finally { // make SURE connection is closed before returning!
			try {
				// ! connection.close();
				in.close();
				out.close();
			} catch (Exception e) {
			}
			System.out.println("Connection closed.");
		}
	}

	private static void sendFile(File file, OutputStream socketOut) throws IOException {
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		OutputStream out = new BufferedOutputStream(socketOut);
		while (true) {
			int x = in.read(); // read one byte from file
			if (x < 0)
				break; // end of file reached
			out.write(x); // write the byte to the socket
		}
		out.flush();
		in.close();
	}

	private static void sendErrorResponse(int code, PrintWriter out) {
		String status;
		String html;

		switch (code) {
			case 400:
				status = "Bad Request";
				html = "<html><body><h1>400 Bad Request</h1></body></html>";
				break;
			case 404:
				status = "Not Found";
				html = "<html><body><h1>404 Not Found</h1></body></html>";
				break;
			case 501:
				status = "Not Implemented";
				html = "<html><body><h1>501 Not Implemented</h1></body></html>";
				break;
			default:
				status = "Internal Server Error";
				html = "<html><body><h1>500 Internal Server Error</h1></body></html>";
		}

		out.println("HTTP/1.1 " + code + " " + status);
		out.println("Connection: close");
		out.println("Content-Type: text/html");
		out.println("Content-Length: " + html.length());
		out.println();
		out.println(html);
	}

	private static String getMimeType(String fileName) {
		int pos = fileName.lastIndexOf('.');
		if (pos < 0) // no file extension in name
			return "x-application/x-unknown";
		String ext = fileName.substring(pos + 1).toLowerCase();
		if (ext.equals("txt"))
			return "text/plain";
		else if (ext.equals("html"))
			return "text/html";
		else if (ext.equals("htm"))
			return "text/html";
		else if (ext.equals("css"))
			return "text/css";
		else if (ext.equals("js"))
			return "text/javascript";
		else if (ext.equals("java"))
			return "text/x-java";
		else if (ext.equals("jpeg"))
			return "image/jpeg";
		else if (ext.equals("jpg"))
			return "image/jpeg";
		else if (ext.equals("png"))
			return "image/png";
		else if (ext.equals("gif"))
			return "image/gif";
		else if (ext.equals("ico"))
			return "image/x-icon";
		else if (ext.equals("class"))
			return "application/java-vm";
		else if (ext.equals("jar"))
			return "application/java-archive";
		else if (ext.equals("zip"))
			return "application/zip";
		else if (ext.equals("xml"))
			return "application/xml";
		else if (ext.equals("xhtml"))
			return "application/xhtml+xml";
		else
			return "x-application/x-unknown";
		// Note: x-application/x-unknown is something made up;
		// it will probably make the browser offer to save the file.
	}

	private static class ConnectionThread extends Thread {
		private Socket connection;

		ConnectionThread(Socket connection) {
			this.connection = connection;
		}

		public void run() {
			try {
				handleConnection(connection);
			} catch (Exception e) {
				System.out.println("Error handling connection: " + e);
			} finally {
				try {
					connection.close();
				} catch (Exception e) {
					System.out.println("Error closing connection: " + e);
				}
			}
		}
	}

}