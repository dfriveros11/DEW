(function (ng) {
    var mod = ng.module('usuarioModule');
    mod.constant("usuariosContext", "api/usuarios");
    mod.controller('usuarioLoginCtrl', ['$scope', '$http', 'usuariosContext','$state',login]);
    
    function login($scope, $http, usuariosContext, $state){
        $scope.loginFailed=false;
        $scope.signIn  = function () {
            if (($scope.username !== undefined) && ($scope.username !== null)) {
                $http.get(usuariosContext + '/' + $scope.username)
                .then(function (response) {
                    $scope.currentUser = response.data;
                    $state.go('usuarioDetail',({usuarioUser: $scope.currentUser.userName}));
                }),
                function(response) {
                    $scope.loginFailed = true;
                    $scope.data = response.data || 'Request failed';
                    $scope.status = response.status;
                };
            }
        };
        
    }
    
})(angular);
