import java.util.Random;

public class AlgoritmoGenetico
{

    public static void main(String[] args)
    {
        int longitudCadena = 20;

        Random random = new Random();

        int[] cadenaPrincipal = generarCadenaAleatoria(longitudCadena, random);

        int iteracion = 1;

        while (!esCadenaOptima(cadenaPrincipal))
        {
            int fncActual = evaluarFuncion(cadenaPrincipal);

            System.out.println("Iteración " + iteracion + ": " + cadenaToString(cadenaPrincipal) + " - Fnc: " + fncActual);

            int[] nuevaCadena = generarCadenaAleatoria(longitudCadena, random);

            if (evaluarFuncion(nuevaCadena) > fncActual)
            {
                cadenaPrincipal = nuevaCadena;
            }

            iteracion++;
        }

        System.out.println("¡Solución óptima encontrada en la iteración " + (iteracion - 1) + "!");
        System.out.println("Cadena óptima final: " + cadenaToString(cadenaPrincipal));
    }

    private static int[] generarCadenaAleatoria(int longitud, Random random)
    {
        int[] cadena = new int[longitud];
        for (int i = 0; i < longitud; i++)
        {
            cadena[i] = random.nextInt(2);
        }
        return cadena;
    }

    private static int evaluarFuncion(int[] cadena)
    {
        int funcion = 0;
        for (int i = 0; i < cadena.length; i++)
        {
            funcion += cadena[i] * 2;
        }
        return funcion;
    }

    private static String cadenaToString(int[] cadena)
    {
        StringBuilder sb = new StringBuilder();
        for (int bit : cadena)
        {
            sb.append(bit);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private static boolean esCadenaOptima(int[] cadena)
    {
        for (int bit : cadena)
        {
            if (bit != 1)
            {
                return false;
            }
        }
        return true;
    }
}