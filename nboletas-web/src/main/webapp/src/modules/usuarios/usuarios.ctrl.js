(function (ng) {
    var mod = angular.module('usuarioModule');
    mod.controller('usuarioCtrl', ['$scope', controladorUsuario]);
    
    function controladorUsuario($scope) {
        $scope.a = 5;
    };
    
})(angular);
