(function (ng) {
    var mod = ng.module('usuarioModule');
    mod.constant("usuariosContext", "api/usuarios");
    mod.controller('usuarioLoginCtrl', ['$scope', '$http', 'usuariosContext',login]);
    
    function controladorUsuario() {
        
    };
    
    function login($scope, $http, usuariosContext, $state, $css){
        
            if (($state.params.user !== undefined) && ($state.params.user !== null)
                    && ($state.params.password !== undefined) && ($state.params.password !== null)) {
                
                $http.get(usuariosContext + '/' + $state.params.user).then(function (response) {
                    $scope.Usuario = response.data;
                });
                
            }
    }
    
})(angular);
