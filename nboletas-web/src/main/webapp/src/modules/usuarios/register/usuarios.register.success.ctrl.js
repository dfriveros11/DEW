(function (ng) {
    var mod = angular.module('usuarioModule');
    mod.controller('usuariosRegisterSuccessCtrl', ['$scope','$state',success]);
    
    function success($scope, $state){
        
        if (($state.params.usuario !== undefined) && ($state.params.usuario !== null)) {
            $scope.user = $state.params.usuario;
        }
        
    }
    
})(angular);