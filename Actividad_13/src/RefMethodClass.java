
import java.util.List;
public class RefMethodClass {

    private static List lista;
    static SortList ordenarLista= new SortList();

    public RefMethodClass(List lista){
        this.lista = lista;
    }
    public static List sortLen(){
        return ordenarLista.sortByLength();
    }
    public static List sortAlp(){
        return ordenarLista.sortByAlphabetical();
    }
}
