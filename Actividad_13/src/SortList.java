import java.util.*;
public class SortList {

    //Declarar lista
    static List <String> list = new ArrayList<String>();

    //Clase principal
    public static void main(String[] arg) {

        System.out.println(
                "\n\n•.,¸,.•*`•.,¸¸,.•*¯ ╭━━━━━━━━━━╮\n" +
                "•.,¸,.•*¯`•.,¸,.•*¯.|::::::/___/\n" +
                "•.,¸,.•*¯`•.,¸,.•* <|:::::(｡ ●ω●｡)\n" +
                "•.,¸,.•¯•.,¸,.•╰ * >し------し---Ｊ");
        //Agregar datos a la lista
        listItems();
        //Convertir Strings en minúsculas para ordenar
        lowerCase();
        //Llamar método anónimo
        anonMethod();
        //Llamar método lambda
        lambdaMethod();
        //Llamar método de referencia
        metodoRef();
    }

    //Método ordenamiento clase anonima
    //Se declara la interfaz para implementar sus métodos
    //y ordenar por longitud y alfabeticamente
    private static void anonMethod(){
        System.out.println("---------CLASE ANÓNIMA ʚ(｡˃ ᵕ ˂ )ɞ---------");

        AnonInterface anonInterface= new AnonInterface() {
            @Override
            public void sortLength() {
                sortByLength();
            }

            @Override
            public void sortAlphabetical() {
                sortByAlphabetical();
            }
        };

        message(0);
        anonInterface.sortLength();
        output();

        message(1);
        anonInterface.sortAlphabetical();
        output();
    }

    //Método ordenamiento expresión lambda
    //que implementa su interfaz de su único método abstracto
    // a implementar que es para ordenar la lista
    private static void lambdaMethod(){
        System.out.println("---------EXPRESIÓN LAMBDA (๑ᵔ⤙ᵔ๑).---------");

        message(0);
        LambdaInterface lambdaInterface= () -> sortByLength();
        lambdaInterface.ordenamiento();
        output();

        message(1);
        list.stream().sorted().forEach(s -> System.out.println(s));

    }

    //Método de referencia
    //se hace referencia de un método de clase
    //como método de referencia
    private static void metodoRef(){
        RefMethodInterface refMethodInterface;
        System.out.println("---------MÉTODO DE REFERENCIA ฅ^•ﻌ•^ฅ---------");

        message(0);
        refMethodInterface= RefMethodClass::sortLen;
        refMethodInterface.ordenamiento();
        output();

        message(1);
        refMethodInterface= RefMethodClass::sortAlp;
        refMethodInterface.ordenamiento();
        output();
    }

    //************************************************************************

    //Método que agraga
    //cadenas de texto a la lista
    private static void listItems(){
        list.add("Hola");
        list.add("Me");
        list.add("Gusta");
        list.add("el");
        list.add("chocolate");
        list.add("Y");
        list.add("los");
        list.add("perritos");
        list.add("X");
        list.add("D");
    }

    //Método que convierte
    //la cadena de texto en minúscula
    //para poder ordenar alfabeticamente
    private static void lowerCase(){
        for(int i=0; i<list.size(); i++){
            list.set(i,list.get(i).toLowerCase());
        }
    }

    //Método de ordenamiento alfabético
    //usando el método sort
    public static List sortByAlphabetical(){
        Collections.sort(list);
        return list;
    }

    //Método de ordenamiento por longitud
    //haciendo uso de una clase anónima
    //haciendo uso de la interfaz Comparator
    public static List<String> sortByLength(){
        Collections.sort(list, new Comparator<String>(){

            public int compare(String arg0, String arg1)  {
                int larg0 = arg0.length();
                int larg1 = arg1.length();

                return larg0 < larg1 ? -1 : larg0 > larg1 ? 1 : 0;
            }});
        return list;
    }

    //Método que itera lista
    //y la imprime
    private static void output(){
        for (Object o : list) {
            System.out.println(o);
        }
    }

    //Método que imprime en pantalla
    //el mensaje correspondiente
    private static void message(int i){
        if(i==0){
            System.out.println("Ordenar longitud:");
        }else{
            System.out.println("\nOrdenar orden alfabético:");
        }
    }
}
