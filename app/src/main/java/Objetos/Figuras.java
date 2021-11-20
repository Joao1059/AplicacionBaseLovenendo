package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Figuras {

    private  int id;
    private String[] figuras = {"SELECCIONE","Nendo Miss Fortune","Nendo Zero Two","Nendo Kirby","Nendo Yoh Asakura"};
    private int[] precios = {90000,68000,70000,69000};
    private int [] envio = {9000};
    private int stock;

    public Figuras() {}

    public Figuras(int id, String[] figuras, int[] precios, int[] envio, int stock) {
        this.id = id;
        this.figuras = figuras;
        this.precios = precios;
        this.envio = envio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getFiguras() {
        return figuras;
    }

    public void setFiguras(String[] figuras) {
        this.figuras = figuras;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int[] getEnvio() {
        return envio;
    }

    public void setEnvio(int[] envio) {
        this.envio = envio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figuras figuras1 = (Figuras) o;
        return id == figuras1.id && stock == figuras1.stock && Arrays.equals(figuras, figuras1.figuras) && Arrays.equals(precios, figuras1.precios) && Arrays.equals(envio, figuras1.envio);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, stock);
        result = 31 * result + Arrays.hashCode(figuras);
        result = 31 * result + Arrays.hashCode(precios);
        result = 31 * result + Arrays.hashCode(envio);
        return result;
    }

    @Override
    public String toString() {
        return "Figuras{" +
                "id=" + id +
                ", figuras=" + Arrays.toString(figuras) +
                ", precios=" + Arrays.toString(precios) +
                ", envio=" + Arrays.toString(envio) +
                ", stock=" + stock +
                '}';
    }

    public int anadirAdicional(int valor, int adicional)
    {
        return valor + adicional;

    }


}
