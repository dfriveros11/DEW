(function (ng) {
    var mod = ng.module('usuarioModule');
    mod.constant("usuariosContext", "api/usuarios");
    mod.controller('usuarioListCtrl', ['$scope', '$http', 'usuariosContext', controladorListUsuario]);
    
    function controladorListUsuario($scope, $http, usuariosContext) {
        
        $http.get(usuariosContext).
        then(function(response) {
            $scope.users = response.data;
        }),
        function(response) {
            $scope.data = response.data || 'Request failed';
            $scope.status = response.status;
        };
    };
    
})(angular);
