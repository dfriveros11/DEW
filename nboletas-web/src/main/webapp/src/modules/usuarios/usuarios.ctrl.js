(function (ng) {
    var mod = angular.module('usuarioModule');
    mod.constant('usuariosContext', 'api/users');
    mod.controller('usuarioCtrl', ['$scope', '$http', 'usuariosContext',controladorUsuario]);
    
    function controladorUsuario($scope, $http, usuariosContext) {
            $http.get('data/usuarios.json').then(function (response) {
                $scope.users = response.data;
            });
        }
    
})(angular);
