<%--
  Created by IntelliJ IDEA.
  User: kristhian.marquez
  Date: 05-06-2015
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<div ng-controller="appController">
<div class="jumbotron">
    <div class="container">
        <div class="row">
            <div class="col-md-12" align="center">
                <br />
                <img src="/AplicacionWebSpringJquery/image/Logo5.png" ismap />
            </div>
        </div>
        <br/>
        <br/>
        <div class="row">
            <div class="col-md-12" align="center">
                <form class="form-inline">
                    <input type="text" ng-model="rutBuscar" placeholder="RUT" class="form-control" />
                    <button type="button" ng-click="consultarCliente()" class="btn btn-primary">Buscar</button>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-12" id="divTablaCliente" ng-show="clientes.length > 0" align="center">
            <br />
            <br />
            <br />
            <table class="table table-hover table-bordered" id="clienteTabla">
                <tr>
                    <td><strong>Rut</strong></td>
                    <td><strong>Nombre</strong></td>
                    <td><strong>Apellidos</strong></td>
                    <td><strong>Tipo de Cliente</strong></td>
                    <td><strong>Cantidad de lineas</strong></td>
                </tr>
                <tr ng-repeat="cli in clientes" ng-click="setCliente(cli)">
                    <td>{{ cli.rut}}</td>
                    <td>{{ cli.nombre}}</td>
                    <td>{{ cli.apellidos}}</td>
                    <td>{{ cli.tipoCliente}}</td>
                    <td>{{ cli.cantidadLineas}}</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12" id="botonDiv" ng-show="cliente != null" align="center">
            <br/>
            <form class="form-inline">
                <button ng-click="editarCliente()" type="button" class="btn btn-primary">Editar</button>
                <button ng-click="limpiarCliente()" type="button" class="btn btn-primary">Limpiar</button>
            </form>
        </div>
    </div>
</div>

<div class="container">
    <div class="modal fade" id="dialog-form"  role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Cliente</h4>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <label >Rut</label>
                            <input type="text" ng-model="cliente.rut" class="form-control" required autofocus>
                        </div>
                        <div class="form-group">
                            <label >Nombre</label>
                            <input type="text" ng-model="cliente.nombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label >Apellidos</label>
                            <input type="text" ng-model="cliente.apellidos" class="form-control">
                        </div>
                        <div class="form-group">
                            <label >Tipo de Cliente</label>
                            <input type="text" ng-model="cliente.tipoCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Cantidad de Lineas</label>
                            <input type="text" ng-model="cliente.cantidadLineas" class="form-control">
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button id="btn_cerrar" type="button" ng-click="cerrarDialogo()" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    <button id="btn_actualiza" type="button" ng-click="actualizarCliente()" class="btn btn-primary" data-dismiss="modal">Actualizar</button>
                </div>
            </div>

        </div>
    </div>
</div>

</div>
