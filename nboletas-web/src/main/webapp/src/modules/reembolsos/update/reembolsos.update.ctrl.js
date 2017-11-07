
(
        function (ng) {
            var mod = ng.module("reembolsosModule");
            mod.constant("reembolsosContext", "api/boletas");
            mod.constant("usuriosContext", "api/usuarios");
            mod.constant("boletasContext", "api/boletas");
            mod.controller('reembolsoUpdateCtrl', ['$scope', '$http', 'reembolsosContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, reembolsosContext, $state, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idReembolso = $state.params.reembolsoId;

                    //Consulto el autor a editar.
                    $http.get(reembolsosContext + '/' + idReembolso).then(function (response) {
                        var reembolso = response.data;
                        $scope.reembolso.valor= reembolso.valor;
                        $scope.reembolso.usuario = reembolso.usuario;
                        $scope.reembolso.boleta = reembolso.boleta;
                    });
                $scope.updateReembolso = function () {
                    $http.put(reembolsosContext + "/" + idReembolso, $scope.reembolso).then(function (response) {
                    $state.go('reembolsosList', {reembolsoId: response.data.id}, {reload: true});
                });
                };
                }
            ]);
        }
)(angular);

