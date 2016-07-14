app.controller("panelController", function appController($scope,ReservaService) {

    var paciente = JSON.parse(sessionStorage.getItem('usuario'));
    $scope.paciente = paciente;
    $("#rutUsuario").html(paciente.usuario.nombres + " " + paciente.usuario.apellidoPaterno);

    if(paciente == undefined || paciente == ""){
        $window.location.href = 'index.html#/ingresar';
    }


    ReservaService.getReservasFuturas(paciente.id)
        .success(function (data) {
            console.log(data);
            $scope.atenciones =  data;
        }).error(function (data) {
            showError(data);
        });



    $scope.anularHora = function (idReserva) {
        ReservaService.anularReserva(idReserva)
            .success(function (data) {
                showExito("Reserva anulada");
                $("#card"+idReserva).hide();

            }).error(function (data) {
                showError(data);
            });
    }
});


app.controller("reservaConsultaController", function appController($scope, EspecialidadesServices,ReservaService) {





    angular.element(document).ready(function () {
        $('#fechaSeleccionada').datepicker({
            startDate: '+0d',
            endDate: '+2m'
        });
    });

    var paciente = JSON.parse(sessionStorage.getItem('usuario'));
    $scope.paciente = paciente;
    $("#rutUsuario").html(paciente.usuario.nombres + " " + paciente.usuario.apellidoPaterno);

    var especialidadSeleccionada = new Array();

    $scope.actualizarEspecialidad = function () {
        console.log($scope.usuariosEspecialidad);
        $scope.doctoresPorEspecialidad = JSON.parse($scope.especialidadSeleccionada);
        $scope.profesionalSeleccionado = $scope.doctoresPorEspecialidad[0];
        console.log($scope.doctoresPorEspecialidad);
    }

    EspecialidadesServices.getEspecialidadesMedicas()
        .success(function (data) {
            if (data == "" || data == null) {
                alert("no se han encontrado especialidades");
            } else {
                $scope.especialidadesMedicas = data;
            }
        }).error(function (data) {
        alert(data);
    }).finally(function () {
    });





    $scope.buscar = function () {
        var idMedico = $scope.profesionalSeleccionado;
        var fecha    = $("#fechaSeleccionada").val();
        fecha = fecha.replace(/\//g , '');
        console.log(idMedico);
        console.log(fecha);
        ReservaService.getHorasDisponibles(idMedico,fecha)
            .success(function (data) {
                if (data == "" || data == null) {
                    showError("no se han encontrado horas disponibles");
                } else {
                    $scope.horasDisponibles = data;
                }
            }).error(function (data) {
                showError(data);
            }).finally(function () {
                showExito("Se han encontrado " + $scope.horasDisponibles.length + " citas disponibles");
        });
    }


    $scope.reservar = function () {
        var idAgenda = $scope.horaSeleccionada;
        var idUsuario =  $scope.paciente.id;
        console.log(idAgenda);
        console.log(idUsuario);
        ReservaService.realizarReserva(idAgenda,idUsuario)
            .success(function (data) {
                showExito(data.mensaje);
                setTimeout(function(){
                    $location.path('#/panel');
                }, 2000);
            }).error(function (data) {
                showError(data);
        }).finally(function () {
        });
    }


});

app.controller("historialController", function appController($scope,ReservaService) {

    var paciente = JSON.parse(sessionStorage.getItem('usuario'));
    $scope.paciente = paciente;
    $("#rutUsuario").html(paciente.usuario.nombres + " " + paciente.usuario.apellidoPaterno);


    ReservaService.getReservasPasadas(paciente.id)
        .success(function (data) {
            $scope.reservas = data;
        }).error(function (data) {
            showError(data);
        }).finally(function () {

    });
});

