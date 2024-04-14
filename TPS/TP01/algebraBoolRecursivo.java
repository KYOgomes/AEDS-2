import java.io.*;

public class algebraBoolRecursivo {
    public static void main(String[] args) {
        boolean notFim;
        int quantNumeros;
        String entradaString = new String();
        int tam;
        char[] entradaChar = new char[1000];

        do {
            quantNumeros = MyIO.readInt();
            notFim = notFim(quantNumeros);
            if (notFim) {
                String[] listaValores = lerValores(quantNumeros);
                entradaString = MyIO.readLine();
                str2char(entradaString, entradaChar);
                tam = entradaString.length();
                tam = removerEspacos(entradaChar, tam);
                trocar(entradaChar, listaValores, tam);
                char resp = algebraBooleana(entradaChar, 0, tam - 1);
                MyIO.println(resp);
            }
        } while (notFim);
    }

    // Verifica se a palavra inserida pelo usuario eh igual a FIM. Se for diferente, retorna True
    public static boolean notFim(int quantNumeros) {
        return quantNumeros != 0;
    }

    // Converte de String para array de caracteres
    public static void str2char(String entradaString, char[] entradaChar) {
        for (int i = 0; i < entradaString.length(); i++) {
            entradaChar[i] = entradaString.charAt(i);
        }
    }

    public static int removerEspacos(char[] entradaChar, int tam) {
        for (int i = 0; i < tam; i++) {
            if (entradaChar[i] == ' ' || entradaChar[i] == ',') {
                for (int j = i; j < tam - 1; j++) {
                    entradaChar[j] = entradaChar[j + 1];
                }
                i--;
                entradaChar[tam] = '\0';
                tam--;
            }
        }
        return tam;
    }

    // Troca as letras pelos valores binarios
    public static void trocar(char[] entradaChar, String[] listaValores, int tam) {
        int index = 0;
        for (int i = 0; i < listaValores.length; i++) {
            for (int j = 0; j < tam; j++) {
                if ((int) entradaChar[j] == index + 65) {
                    entradaChar[j] = (char) listaValores[index].charAt(0);
                }
            }
            index++;
        }
    }

    // Le os valores binarios que sao apresentados na entrada
    public static String[] lerValores(int quantValores) {
        String[] listaValores = new String[quantValores];
        for (int i = 0; i < quantValores; i++) {
            listaValores[i] = MyIO.readString();
        }
        return listaValores;
    }

    // Método booleano not
    public static char not(char valor) {
        return valor == '0' ? '1' : '0';
    }

    // Método booleano and
    public static char and(char[] valores, int inicio, int fim) {
        for (int i = inicio; i <= fim; i++) {
            if (valores[i] == '0') {
                return '0';
            }
        }
        return '1';
    }

    // Método booleano or
    public static char or(char[] valores, int inicio, int fim) {
        for (int i = inicio; i <= fim; i++) {
            if (valores[i] == '1') {
                return '1';
            }
        }
        return '0';
    }

    // Método principal que resolve a expressão booleana
    public static char algebraBooleana(char[] entradaChar, int inicio, int fim) {
        // Se a expressão tem apenas um caractere, retornamos esse caractere
        if (inicio == fim) {
            return entradaChar[inicio];
        }

        // Contadores para parênteses
        int contadorParenteses = 0;
        int index = -1;

        // Procurando parênteses
        for (int i = inicio; i <= fim; i++) {
            if (entradaChar[i] == '(') {
                contadorParenteses++;
            } else if (entradaChar[i] == ')') {
                contadorParenteses--;
            } else if (contadorParenteses == 0 && (entradaChar[i] == 't' || entradaChar[i] == 'd' || entradaChar[i] == 'r')) {
                index = i;
                break;
            }
        }

        // Se não encontrarmos nenhum operador fora de parênteses, retornamos o valor dentro dos parênteses
        if (index == -1) {
            return algebraBooleana(entradaChar, inicio + 1, fim - 1);
        }

        // Chamando recursivamente para os operandos e operador
        char operador = entradaChar[index];
        if (operador == 't') {
            char operando = algebraBooleana(entradaChar, index + 1, fim);
            return not(operando);
        } else {
            int inicioOperando1 = index + 2;
            int fimOperando1 = -1;
            int inicioOperando2 = -1;
            int fimOperando2 = -1;

            for (int i = index + 2; i <= fim; i++) {
                if (entradaChar[i] == '(') {
                    contadorParenteses++;
                } else if (entradaChar[i] == ')') {
                    contadorParenteses--;
                } else if (contadorParenteses == 0 && (entradaChar[i] == 't' || entradaChar[i] == 'd' || entradaChar[i] == 'r')) {
                    if (inicioOperando2 == -1) {
                        inicioOperando2 = i;
                    } else {
                        fimOperando2 = i - 1;
                        break;
                    }
                } else if (contadorParenteses == 0 && (entradaChar[i] == ',' || entradaChar[i] == ')')) {
                    if (fimOperando1 == -1) {
                        fimOperando1 = i - 1;
                    }
                }
            }

            if (fimOperando2 == -1) {
                fimOperando2 = fim - 1;
            }

            if (operador == 'd') {
                char resultado1 = algebraBooleana(entradaChar, inicioOperando1, fimOperando1);
                char resultado2 = algebraBooleana(entradaChar, inicioOperando2, fimOperando2);
                return and(entradaChar, resultado1, resultado2);
            } else if (operador == 'r') {
                char resultado1 = algebraBooleana(entradaChar, inicioOperando1, fimOperando1);
                char resultado2 = algebraBooleana(entradaChar, inicioOperando2, fimOperando2);
                return or(entradaChar, resultado1, resultado2);
            }
        }
        return ' '; // Só para
    }
}
