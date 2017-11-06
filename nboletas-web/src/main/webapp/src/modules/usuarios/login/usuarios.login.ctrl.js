(function (ng) {
    var mod = ng.module('usuarioModule');
    mod.constant("usuariosContext", "api/usuarios");
    mod.controller('usuarioLoginCtrl', ['$scope', '$http', 'usuariosContext','$state',login]);
    
    function login($scope, $http, usuariosContext, $state){
        
        if (($state.params.usuarioUser !== undefined) && ($state.params.usuarioUser !== null)) {
            $http.get(usuariosContext + '/' + $state.params.usuarioUser).then(function (response) {
                $scope.currentUser = response.data;
                $http.get(usuariosContext + '/' + $scope.currentUser.id + '/boletas').then(function(response){
                    $scope.boletas = response.data;
                });
            });
        }
        
    }
    
})(angular);
