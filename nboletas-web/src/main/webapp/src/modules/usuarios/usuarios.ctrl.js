(function (ng) {
    var mod = ng.module("editorialModule");
    mod.constant("editorialContext", "api/editorials");
    mod.controller('editorialCtrl', ['$scope', '$http', 'editorialContext',
        function ($scope, $http, usuariosContext) {
            $http.get('data/usuarios.json').then(function (response) {
                $scope.usuariosRecords = response.data;
            });
        }
    ]);
}
)(angular);

