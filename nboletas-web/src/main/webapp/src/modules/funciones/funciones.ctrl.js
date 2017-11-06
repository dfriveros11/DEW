/* global windows */

(function (ng) {
    var mod = ng.module("funcionesModule");
    mod.controller('funcionesCtrl', ['$scope', '$http', 'funcionesContext', '$state',
        function ($scope, $http, funcionesContext, $state) {
            $http.get(funcionesContext).then(function (response) {
                $scope.funcionesGetAll = response.data;
            });
            if (($state.params.funcionId !== undefined) && ($state.params.funcionId !== null)) {
                $http.get(funcionesContext + '/' + $state.params.funcionId).then(function (response) {
                    $scope.currentFuncion = response.data;
                });
            }
        }
    ]);
}
)(window.angular);


