/* global windows */

(function (ng) {
    var mod = ng.module("boletasModule");
    mod.constant("boletasContext", "api/boletas");
    mod.controller('boletaCtrl', ['$scope', '$http', 'boletasContext',
        function ($scope, $http, boletasContext) {
            $http.get('data/boletas.json').then(function (response) {
                $scope.boletasRecords = response.data;
            });
        }
    ]);
}
)(window.angular);


