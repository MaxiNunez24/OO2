# Ejercicio 1 SingleThreadTCPFramework


## Tareas:
Refactorizar el método SingleThreadTCPFramework::handleClient(Socket) para convertirlo en un Template Method. Este método debe incluir métodos hook opcionales, es decir, métodos hooks que pueden ser implementados por las subclases o no.

Estado previo:
```java
    private final void handleClient(Socket clientSocket) {
        
        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received message: " + inputLine + " from "
                        + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());
                
                if (inputLine.equalsIgnoreCase("")) {
                    break; // Client requested to close the connection
                }
                handleMessage(inputLine, out);
            }
            System.out.println("Connection closed with " + clientSocket.getInetAddress().getHostAddress() + ":"
                    + clientSocket.getPort());
        } catch (IOException e) {
            System.err.println("Problem with communication with client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing socket: " + e.getMessage());
            }
        }
    }
```

Se desea aplicar Template Method:
Operaciones encontradas:
- Creación de Streams (esqueleto)
- loop
    - informar mensaje recibido (futuro hook)
        - con ip y puerto (código repetido -> Extract Method)
    - condición de cierre (frozen spot -> futuro cambio)
    - manejar mensaje (primitiva / hot spot)
- informar conexión cerrada (futuro hook)
  - con ip y puerto (código repetido -> Extract Method)
- cerrar conexión (esqueleto -> se puede extraer)

```java
    
    private String ipAndPort(Socket clientSocket) {
        return clientSocket.getInetAddress().getHostAddress() + ":"
                + clientSocket.getPort();
    }
    
    protected void logRecepcion(String msg, Socket client) {
        System.out.println("Received message: " + msg + " from " + ipAndPort(client));
    }
    
    protected void logCierre(Socket client) {
        System.out.println("Connection closed with " + ipAndPort(client));
    } 
    
    private void closeConection(Socket client) {
        try {
            client.close();
        } catch (IOException e) {
            System.err.println("Error closing socket: " + e.getMessage());
        }
    }
    
    private final void handleClient(Socket clientSocket) {
        
        try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                
                logRecepcion(inputLine, clientSocket);
                
                if (inputLine.equalsIgnoreCase("")) {
                    break; // Client requested to close the connection
                }
                
                handleMessage(inputLine, out);
            }
            logCierre(clientSocket);
        } catch (IOException e) {
            System.err.println("Problem with communication with client: " + e.getMessage());
        } finally {
            closeConection(clientSocket);
        }
    }
```


Extienda el framework para permitir que la “palabra” que produce el cierre de la sesión con un cliente sea configurable. Evalúe las siguientes cuatro alternativas e implemente la que considere más adecuada:
- Una variable en SingleThreadTCPServer que se configura desde el método main() de las subclases.
- Un método (hook) que retorna un booleano resultado de evaluar la condición.
- Un método (hook) que retorna un String que es la palabra de término de sesión.
- Una jerarquía de Strategies que implementan cada una de las condiciones de cierre de sesión.
Para ayudarlo en definir cuál sería la alternativa que considera más apropiada, puede usar los siguientes aspectos (pero no limitarse a):
- Esfuerzo de implementación dentro del framework
- Facilidad de uso para los programadores usuarios del framework
- Limitaciones de la solución; es decir, que tan flexible es la alternativa elegida, ¿que casos de uso permite abarcar y cuales no podría?

Implemente un servidor PasswordServer. Este servidor debe generar una password a partir de los tres argumentos que recibe en el mensaje enviado por el cliente.
Arg[0]: cadena de caracteres (letras) permitidas para utilizar en la password
Arg[1]: cadena de caracteres (números de 0 a 9) permitidos para utilizar en la password
Arg[2]: cadena de caracteres especiales permitidos para utilizar en la password
Las passwords deben ser generadas de forma aleatoria y complir con las 	siguientes reglas:
Tener una longitud de 8 caracteres
Contener letras, al menos un número y un solo carácter especial


## Dudas

Cómo funcionan y qué son los sockets? 
Es la forma en la que funciona el print y el input en los lenguajes el stream de in u out?


