(function (ng) {
    var mod = angular.module('usuarioModule');
    mod.constant("usuariosContext", "api/usuarios");
    mod.controller('usuarioRegisterCtrl', ['$scope', '$http', 'usuariosContext',register]);
    
    function register($scope, $http, usuariosContext, $state){
        
    }
    
})(angular);
