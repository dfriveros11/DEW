
(
        function (ng) {
            var mod = ng.module("organizadoresModule");
            mod.constant("organizadoresContexts", "api/organizadores");
            mod.controller('organizadorUpdateCtrl', ['$scope', '$http', 'organizadoresContexts', '$state', '$rootScope', '$filter',
                function ($scope, $http, organizadoresContexts, $state, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idOrganizador= $state.params.organizadorId;

                    //Consulto el autor a editar.
                    $http.get(organizadoresContexts + '/' + idOrganizador).then(function (response) {
                        var organizador = response.data;
                        $scope.organizador.nombreEmpresa = organizador.nombreEmpresa;
                        $scope.organizador.espectaculos = organizador.espectaculos;
                    });
                $scope.updateOrganizador = function () {
                    $http.put(organizadoresContexts + "/" + idOrganizador, $scope.organizador).then(function (response) {
                    $state.go('organizadoresList', {organizadorId: response.data.id}, {reload: true});
                });
                };
                }
            ]);
        }
)(angular);

