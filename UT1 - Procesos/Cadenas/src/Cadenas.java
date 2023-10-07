import java.util.Random;

/**
 * Genera cadenas formadas por caracteres del alfabeto, con una longitud aleatoria de 20 caracteres como máximo.
 * La cantidad de cadenas será indicada por el usuario al ejecutar la aplicación.
 * Las cadenas se deben escribir en la salida estándar.
 * 
 * @version 1.0
 */
public class Cadenas
{
    /**
     * Implementa la funcionalidad principal de la clase.
     * @param args Argumentos de línea de comandos (debe contener el número de cadenas a generar).
     */
    public static void main(String[] args)
    {
        int cantCadenas;    // Cantidad de cadenas a generar
        int longCadena;     // Longitud de cada una de las cadenas
        String cadena;

        try
        {
            // Comprobar que solo se ha indicado como parámetro el número
            // de cadenas a generar, y que es un valor positivo.
            if (args.length != 1)
                throw new Exception("Parámetros incorrectos: Se debe indicar el número de cadenas a generar.");

            // Comprobar si alguno de los caracteres del primer parámetro no es numérico
            for (int i=0; i<args[0].length(); i++)
            {
                if (!Character.isDigit(args[0].charAt(i)))
                    throw new Exception("El número de cadenas a generar debe ser un valor numérico positivo.");                
            }

            // La cantidad de cadenas que se ha indicado es valor numérico.
            cantCadenas = Integer.parseInt(args[0]);

            // Comprobar que es mayor que cero.
            if (cantCadenas <= 0)
                throw new Exception("El número de cadenas a generar debe ser un valor numérico positivo."); 

            
            // Generar tantas cadenas como se haya indicado
            for (int c=0; c<cantCadenas; c++)
            {
                // La longitud de la cadena será un número aleatorio entre 1 y 20
                // Se genera un número aleatorio entre 0-19, y se le suma 1.
                longCadena = (new Random().nextInt(20)) + 1;

                // Inicializar la nueva cadena
                cadena = "";

                // Generar el número de letras que indique la longitud de la cadena 
                for (int i=0; i<longCadena; i++)
                {
                    // Añadir a la cadena una nueva letra.
                    cadena += generarLetra();
                }

                // Mostrar la cadena generada
                System.out.println(cadena);            
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }    
    }
    
    /**
     * Genera de forma aleatoria un carácter del alfabeto, en mayúscula o minúscula.
     * @return Carácter del alfabeto.
     */
    private static char generarLetra()
    {
        int randomNum;  // Número aleatorio, para obtener el código ASCII
        int codASCII;   // Código ASCII del carácter a generar
        char letra;
        
        
        // En la tabla ASCII estándar hay 26 letras minúsculas y 26 mayúsculas.
        // Tenemos 52 opciones posibles. Se generará un número entre 0-51.
        randomNum = new Random().nextInt(52);

        // Los primeros 26 números, corresponderán a las mayúsculas,
        // con caracteres ASCII entre el 65-90, así que le sumaremos 65.
        if (randomNum < 26)
        {
            codASCII = randomNum + 65;
        }
        else
        {
            // Los siguientes números (26 al 51), corresponderán a las minúsculas,
            // con caracteres ASCII entre el 97-122, así que le sumaremos 71.
            codASCII = randomNum + 71;
        }
        
        // La letra será la correspondiente al código ASCII que se ha calculado,
        // para ello basta con hacer un casting.
        letra = (char)codASCII;
        
        return letra;
    }
    
}
