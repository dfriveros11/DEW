/* global windows */

(function (ng) {
    var mod = ng.module("organizadoresModule");
    mod.constant("organizadoresContext", "api/organizadores");
    mod.controller('organizadorCtrl', ['$scope', '$http', 'organizadoresContext', '$state',
        function ($scope, $http, organizadoresContext, $state) {
            $http.get(organizadoresContext).then(function (response) {
                $scope.organizadoresRecords = response.data;
            });
            if (($state.params.organizadorId !== undefined) && ($state.params.organizadorId !== null)) {
                $http.get(organizadoresContext + '/' + $state.params.organizadorId).then(function (response) {
                    $scope.currentOrganizador = response.data;
                    $scope.espectaculosRecord = response.data.espectaculo;
                });
            }
        }
    ]);
}
)(window.angular);


