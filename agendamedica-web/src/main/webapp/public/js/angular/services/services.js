app.service('UsuarioServices', function ($http) {

    this.getAllUsuarios = function () {
        return $http.get("usuariocontroller/all?" + new Date().getTime());
    }

    this.registrarUsuario = function (paciente) {
        return $http.post("usuariocontroller/registro", paciente);
    }

    this.logearUsuario = function (usuario) {
        return $http.post("usuariocontroller/login", usuario);
    }

});

app.service('EspecialidadesServices', function ($http) {

    this.getEspecialidadesLaboratorio = function () {
        return $http.get("especialidadescontroller/laboratorio/all?" + new Date().getTime());
    }

    this.getEspecialidadesMedicas = function () {
        return $http.get("especialidadescontroller/medicas/all?" + new Date().getTime());
    }
});

app.service('RegionesServices', function ($http) {

    this.getAllRegiones = function () {
        return $http.get("regioncontroller/all?" + new Date().getTime());
    }

});
app.service('PrevisionServices', function ($http) {

    this.getAllPrevisions = function () {
        return $http.get("previsioncontroller/all?" + new Date().getTime());
    }

});

app.service('ReservaService', function ($http) {

    this.getHorasDisponibles = function (medico, fecha) {
        return $http.get("reservacontroller/disponibilidad/" + medico + "/" + fecha + "?" + new Date().getTime());
    }

    this.realizarReserva = function (idAgenda, idUsuario) {
        return $http.get("reservacontroller/reservar/" + idAgenda + "/" + idUsuario + "?" + new Date().getTime());
    }

    this.getReservasFuturas = function (idPaciente) {
        return $http.get("reservacontroller/pendientes/" + idPaciente + "?" + new Date().getTime());
    }


    this.getReservasPasadas = function (idPaciente) {
        return $http.get("reservacontroller/historial/" + idPaciente + "?" + new Date().getTime());
    }

    this.anularReserva = function (idReserva) {
        return $http.get("reservacontroller/anular/" + idReserva + "?" + new Date().getTime());
    }


});