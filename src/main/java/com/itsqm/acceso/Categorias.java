
package com.itsqm.acceso;

import com.itsqm.modelo.CBDD;
import java.sql.ResultSet;

public class Categorias {

    private int id;
    private String categoria;
    private String fecha;
    private CBDD cbdd;

    public Categorias() {
        cbdd = new CBDD();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean insertCategoria(String categoria, String fecha) {
        setCategoria(categoria);
        setFecha(fecha);
        String sql = "INSERT INTO `categorias`"
                + "(`categoria`, `fecha`) "
                + "VALUES ('" + getCategoria() + "',"
                + "'" + getFecha() + "')";
        boolean r = cbdd.ejecutar(sql);
        return r;
    }

    public boolean deleteCategoria(int id) {
        setId(id);
        String sql = "DELETE FROM `categorias` "
                + "WHERE `id` =" + getId();
        boolean r = cbdd.ejecutar(sql);
        return r;
    }

    public boolean updateCategorias(int id, String categoria, String fecha) {
        setId(id);
        setCategoria(categoria);
        setFecha(fecha);
        String sql = "update categorias set categoria = '" + getCategoria() + "',"
                + " fecha = '" + getFecha() + "' "
                + "where id = " + getId();
          
        return cbdd.ejecutar(sql);
    }

    public ResultSet selectCategorias(String buscar) {
//        String sql = "select * from categorias "
//                + "where categoria like '%" + buscar + "%'";
          String sql =  "select * from categorias"
                 + " order by id ASC ";
        return cbdd.consulta(sql);
    }
}
