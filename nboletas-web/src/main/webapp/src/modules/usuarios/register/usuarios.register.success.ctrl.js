(function (ng) {
    var mod = angular.module('usuarioModule');
    mod.controller('usuariosRegisterSuccessCtrl', ['$scope','$state',success]);
    
    function success($scope, $state){
        
        if (($state.params.userName !== undefined) && ($state.params.userName !== null)) {
            $scope.user = $state.params.userName;
        }
        
    }
    
})(angular);