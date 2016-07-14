app.controller("homeController", function appController($scope) {

    angular.element(document).ready(function () {
        $.stellar({
            horizontalScrolling: false,
            verticalOffset: 0
        });
        //$(".panel-collapse").collapse();


        // AnythingSlider initialization
        $('#slider').anythingSlider();
        //date picker
        $("#datepicker").datepicker({
            inline: true
        });

        //form styling
        $("select").uniform();
        $("#navbar").find("li").removeClass("active");
        $("#menuHome").addClass("active");
    });


});


app.controller("reservaController", function appController($scope, UsuarioServices, EspecialidadesServices) {

    angular.element(document).ready(function () {
        $.stellar({
            horizontalScrolling: false,
            verticalOffset: 0
        });
        //$(".panel-collapse").collapse();


        // AnythingSlider initialization
        $('#slider').anythingSlider();
        //date picker
        $("#datepicker").datepicker({
            inline: true
        });

        //form styling
        $("select").uniform();
        $("#navbar").find("li").removeClass("active");
        $("#menuReserva").addClass("active");
        $("#tipoProfesional").hide();
        $("#tipoPrestacion").hide();
        $("#rutUsuario").rut();
    });

    var doctoresPorEspecialidad = new Array();

    $scope.logicaPrestacion = function () {
        if ($scope.prestacionSeleccionada == 'CONSULTA MEDICA') {
            $("#tipoProfesional").show();
            $("#tipoPrestacion").hide();
        } else {
            $("#tipoProfesional").hide();
            $("#tipoPrestacion").show();
        }
    }


    $scope.actualizarEspecialidad = function () {
        console.log($scope.usuariosEspecialidad);
        $scope.doctoresPorEspecialidad = JSON.parse($scope.especialidadSeleccionada);
        console.log($scope.doctoresPorEspecialidad);
    }

    $scope.buscarRut = function (a) {
        alert(a);
    }

    EspecialidadesServices.getEspecialidadesLaboratorio()
        .success(function (data) {
            if (data == "" || data == null) {
                alert("no se han encontrado especialidades");
            } else {
                $scope.especialidadesLaboratorio = data;
            }
        }).error(function (data) {
        alert(data);
    }).finally(function () {

    });


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
});


app.controller("registroController", function appController($scope, UsuarioServices, RegionesServices,PrevisionServices) {

    angular.element(document).ready(function () {
        $.stellar({
            horizontalScrolling: false,
            verticalOffset: 0
        });
        // AnythingSlider initialization
        $('#slider').anythingSlider();
        //date picker
        $("#fechaNacimiento").datepicker({
            dateFormat: "yy-mm-dd"
        });

        //form styling
        $("select").uniform();
        $("#navbar").find("li").removeClass("active");
        $("#menuRegistro").addClass("active");
        //$("#rut").rut();

    });

    $scope.usuario = {};

    $scope.seleccionRegion = function () {
        var region = JSON.parse($scope.regionSeleccionada);
        $scope.provinciasSeleccionada = region.provincias;
    }

    $scope.seleccionProvincia = function () {
        var provincia = JSON.parse($scope.provinciaSeleccionada);
        $scope.comunasSeleccionada = provincia.comunas;
    }

    RegionesServices.getAllRegiones(
    ).success(function (data) {
        $scope.regiones = data;
    }).error(function (data) {
        showError("No se a podido obtener información de la regiones");
    });

    PrevisionServices.getAllPrevisions(
    ).success(function (data) {
        $scope.previsiones = data;
    }).error(function (data) {
        showError("No se a podido obtener información de las previsiones");
    });

    $scope.registrarUsuario = function (paciente) {
        paciente.usuario["fechaNacimiento"] = $("#fechaNacimiento").val();
        if(paciente.prevision == undefined || paciente.prevision == ""){showError("Campo previsión es obligatorio"); return;}

        if(typeof(paciente.prevision) == "string"){
            paciente.prevision = JSON.parse(paciente.prevision);
        }

        if(paciente.usuario.nombres == undefined || paciente.usuario.nombres == ""){showError("Campo nombres es obligatorio"); return;}
        if(paciente.usuario.apellidoMaterno == undefined || paciente.usuario.apellidoMaterno == ""){showError("Campo apellido materno es obligatorio"); return;}
        if(paciente.usuario.apellidoPaterno == undefined || paciente.usuario.apellidoPaterno == ""){showError("Campo apellido paterno es obligatorio"); return;}
        if(paciente.usuario.telefono == undefined || paciente.usuario.telefono == ""){showError("Campo telefono es obligatorio"); return;}
        if(paciente.usuario.correo == undefined || paciente.usuario.correo == ""){showError("Campo correo es obligatorio"); return;}
        if(paciente.usuario.comuna == undefined || paciente.usuario.comuna == ""){showError("Campo comuna es obligatorio"); return;}
        if(paciente.usuario.genero == undefined || paciente.usuario.genero == ""){showError("Campo genero es obligatorio"); return;}
        if(paciente.usuario.fechaNacimiento == undefined || paciente.usuario.fechaNacimiento == ""){showError("Campo fechaNacimiento es obligatorio"); return;}
        if(paciente.usuario.rut == undefined || paciente.usuario.rut == ""){showError("Campo rut es obligatorio"); return;}
        if(paciente.usuario.password == undefined || paciente.usuario.password == ""){showError("Campo contraseña es obligatorio"); return;}

        console.log(paciente);
        UsuarioServices.registrarUsuario(angular.copy(paciente)
        ).success(function (data) {
            showExito("Usuario registrado con exito.");
            setTimeout(function(){
                $window.location.href = 'panel.html#/ingresar';
            }, 2000);
        }).error(function (data) {
            console.log(data);
            showError(data);
        });
    };
});


app.controller("ingresoController", function appController($scope, UsuarioServices, $window) {

    angular.element(document).ready(function () {
        $.stellar({
            horizontalScrolling: false,
            verticalOffset: 0
        });
        // AnythingSlider initialization
        $('#slider').anythingSlider();
        //date picker
        $("#fechaNacimiento").datepicker();
        //form styling
        $("select").uniform();
        $("#navbar").find("li").removeClass("active");
        $("#menuEntrar").addClass("active");
    });


    $scope.logearUsuario = function (usuario) {
        console.log(usuario);

        if(usuario.rut == "" || usuario.password == "" ||
            usuario.rut === undefined || usuario.password === undefined){
            showError("Complete los campos.");
            return;
        }

        UsuarioServices.logearUsuario(angular.copy(usuario)
        ).success(function (data) {
            console.log(data);
            sessionStorage.setItem('usuario', JSON.stringify(data));
            //var usuario = JSON.parse(sessionStorage.getItem('usuario'));
            $window.location.href = 'panel.html#/panel';
        }).error(function (data) {
            showError(data);
        });
    };
});

