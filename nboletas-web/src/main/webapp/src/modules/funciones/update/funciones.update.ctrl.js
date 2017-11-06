
(
        function (ng) {
            var mod = ng.module("funcionesModule");
            mod.constant("funcionesContext", "api/funciones");
            mod.controller('funcionesUpdateCtrl', ['$scope', '$http', 'funcionesContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, funcionesContext, $state, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idFuncion = $state.params.funcionId;
                    
                    $http.get(funcionesContext + '/' + idFuncion).then(function (response) {
                        var funcion = response.data;
                        $scope.funcion.fecha = funcion.fecha;
                        $scope.funcion.espectaculo = funcion.espectaculo;
                        $scope.funcion.lugar = funcion.lugar;
                        $scope.funcion.hora = funcion.hora;
                    });
                $scope.updateFuncion = function () {
                    $http.put(funcionesContext + "/" + idFuncion, $scope.funcion).then(function (response) {
                    $state.go('funcionesList', {funcionId: response.data.id}, {reload: true});
                });
                };
                }
            ]);
        }
)(angular);

