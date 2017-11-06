
(
        function (ng) {
            var mod = ng.module("espectaculosModule");
            mod.constant("espectaculosContext", "api/espectaculos");
            mod.controller('espectaculoUpdateCtrl', ['$scope', '$http', 'espectaculosContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, espectaculosContext, $state, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idEspectaculo = $state.params.espectaculoId;

   
                    $http.get(espectaculosContext + '/' + idEspectaculo).then(function (response) {
                        var espectaculo = response.data;
                        $scope.espectaculo.nombre= espectaculo.nombre;
                        $scope.espectaculo.imagen = espectaculo.imagen;
                        $scope.espectaculo.descripcion = espectaculo.descripcion;
                    });
                $scope.updateEspectaculo= function () {
                    $http.put(espectaculosContext + "/" + idEspectaculo, $scope.espectaculo).then(function (response) {
                    $state.go('espectaculosList', {espectaculoId: response.data.id}, {reload: true});
                });
                };
                }
            ]);
        }
)(angular);

