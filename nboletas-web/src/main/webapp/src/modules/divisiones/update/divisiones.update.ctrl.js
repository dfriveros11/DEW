
(
        function (ng) {
            var mod = ng.module("divisionesModule");
            mod.constant("divisionesContext", "api/divisiones");
            mod.controller('divisionesUpdateCtrl', ['$scope', '$http', 'divisionesContext', '$state', '$rootScope', '$filter',
                function ($scope, $http, divisionesContext, $state, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idDivision = $state.params.divisionId;

   
                    $http.get(divisionesContext + '/' + idDivision).then(function (response) {
                        var division = response.data;
                        $scope.division.nombre= division.name;
                    });
                $scope.updateDivision= function () {
                    $http.put(divisionesContext + "/" + idDivision, $scope.division).then(function (response) {
                    $state.go('divisionesList', {divisionId: response.data.id}, {reload: true});
                });
                };
                }
            ]);
        }
)(angular);

