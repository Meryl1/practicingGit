window.onload = function(){   //presenta la tabla al momento de acceder o recargar la pagina
    readClientes();
};

function readClientes(){
    let buscar = document.getElementById('buscarC').value; //getElementById  este elemento toma control total de la etiqueta buscarC para extraer el valor que se ingresa 

    //Estructura básica de un ajax: debo utilizar la misma estructura
    // localhost:8080/JSP_VESP/CategoriasS?crud=select&txtBuscar=
    $.ajax({
         data:{                   //preparo la informacion que voy a enviar
            "crud": "select",     
            "txtBuscar": buscar
        },
        url:"./ClientesS",
        async:true,
        type:"GET",
        dataType:"text",
        success: function(datos){
            document.getElementById('tablaClientes').innerHTML = datos;  //incrusta la tabla en html
        }
    });
}
function insertClientes(){
    let nombre = document.getElementById('txtNombre').value;
    let docu = document.getElementById('txtDocumento').value;
    let mail = document.getElementById('txtEmail').value;
    let telf = document.getElementById('txtTelefono').value;
    let dir = document.getElementById('txtDireccion').value;
    let fecha_nac = document.getElementById('txtFecha_nacimiento').value;
    let compras = document.getElementById('txtCompras').value;
    let ultima_compra = document.getElementById('txtUltima_compra').value;
    let fecha = document.getElementById('txtFecha').value;   //alert(cli+"\n"+fecha);
      
     $.ajax({
        data:{
            "crud":"insert",
            "txtNombre": nombre,
            "txtDocumento": docu,
            "txtEmail": mail,
            "txtTelefono": telf,
            "txtDireccion": dir,
            "txtFecha_nacimiento": fecha_nac,
            "txtCompras": compras,
            "txtUltima_compra": ultima_compra,
            "txtFecha": fecha
        },
        url:"./ClientesS",
        async:true,
        type:"GET",
        dataType:"text",
        success: function(datos){
            datos = datos.trim();  //trim elimina el espacio 
            if(datos === 'true'){
                alert("Cliente insertado");
            }else{
                alert("Cliente no insertado");
            }
            document.getElementById('closeInsertar').click(); //accede y cierra el modal con un click automatico
            readClientes(); //llamo al metodo para que se muestre con el dato insertado al final
        }
    });
}

function cargarDatosActualizar(id, nombre, docu, mail, telf, dir, fecha_nac, compras, ultima_compra, fecha){
    document.getElementById('numId').value = id;
    document.getElementById('txtNombreUp').value = nombre;
    document.getElementById('txtDocumentoUp').value = docu;
    document.getElementById('txtEmailUp').value = mail;
    document.getElementById('txtTelefonoUp').value = telf;
    document.getElementById('txtDireccionUp').value = dir;
    document.getElementById('txtFecha_nacimientoUp').value = fecha_nac;
    document.getElementById('txtComprasUp').value = compras;
    document.getElementById('txtUltima_compraUp').value = ultima_compra;    
    document.getElementById('txtFechaUp').value = fecha;
}

function updateCategorias(){
    debugger
    let id = document.getElementById('numId').value;
    let nombre = document.getElementById('txtNombreUp').value;
    let docu = document.getElementById('txtDocumentoUp').value;
    let mail = document.getElementById('txtEmailUp').value;
    let telf = document.getElementById('txtTelefonoUp').value;
    let dir = document.getElementById('txtDireccionUp').value;
    let fecha_nac = document.getElementById('txtFecha_nacimientoUp').value;
    let compras = document.getElementById('txtComprasUp').value;
    let ultima_compra = document.getElementById('txtUltima_compraUp').value;
    let fecha = document.getElementById('txtFechaUp').value;
    $.ajax({
        data:{
            "crud":"update",
            "numId": id,
            "txtNombre": nombre,
            "txtDocumento": docu,
            "txtEmail": mail,
            "txtTelefono": telf,
            "txtDireccion": dir,
            "txtFecha_nacimiento": fecha_nac,
            "txtCompras": compras,
            "txtUltima_compra": ultima_compra,
            "txtFecha": fecha
        },
        url:"./ClientesS",
        async:true,
        type:"GET",
        dataType:"text",
        success: function(datos){
            datos = datos.trim();
            if(datos === 'true'){
                alert("Cliente actualizado");
            }else{
                alert("Alerta! Cliente no actualizado");
            }
            document.getElementById('closeUpdate').click();
            readClientes();
        }
    });
}

function cargarIdEliminar(id) {
    document.getElementById('numIdDel').value = id;
}

function deleteClientes() {
    let id = document.getElementById('numIdDel').value;
    $.ajax({
        data: {
            "crud": "delete",
            "txtId": id,
        },
        url: "./ClientesS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            if (datos === 'true') {
                alert("Cliente eliminado");
            } else {
                alert("Cliente no eliminado");
            }
            document.getElementById('deleteClose').click();
            readClientes();
        }
    });
}
