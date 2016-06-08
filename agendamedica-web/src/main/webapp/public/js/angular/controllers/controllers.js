app.controller("homeController", function appController($scope, ClienteServices) {

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


app.controller("reservaController", function appController($scope, DoctorServices) {

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
    });


    $scope.logicaPrestacion = function(){
        if($scope.prestacionSeleccionada == 'CONSULTA MEDICA'){
            $("#tipoProfesional").show();
            $("#tipoPrestacion").hide();
        } else {
            $("#tipoProfesional").hide();
            $("#tipoPrestacion").show();
        }
    }



    DoctorServices.getAllDoctors()
        .success(function (data) {
        if (data == "" || data == null) {
            showInfo("no se han encontrado doctores");
        } else {
            $scope.doctors = data;
        }
    }).error(function (data) {
        showError(data);
    }).finally(function () {

    });
});