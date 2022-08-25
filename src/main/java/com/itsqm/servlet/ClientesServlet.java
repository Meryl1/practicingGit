package com.itsqm.servlet;

import com.itsqm.acceso.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClientesS", urlPatterns = "/ClientesS")
public class ClientesServlet extends HttpServlet {

    // Polimorfismo
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menu = request.getParameter("crud");
        if (menu.equals("select")) {

            //Read
            selectClientes(request, response);
        } else if (menu.equals("update")) {
            //Update
            updateClientes(request, response);
        } else if (menu.equals("insert")) {
            // Insert
            insertClientes(request, response);
        } else if (menu.equals("delete")) {
            // Delete
            deleteClientes(request, response);
        }

    }
    //Delete

    private void deleteClientes(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html"); // este formato me permite escribir dentto del html
            PrintWriter pw = response.getWriter();
            int id = Integer.parseInt(request.getParameter("txtId"));
            Clientes cli = new Clientes();
            boolean resp = cli.deleteClientes(id);
            pw.println("<h1> Respuesta: </h1>" + resp);  //escribir en el navegador el resultado 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Create
    private void insertClientes(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html"); // permite escribir dentro del html
            PrintWriter pw = response.getWriter();
            String nombre = request.getParameter("txtNombre");
            String documento = request.getParameter("txtDocumento");
            String email = request.getParameter("txtEmail");
            String telefono = request.getParameter("txtTelefono");
            String direccion = request.getParameter("txtDireccion");
            String fecha_nacimiento = request.getParameter("txtFecha_nacimiento");
            String compras = request.getParameter("txtCompras");
            String ultima_compra = request.getParameter("txtUltima_compra");
            String fecha = request.getParameter("txtFecha");
            Clientes cli = new Clientes();
            boolean resp = cli.insertClientes(nombre, documento, email, telefono, direccion, fecha_nacimiento, compras, ultima_compra, fecha);
            pw.println(resp);
        } catch (Exception e) {
        }
    }
//Update

    private void updateClientes(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            int id = Integer.parseInt(request.getParameter("numId"));
            String nombre = request.getParameter("txtNombre");
            String documento = request.getParameter("txtDocumento");
            String email = request.getParameter("txtEmail");
            String telefono = request.getParameter("txtTelefono");
            String direccion = request.getParameter("txtDireccion");
            String fecha_nacimiento = request.getParameter("txtFecha_nacimiento");
            String compras = request.getParameter("txtCompras");
            String ultima_compra = request.getParameter("txtUltima_compra");
            String fecha = request.getParameter("txtFecha");
            Clientes cli = new Clientes();
            boolean resp = cli.updateClientes(id, nombre, documento, email, telefono, direccion, fecha_nacimiento, compras, ultima_compra, fecha);
            pw.println(resp);
        } catch (Exception e) {
        }
    }

    //Read
    private void selectClientes(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            String buscar = request.getParameter("txtBuscar");
            Clientes cli = new Clientes();
            ResultSet rs = cli.selectClientes(buscar);
            String tabla = "<table class='table table-hover'>";  // NUEVA PRESENTACION DE TABLA 
            tabla += "<thead class='thead-light'>";               //cabecera
            tabla += "<tr>"; //con negrita 
            tabla += "<th>ID";                //<th> para declarar las columnas
            tabla += "</th>";
            tabla += "<th>NOMBRE";
            tabla += "</th>";
            tabla += "<th>DOCUMENTO";
            tabla += "</th>";
            tabla += "<th>EMAIL";
            tabla += "</th>";
            tabla += "<th>TELEFONO";
            tabla += "</th>";
            tabla += "<th>DIRECCION";
            tabla += "</th>";
            tabla += "<th>FECHA DE NACIMIENTO";
            tabla += "</th>";
            tabla += "<th>COMPRAS";
            tabla += "</th>";
            tabla += "<th>ULTIMA COMPRA";
            tabla += "</th>";
            tabla += "<th>FECHA";
            tabla += "</th>";
            tabla += "<th>ACTION";          // crear la cabecera de la nueva columna
            tabla += "</th>";
            tabla += "</tr>";
            tabla += "</thead>";
            tabla += "<tbody";
            while (rs.next()) {     //WHILE va a presentar los registros                         //Cuerpo de la tabla
                tabla += "<tr>";   //sin negrita, genera nueva fila 
                tabla += "<td>" + rs.getInt("id");
                tabla += "</td>";
                tabla += "<td>" + rs.getString("nombre");
                tabla += "</td>";
                tabla += "<td>" + rs.getString("documento");
                tabla += "</td>";
                tabla += "<td>" + rs.getString("email");
                tabla += "</td>";
                tabla += "<td>" + rs.getString("telefono");
                tabla += "</td>";
                tabla += "<td>" + rs.getString("direccion");
                tabla += "</td>";
                tabla += "<td>" + rs.getString("fecha_nacimiento");
                tabla += "</td>";
                tabla += "<td>" + rs.getString("compras");
                tabla += "</td>";
                tabla += "<td>" + rs.getString("ultima_compra");
                tabla += "</td>";
                tabla += "<td>" + rs.getString("fecha");
                tabla += "</td>";
                tabla += "<td>";
                tabla += "<button type='button' class='btn btn-warning' data-toggle='modal' data-target='#actualizarModal 'onclick=\"cargarDatosActualizar('"+rs.getInt("id")+"','"+rs.getString("nombre")+"','"+rs.getString("documento")+"','"+rs.getString("telefono")+"','"+rs.getString("direccion")+"','"+rs.getString("fecha_nacimiento")+"','"+rs.getString("compras")+"','"+rs.getString("ultima_compra")+"','"+rs.getString("fecha")+"')\">Actualizar</button>";
                tabla += "<button type='button' class='btn btn-danger'>Eliminar</button>";
                tabla += "</td>";
                tabla += "</tr>";
            }
            tabla += "</tbody";
            tabla += "</table>";

            // Imprimir tabla
            pw.println(tabla);

        } catch (Exception e) {
        }
    }
}
