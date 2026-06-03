package net.salesianos;

public class Pedido {

    private String codigo;
    private String cliente;
    private String producto;
    private boolean paraLlevar;

    public Pedido(String codigo, String cliente, String producto, boolean paraLlevar) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.producto = producto;
        this.paraLlevar = paraLlevar;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public boolean isParaLlevar() {
        return paraLlevar;
    }

    public void setParaLlevar(boolean paraLlevar) {
        this.paraLlevar = paraLlevar;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo='" + codigo + '\'' +
                ", cliente='" + cliente + '\'' +
                ", producto='" + producto + '\'' +
                ", paraLlevar=" + paraLlevar +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Pedido))
            return false;
        Pedido pedido = (Pedido) obj;
        return this.codigo.equals(pedido.getCodigo());
    }
}