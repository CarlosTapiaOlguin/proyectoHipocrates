var app = angular.module("app", ['ngRoute']);

app.config(function($routeProvider){
    $routeProvider
        .when("/panel", {
            templateUrl : "html/back/panel.html",
            controller : "panelController"
        })
        .when("/reservarConsulta", {
            templateUrl : "html/back/reservaConsulta.html",
            controller : "reservaConsultaController"
        })
        .when("/historial", {
            templateUrl : "html/back/historial.html",
            controller : "historialController"
        })
        .when("/aaaaaa", {
            templateUrl : "html/panel.html",
            controller : "panelController"
        })
});

