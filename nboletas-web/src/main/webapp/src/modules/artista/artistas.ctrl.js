(function (ng) {
    var mod = ng.module("artistaModule");
    mod.constant("artistaContext", "api/artistas");
    mod.controller('artistaCtrl', ['$scope', '$http', 'artistaContext',
        function ($scope, $http, artistaContext) {
            $http.get('data/artistas.json').then(function (response) {
                $scope.artistasRecords = response.data;
            });
        }
    ]);
}
)(angular);