# Socket Client and Server Project

A small multi-client chat over TCP sockets in Java. The server listens on port 1357 and starts a thread for every client that connects. Each message a client sends is relayed to all the other connected clients, and the server announces when someone joins or leaves.

## Project structure

| File | What it does |
| --- | --- |
| `src/Server.java` | Listens on port 1357 and hands each new connection to a `ClientHandler` thread. |
| `src/ClientHandler.java` | Reads the client's username, then relays each of its messages to every other client. |
| `src/Client.java` | Asks for a username, connects to `localhost:1357`, prints incoming messages and sends what you type. |

## Running it

You need a JDK (Java 8 or newer; CI builds with Java 17). From the repository root, compile everything into `out/`:

```sh
javac -d out src/*.java
```

Start the server in one terminal:

```sh
java -cp out Server
```

Then start a client in each additional terminal:

```sh
java -cp out Client
```

Enter a username when prompted, then type a message and press Enter. Every other connected client sees it as `username: message`.

## License

MIT. See [LICENSE](LICENSE).
