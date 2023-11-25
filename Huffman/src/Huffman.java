import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Huffman
{
    private final LinkedHashMap mapa;
    private final List<Nodo> nodos;
    private final Map<Character, String> diccionario;
    private final String texto;
    private StringBuilder camino;
    private int tamanoComprimido;
    private int tamanoNoComprimido;
    private String textoComprimido;

    public Huffman(String text)
    {
        mapa = new LinkedHashMap();
        nodos = new ArrayList();
        diccionario = new HashMap();
        texto = text;

        for (char c: text.toCharArray())
        {
            if (mapa.containsKey(c))
            {
                mapa.put(c, ((int) mapa.get(c)) + 1);
            }
            else
            {
                mapa.put(c, 1);
            }
        }

        Iterator iterador = mapa.entrySet().iterator();

        while (iterador.hasNext())
        {
            Map.Entry entrada = (Map.Entry) iterador.next();
            nodos.add(new Nodo((int) entrada.getValue(), (char) entrada.getKey()));
        }

        crearArbol();
    }

    private void crearArbol()
    {
        while (nodos.size() != 1)
        {
            ordenar();

            Nodo nodo = new Nodo(nodos.get(0).getData() + nodos.get(1).getData());
            nodo.setAncho(nodos.get(0).getAncho() + nodos.get(1).getAncho() + 60);
            nodo.setAltura(Math.max(nodos.get(0).getAltura(), nodos.get(1).getAltura()) + 80);
            nodo.setMedio(nodos.get(0).getAncho());
            nodo.setHijoIzq(nodos.get(0));
            nodo.setHijoDer(nodos.get(1));
            nodos.remove(0);
            nodos.remove(0);
            nodos.add(nodo);
        }
    }

    private void ordenar()
    {
        Collections.sort(nodos, new Comparator<Nodo>(){
            @Override
            public int compare(Nodo x, Nodo y)
            {
                return Integer.valueOf(x.getData()).compareTo(Integer.valueOf(y.getData()));
            }
        });
    }

    public void comprimir()
    {
        StringBuilder str = new StringBuilder();

        for (char c: texto.toCharArray())
        {
            camino = new StringBuilder();
            comprimir(c, nodos.get(0));
            str.append(camino);
            diccionario.put(c, camino.toString());
        }

        tamanoNoComprimido = texto.length() * 8;
        tamanoComprimido = str.length();
        textoComprimido = str.toString();
    }

    private boolean comprimir(char c, Nodo node)
    {
        if (node.getCaracter() == c)
        {
            return true;
        }

        if (node.getHijoIzq() != null)
        {
            camino.append('0');

            if (comprimir(c, node.getHijoIzq()))
            {
                return true;
            }

            camino.deleteCharAt(camino.length() - 1);
        }

        if (node.getHijoDer() != null)
        {
            camino.append('1');

            if (comprimir(c, node.getHijoDer()))
            {
                return true;
            }

            camino.deleteCharAt(camino.length() - 1);
        }

        return false;
    }

    public int getTamanoComprimido()
    {
        return tamanoComprimido;
    }

    public int getTamanoNoComprimido()
    {
        return tamanoNoComprimido;
    }

    public String getTextoComprimido()
    {
        return textoComprimido;
    }

    public Map<Character, String> getDiccionario()
    {
        return diccionario;
    }

    public Nodo getRoot() { return nodos.get(0); }
}
