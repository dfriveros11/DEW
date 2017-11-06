(function (ng) {
    var mod = angular.module('usuarioModule', ['ui.router']);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/usuarios/';
            $urlRouterProvider.otherwise("/usuarios");
            $stateProvider
                
            .state('usuario', {
                url: '/usuarios',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'usuarios.html',
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            })
            .state('usuarioList', {
                url: '/list',
                parent: 'usuario',
                views:{
                    'listView':{
                        templateUrl: basePath + '/list/usuarios.list.html',
                        controller: 'usuarioListCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            })
            .state('usuarioRegister',{
                url: '/register',
                parent: 'usuario',
                views: {
                    'mainView': {
                        templateUrl: basePath + '/register/usuarios.register.html',
                        controller: 'usuariosRegisterCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            })
            .state('usuarioLogin',{
                url: '/login',
                parent: 'usuario',
                views: {
                    'detailView':{
                        templateUrl: basePath + '/login/usuarios.login.html',
                        controller: 'usuarioLoginCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);
})(window.angular);

