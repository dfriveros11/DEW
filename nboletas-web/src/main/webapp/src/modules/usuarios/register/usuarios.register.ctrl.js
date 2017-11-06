(function (ng) {
    var mod = angular.module('usuarioModule');
    mod.constant("usuariosContext", "api/usuarios");
    mod.controller('usuariosRegisterCtrl', ['$scope', '$http', 'usuariosContext', '$state', '$rootScope',register]);
    
    function register($scope, $http, usuariosContext, $state, $rootScope){
            $rootScope.edit = false;
            $scope.registerUser = function () {
                $http.post(usuariosContext, {
                    nombreEmpresa: $scope.organizadorNombreEmpresa
                }).then(function (response) {
                    $state.go('organizadoresList', {organizadorId: response.data.id}, {reload: true});
                });
            };
    }
    
})(angular);
