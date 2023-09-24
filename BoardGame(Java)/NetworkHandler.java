package edu.wsu.se;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkHandler {

	boolean isServer = false;
	int port = 8080;
	String ip = "";
	int myNumber = 1;

	ServerSocket serverSoc = null;
	Server server = null;
	Client[] clients = null;

	public NetworkHandler(boolean isServer, String ip, int port) {
		this.isServer = isServer;
		this.ip = ip;
		this.port = port;

		if (isServer) {
			// setup server
			clients = new Client[3];
			// start server
			try {
				serverSoc = new ServerSocket(port);
			} catch (IOException e) {
				System.out.println("Failed to start server");
				e.printStackTrace();
				System.exit(0);
			}

			// wait for clients to connect
			for (int i = 0; i < 3; i++) {
				clients[i] = new Client(i + 2);
				clients[i].waitForConnection(serverSoc);
				// tell the client which player it is
				clients[i].writeUTF("" + (i + 2));
			}
		} else {
			// client setup
			server = new Server(ip, port);
			server.connectToServer();
			myNumber = Integer.parseInt(server.readUTF());
		}
	}

	public NetworkHandler(boolean isServer, int port) {
		this(isServer, "localhost", port);
	}

	public void waitForClientConnection(int playerNumber) {
		clients[playerNumber - 1] = new Client(playerNumber - 1);
		clients[playerNumber - 1].waitForConnection(serverSoc);
	}

	public String readFromServer() {
		return server.readUTF();
	}

	public String readFromClient(int i) {
		return clients[i].readUTF();
	}

	public void sendToServer(String s) {
		server.writeUTF(s);
	}

	public void broadcast(String s) {
		for (int i = 0; i < 3; i++) {
			clients[i].writeUTF(s);
		}
	}

	public void broadcastException(String s, int e) {
		for (int i = 0; i < 3; i++) {
			if (i != (e - 2))
				clients[i].writeUTF(s);
		}
	}

	public boolean isServer() {
		return isServer;
	}

	public int getMyNumber() {
		return myNumber;
	}

	public class Client {

		DataInputStream dis = null;
		DataOutputStream dos = null;

		Socket socket = null;

		int clientNumber = 0;

		public Client(int number) {
			clientNumber = number;
		}

		public void waitForConnection(ServerSocket soc) {
			try {
				System.out.println("Waiting For Client To Connect");
				socket = soc.accept();
				soc.setSoTimeout(1000 * 1000);
				dos = new DataOutputStream(socket.getOutputStream());
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				System.out.println("Client Failed To Connect");
				// gui prompt
				System.exit(0);
			}
		}

		public String readUTF() {
			String s = "";
			try {
				s = dis.readUTF();
			} catch (IOException e) {
				System.out.println("Failed to read message");
				System.exit(0);
			}
			return s;
		}

		public void writeUTF(String s) {
			try {
				dos.writeUTF(s);
			} catch (IOException e) {
				System.out.println("Failed to write message");
				// gui prompt
				System.exit(0);
			}
		}

		public int getClientNumber() {
			return clientNumber;
		}

	}

	public class Server {

		DataInputStream dis = null;
		DataOutputStream dos = null;

		Socket socket = null;

		String ip = "";
		int port = 8080;

		public Server(String ip, int port) {
			this.ip = ip;
			this.port = port;
		}

		public void connectToServer() {
			try {
				System.out.println("Trying to connect to server at " + ip + ":" + port);
				socket = new Socket(ip, port);
				socket.setSoTimeout(1000 * 1000);
				dos = new DataOutputStream(socket.getOutputStream());
				dis = new DataInputStream(socket.getInputStream());
				System.out.println("Connected To Server");
			} catch (IOException e) {
				System.out.println("Failed to connect to server");
				System.exit(0);
			}
		}

		public String readUTF() {
			String s = "";
			try {
				s = dis.readUTF();
			} catch (IOException e) {
				System.out.println("Failed to read message");
				System.exit(0);
			}
			return s;
		}

		public void writeUTF(String s) {
			try {
				dos.writeUTF(s);
			} catch (IOException e) {
				System.out.println("Failed to write message");
				System.exit(0);
			}
			System.out.println("message written");
		}
	}

}
