
(
        function (ng) {
            var mod = ng.module("boletasModule");
            mod.constant("boletasContext", "api/boletas");
            mod.constant("espectaculosContext", "api/espectaculos");
            mod.controller('boletaUpdateCtrl', ['$scope', '$http', 'boletasContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, boletasContext, $state, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idBoleta = $state.params.boletaId;

                    //Consulto el autor a editar.
                    $http.get(boletasContext + '/' + idBoleta).then(function (response) {
                        var boleta = response.data;
                        $scope.boleta.precio= boleta.precio;
                        $scope.boleta.vendida = boleta.vendida;
                        $scope.boleta.reembolso = boleta.reembolso;
                        $scope.boleta.envio = boleta.envio;
                        $scope.boleta.usuario = boleta.usuario;
                        $scope.boleta.comentario = boleta.comentario;
                        $scope.boleta.funcion = boleta.funcion;
                        $scope.boleta.silla = boleta.silla;
                    });
                $scope.updateBoleta = function () {
                    $http.put(boletasContext + "/" + idBoleta, $scope.boleta).then(function (response) {
                    $state.go('boletasList', {boletaId: response.data.id}, {reload: true});
                });
                };
                }
            ]);
        }
)(angular);

