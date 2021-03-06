var app = angular.module("app", ['ngRoute']);

app.config(function($routeProvider){
    $routeProvider.when("/home", {
        templateUrl : "html/home.html",
        controller : "homeController"
    })
    .when('/reserva', {
        templateUrl : "html/reservar.html",
        controller : "reservaController"
    })
    .when('/registro', {
        templateUrl : "html/registro.html",
        controller : "registroController"
    })
    .when('/ingresar', {
        templateUrl : "html/ingreso.html",
        controller : "ingresoController"
    })
    //.otherwise({ redirectTo : "/home"})
});

