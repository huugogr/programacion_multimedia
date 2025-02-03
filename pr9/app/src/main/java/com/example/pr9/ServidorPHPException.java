<<<<<<< HEAD
package com.example.practica9;
=======
package com.example.pr9;
>>>>>>> 1ae5ced8c3868cbe34c4226feee37bcebe1bb993

/**
 * Esta clase representa una excepción en el uso del acceso a un servidor remoto
 */

@SuppressWarnings("serial")
public class ServidorPHPException extends Exception
{
    /**
     * Constructor de la clase
     * @param message Mensaje
     */
    public ServidorPHPException(String message)
    {
        super(message);
    }
}
