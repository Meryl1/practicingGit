<%-- 
    Document   : ClientesVista
    Created on : 24 jun 2022, 14:46:14
    Author     : Meryli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
        <script src="./js/ClientesJS.js"></script>
        <%@include file="./librerias/libs.jsp"%>
    </head>
    <body>
        <!--colocamos la cabecera-->
        <%@include file="./librerias/menu.jsp"%>

        <div class="container" align="center"> <!--agrega un margen al rededor-->
            <h1>Clientes</h1>
            <hr><!-- agrega una linea orizontal -->
            <form>
                <table>
                    <tr>
                        <td>
                            <label>Buscar</label>

                        </td>
                        <td>
                            <input type="text" id="buscarC" class="form-control"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>            <!--Boton buscar despliega la tabla de clientes para buscar-->
                            <button type="button" class="btn btn-primary"style="width: 70px; height: 40px" onclick="readClientes()">Buscar</button> <!--width me ayuda a darle un tamaño igual a los botones-->
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <button 
                                type="button" 
                                class="btn btn-success"
                                style="width: 70px; height: 40px"
                                data-toggle="modal"
                                data-target="#insertarModal">Insertar</button>   <!-- el # indica que busca id-->
                        </td> 
                    </tr>
                </table>
            </form>
            <hr>
            <div id="tablaClientes"></div>  <!--aqu[i imprimir[a la tabla para que pueda buscar-->
        </div>

        <!-- Button to Open the Modal -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
            Open modal
        </button>

        <!-- The Modal -->
        <div class="modal" id="insertarModal">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Insertar Cliente</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body"align"center">
                        <form>
                            <table>
                                <tr>
                                    <td>
                                        <label>Nombre:</label>

                                    </td>
                                    <td>
                                        <input type="text" id="txtNombre" class="form-control"/>  <!--no hace falta que el nombre sea igual-->
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Documento:</label>

                                    </td>
                                    <td>
                                        <input type="text" id="txtDocumento" class="form-control"/>  <!--no hace falta que el nombre sea igual-->
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Email:</label>

                                    </td>
                                    <td>
                                        <input type="text" id="txtEmail" class="form-control"/>  <!--no hace falta que el nombre sea igual-->
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Teléfono:</label>

                                    </td>
                                    <td>
                                        <input type="text" id="txtTelefono" class="form-control"/>  <!--no hace falta que el nombre sea igual-->
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Dirección:</label>

                                    </td>
                                    <td>
                                        <input type="text" id="txtDireccion" class="form-control"/>  
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Fecha de nacimiento:</label>

                                    </td>
                                    <td>
                                        <input type="text" id="txtFecha_nacimiento" class="form-control"/>  
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Compras:</label>

                                    </td>
                                    <td>
                                        <input type="txt" id="txtCompras" class="form-control"/>  <!--no hace falta que el nombre sea igual-->
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Ultima_compra:</label>

                                    </td>
                                    <td>
                                        <input type="text" id="txtUltima_compra" class="form-control"/>  <!--no hace falta que el nombre sea igual-->
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Fecha:</label>
                                    </td>
                                    <td>
                                        <input type="date" id="txtFecha" class="form-control"/>
                                    </td> 
                                </tr>
                                <tr>
                                    <td>
                                        <button type="button" class="btn btn-success" onclick="insertClientes()">Insertar</button>
                                    </td>
                                    <td></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal" id="closeInsertar">Close</button>
                    </div>

                </div>
            </div>
        </div>


        <!-- The Modal -->
        <div class="modal" id="actualizarModal">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Actualizar Cliente</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body"align"center">
                    </div>
                    <form>
                        <table>
                            <tr>
                                <td>
                                    <label>ID</label>
                                </td>
                                <td>
                                    <input type="number" id="numId" class="form-control" readonly=""/>  <!--solo se puede leer no cambiar el id-->
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Nombre:</label>

                                </td>
                                <td>
                                    <input type="text" id="txtNombreUp" class="form-control"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Documento:</label>

                                </td>
                                <td>
                                    <input type="number" id="txtDocumentoUp" class="form-control"/>  <!--no hace falta que el nombre sea igual-->
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Email:</label>

                                </td>
                                <td>
                                    <input type="text" id="txtEmailUp" class="form-control"/>  
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Telefono:</label>

                                </td>
                                <td>
                                    <input type="text" id="txtTelefonoUp" class="form-control"/>  <!--no hace falta que el nombre sea igual-->
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Dirección:</label>

                                </td>
                                <td>
                                    <input type="text" id="txtDireccionUp" class="form-control"/>  <!--no hace falta que el nombre sea igual-->
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Fecha de nacimiento:</label>

                                </td>
                                <td>
                                    <input type="date" id="txtFecha_nacimientoUp" class="form-control"/>  <!--no hace falta que el nombre sea igual-->
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Compras:</label>

                                </td>
                                <td>
                                    <input type="number" id="txtComprasUp" class="form-control"/>  <!--no hace falta que el nombre sea igual-->
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Ultima compra:</label>

                                </td>
                                <td>
                                    <input type="date" id="txtUltima_compraUp" class="form-control"/>  <!--no hace falta que el nombre sea igual-->
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Fecha:</label>
                                </td>
                                <td>
                                    <input type="date" id="txtFechaUp" class="form-control"/>
                                </td> 
                            </tr>
                            <tr>
                                <td>
                                    <button type="button" class="btn btn-success" onclick="updateClientes()">Actualizar</button>
                                </td>
                                <td></td>
                            </tr>
                        </table>
                    </form>
                </div>
             <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal" id="closeUpdate">Close</button>     
                    </div>
            </body>
        </html>
