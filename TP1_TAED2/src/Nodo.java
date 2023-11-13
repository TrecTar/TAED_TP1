public class Nodo implements Comparable<Nodo>
{
    public int valor;
    public int peso;

    public int compareTo(Nodo node)
    {
        return peso - node.peso;
    }

    Nodo izq;
    Nodo der;
    Nodo pariente;

    Nodo(int v, int p, Nodo iz, Nodo de, Nodo par)
    {
        valor = v;
        peso = p;
        izq = iz;
        der = de;
        pariente = par;
    }
}