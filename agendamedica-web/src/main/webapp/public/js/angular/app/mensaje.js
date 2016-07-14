function showExito(mensaje) {
    $.notify({
        // options
        message: mensaje
    },{
        // settings
        type: 'success',
        delay: 2000,
        template : '<div class="growl growl-notice growl-large">'+
        '<div data-notify="dismiss" class="myclose">X</div>'+
        '<div class="growl-title">Exito</div>'+
        '<div class="growl-message">{2}</div>'+
        '</div>'
    });
}

function showError(mensaje) {
    $.notify({
        // options
        message: mensaje
    },{
        // settings
        type: 'danger',
        delay: 2000,
        template : '<div class="growl growl-error growl-large">'+
        '<div data-notify="dismiss" class="myclose">X</div>'+
        '<div class="growl-title">Error</div>'+
        '<div class="growl-message">{2}</div>'+
        '</div>'
    });
}

function showAdvertencia(mensaje) {
    $.notify({
        // options
        message: mensaje
    },{
        // settings
        type: 'warning',
        delay: 2000,
        template : '<div class="growl growl-warning growl-large">'+
        '<div data-notify="dismiss" class="myclose">X</div>'+
        '<div class="growl-title">Advertencia</div>'+
        '<div class="growl-message">{2}</div>'+
        '</div>'
    });
}

function showInfo(mensaje) {

    $.notify({
        // options
        message: mensaje
    },{
        // settings
        type: 'info',
        delay: 2000,
        template : '<div class="growl growl-default growl-large">'+
        '<div data-notify="dismiss" class="myclose">X</div>'+
        '<div class="growl-title">Informaci\u00f3n</div>'+
        '<div class="growl-message">{2}</div>'+
        '</div>'

    });
}

function cerrarSession() {
    sessionStorage.removeItem("usuario");
    window.location.href = "/agendamedica/index.html#/home";
}