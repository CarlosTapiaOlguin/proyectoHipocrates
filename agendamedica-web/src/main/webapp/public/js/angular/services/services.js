app.service('ClienteServices', function($http){

    this.getCliente = function (rut){
       return $http.get("clientes/" + rut+"?"+new Date().getTime());
    }

    this.postCliente = function (cli){
        return $http.post('clientes/prueba2', cli);
    }
});


app.service('DoctorServices', function($http){

    this.getAllDoctors = function (){
        return $http.get("doctorcontroller/all?"+new Date().getTime());
    }

});