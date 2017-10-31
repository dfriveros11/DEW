(function (ng) {
    var mod = ng.module("espectaculosModule");
    mod.constant("espectaculosContext", "api/espectaculos");
    mod.controller('espectaculoDeleteCtrl', ['$scope', '$http', 'espectaculoContext', '$state',
        function ($scope, $http, espectaculoContext, $state) {
            var idEspectaculo = $state.params.espectaculoId;
            $scope.deleteBoleta = function () {
                $http.delete(espectaculosContext + '/' + idEspectaculo, {}).then(function (response) {
                    $state.go('espectaculosList', {espectaculoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);

