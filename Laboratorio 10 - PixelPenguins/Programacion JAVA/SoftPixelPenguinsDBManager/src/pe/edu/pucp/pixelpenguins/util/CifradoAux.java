
package pe.edu.pucp.pixelpenguins.util;

public class CifradoAux {
    // Método para cifrar el texto
    public static String cifrar(String texto, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            
            // Verifica si el caracter es una letra mayúscula
            if (Character.isUpperCase(caracter)) {
                char cifrado = (char) (((int) caracter + desplazamiento - 65) % 26 + 65);
                resultado.append(cifrado);
            } 
            // Verifica si el caracter es una letra minúscula
            else if (Character.isLowerCase(caracter)) {
                char cifrado = (char) (((int) caracter + desplazamiento - 97) % 26 + 97);
                resultado.append(cifrado);
            } 
            // Verifica si el caracter es un número
            else if (Character.isDigit(caracter)) {
                char cifrado = (char) (((int) caracter + desplazamiento - 48) % 10 + 48);
                resultado.append(cifrado);
            }
            // Si no es letra, deja el caracter igual
            else {
                resultado.append(caracter);
            }
        }
        return resultado.toString();
    }
    
    // Método para descifrar el texto
    public static String descifrar(String texto, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            
            // Verifica si el caracter es una letra mayúscula
            if (Character.isUpperCase(caracter)) {
                char descifrado = (char) (((int) caracter - desplazamiento - 65 + 26) % 26 + 65);
                resultado.append(descifrado);
            } 
            // Verifica si el caracter es una letra minúscula
            else if (Character.isLowerCase(caracter)) {
                char descifrado = (char) (((int) caracter - desplazamiento - 97 + 26) % 26 + 97);
                resultado.append(descifrado);
            }
            // Verifica si el caracter es un número
            else if (Character.isDigit(caracter)) {
                char descifrado = (char) (((int) caracter - desplazamiento - 48 + 10) % 10 + 48);  // Ajuste para los números
                resultado.append(descifrado);
            }
            // Si no es ni letra ni número, deja el caracter igual
            else {
                resultado.append(caracter);
            }
        }
        return resultado.toString();
    }
}
