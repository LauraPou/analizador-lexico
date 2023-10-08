import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scanner {

    private static final Map<String, TipoToken> palabrasReservadas;
    private static final Map<String, TipoToken> oprelacionales;

    static {
        palabrasReservadas = new HashMap<>();
        palabrasReservadas.put("and", TipoToken.AND);
        palabrasReservadas.put("else", TipoToken.ELSE);
        palabrasReservadas.put("false", TipoToken.FALSE);
        palabrasReservadas.put("for", TipoToken.FOR);
        palabrasReservadas.put("fun", TipoToken.FUN);
        palabrasReservadas.put("if", TipoToken.IF);
        palabrasReservadas.put("null", TipoToken.NULL);
        palabrasReservadas.put("or", TipoToken.OR);
        palabrasReservadas.put("print", TipoToken.PRINT);
        palabrasReservadas.put("return", TipoToken.RETURN);
        palabrasReservadas.put("true", TipoToken.TRUE);
        palabrasReservadas.put("var", TipoToken.VAR);
        palabrasReservadas.put("while", TipoToken.WHILE);

        oprelacionales = new HashMap<>();
        oprelacionales.put("(", TipoToken.LEFT_PAREN);
        oprelacionales.put(")", TipoToken.RIGHT_PAREN);
        oprelacionales.put("{", TipoToken.LEFT_BRACE);
        oprelacionales.put("}", TipoToken.RIGHT_BRACE);
        oprelacionales.put(",", TipoToken.COMMA);
        oprelacionales.put(".", TipoToken.DOT);
        oprelacionales.put(";", TipoToken.SEMICOLON);
        oprelacionales.put("+", TipoToken.PLUS);
        oprelacionales.put("-", TipoToken.MINUS);
        oprelacionales.put("*", TipoToken.STAR);
        oprelacionales.put("[", TipoToken.LEFT_BRACKET);
        oprelacionales.put("]", TipoToken.RIGHT_BRACKET);
    }

    private final String source;

    private final List<Token> tokens = new ArrayList<>();

    List<String> se = Arrays.asList("(", ")", "{", "}", ",", ".", ";", "+", "-", ";", "[", "]", "*");

    public Scanner(String source) {
        this.source = source + " ";
    }

    public List<Token> scan() throws Exception {
        int estado = 0;
        String lexema = "";
        char c;

        for (int i = 0; i < source.length(); i++) {
            c = source.charAt(i);

            switch (estado) {
                case 0: // Estado inicial
                    if (Character.isLetter(c)) {
                        estado = 1;
                        lexema += c;
                    }

                    else if (Character.isDigit(c)) {
                        estado = 2;
                        lexema += c;
                    }

                    else if (c == '"') {
                        estado = 8;
                        lexema += c;
                    }

                    else if (c == '/') {
                        estado = 10;
                        lexema += c;
                    }

                    else if (se.contains(c + "")) {
                        estado = 14;
                        lexema += c;
                    }

                    else if (c == '<') {
                        estado = 15;
                        lexema += c;
                    }

                    else if (c == '>') {
                        estado = 16;
                        lexema += c;
                    }

                    else if (c == '=') {
                        estado = 17;
                        lexema += c;
                    }

                    else if (c == '!') {
                        estado = 18;
                        lexema += c;
                    }

                    break;
            }

        }

        return tokens;
    }
}
