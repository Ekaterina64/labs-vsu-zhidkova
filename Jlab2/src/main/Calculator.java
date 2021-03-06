import java.util.HashMap;
/**
 * Калькулятор разработан с помощью рекурсивного парсера.
 * Рекурсия осуществляется на основе приоритета математических операций.
 * */
public class Calculator {
    private final HashMap<String, Double> variables;

    public Calculator(double val)
    {
        variables = new HashMap<String, Double>();
        variables.put("X", val);

    }

    public Double getVariable(String variableName)
    {
        if (!variables.containsKey(variableName)) {
            System.err.println( "Error: Try get unexists variable '"+variableName+"'" );
            return 0.0;
        }
        return variables.get(variableName);
    }

    public double Parse(String s) throws Exception
    {
        RestOfParse result = PlusMinus(s);
        if (!result.rest.isEmpty()) {
            System.err.println("Error: can't full parse");
            System.err.println("rest: " + result.rest);
        }
        return result.acc;
    }

    private RestOfParse PlusMinus(String s) throws Exception
    {
        RestOfParse current = MulDiv(s);
        double acc = current.acc;

        while (current.rest.length() > 0) {
            if (!(current.rest.charAt(0) == '+' || current.rest.charAt(0) == '-')) break;

            char sign = current.rest.charAt(0);
            String next = current.rest.substring(1);

            current = MulDiv(next);
            if (sign == '+') {
                acc += current.acc;
            } else {
                acc -= current.acc;
            }
        }
        return new RestOfParse(acc, current.rest);
    }

    private RestOfParse Bracket(String s) throws Exception
    {
        char zeroChar = s.charAt(0);
        if (zeroChar == '(') {
            RestOfParse r = PlusMinus(s.substring(1));
            if (!r.rest.isEmpty() && r.rest.charAt(0) == ')') {
                r.rest = r.rest.substring(1);
            } else {
                System.err.println("Error: not close bracket");
            }
            return r;
        }
        return FunctionVariable(s);
    }

    private RestOfParse FunctionVariable(String s) throws Exception
    {
        String f = "";
        int i = 0;
        // ищем название функции или переменной
        // имя обязательно должно начинаться с буквы
        while (i < s.length() && (Character.isLetter(s.charAt(i)) || ( Character.isDigit(s.charAt(i)) && i > 0 ) )) {
            f += s.charAt(i);
            i++;
        }
        if (!f.isEmpty()) { // если что-нибудь нашли
            if ( s.length() > i && s.charAt( i ) == '(') { // и следующий символ скобка значит - это функция
                RestOfParse r = Bracket(s.substring(f.length()));
                return processFunction(f, r);
            } else { // иначе - это переменная
                return new RestOfParse(getVariable(f), s.substring(f.length()));
            }
        }
        return Num(s);
    }

    private RestOfParse MulDiv(String s) throws Exception
    {
        RestOfParse current = Bracket(s);

        double acc = current.acc;
        while (true) {
            if (current.rest.length() == 0) {
                return current;
            }
            char sign = current.rest.charAt(0);
            if ((sign != '*' && sign != '/')) return current;

            String next = current.rest.substring(1);
            RestOfParse right = Bracket(next);

            if (sign == '*') {
                acc *= right.acc;
            } else {
                acc /= right.acc;
            }

            current = new RestOfParse(acc, right.rest);
        }
    }

    private RestOfParse Num(String s) throws Exception
    {
        int i = 0;
        int dot_cnt = 0;
        boolean negative = false;
        // число также может начинаться с минуса
        if( s.charAt(0) == '-' ){
            negative = true;
            s = s.substring( 1 );
        }
        // разрешаем только цифры и точку
        while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
            // но также проверям, что в числе может быть только одна точка!
            if (s.charAt(i) == '.' && ++dot_cnt > 1) {
                throw new Exception("not valid number '" + s.substring(0, i + 1) + "'");
            }
            i++;
        }
        if( i == 0 ){ // что-либо похожее на число мы не нашли
            throw new Exception( "can't get valid number in '" + s + "'" );
        }

        double dPart = Double.parseDouble(s.substring(0, i));
        if( negative ) dPart = -dPart;
        String restPart = s.substring(i);

        return new RestOfParse(dPart, restPart);
    }

    // Тут определяем все нашие функции, которыми мы можем пользоватся в формулах
    private RestOfParse processFunction(String func, RestOfParse r)
    {
        if (func.equals("sin")) {
            return new RestOfParse(Math.sin(Math.toRadians(r.acc)), r.rest);
        } else if (func.equals("cos")) {
            return new RestOfParse(Math.cos(Math.toRadians(r.acc)), r.rest);
        } else if (func.equals("exp")) {
            return new RestOfParse(Math.exp(r.acc), r.rest);
        } else if (func.equals("abs")) {
            return new RestOfParse(Math.abs(r.acc), r.rest);
        } else {
            System.err.println("function '" + func + "' is not defined");
        }
        return r;
    }
}