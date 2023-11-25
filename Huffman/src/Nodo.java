public class Nodo
{
    private final int data;
    private Nodo hijoIzq;
    private Nodo hijoDer;
    private char caracter;
    private int ancho;
    private int altura;
    private int medio;

    Nodo(int data)
    {
        this.data = data;
        this.hijoIzq = null;
        this.hijoDer = null;
        this.ancho = 60;
        this.altura = 80;
        this.medio = 30;
    }

    Nodo(int data, char character)
    {
        this.data = data;
        this.caracter = character;
        this.hijoIzq = null;
        this.hijoDer = null;
        this.ancho = 60;
        this.altura = 80;
        this.medio = 30;
    }

    public int getData()
    {
        return this.data;
    }

    public Nodo getHijoIzq()
    {
        return this.hijoIzq;
    }

    public Nodo getHijoDer()
    {
        return this.hijoDer;
    }

    public char getCaracter()
    {
        return this.caracter;
    }

    public int getAncho()
    {
        return this.ancho;
    }

    public int getAltura()
    {
        return this.altura;
    }

    public int getMedio()
    {
        return this.medio;
    }

    public void setHijoIzq(Nodo node)
    {
        this.hijoIzq = node;
    }

    public void setHijoDer(Nodo node)
    {
        this.hijoDer = node;
    }

    public void setAncho(int ancho)
    {
        this.ancho = ancho;
    }

    public void setAltura(int altura)
    {
        this.altura = altura;
    }

    public void setMedio(int medio)
    {
        this.medio = medio;
    }
}