(function (ng) {
    var mod = angular.module('usuarioModule');
    mod.constant("usuariosContext", "api/usuarios");
    mod.controller('usuariosRegisterCtrl', ['$scope', '$http', 'usuariosContext', '$state', '$rootScope',register]);
    
    function register($scope, $http, usuariosContext, $state, $rootScope){
        $scope.creationFailed = false;
        $rootScope.edit = false;
        $scope.usr = "Error";
        
        $scope.registerUsuario = function () {
            
            var user = {
                userName: $scope.userName,
                password: $scope.password,
                nombreUsuario: $scope.nombreUsuario,
                email: $scope.email,
                pais: $scope.pais,
                ciudad: $scope.ciudad
            };
            
            $http.post(usuariosContext,user).then(function (response) {
                $scope.data = response.data;
                $scope.usr = 1;
                $http.get(usuariosContext + '/' + user.userName).then(function (responseG) {
                    $scope.id = responseG.data.id;
                    $state.go('usuarioRegisterSuccess',({usuarioId: $scope.id}));
                });
            }),
            function(response) {
                $scope.creationFailed = true;
                $scope.data = response.data || 'Request failed';
                $scope.status = response.status;
            };
            
            
        };
        
    }

    
})(angular);
