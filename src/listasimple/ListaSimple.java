package listasimple;

class Nodo {
    String dato;
    Nodo siguienteNodo;

    // Constructor
    public Nodo(String dato) {
        this.dato = dato;
        this.siguienteNodo = null;
    }
}

public class ListaSimple {
    private Nodo primerNodo;

    // Constructor
    public ListaSimple() {
        this.primerNodo = null;
    }

    // Método para buscar un nodo por su posición
    public Nodo buscarPorPosicion(int posicion) {
        Nodo actual = primerNodo;
        int contador = 0;

        while (actual != null && contador < posicion) {
            actual = actual.siguienteNodo;
            contador++;
        }

        return actual;
    }

    // Método para insertar un nuevo nodo antes del último
    public void insertarAntesUltimoNodo(String dato) {
    Nodo nuevoNodo = new Nodo(dato);

    if (primerNodo == null) {
        primerNodo = nuevoNodo;
    } else {
        Nodo actual = primerNodo;
        Nodo anterior = null;

        while (actual != null && actual.siguienteNodo != null) {
            anterior = actual;
            actual = actual.siguienteNodo;
        }

        if (anterior != null) {
            anterior.siguienteNodo = nuevoNodo;
            nuevoNodo.siguienteNodo = actual;
        } else {
            // Si anterior es null, significa que estamos insertando antes del primer nodo.
            nuevoNodo.siguienteNodo = primerNodo;
            primerNodo = nuevoNodo;
        }
    }
}


    // Método para intercambiar un nodo por otro buscado
    public void intercambiarNodos(String dato1, String dato2) {
        Nodo nodo1 = buscarNodoPorDato(dato1);
        Nodo nodo2 = buscarNodoPorDato(dato2);

        if (nodo1 != null && nodo2 != null) {
            String temp = nodo1.dato;
            nodo1.dato = nodo2.dato;
            nodo2.dato = temp;
        }
    }

    // Método auxiliar para buscar un nodo por su dato
    private Nodo buscarNodoPorDato(String dato) {
        Nodo actual = primerNodo;

        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return actual;
            }
            actual = actual.siguienteNodo;
        }

        return null;
    }

    // Método para imprimir la lista
    public void imprimir() {
        Nodo actual = primerNodo;

        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguienteNodo;
        }

        System.out.println(); // Nueva línea al final
    }

    // Método para obtener una representación de la lista como String
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        Nodo actual = primerNodo;

        while (actual != null) {
            resultado.append(actual.dato).append(" ");
            actual = actual.siguienteNodo;
        }

        return resultado.toString();
    }

    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        lista.insertarAntesUltimoNodo("H");
        lista.insertarAntesUltimoNodo("O");
        lista.insertarAntesUltimoNodo("Y");
        lista.insertarAntesUltimoNodo("R");
        lista.insertarAntesUltimoNodo("A");

        System.out.println("Lista completa:");
        lista.imprimir();

        System.out.println("Nodo en posición 2:");
        Nodo nodoEnPosicion2 = lista.buscarPorPosicion(2);
        if (nodoEnPosicion2 != null) {
            System.out.println(nodoEnPosicion2.dato);
        } else {
            System.out.println("Posición no válida");
        }

        System.out.println("Intercambiar nodos 'O' y 'R':");
        lista.intercambiarNodos("O", "R");
        lista.imprimir();
    }
}
