/* global windows */

(function (ng) {
    var mod = ng.module("organizadoresModule");
    mod.constant("organizadoresContext", "api/organizadores");
    mod.controller('organizadorCtrl', ['$scope', '$http', 'organizadoresContext',
        function ($scope, $http, organizadoresContext) {
            $http.get('data/organizadores.json').then(function (response) {
                $scope.organizadoresRecords = response.data;
            });
        }
    ]);
}
)(window.angular);


