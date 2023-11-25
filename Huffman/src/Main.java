import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("\nIngrese el texto a comprimir: ");
        Scanner entrada = new Scanner(System.in);
        String texto = entrada.nextLine();
        Huffman ejemplo = new Huffman(texto);

        ejemplo.comprimir();

        System.out.println("========================================================================================================================");

        System.out.println("Tamaño Antes de la Compresión: " + ejemplo.getTamanoNoComprimido());
        System.out.println("Tamaño Despues de la Compresión: " + ejemplo.getTamanoComprimido());
        System.out.println("Texto Original: " + texto);
        System.out.println("Texto Comprimido: " + ejemplo.getTextoComprimido());

        System.out.println("========================================================================================================================");
    }
}
