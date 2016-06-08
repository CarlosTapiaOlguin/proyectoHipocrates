function showExito(mensaje) {
    $.alert(mensaje, {
        title: "Exito",
        closeTime: 5000,
        autoClose: true,
        position: ["top-right"],
        withTime: false,
        type: "success",
        isOnly: false
    });
}

function showError(mensaje) {
    $.alert(mensaje, {
        title: "Error",
        closeTime: 5000,
        autoClose: true,
        position: ["top-right"],
        withTime: false,
        type: "danger",
        isOnly: false
    });
}

function showAdvertencia(mensaje) {
    $.alert(mensaje, {
        title: "Advertencia",
        closeTime: 5000,
        autoClose: true,
        position: ["top-right"],
        withTime: false,
        type: "warning",
        isOnly: false
    });
}

function showInfo(mensaje) {
    $.alert(mensaje, {
        title: "Informacion",
        closeTime: 5000,
        autoClose: true,
        position: ["top-right"],
        withTime: false,
        type: "info",
        isOnly: false
    });
}