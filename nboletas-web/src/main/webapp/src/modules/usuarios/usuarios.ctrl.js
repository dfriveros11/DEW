(function (ng) {
    var mod = angular.module('userModule');
    mod.constant('usersContext', 'api/users');
    mod.controller('userCtrl', ['$scope', '$http', 'usersContext',userControllerF]);
    
    function userControllerF($scope, $http, usersContext) {
            $http.get('data/usuarios.json').then(function (response) {
                $scope.users = response.data;
            });
        }
    
}
)(angular);
