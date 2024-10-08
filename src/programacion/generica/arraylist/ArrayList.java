package programacion.generica.arraylist;

public class ArrayList {

    private int i = 0;
    private Object [] datosElemento;

    public ArrayList(int z) {
        datosElemento = new Object[z];
    }

    public Object get(int i) {
        return datosElemento[i];
    }

    public void add (Object o) {
        datosElemento[i] = o;
        i++;
    }
}
