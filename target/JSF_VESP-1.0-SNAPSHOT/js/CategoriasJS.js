
window.onload = function(){
    readCategorias();
    console.log("inicio")
};

function readCategorias() {
    let buscar = document.getElementById('buscarC').value; //getElementById  este elemento toma control total de la etiqueta buscarC para extraer el valor que se ingresa 

    //Estructura básica de un ajax: debo utilizar la misma estructura
    // localhost:8080/JSP_VESP/CategoriasS?crud=select&txtBuscar=
    $.ajax({
        data:{                   //preparo la informacion que voy a enviar
            "crud": "select",     
            "txtBuscar": buscar
        },
        url:"./CategoriasS",
        async:true,
        type:"GET",
        dataType:"text",
        success: function(datos){
            document.getElementById('tablaCategorias').innerHTML = datos;
        }
    });
}

function insertCategorias(){
    let cat = document.getElementById('txtCategoria').value;
    let fecha = document.getElementById('txtFecha').value;
    
    //alert(cat+"\n"+fecha);
     $.ajax({
        data:{
            "crud":"insert",
            "txtCategoria": cat,
            "txtFecha": fecha
        },
        url:"./CategoriasS",
        async:true,
        type:"GET",
        dataType:"text",
        success: function(datos){
            datos = datos.trim();
            if(datos === 'true'){
                alert("Categoria insertada");
            }else{
                alert("Categoria no insertada");
            }
            document.getElementById('closeInsertar').click();
            readCategorias();
        }
    });
}

function cargarDatosActualizar(id, cat, fec){
    document.getElementById('numId').value = id;
    document.getElementById('txtCategoriaUp').value = cat;
    document.getElementById('txtFechaUp').value = fec;
    var fecha = moment(fec);
    var anio = fecha.format('YYYY')
    if (parseInt(anio)<2022){
      alert("No se puede actualizar");  
    }else{
      $('#actualizarModal').modal('show');
    }
}
function updateCategorias(){
    debugger
    let id = document.getElementById('numId').value;
    let c = document.getElementById('txtCategoriaUp').value;
    let f = document.getElementById('txtFechaUp').value;

    $.ajax({
        data:{
            "crud":"update",
            "numId": id,
            "txtCategoria": c,
            "txtFecha": f
        },
        url:"./CategoriasS",
        async:true,
        type:"GET",
        dataType:"text",
        success: function(datos){
            datos = datos.trim();
            if(datos === 'true'){
                alert("Categoria actualizada");
            }else{
                alert("Categoria no actualizada");
            }
            document.getElementById('closeUpdate').click();
            readCategorias();
        }
    });
}

function cargarIdEliminar(id) {
    document.getElementById('numIdDel').value = id;
}

function deleteCategorias() {
    let id = document.getElementById('numIdDel').value;
    $.ajax({
        data: {
            "crud": "delete",
            "txtId": id,
        },
        url: "./CategoriasS",
        async: true,
        type: "GET",
        dataType: "text",
        success: function (datos) {
            datos = datos.trim();
            if (datos === 'true') {
                alert("Categoria eliminada");
            } else {
                alert("Categoria no eliminada");
            }
            document.getElementById('deleteClose').click();
            readCategorias();
        }
    });
}