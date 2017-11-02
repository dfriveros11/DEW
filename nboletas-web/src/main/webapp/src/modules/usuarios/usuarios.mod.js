(function (ng) {
    var mod = angular.module('usuarioModule', ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/usuarios/';
            $urlRouterProvider.otherwise("/usuariosList");
            $stateProvider
                
                .state('usuariosList', {
                url: "/usuarios",
                views: {
                    'mainView': {
                        templateUrl: basePath + 'usuarios.list.html',
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);

